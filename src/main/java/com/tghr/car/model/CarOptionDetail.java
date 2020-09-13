package com.tghr.car.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tghr.comm.entity.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tc_car_option_detail")
public class CarOptionDetail extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_option_detail_id")
	private Long carOptionDetailId;

	@ApiModelProperty(value="차량 ID")
	@Column(name = "car_id")
	private Long carId;

	@ApiModelProperty(value="옵션 ID")
	@Column(name = "opt_id")
	private Long optId;

	@ApiModelProperty(value="옵션 값 : 이건왜 있을까?")
	@Column(name = "opt_val")
	private String optVal;

    @Transient
    private String optNm;

	@Builder
	public CarOptionDetail(Long carOptionDetailId, Long carId, Long optId, String optVal) {
		super();
		this.carOptionDetailId = carOptionDetailId;
		this.carId = carId;
		this.optId = optId;
		this.optVal = optVal;
	}

}
