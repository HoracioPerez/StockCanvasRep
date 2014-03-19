USE `stock_canvas`;
DROP procedure IF EXISTS `PAYMENT_DETAIL_ADVANCE_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PAYMENT_DETAIL_ADVANCE_update` 
(IN p_id BIGINT,
IN p_amount DOUBLE, 
IN p_id_payment_type BIGINT,
IN p_id_order BIGINT)
BEGIN
	UPDATE `PAYMENT_DETAIL_ADVANCE` 
	SET  `amount`=p_amount, `id_payment_type`=p_id_payment_type, `id_order`=p_id_order
	WHERE `id`=p_id;
END$$



DELIMITER ;