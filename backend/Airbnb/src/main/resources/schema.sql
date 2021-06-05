DROP TABLE IF EXISTS `wishlist`;
DROP TABLE IF EXISTS `reserve`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `room`;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema airbnb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema airbnb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `airbnb` DEFAULT CHARACTER SET utf8;
USE `airbnb`;

-- -----------------------------------------------------
-- Table `airbnb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`user`;

CREATE TABLE IF NOT EXISTS `airbnb`.`user`
(
    `id`       VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `nickname` VARCHAR(45) NULL,
    `email`    VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`room`;

CREATE TABLE IF NOT EXISTS `airbnb`.`room`
(
    `id`           INT           NOT NULL AUTO_INCREMENT,
    `location`     VARCHAR(45)   NOT NULL,
    `title`        VARCHAR(100)  NOT NULL,
    `image`        VARCHAR(500)  NULL,
    `description`  VARCHAR(1000) NULL,
    `x_pos`        VARCHAR(45)   NOT NULL,
    `y_pos`        VARCHAR(45)   NOT NULL,
    `ratings`      DOUBLE        NULL,
    `reviews`      INT           NULL,
    `charge`       INT           NOT NULL,
    `cleaning_fee` INT           NULL,
    `service_fee`  INT           NULL,
    `tax_fee`      INT           NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`wishlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`wishlist`;

CREATE TABLE IF NOT EXISTS `airbnb`.`wishlist`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(45) NOT NULL,
    `room_id` INT         NOT NULL,
    INDEX `fk_wishlist_user_idx` (`user_id` ASC) VISIBLE,
    INDEX `fk_wishlist_room1_idx` (`room_id` ASC) VISIBLE,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_wishlist_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `airbnb`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_wishlist_room1`
        FOREIGN KEY (`room_id`)
            REFERENCES `airbnb`.`room` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`reserve`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airbnb`.`reserve`;

CREATE TABLE IF NOT EXISTS `airbnb`.`reserve`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `user_id`   VARCHAR(45) NOT NULL,
    `room_id`   INT         NOT NULL,
    `check_in`  VARCHAR(45) NULL,
    `check_out` VARCHAR(45) NULL,
    `guests`    INT         NULL,
    INDEX `fk_table1_user1_idx` (`user_id` ASC) VISIBLE,
    INDEX `fk_table1_room1_idx` (`room_id` ASC) VISIBLE,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_table1_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `airbnb`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_table1_room1`
        FOREIGN KEY (`room_id`)
            REFERENCES `airbnb`.`room` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
