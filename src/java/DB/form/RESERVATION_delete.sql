USE `stock_canvas`;
DROP procedure IF EXISTS `RESERVATION_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`RESERVATION_delete` (IN p_id BIGINT)
BEGIN
	DELETE FROM `RESERVATION` 
	WHERE `id`=p_id;
END$$
DELIMITER ;