
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

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tc_car")
public class CarEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="tc_id")
    private Long tcId;
    
    @Column(name="tc_name", length = 10, nullable = false)
    private String tcName;
    
    @Column(name="tc_register_date",length = 8, nullable = false)
    private String tcRegisterDate;
    
    @Column(name="tc_number",length = 10, nullable = false)
    private String tcNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(name="tc_fuel",length = 1, nullable = false)
    private FUEL tcfuel;
    
    @Column(name="tc_identification_num",length = 10, nullable = false)
    private String tcIdentificationNum;
    
    @Column(name="tc_motro_type", length = 1, nullable = false)
    private String tcMotroType;
    
    @Enumerated(EnumType.STRING)
    @Column(name="tc_gear_type", length = 1, nullable = false)
    private GearType tcGearType;
    
    @Column(name="tc_birth_year", length = 4, nullable = false)
    private String tcBirthYear;
    
    @Column(name="tc_inspection_start_date", length = 8, nullable = false)
    private String tcInspectionStartDate;
    
    @Column(name="tc_inspection_end_date", length = 8, nullable = false)
    private String tcInspectionEndDate;      
    
    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    private GuaranteeType tcGuaranteeType;
    
    @Column(name="tc_base_price",nullable = false)
	private BigDecimal tcBasePrice;
    
    @Column(name="tc_price",nullable = false)
	private BigDecimal tcPrice;
    
    @Column(name="del_yn", length = 1, nullable = false)
    private String delYn;

    @Builder
	public CarEntity(Long tcId, String tcName, String tcRegisterDate, String tcNumber, FUEL tcfuel,
			String tcIdentificationNum, String tcMotroType, GearType tcGearType, String tcBirthYear,
			String tcInspectionStartDate, String tcInspectionEndDate, GuaranteeType tcGuaranteeType,
			BigDecimal tcBasePrice, BigDecimal tcPrice) {
		super();
		this.tcId = tcId;
		this.tcName = tcName;
		this.tcRegisterDate = tcRegisterDate;
		this.tcNumber = tcNumber;
		this.tcfuel = tcfuel;
		this.tcIdentificationNum = tcIdentificationNum;
		this.tcMotroType = tcMotroType;
		this.tcGearType = tcGearType;
		this.tcBirthYear = tcBirthYear;
		this.tcInspectionStartDate = tcInspectionStartDate;
		this.tcInspectionEndDate = tcInspectionEndDate;
		this.tcGuaranteeType = tcGuaranteeType;
		this.tcBasePrice = tcBasePrice;
		this.tcPrice = tcPrice;
	}

    
}
