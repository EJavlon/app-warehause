package com.company.appwarehause.controller;

import com.company.appwarehause.entity.Warehause;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.service.WarehauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehause")
public class WarehauseController {
    @Autowired
    private WarehauseService warehauseService;

    @PostMapping
    public Result addWarehause(@RequestBody Warehause warehause){
        return warehauseService.addWarehause(warehause);
    }

    @GetMapping("/{id}")
    public Result getWarehauseById(@PathVariable Integer id){
        return warehauseService.getWarehauseById(id);
    }

    @GetMapping
    public Page<Warehause> getWarehauses(@RequestParam int page){
        return warehauseService.getWarehauses(page);
    }

    @PutMapping("/{id}")
    public Result editWarehause(@PathVariable Integer id, @RequestBody Warehause warehause){
        return warehauseService.editWarehause(id,warehause);
    }

    @DeleteMapping("/{id}")
    public Result deleteWarehause(@PathVariable Integer id){
        return warehauseService.deleteWarehause(id);
    }
}
