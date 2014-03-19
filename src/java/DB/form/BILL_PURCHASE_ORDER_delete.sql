USE `stock_canvas`;
DROP procedure IF EXISTS `BILL_PURCHASE_ORDER_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`BILL_PURCHASE_ORDER_delete` (IN p_id BIGINT)
BEGIN
	DELETE FROM `BILL_PURCHASE_ORDER` 
	WHERE `id`=p_id;
END$$
DELIMITER ;