package com.tghr.car.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tghr.comm.entity.BaseEntity;

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

	@Column(name = "car_id")
	private Long carId;

	@Column(name = "opt_id")
	private Long optId;

	@Column(name = "opt_val")
	private String optVal;

//    @OneToOne
//    @JoinColumn(name = "opt_id", insertable = false, updatable = false) 
//    private CarOption carOption;
    
    @Transient
    private String optNm;

	@Builder
	public CarOptionDetail(Long carOptionDetailId, Long carId, Long optId, String optVal) {
		super();
		this.carOptionDetailId = carOptionDetailId;
		this.carId = carId;
		this.optId = optId;
		this.optVal = optVal;
		//this.carOption = carOption;
		//this.optNm = carOption.getOptNm();
	}
	
//	public void setOptNm () {
//		this.optNm = carOption.getOptNm();
//	}	
}
