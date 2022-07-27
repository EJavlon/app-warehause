package com.company.appwarehause.controller;

import com.company.appwarehause.entity.Supplier;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/{id}")
    public Result getSupplier(@PathVariable Integer id){
        return supplierService.getSupplierById(id);
    }

    @GetMapping
    public Page<Supplier> getSuppliers(@RequestParam int page){
        return supplierService.getSuppliers(page);
    }

    @PostMapping
    public Result addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }

    @PutMapping("/{id}")
    public Result editSupplier(@PathVariable Integer id, @RequestBody Supplier supplier){
        return supplierService.editSupplier(id,supplier);
    }

    @DeleteMapping("/{id}")
    public  Result deleteSupplier(@PathVariable Integer id){
        return supplierService.deleteSupplier(id);
    }
}
