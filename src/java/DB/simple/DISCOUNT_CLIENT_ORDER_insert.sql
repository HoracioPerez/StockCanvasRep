USE `stock_canvas`;
DROP procedure IF EXISTS `DISCOUNT_CLIENT_ORDER_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DISCOUNT_CLIENT_ORDER_insert` 
(IN p_name VARCHAR(45), 
IN p_summary VARCHAR(100),
IN p_percentage INT,
IN p_id_active TINYINT)

BEGIN
	INSERT INTO `DISCOUNT_CLIENT_ORDER` (`name`,`summary`,`percentage`,`active`) 
	VALUE (p_name,p_summary,p_percentage,p_id_active);
	SELECT MAX(`id`) AS id FROM `DISCOUNT_CLIENT_ORDER`;
END$$
DELIMITER ;