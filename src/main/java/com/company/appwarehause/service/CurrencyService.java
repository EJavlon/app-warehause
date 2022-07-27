package com.company.appwarehause.service;

import com.company.appwarehause.entity.Currency;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.repasitory.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public Result getCurrencyById(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent()) return new Result("Currency not found",false);

        return new Result("Currency found",true,optionalCurrency.get());
    }

    public Page<Currency> getCurrencys(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return currencyRepository.findAll(pageable);
    }

    public Result addCurrency(Currency currency) {
        boolean exists = currencyRepository.existsByName(currency.getName());
        if (exists) return new Result("Such a currency exists",false);

        return new Result("Currency seccessfully added",true);
    }

    public Result editCurrency(Integer id, Currency currency) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent()) return new Result("Currency not found",false);

        currency.setId(optionalCurrency.get().getId());
        return new Result("Currency seccessfully edited",true);
    }

    public Result deleteCurrency(Integer id) {
        boolean exists = currencyRepository.existsById(id);
        if (!exists) return new Result("Currency not found",false);

        currencyRepository.deleteById(id);
        return new Result("Currency seccessfully deleted",true);

    }
}
