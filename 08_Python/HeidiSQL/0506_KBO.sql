CREATE DATABASE kbo;

USE kbo;

CREATE TABLE `kbo_players` (
	`구단명` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`선수명` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`등번호` INT(11) NULL DEFAULT NULL,
	`생년월일` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`포지션` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`신장/체중` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`경력` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`입단 계약금` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`연봉` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`지명순위` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`입단년도` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci'
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;