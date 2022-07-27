package com.company.appwarehause.service;

import com.company.appwarehause.entity.Attachment;
import com.company.appwarehause.entity.Category;
import com.company.appwarehause.entity.Measurement;
import com.company.appwarehause.entity.Product;
import com.company.appwarehause.payload.ProductDto;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.repasitory.AttachmentRepository;
import com.company.appwarehause.repasitory.CategoryRepository;
import com.company.appwarehause.repasitory.MeasurementRepasitory;
import com.company.appwarehause.repasitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private MeasurementRepasitory measurementRepasitory;

    public Result addProduct(ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) return new Result("Category not found",false);

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent()) return new Result("File not found",false);

        Optional<Measurement> optionalMeasurement = measurementRepasitory.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent()) return new Result("Measurement not found",false);

        boolean exists = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (exists) return new Result("Product found",false);

        Product product = new Product();
        product.setCategory(optionalCategory.get());
        product.setAttachment(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        product.setActive(productDto.isActive());
        product.setName(productDto.getName());
        product.setCode(String.valueOf(productRepository.countAllProduct()+1));
        productRepository.save(product);

        return new Result("Product seccessfully added",true);
    }

    public Result getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) return new Result("Prodcut not found",false);

        return new Result("Product found",true,optionalProduct.get());
    }

    public Page<Product> getProducts(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return productRepository.findAll(pageable);
    }

    public Result editProduct(Integer id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) return new Result("Product not found",false);

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) return new Result("Category not found",false);

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent()) return new Result("File not found",false);

        Optional<Measurement> optionalMeasurement = measurementRepasitory.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent()) return new Result("Measurement not found",false);

        boolean exists = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (exists) return new Result("Product found",false);

        Product product = optionalProduct.get();
        product.setCategory(optionalCategory.get());
        product.setAttachment(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        product.setActive(productDto.isActive());
        product.setName(productDto.getName());
        productRepository.save(product);

        return new Result("Product seccessfully edited",true);
    }

    public Result deleteProduct(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) return new Result("Product not found",false);
        productRepository.delete(optionalProduct.get());
        return new Result("Product seccessfully deleted",true);
    }
}
