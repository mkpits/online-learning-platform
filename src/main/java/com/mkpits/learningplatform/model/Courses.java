package com.mkpits.learningplatform.model;

import jdk.jfr.Enabled;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "courses")
public class Courses {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long courseId;
        private String courseName;
        private String description;
        private long instructionId;
        private int createdBy;
        private int updatedBy;
        private Date updatedAt;
        private Date createdAt;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date startDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date endDate;

        public long getCourseId() {
                return courseId;
        }

        public void setCourseId(long courseId) {
                this.courseId = courseId;
        }

        public String getCourseName() {
                return courseName;
        }

        public void setCourseName(String courseName) {
                this.courseName = courseName;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public long getInstructionId() {
                return instructionId;
        }

        public void setInstructionId(long instructionId) {
                this.instructionId = instructionId;
        }

        public Date getStartDate() {
                return startDate;
        }

        public void setStartDate(Date startDate) {
                this.startDate = startDate;
        }

        public Date getEndDate() {
                return endDate;
        }

        public void setEndDate(Date endDate) {
                this.endDate = endDate;
        }

        public int getCreatedBy() {
                return createdBy;
        }

        public void setCreatedBy(int createdBy) {
                this.createdBy = createdBy;
        }

        public int getUpdatedBy() {
                return updatedBy;
        }

        public void setUpdatedBy(int updatedBy) {
                this.updatedBy = updatedBy;
        }

        public Date getUpdatedAt() {
                return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
                this.updatedAt = updatedAt;
        }

        public Date getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
                this.createdAt = createdAt;
        }
}
