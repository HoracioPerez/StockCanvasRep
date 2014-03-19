USE `stock_canvas`;
DROP procedure IF EXISTS `DISCOUNT_DETAIL_PURCHASE_ORDER_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DISCOUNT_DETAIL_PURCHASE_ORDER_delete` (IN p_id BIGINT)
BEGIN
	DELETE FROM `DISCOUNT_DETAIL_PURCHASE_ORDER` 
	WHERE `id`=p_id;
END$$
DELIMITER ;