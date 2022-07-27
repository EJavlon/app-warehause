package com.company.appwarehause.service;

import com.company.appwarehause.entity.Measurement;
import com.company.appwarehause.payload.Result;
import com.company.appwarehause.repasitory.MeasurementRepasitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepasitory measurementRepasitory;

    public Result addMeasurement(Measurement measurement) {
        boolean exists = measurementRepasitory.existsByName(measurement.getName());
        if (exists) return new Result("There is such a unit of measurement",false);

        measurementRepasitory.save(measurement);
        return new Result("Measurement seccessfully added!",true);
    }

    public Result getMeasurementById(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepasitory.findById(id);
        if (!optionalMeasurement.isPresent()) return new Result("Measurement not found",false);

        return new Result("Measurement found",true,optionalMeasurement.get());
    }

    public Page<Measurement> getMeasurements(int page) {
        Pageable pageable = PageRequest.of(page,10);
        return measurementRepasitory.findAll(pageable);
    }

    public Result editMeasurement(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = measurementRepasitory.findById(id);
        if (!optionalMeasurement.isPresent()) return new Result("Measurement not found",false);

        measurement.setId(optionalMeasurement.get().getId());
        return new Result("Measurement seccessfully edited",true,measurement);
    }

    public Result deleteMeasurement(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepasitory.findById(id);
        if (!optionalMeasurement.isPresent()) return new Result("Measurement not found",false);

        measurementRepasitory.deleteById(id);
        return new Result("Measurement seccessfully deleted",true);
    }
}
