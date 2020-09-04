package com.tghr.car.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tghr.comm.consts.FUEL;
import com.tghr.comm.consts.GearType;
import com.tghr.comm.consts.GuaranteeType;
import com.tghr.comm.consts.YN;
import com.tghr.comm.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 차량 기본 정보
 * @author white
 *
 */
@Getter
@Entity
@Table(name = "tc_car")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Long carId;

	@Column(name = "car_nm", length = 10, nullable = false)
	private String carNm;

	@Column(name = "car_register_date", length = 8)
	private String carRegisterDate;

	@Column(name = "car_number", length = 10)
	private String carNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "fuel", length = 1)
	private FUEL fuel;

	@Column(name = "fuel_eff")
	private String fuelEff; // 연비

	@Column(name = "motor_type", length = 1)
	private String motorType;

	@Enumerated(EnumType.STRING)
	@Column(name = "gear_type", length = 1)
	private GearType gearType;

	@Column(name = "gear_nm")
	private String gearNm;

	@Column(name = "inspection_start_date", length = 8)
	private String inspectionStartDate;

	@Column(name = "inspection_end_date", length = 8)
	private String inspectionEndDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "guarantee_type", length = 1)
	private GuaranteeType guaranteeType;

	@Column(name = "base_price")
	private BigDecimal basePrice;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "drv_dist")
	private String drvDist;  // 주행거리

	@Column(name = "car_color")
	private String carColor;

	@Column(name = "car_exhat")  // 배기량
	private String carExhat;

	@Column(name = "smok_yn")
	private String smokYn;

	@Column(name = "flood_yn")  // 침수 여부 
	private String floodYn;

	@Column(name = "rid_capa")  // 승차 정원
	private String ridCapa;

	@Column(name = "seizure_yn")  // 압류 저당 여부
	private String seizureYn;

	@Column(name = "recommend")  // 추천 포인트
	private String recommend;

	@Enumerated(EnumType.STRING)
	@Column(name = "del_yn", length = 1)
	private YN delYn;
	
    // fetch = FetchType.LAZY
    @OneToMany(mappedBy = "carId", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private List<CarOptionDetail> carOptionDetailList;

    @Builder
	public Car(Long carId, String carNm, String carRegisterDate, String carNumber, FUEL fuel, String fuelEff,
			String motorType, GearType gearType, String gearNm, String inspectionStartDate, String inspectionEndDate,
			GuaranteeType guaranteeType, BigDecimal basePrice, BigDecimal price, String drvDist, String carColor,
			String carExhat, String smokYn, String floodYn, String ridCapa, String seizureYn, String recommend,
			YN delYn, List<CarOptionDetail> carOptionDetailList) {
		super();
		this.carId = carId;
		this.carNm = carNm;
		this.carRegisterDate = carRegisterDate;
		this.carNumber = carNumber;
		this.fuel = fuel;
		this.fuelEff = fuelEff;
		this.motorType = motorType;
		this.gearType = gearType;
		this.gearNm = gearNm;
		this.inspectionStartDate = inspectionStartDate;
		this.inspectionEndDate = inspectionEndDate;
		this.guaranteeType = guaranteeType;
		this.basePrice = basePrice;
		this.price = price;
		this.drvDist = drvDist;
		this.carColor = carColor;
		this.carExhat = carExhat;
		this.smokYn = smokYn;
		this.floodYn = floodYn;
		this.ridCapa = ridCapa;
		this.seizureYn = seizureYn;
		this.recommend = recommend;
		this.delYn = delYn;
		this.carOptionDetailList = carOptionDetailList;
	}

	


}
