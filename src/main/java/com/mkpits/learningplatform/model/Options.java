package com.mkpits.learningplatform.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "options")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private long option_id;
    @Column(name = "que_id")
    private long que_id;
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
}
