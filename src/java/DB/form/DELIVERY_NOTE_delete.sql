USE `stock_canvas`;
DROP procedure IF EXISTS `DELIVERY_NOTE_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DELIVERY_NOTE_delete` (IN p_id BIGINT)
BEGIN
	DELETE FROM `DELIVERY_NOTE` 
	WHERE `id`=p_id;
END$$
DELIMITER ;