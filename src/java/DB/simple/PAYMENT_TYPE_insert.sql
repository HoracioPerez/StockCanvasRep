USE `stock_canvas`;
DROP procedure IF EXISTS `PAYMENT_TYPE_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PAYMENT_TYPE_insert` 
(IN p_name VARCHAR(45), 
IN p_summary VARCHAR(100),
IN p_id_active TINYINT)

BEGIN
	INSERT INTO `PAYMENT_TYPE` (`name`,`summary`,`active`) 
	VALUE (p_name,p_summary,p_id_active);
	SELECT MAX(`id`) AS id FROM `PAYMENT_TYPE`;
END$$
DELIMITER ;