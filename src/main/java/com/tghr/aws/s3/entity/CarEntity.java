
package com.tghr.aws.s3.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tghr.consts.FUEL;
import com.tghr.consts.GearType;
import com.tghr.consts.GuaranteeType;
import com.tghr.consts.YN;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tc_car")
public class CarEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tc_id")
	private Long tcId;

	@Column(name = "tc_nm", length = 10, nullable = false)
	private String tcNm;

	@Column(name = "tc_register_date", length = 8, nullable = false)
	private String tcRegisterDate;

	@Column(name = "tc_number", length = 10, nullable = false)
	private String tcNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "tc_fuel", length = 1, nullable = false)
	private FUEL tcfuel;

	@Column(name = "fuel_eff")
	private String fuelEff; // 연비

	@Column(name = "tc_identification_num", length = 10, nullable = false)
	private String tcIdentificationNum;

	@Column(name = "tc_motor_type", length = 1, nullable = false)
	private String tcMotorType;

	@Enumerated(EnumType.STRING)
	@Column(name = "tc_gear_type", length = 1, nullable = false)
	private GearType tcGearType;

	@Column(name = "gear_nm")
	private String gearNm;

	@Column(name = "tc_birth_year", length = 4, nullable = false)
	private String tcBirthYear;

	@Column(name = "tc_inspection_start_date", length = 8, nullable = false)
	private String tcInspectionStartDate;

	@Column(name = "tc_inspection_end_date", length = 8, nullable = false)
	private String tcInspectionEndDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "tc_guarantee_type", length = 1, nullable = false)
	private GuaranteeType tcGuaranteeType;

	@Column(name = "tc_base_price", nullable = false)
	private BigDecimal tcBasePrice;

	@Column(name = "tc_price", nullable = false)
	private BigDecimal tcPrice;

	@Column(name = "tc_drv_dist")
	private String tcDrvDist;

	@Column(name = "car_color")
	private String carColor;

	@Column(name = "car_exhat")
	private String carExhat;

	@Column(name = "smok_yn")
	private String smokYn;

	@Column(name = "flood_yn")
	private String floodYn;

	@Column(name = "rid_capa")
	private String ridCapa;

	@Column(name = "seizure_yn")
	private String seizureYn;

	@Column(name = "recommend")
	private String recommend;

	@Enumerated(EnumType.STRING)
	@Column(name = "del_yn", length = 1, nullable = false)
	private YN delYn;

	@Builder
	public CarEntity(Long tcId, String tcNm, String tcRegisterDate, String tcNumber, FUEL tcfuel, String fuelEff,
			String tcIdentificationNum, String tcMotorType, GearType tcGearType, String gearNm, String tcBirthYear,
			String tcInspectionStartDate, String tcInspectionEndDate, GuaranteeType tcGuaranteeType,
			BigDecimal tcBasePrice, BigDecimal tcPrice, String tcDrvDist, String carColor, String carExhat,
			String smokYn, String floodYn, String ridCapa, String seizureYn, String recommend, YN delYn) {
		super();
		this.tcId = tcId;
		this.tcNm = tcNm;
		this.tcRegisterDate = tcRegisterDate;
		this.tcNumber = tcNumber;
		this.tcfuel = tcfuel;
		this.fuelEff = fuelEff;
		this.tcIdentificationNum = tcIdentificationNum;
		this.tcMotorType = tcMotorType;
		this.tcGearType = tcGearType;
		this.gearNm = gearNm;
		this.tcBirthYear = tcBirthYear;
		this.tcInspectionStartDate = tcInspectionStartDate;
		this.tcInspectionEndDate = tcInspectionEndDate;
		this.tcGuaranteeType = tcGuaranteeType;
		this.tcBasePrice = tcBasePrice;
		this.tcPrice = tcPrice;
		this.tcDrvDist = tcDrvDist;
		this.carColor = carColor;
		this.carExhat = carExhat;
		this.smokYn = smokYn;
		this.floodYn = floodYn;
		this.ridCapa = ridCapa;
		this.seizureYn = seizureYn;
		this.recommend = recommend;
		this.delYn = delYn;
	}
}
