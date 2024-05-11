package com.zosh.tasksubmissionservice.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long taskId;

    private String githubLink;
    private Long userId;
    private String status="PENDING";
    private LocalDateTime submissionTime;

}
