package com.company.appwarehause.controller;

import com.company.appwarehause.entity.Measurement;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @PostMapping
    public Result addMeasurement(@RequestBody Measurement measurement){
        return measurementService.addMeasurement(measurement);
    }

    @GetMapping("/{id}")
    public Result getMeasurementById(@PathVariable Integer id){
        return measurementService.getMeasurementById(id);
    }

    @GetMapping
    public Page<Measurement> getMeasurements(@RequestParam int page){
        return measurementService.getMeasurements(page);
    }

    @PutMapping("/{id}")
    public Result editMeasurement(@PathVariable Integer id, @RequestBody Measurement measurement){
        return measurementService.editMeasurement(id,measurement);
    }

    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id){
        return measurementService.deleteMeasurement(id);
    }
}
