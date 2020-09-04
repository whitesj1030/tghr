package com.tghr.car.reposigory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tghr.car.model.CarOption;

public interface CarOptionRepository extends JpaRepository<CarOption, Long> {
	

}
