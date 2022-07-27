package com.company.appwarehause.controller;

import com.company.appwarehause.entity.Currency;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;


    @GetMapping("/{id}")
    public Result getCurrency(@PathVariable Integer id){
        return currencyService.getCurrencyById(id);
    }

    @GetMapping
    public Page<Currency> getCurrencys(@RequestParam int page){
        return currencyService.getCurrencys(page);
    }

    @PostMapping
    public Result addCurrency(@RequestBody Currency currency){
        return currencyService.addCurrency(currency);
    }

    @PutMapping("/{id}")
    public Result editCurrency(@PathVariable Integer id, @RequestBody Currency currency){
        return currencyService.editCurrency(id,currency);
    }

    @DeleteMapping("/{id}")
    public Result deleteCurrency(@PathVariable Integer id){
        return currencyService.deleteCurrency(id);
    }
}

