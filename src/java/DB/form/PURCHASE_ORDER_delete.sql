USE `stock_canvas`;
DROP procedure IF EXISTS `PURCHASE_ORDER_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PURCHASE_ORDER_delete` (IN p_id BIGINT)
BEGIN
	DELETE FROM `PURCHASE_ORDER` 
	WHERE `id`=p_id;
END$$
DELIMITER ;