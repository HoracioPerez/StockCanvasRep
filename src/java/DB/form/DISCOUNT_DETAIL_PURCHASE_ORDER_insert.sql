USE `stock_canvas`;
DROP procedure IF EXISTS `DISCOUNT_DETAIL_PURCHASE_ORDER_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DISCOUNT_DETAIL_PURCHASE_ORDER_insert` 
(IN p_amount DOUBLE, 
IN p_id_discount BIGINT,
IN p_id_order BIGINT)

BEGIN
	INSERT INTO `DISCOUNT_DETAIL_PURCHASE_ORDER` (`amount`, `id_discount`, `id_order`) 
	VALUE (p_amount, p_id_discount, p_id_order);
	SELECT MAX(`id`) AS id FROM `DISCOUNT_DETAIL_PURCHASE_ORDER`;
END$$



DELIMITER ;