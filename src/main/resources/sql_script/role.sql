CREATE TABLE `online_learning`.`role` (
                                          `role_id` INT(11) NOT NULL AUTO_INCREMENT,
                                          `role_value` VARCHAR(15) NOT NULL,
                                          `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                                          `updated_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
                                          `created_by` INT(11) NULL,
                                          `updated_by` INT(11) NULL,
                                          PRIMARY KEY (`role_id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;