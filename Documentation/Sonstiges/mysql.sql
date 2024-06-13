-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema m245
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `module` (
  `modul_id` INT NOT NULL AUTO_INCREMENT,
  `modul_description` VARCHAR(45) NOT NULL,
  `modul_name` VARCHAR(45) NOT NULL,
  `modul_day` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`modul_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` ENUM('ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN') NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sidequests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sidequests` (
  `sq_id` INT NOT NULL AUTO_INCREMENT,
  `sq_Name` VARCHAR(45) NOT NULL,
  `sq_Description` VARCHAR(45) NOT NULL,
  `sq_Day` VARCHAR(45) NOT NULL,
  `Module_modul_id` INT NOT NULL,
  `sq_time` VARCHAR(45) NOT NULL,
  `sq_Week` VARCHAR(45) NOT NULL,
  `sq_deadline` DATE GENERATED ALWAYS AS () STORED,
  PRIMARY KEY (`sq_id`),
  INDEX `fk_SideQuests_Module1_idx` (`Module_modul_id` ASC) VISIBLE,
  CONSTRAINT `fk_SideQuests_Module1`
    FOREIGN KEY (`Module_modul_id`)
    REFERENCES `module` (`modul_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `password` VARCHAR(120) NULL DEFAULT NULL,
  `username` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKr43af9ap4edm43mmtq01oddj6` (`username` ASC) VISIBLE,
  UNIQUE INDEX `UK6dotkott2kjsp8vw4d0m25fb7` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` BIGINT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id` ASC) VISIBLE,
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6`
    FOREIGN KEY (`role_id`)
    REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `User_SQS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `User_SQS` (
  `id` INT NOT NULL,
  `sq_id` INT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `user_sqStatus` TINYINT GENERATED ALWAYS AS (false) STORED,
  PRIMARY KEY (`id`, `user_id`, `sq_id`),
  INDEX `fk_SideQuests_User_Sidequest1_idx` (`sq_id` ASC) VISIBLE,
  INDEX `fk_SideQuests_User_User1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_SideQuests_User_Sidequest1`
    FOREIGN KEY (`sq_id`)
    REFERENCES `sidequests` (`sq_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_SideQuests_User_User1`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
