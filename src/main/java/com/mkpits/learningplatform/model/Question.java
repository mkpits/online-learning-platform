package com.mkpits.learningplatform.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_i")
    private long question_id;
    @Column(name = "tag")
    private String tag;
    @Column(name = "questions")
    private String questions;
    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private LocalDateTime created_at;
    @Column(name = "created_by")
    private Long created_by;
    @Column(name = "updated_at")
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private LocalDateTime updated_at;
    @Column(name = "updated_by")
    private Long updated_by;

}
