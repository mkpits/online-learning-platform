CREATE TABLE online_learning.user ( user_id INT NOT NULL AUTO_INCREMENT,
                                    display_name VARCHAR(50) NOT NULL,
                                    email VARCHAR(50) NOT NULL,
                                    password VARCHAR(100) NOT NULL,
                                    mobile_number VARCHAR(12) NOT NULL,
                                    age INT(3) NOT NULL,
                                    role_value VARCHAR(15) NOT NULL DEFAULT 'STUDENT',
                                    role_id INT NULL,
                                    PRIMARY KEY (user_id),
                                    UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE);



ALTER TABLE online_learning.user
    ADD INDEX user_role_idx (role_id ASC) VISIBLE;


ALTER TABLE online_learning.user
    ADD CONSTRAINT user_role
        FOREIGN KEY (role_id)
            REFERENCES `online_learning`.`role` (`role_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;