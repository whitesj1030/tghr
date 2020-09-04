package com.tghr.aws.s3.dto;

import java.math.BigDecimal;

import com.tghr.car.model.Car;
import com.tghr.comm.consts.FUEL;
import com.tghr.comm.consts.GearType;
import com.tghr.comm.consts.GuaranteeType;
import com.tghr.comm.consts.YN;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CarDto {

	/**
	 * 차량 등록 시 입력 데이터 
	 * @author white
	 *
	 */
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignUpReq {
    	private String carNm;
    	private String carRegisterDate;
    	private String carNumber;
    	private FUEL fuel;
    	private String fuelEff;
    	private String motorType;
    	private GearType gearType;
    	private String gearNm;
    	private String inspectionStartDate;
    	private String inspectionEndDate;
    	private GuaranteeType guaranteeType;
    	private BigDecimal basePrice;
    	private BigDecimal price;
    	private String drvDist;
    	private String carColor;
    	private String carExhat;
    	private String smokYn;
    	private String floodYn;
    	private String ridCapa;
    	private String seizureYn;
    	private String recommend;
    	private YN delYn;
    	
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
            .delYn(this.delYn)                    
            .build();
        }       
    }
    
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CarReq {


    }
    
    /**
     * 반환 차량 정보
     * @author white
     *
     */
    @Getter
    public static class Res {
    	private String tcNm;
    	private String tcRegisterDate;
    	private String tcNumber;
    	private FUEL fuel;
    	private String fuelEff;
    	private String identificationNum;
    	private String motorType;
    	private GearType gearType;
    	private String gearNm;
    	private String tcBirthYear;
    	private String inspectionStartDate;
    	private String inspectionEndDate;
    	private GuaranteeType guaranteeType;
    	private BigDecimal basePrice;
    	private BigDecimal price;
    	private String drvDist;
    	private String carColor;
    	private String carExhat;
    	private String smokYn;
    	private String floodYn;
    	private String ridCapa;
    	private String seizureYn;
    	private String recommend;
    	private YN delYn;

    	@Builder
    	public Res(String tcNm, String tcRegisterDate, String tcNumber, FUEL fuel, String fuelEff,
    			String identificationNum, String motorType, GearType gearType, String gearNm, String tcBirthYear,
    			String inspectionStartDate, String inspectionEndDate, GuaranteeType guaranteeType,
    			BigDecimal basePrice, BigDecimal price, String drvDist, String carColor, String carExhat,
    			String smokYn, String floodYn, String ridCapa, String seizureYn, String recommend, YN delYn) {
    		super();
    		this.tcNm = tcNm;
    		this.tcRegisterDate = tcRegisterDate;
    		this.tcNumber = tcNumber;
    		this.fuel = fuel;
    		this.fuelEff = fuelEff;
    		this.identificationNum = identificationNum;
    		this.motorType = motorType;
    		this.gearType = gearType;
    		this.gearNm = gearNm;
    		this.tcBirthYear = tcBirthYear;
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
    	}
    }
}
