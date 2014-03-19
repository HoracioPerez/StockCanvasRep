USE `stock_canvas`;
DROP procedure IF EXISTS `DISCOUNT_CLIENT_ORDER_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DISCOUNT_CLIENT_ORDER_delete` (IN p_id BIGINT)
BEGIN
	UPDATE `DISCOUNT_CLIENT_ORDER` 
	SET  `active`=0
	WHERE `id`=p_id;
END$$
DELIMITER ;