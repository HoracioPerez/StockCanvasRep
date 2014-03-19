USE `stock_canvas`;
DROP procedure IF EXISTS `DISCOUNT_DETAIL_CLIENT_ORDER_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DISCOUNT_DETAIL_CLIENT_ORDER_update` 
(IN p_id BIGINT,
IN p_amount DOUBLE, 
IN p_id_discount BIGINT,
IN p_id_order BIGINT)
BEGIN
	UPDATE `DISCOUNT_DETAIL_CLIENT_ORDER` 
	SET  `amount`=p_amount, `id_discount`=p_id_discount, `id_order`=p_id_order
	WHERE `id`=p_id;
END$$



DELIMITER ;