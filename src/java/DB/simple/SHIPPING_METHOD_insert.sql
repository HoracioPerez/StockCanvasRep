USE `stock_canvas`;
DROP procedure IF EXISTS `SHIPPING_METHOD_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`SHIPPING_METHOD_insert` 
(IN p_name VARCHAR(45), 
IN p_summary VARCHAR(100),
IN p_id_active TINYINT)

BEGIN
	INSERT INTO `SHIPPING_METHOD` (`name`,`summary`,`active`) 
	VALUE (p_name,p_summary,p_id_active);
	SELECT MAX(`id`) AS id FROM `SHIPPING_METHOD`;
END$$
DELIMITER ;