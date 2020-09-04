package com.tghr.car.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tghr.car.model.CarOption;
import com.tghr.car.reposigory.CarOptionRepository;
import com.tghr.common.exception.OptionNotFoundException;

import lombok.AllArgsConstructor;

/**
 * 차량 옵션 마스터 데이터 관리
 * 
 * @author white
 *
 */
@Service
@Transactional
@AllArgsConstructor
public class CarOptionService {

	@Autowired
	private CarOptionRepository carOptionRepository;

	@Transactional(readOnly = true)
	public Page<CarOption> findAll(Pageable pageable) {
		return carOptionRepository.findAll(pageable);
	}

	public Optional<CarOption> findById(Long id) {
		return carOptionRepository.findById(id);
	}

	public CarOption saveCarOption(CarOption carOption) {
		return carOptionRepository.save(carOption);
	}

	public CarOption updateCarOption(CarOption carOption) {
		Optional<CarOption> carOpOptional = carOptionRepository.findById(carOption.getOptId());
		carOpOptional.orElseThrow(() -> new OptionNotFoundException("id:" + carOption.getOptId()));
		return carOptionRepository.save(carOption);
	}

	public void deleteById(Long id) {
		carOptionRepository.deleteById(id);
	}
}
