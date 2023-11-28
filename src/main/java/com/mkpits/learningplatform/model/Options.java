package com.mkpits.learningplatform.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private long option_id;

    @Column(name = "question_id")
    private long question_id;

    @Column(name = "tag")
    private String tag;

    @Column(name = "que_option")
    private String que_option;

    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(name = "created_by")
    private Long created_by;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @CreationTimestamp
    @Column(name = "updated_at")
    private  LocalDateTime updated_at;

    @Column(name ="updated_by")
    private Long updated_by;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "question_id", nullable = false, insertable = false, updatable = false)
    @Fetch(FetchMode.SELECT)
    private Question question;
}
