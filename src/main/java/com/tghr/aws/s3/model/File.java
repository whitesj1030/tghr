
package com.tghr.aws.s3.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    @Builder
    public File(Long id, String title, String filePath) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
    }
}
