package com.mkpits.learningplatform.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private long question_id;
    @Column(name = "tag")
    private String tag;
    @Column(name = "questions")
    private String questions;
    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @CreationTimestamp
    private LocalDateTime created_at;
    @Column(name = "created_by")
    private Long created_by;
    @Column(name = "updated_at")
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @CreationTimestamp
    private LocalDateTime updated_at;
    @Column(name = "updated_by")
    private Long updated_by;

//    @OneToMany(mappedBy = "question")
//    private List<Options> options;

}
