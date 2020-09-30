package com.tghr.car.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tghr.comm.consts.FUEL;
import com.tghr.comm.consts.GearType;
import com.tghr.comm.consts.GuaranteeType;
import com.tghr.comm.consts.YN;
import com.tghr.comm.entity.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 차량 기본 정보
 * 
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

	@ApiModelProperty(value = "차량명")
	@Column(name = "car_nm", length = 10, nullable = false)
	private String carNm;

	@ApiModelProperty(value = "차량최초등록일")
	@Column(name = "car_register_date", length = 8)
	private String carRegisterDate;

	@ApiModelProperty(value = "차량 번호(번호판)")
	@Column(name = "car_number", length = 10)
	private String carNumber;

	@ApiModelProperty(value = "연료 : G, L, D, E")
	@Enumerated(EnumType.STRING)
	@Column(name = "fuel", length = 1)
	private FUEL fuel;

	@ApiModelProperty(value = "연비: 단위 Km")
	@Column(name = "fuel_eff")
	private String fuelEff;

	@ApiModelProperty(value = "모터 타입(멀까 ㅠ)")
	@Column(name = "motor_type", length = 1)
	private String motorType;

	@ApiModelProperty(value = "기어타입: M, A")
	@Enumerated(EnumType.STRING)
	@Column(name = "gear_type", length = 1)
	private GearType gearType;

	@ApiModelProperty(value = "기어명: 자동10단")
	@Column(name = "gear_nm")
	private String gearNm;

	@ApiModelProperty(value = "차량검사 유효기간 start")
	@Column(name = "inspection_start_date", length = 8)
	private String inspectionStartDate;

	@ApiModelProperty(value = "차량검사 유효기간 만료일")
	@Column(name = "inspection_end_date", length = 8)
	private String inspectionEndDate;

	@ApiModelProperty(value = "보증유형: S,I  (자가 self, 보험사 insurance~)")
	@Enumerated(EnumType.STRING)
	@Column(name = "guarantee_type", length = 1)
	private GuaranteeType guaranteeType;

	@ApiModelProperty(value = "출고가")
	@Column(name = "base_price")
	private BigDecimal basePrice;

	@ApiModelProperty(value = "판매가")
	@Column(name = "price")
	private BigDecimal price;

	@ApiModelProperty(value = "주행거리")
	@Column(name = "drv_dist")
	private String drvDist;

	@ApiModelProperty(value = "차량 색상")
	@Column(name = "car_color")
	private String carColor;

	@ApiModelProperty(value = "배기량")
	@Column(name = "car_exhat")
	private String carExhat;

	@ApiModelProperty(value = "흡연여부: Y/N")
	@Column(name = "smok_yn")
	private String smokYn;

	@ApiModelProperty(value = "침수 여부 ")
	@Column(name = "flood_yn")
	private String floodYn;

	@ApiModelProperty(value = "승차 정원")
	@Column(name = "rid_capa")
	private String ridCapa;

	@ApiModelProperty(value = "압류 저당 여부")
	@Column(name = "seizure_yn")
	private String seizureYn;

	@ApiModelProperty(value = "추천 포인트")
	@Column(name = "recommend")
	private String recommend;

	@ApiModelProperty(value = "차량종류: 경차(L), 준중형(S), 중형(M), 대형(B), SUV(S), 기타(E) ")
	@Column(name = "car_kind")
	private String carKind;

	@ApiModelProperty(value = "판매여부")
	@Column(name = "sold_yn")
	private YN soldYn;

	@Enumerated(EnumType.STRING)
	@Column(name = "del_yn", length = 1)
	private YN delYn;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "car_id")
	private List<CarOptionDetail> carOptionDetailList = new ArrayList<>();

	@Builder
	public Car(Long carId, String carNm, String carRegisterDate, String carNumber, FUEL fuel, String fuelEff,
			String motorType, GearType gearType, String gearNm, String inspectionStartDate, String inspectionEndDate,
			GuaranteeType guaranteeType, BigDecimal basePrice, BigDecimal price, String drvDist, String carColor,
			String carExhat, String smokYn, String floodYn, String ridCapa, String seizureYn, String recommend,
			String carKind, YN soldYn, YN delYn, List<CarOptionDetail> carOptionDetailList) {
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
		this.carKind = carKind;
		this.soldYn = soldYn;
		this.delYn = delYn;
		this.carOptionDetailList = carOptionDetailList;
	}
}
