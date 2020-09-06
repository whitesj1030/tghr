package com.tghr.car.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tghr.car.model.Car;
import com.tghr.car.repository.CarRepository;
import com.tghr.comm.exception.CarNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CarService {

	@Autowired
    private CarRepository carRepository;	
	
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }
	
	public Car findCarsByIdUsingQuery(Long id)	{
		Car car = carRepository.findCarsByCarIdUsingNamedParameters(id);
		if (null == car)
			throw new CarNotFoundException("id-" + id);
		return car;
	}
        
	public Car findById(Long id)	{
		Optional<Car> car = carRepository.findById(id);
		car.orElseThrow(() -> new CarNotFoundException("id-" + id));
		return car.get();
	}
	
	public Car saveCar(Car car) {		
		return carRepository.save(car);
	}
	
	public Car updateCar(Car car) {
	Optional<Car> carOptional = carRepository.findById(car.getCarId());
	carOptional.orElseThrow(() -> new CarNotFoundException("id:"+car.getCarId()));
	return carRepository.save(car);
	}
	
	public void deleteById(Long id) {
		carRepository.deleteById(id);
	}
}
