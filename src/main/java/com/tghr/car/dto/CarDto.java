package com.tghr.car.dto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.tghr.car.model.Car;
import com.tghr.comm.consts.FUEL;
import com.tghr.comm.consts.GearType;
import com.tghr.comm.consts.GuaranteeType;
import com.tghr.comm.consts.YN;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 차량 기본 정보 DTO
 * 
 * @author white
 *
 */
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarDto {
	private Long carId;
	private String carNm; // 차량명
	private String carRegisterDate; // 차량최초등록일
	private String carNumber; // 차량 번호(번호판)
	private FUEL fuel; // 연료 : G, L, D, E
	private String fuelEff; // 연비: 단위 Km
	private String motorType;
	private GearType gearType; // 기어타입: M, A
	private String gearNm; // 기어명: 자동10단
	private String inspectionStartDate; // 차량검사 유효기간 start
	private String inspectionEndDate; // 차량검사 유효기간 만료일
	private GuaranteeType guaranteeType; // 보증유형: S,I (자가 self, 보험사 insurance~)
	private BigDecimal basePrice; // 출고가
	private BigDecimal price; // 판매가
	private String drvDist; // 주행거리
	private String carColor; // 차량 색상
	private String carExhat; // 배기량
	private String smokYn; // 흡연여부: Y/N
	private String floodYn; // 침수 여부
	private String ridCapa; // 승차 정원
	private String seizureYn; // 압류 저당 여부
	private String recommend; // 추천 포인트
	private String carKind; // 차량종류: 경차(L), 준중형(S), 중형(M), 대형(B), SUV(S), 기타(E)
	private YN soldYn; // 판매여부
	private YN delYn; // 삭제여부

    // Entity -> DTO   
	public static CarDto of(Car car) {
		return new ModelMapper().map(car, CarDto.class);
	}

    // Entity -> DTO (Page)
    public static Page<CarDto> of(Page<Car> sourcePage) {
        return sourcePage.map(CarDto::of);
    }
    
    // DTO -> Entity
    public Car toEntity() {
    	return Car.builder()
    	.carNm(this.carNm)
    	.carRegisterDate(this.carRegisterDate)
    	.carNumber(this.carNumber)
    	.fuel(this.fuel)
    	.fuelEff(this.fuelEff)
    	.motorType(this.motorType)
    	.gearType(this.gearType)
    	.gearNm(this.gearNm)
    	.inspectionStartDate(this.inspectionStartDate)
    	.inspectionEndDate(this.inspectionEndDate)
    	.guaranteeType(this.guaranteeType)
    	.basePrice(this.basePrice)
    	.price(this.price)
    	.drvDist(this.drvDist)
    	.carColor(this.carColor)
    	.carExhat(this.carExhat)
    	.smokYn(this.smokYn)
    	.floodYn(this.floodYn)
    	.ridCapa(this.ridCapa)
    	.seizureYn(this.seizureYn)
    	.recommend(this.recommend)
    	.carKind(this.carKind)
    	.soldYn(this.soldYn)
    	.delYn(this.delYn)
        .build();
        }  
    
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CarQueryReq {
    	private String name;
    	private String carKind; // 차량종류: 경차(L), 준중형(S), 중형(M), 대형(B), SUV(S), 기타(E)
    	private FUEL fuel; // 연료 : G, L, D, E   	

        @Builder
        public CarQueryReq(final String name, String carKind, FUEL fuel) {
            this.name = name;
            this.carKind = carKind;
            this.fuel = fuel;
        }

    }
    
    
}
