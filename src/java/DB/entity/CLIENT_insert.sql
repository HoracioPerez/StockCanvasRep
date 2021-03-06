USE `stock_canvas`;
DROP procedure IF EXISTS `CLIENT_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`CLIENT_insert` 
(IN p_name VARCHAR(45), 
IN p_last_name VARCHAR(45),
IN p_email VARCHAR(60),
IN p_phone VARCHAR(45),
IN p_address VARCHAR(45),
IN p_active TINYINT)

BEGIN
	INSERT INTO `CLIENT` (`name`,`last_name`,`email`,`phone`,`address`,`active`) 
	VALUE (p_name,p_last_name,p_email,p_phone,p_address,p_active);
	SELECT MAX(`id`) AS id FROM `CLIENT`;
END$$
DELIMITER ;