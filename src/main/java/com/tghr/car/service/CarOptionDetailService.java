package com.tghr.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tghr.car.model.CarOptionDetail;
import com.tghr.car.reposigory.CarOptionDetailRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CarOptionDetailService {

	@Autowired
	private CarOptionDetailRepository carOptionDetailRepository;

	@Transactional(readOnly = true)
	public Page<CarOptionDetail> findAll(Pageable pageable) {
		return carOptionDetailRepository.findAll(pageable);
	}

//	public List<CarOptionDetail> findById(Long id)	{
//		Optional<CarOptionDetail> carOpOptionDetail = carOptionDetailRepository.findById(id);
//		carOpOptionDetail.orElseThrow(() -> new CarOptionDetailNotFoundException("id-" + id));	
//		return carOpOptionDetail.of(CarOptionDetail);
//	}

	public List<CarOptionDetail> findByCarId(Long carId) {
		return carOptionDetailRepository.findCarsByCarIdUsingNamedParameters(carId);
	}

	public List<CarOptionDetail> saveCarOptionDetail(List<CarOptionDetail> carOptionDetail) {
		return carOptionDetailRepository.saveAll(carOptionDetail);
	}

	public List<CarOptionDetail> updateCarOptionDetail(List<CarOptionDetail> carOptionDetail) {
		return carOptionDetailRepository.saveAll(carOptionDetail);
	}

	public void deleteById(Long id) {
		carOptionDetailRepository.deleteById(id);
	}
}
