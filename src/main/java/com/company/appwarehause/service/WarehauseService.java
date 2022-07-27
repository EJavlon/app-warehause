package com.company.appwarehause.service;

import com.company.appwarehause.entity.Warehause;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.repasitory.WarehauseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehauseService {
    @Autowired
    private WarehauseRepository warehauseRepository;


    public Result addWarehause(Warehause warehause) {
        boolean exists = warehauseRepository.existsByName(warehause.getName());
        if (exists) return new Result("There is such a unit of warehause",false);

        warehauseRepository.save(warehause);
        return new Result("Warehause seccessfully added!",true);
    }

    public Result getWarehauseById(Integer id) {
        Optional<Warehause> optionalWarehause = warehauseRepository.findById(id);
        if (!optionalWarehause.isPresent()) return new Result("Warehause not found",false);

        return new Result("Warehause found",true, optionalWarehause.get());
    }

    public Page<Warehause> getWarehauses(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return warehauseRepository.findAll(pageable);
    }

    public Result editWarehause(Integer id, Warehause warehause) {
        Optional<Warehause> optionalWarehause = warehauseRepository.findById(id);
        if (!optionalWarehause.isPresent()) return new Result("Warehause not found",false);

        warehause.setId(optionalWarehause.get().getId());
        return new Result("Warehause seccessfully edited",true,warehause);
    }

    public Result deleteWarehause(Integer id) {
        Optional<Warehause> optionalWarehause = warehauseRepository.findById(id);
        if (!optionalWarehause.isPresent()) return new Result("Warehause not found",false);

        warehauseRepository.deleteById(id);
        return new Result("Warehause seccessfully deleted",true);
    }
}
