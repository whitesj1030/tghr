package com.tghr.aws.s3.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carid;
	@NotBlank
	@Size(max = 50)
    private String title;
	@NotBlank
	@Size(max = 100)
    private String filePath;

    public File toEntity(){
        File build = File.builder()
                .id(carid)
                .title(title)
                .filePath(filePath)
                .build();
        return build;
    }

    @Builder
    public FileDto(String title, String filePath) {
        this.title = title;
        this.filePath = filePath;
    }
}
