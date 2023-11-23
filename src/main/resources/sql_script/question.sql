create table question(question_id bigint auto_increment,tag varchar(15),
                       questions varchar(500),created_at datetime,created_by bigint(15),
                      updated_at datetime,updated_by bigint(15),primary key(question_id));