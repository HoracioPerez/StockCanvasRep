USE `stock_canvas`;
DROP procedure IF EXISTS `PAYMENT_DETAIL_ADVANCE_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PAYMENT_DETAIL_ADVANCE_insert` 
(IN p_amount DOUBLE, 
IN p_id_payment_type BIGINT,
IN p_id_order BIGINT)

BEGIN
	INSERT INTO `PAYMENT_DETAIL_ADVANCE` (`amount`, `id_payment_type`, `id_order`) 
	VALUE (p_amount, p_id_payment_type, p_id_order);
	SELECT MAX(`id`) AS id FROM `PAYMENT_DETAIL_ADVANCE`;
END$$

DELIMITER ;