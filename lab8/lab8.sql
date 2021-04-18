CREATE TABLE `mydb`.`movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `release_date` DATETIME NOT NULL,
  `duration` DOUBLE NOT NULL,
  `score` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE);
  
  
  CREATE TABLE `mydb`.`genres` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `mydb`.`asoc` (
  `id_movie` INT NOT NULL,
  `id_genre` INT NOT NULL);
  
  ALTER TABLE `mydb`.`asoc` 
ADD INDEX `id_idx1` (`id_movie` ASC) VISIBLE,
ADD INDEX `id-g_idx2` (`id_genre` ASC) VISIBLE;
;
ALTER TABLE `mydb`.`asoc` 
ADD CONSTRAINT `id-m`
  FOREIGN KEY (`id_movie`)
  REFERENCES `mydb`.`movies` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `id-g`
  FOREIGN KEY (`id_genre`)
  REFERENCES `mydb`.`genres` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
