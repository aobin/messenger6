CREATE TABLE `user_role_new` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  UNIQUE KEY `user_id_role_id_up` (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
