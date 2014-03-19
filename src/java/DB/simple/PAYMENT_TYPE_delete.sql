USE `stock_canvas`;
DROP procedure IF EXISTS `PAYMENT_TYPE_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PAYMENT_TYPE_delete` (IN p_id BIGINT)
BEGIN
	UPDATE `PAYMENT_TYPE` 
	SET  `active`=0
	WHERE `id`=p_id;
END$$
DELIMITER ;