package com.tghr.aws.s3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tc_car_option")
public class OptionEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "opt_id")
	private Long optId;

	@Column(name = "opt_gp_id")
	private String optGpId;

	@Column(name = "opt_name")
	private String optName;

	@Column(name = "opt_desc")
	private String optDesc;

	public OptionEntity(Long optId, String optGpId, String optName, String optDesc) {
		super();
		this.optId = optId;
		this.optGpId = optGpId;
		this.optName = optName;
		this.optDesc = optDesc;
	}	
}
