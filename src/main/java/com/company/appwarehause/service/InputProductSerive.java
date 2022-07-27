package com.company.appwarehause.service;

import com.company.appwarehause.entity.Input;
import com.company.appwarehause.entity.InputProduct;
import com.company.appwarehause.entity.Product;
import com.company.appwarehause.payload.InputProductDto;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.repasitory.InputProductRepository;
import com.company.appwarehause.repasitory.InputRepository;
import com.company.appwarehause.repasitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InputProductSerive {
    @Autowired
    private InputProductRepository inputProductRepository;
    @Autowired
    private InputRepository inputRepository;
    @Autowired
    private ProductRepository productRepository;

    public Result getInputProduct(Integer id) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent()) return new Result("Input-Product not found",false);

        return new Result("Input-Prodcut found",true,optionalInputProduct.get());
    }

    public Page<InputProduct> getInputProducts(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return inputProductRepository.findAll(pageable);
    }

    public Result editInputProduct(Integer id, InputProductDto inputProductDto) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent()) return new Result("Input-Product not found",false);

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (!optionalInput.isPresent()) return new Result("Input not found",false);

        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (!optionalProduct.isPresent()) return new Result("Product not found",false);

        InputProduct inputProduct = optionalInputProduct.get();
        inputProduct.setInput(optionalInput.get());
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProductRepository.save(inputProduct);

        return new Result("Input Prodcut seccessfully edited",true);
    }

    public Result deleteInputProduct(Integer id) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent()) return new Result("Input-Product not found",false);

        inputProductRepository.deleteById(id);

        return new Result("Input Prodcut seccessfully deleted",true);
    }
}
