USE `stock_canvas`;
DROP procedure IF EXISTS `USER_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`USER_insert` 
(IN p_id VARCHAR(45), 
IN p_pass VARCHAR(45),
IN p_active TINYINT)

BEGIN
	INSERT INTO `USER` (`id`,`pass`,`active`) 
	VALUE (p_id,p_pass,p_active);
	SELECT MAX(`id`) AS id FROM `USER`;
END$$
DELIMITER ;