package com.company.appwarehause.controller;

import com.company.appwarehause.entity.InputProduct;
import com.company.appwarehause.payload.InputProductDto;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.service.InputProductSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/input-product")
public class InputProductController {
    @Autowired
    private InputProductSerive inputProductSerive;

    @GetMapping("/{id}")
    public Result getInputProduct(@PathVariable Integer id){
        return inputProductSerive.getInputProduct(id);
    }

    @GetMapping
    public Page<InputProduct> getInputProducts(@RequestParam int page){
        return inputProductSerive.getInputProducts(page);
    }

    @PutMapping("/{id}")
    public Result editInputProduct(@PathVariable Integer id, @RequestBody InputProductDto inputProductDto){
        return inputProductSerive.editInputProduct(id,inputProductDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteInputProduct(@PathVariable Integer id){
        return inputProductSerive.deleteInputProduct(id);
    }
}
