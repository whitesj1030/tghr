
package com.tghr.aws.s3.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.tghr.comm.entity.BaseEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tc_file")
public class File extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long fileId;

    @Column(length = 10, nullable = false)
    private Long carId;
    
    @Column(length = 10, nullable = true)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    @Builder
	public File(Long fileId, Long carId, String title, String filePath) {
		super();
		this.fileId = fileId;
		this.carId = carId;
		this.title = title;
		this.filePath = filePath;
	}



}
