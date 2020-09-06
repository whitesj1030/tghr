package com.tghr.aws.s3.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tghr.aws.s3.model.File;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileDto {

	private Long fileId;
	
	@NotBlank
    private Long carId;
    
	@NotBlank
	@Size(max = 50)
    private String title;
	
	@NotBlank
	@Size(max = 100)
    private String fileURL;

    public File toEntity(){
        File build = File.builder()
                .fileId(fileId)
                .carId(carId)
                .title(title)
                .filePath(fileURL)
                .build();
        return build;
    }

    @Builder
	public FileDto(Long fileId, @NotBlank Long carId, @NotBlank @Size(max = 50) String title,
			@NotBlank @Size(max = 100) String fileURL) {
		super();
		this.fileId = fileId;
		this.carId = carId;
		this.title = title;
		this.fileURL = fileURL;
	}
}
