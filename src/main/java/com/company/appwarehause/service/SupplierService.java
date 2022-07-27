package com.company.appwarehause.service;

import com.company.appwarehause.entity.Supplier;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.repasitory.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Result getSupplierById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent()) return new Result("Supplier not found",false);
        
        return new Result("Supplier found",true,optionalSupplier.get());
    }

    public Page<Supplier> getSuppliers(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return supplierRepository.findAll(pageable);
    }

    public Result addSupplier(Supplier supplier) {
        boolean exists = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (exists) return new Result("Such a number exists",false);

        supplierRepository.save(supplier);
        return new Result("Supplier seccessfully added",true);
    }

    public Result editSupplier(Integer id, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent()) return new Result("Supplier not found",false);

        supplier.setId(optionalSupplier.get().getId());
        supplierRepository.save(supplier);
        return new Result("Supplier seccessfully edited",true);
    }

    public Result deleteSupplier(Integer id) {
        boolean exists = supplierRepository.existsById(id);
        if (!exists) return new Result("Supplier not found", false);

        supplierRepository.deleteById(id);
        return new Result("Supplier seccessfully deleted",true);
    }
}
