CREATE TABLE `u316592767_onlinelearning`.`courses` (
                                                       `course_id` INT(11) NOT NULL AUTO_INCREMENT,
                                                       `user_id` INT(11) NULL,
                                                       `course_name` VARCHAR(50) NOT NULL,
                                                       `course_description` VARCHAR(100) NOT NULL,
                                                       `start_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                                                       `end_date` DATETIME NULL,
                                                       `created_by` INT(11) NULL,
                                                       `updated_by` INT(11) NULL,
                                                       `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                                                       `updated_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
                                                       PRIMARY KEY (`course_id`),
                                                       INDEX `course_user_fk_idx` (`user_id` ASC) VISIBLE,
                                                       CONSTRAINT `course_user_fk`
                                                           FOREIGN KEY (`user_id`)
                                                               REFERENCES `u316592767_onlinelearning`.`user` (`user_id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;
