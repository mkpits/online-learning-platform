package com.mkpits.learningplatform.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "user")
    private List<Courses> courses;

    @NotBlank(message = "Name field is required")
    @Size(min = 3, max = 30, message = "maximum 30 character accepted")
    @Column(name = "display_name")
    private String displayName;

    @NotBlank(message = "email field is required")
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Password field is required")
//    @Size(min = 3,max = 10, message = "maximum 10 character accepted")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Mobile Number field is required")
    @Size(min = 10, max = 12, message = " Enter 10 digit mobile number")
    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "age")
    private Integer age;

    @Column(name = "role_value")
    private String roleValue;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
