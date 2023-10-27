package com.mkpits.learningplatform.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "usercourse")
public class UserCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCourseId;
    @Column(name = "user_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "user_course_name")
    private  String userCourseName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "register_date")
    private Date registerDate;

    public int getUserCourseId() {
        return userCourseId;
    }

    public void setUserCourseId(int userCourseId) {
        this.userCourseId = userCourseId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserCourseName() {
        return userCourseName;
    }

    public void setUserCourseName(String userCourseName) {
        this.userCourseName = userCourseName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
