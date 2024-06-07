-- -----------------------------------------------------
-- Insert data into `m245`.`module`
-- -----------------------------------------------------
INSERT INTO `m245`.`module` (`modul_description`, `modul_name`, `modul_day`) VALUES 
('Description 1', 'Module 1', 'Monday'),
('Description 2', 'Module 2', 'Tuesday'),
('Description 3', 'Module 3', 'Wednesday');

-- -----------------------------------------------------
-- Insert data into `m245`.`roles`
-- -----------------------------------------------------
INSERT INTO `m245`.`roles` (`name`) VALUES 
('ROLE_USER'),
('ROLE_MODERATOR'),
('ROLE_ADMIN');

-- -----------------------------------------------------
-- Insert data into `m245`.`sidequests`
-- -----------------------------------------------------
INSERT INTO `m245`.`sidequests` (`sq_Name`, `sq_Description`, `sq_Day`, `Module_modul_id`, `sq_time`, `sq_Week`, `sq_deadline`) VALUES 
('Sidequest 1', 'Sidequest Description 1', 'Monday', 1, '10:00', 'Week 1', '2024-12-31 23:59:59'),
('Sidequest 2', 'Sidequest Description 2', 'Tuesday', 2, '11:00', 'Week 2', '2024-12-31 23:59:59'),
('Sidequest 3', 'Sidequest Description 3', 'Wednesday', 3, '12:00', 'Week 3', '2024-12-31 23:59:59');

-- -----------------------------------------------------
-- Insert data into `m245`.`tasks`
-- -----------------------------------------------------
INSERT INTO `m245`.`tasks` (`task_date`, `task_description`, `task_name`, `task_status`) VALUES 
('2024-06-06', 'Task Description 1', 'Task 1', 'Pending'),
('2024-06-07', 'Task Description 2', 'Task 2', 'Completed');

-- -----------------------------------------------------
-- Insert data into `m245`.`users`
-- -----------------------------------------------------
INSERT INTO `m245`.`users` (`email`, `password`, `username`) VALUES 
('user1@example.com', 'password1', 'user1'),
('user2@example.com', 'password2', 'user2'),
('user3@example.com', 'password3', 'user3');

-- -----------------------------------------------------
-- Insert data into `m245`.`user_roles`
-- -----------------------------------------------------
INSERT INTO `m245`.`user_roles` (`user_id`, `role_id`) VALUES 
(1, 1),
(2, 2),
(3, 3);

-- -----------------------------------------------------
-- Insert data into `m245`.`user_sqs`
-- -----------------------------------------------------
INSERT INTO `m245`.`user_sqs` (`sq_id`, `user_id`, `user_sqStatus`, `user_sq_status_finish`, `user_sq_status`) VALUES 
(1, 1, 1, 0, 0),
(2, 2, 1, 1, 1),
(3, 3, 0, 1, 1);
