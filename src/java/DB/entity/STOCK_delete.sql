USE `stock_canvas`;
DROP procedure IF EXISTS `STOCK_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`STOCK_delete` (IN p_id BIGINT)
BEGIN	
	DELETE FROM `STOCK` 
	WHERE `id`=p_id;
END$$
DELIMITER ;