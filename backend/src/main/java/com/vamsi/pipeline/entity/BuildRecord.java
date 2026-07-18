package com.vamsi.pipeline.entity;

import com.vamsi.pipeline.enums.BuildStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "build_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String jobName;

    @Column(nullable = false)
    private Integer buildNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuildStatus status;

    @Column(nullable = false)
    private Long duration;

    @Column(nullable = false)
    private String branch;

    @Column(nullable = false)
    private String commitId;

    @Column(nullable = false)
    private LocalDateTime buildTime;

    @Column(nullable = false)
    private String buildUrl;

    @Column(nullable = false)
    private String consoleUrl;
}