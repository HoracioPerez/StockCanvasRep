USE `stock_canvas`;
DROP procedure IF EXISTS `DETAIL_PURCHASE_ORDER_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DETAIL_PURCHASE_ORDER_update` 
(IN p_id BIGINT,
IN p_amount BIGINT, 
IN p_price DOUBLE,
IN p_id_product BIGINT,
IN p_id_order BIGINT)
BEGIN
	UPDATE `DETAIL_PURCHASE_ORDER` 
	SET  `amount`=p_amount, `price`=p_price, `id_product`=p_id_product, `id_order`=p_id_order
	WHERE `id`=p_id;
END$$



DELIMITER ;