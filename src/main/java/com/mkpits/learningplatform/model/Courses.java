package com.mkpits.learningplatform.model;

import jdk.jfr.Enabled;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Courses {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long courseId;
        private String courseName;
        private String description;
        private long instructionId;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date startDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date endDate;
}
