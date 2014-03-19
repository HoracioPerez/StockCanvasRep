USE `stock_canvas`;
DROP procedure IF EXISTS `SHIPPING_METHOD_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`SHIPPING_METHOD_delete` (IN p_id BIGINT)
BEGIN
	UPDATE `SHIPPING_METHOD` 
	SET  `active`=0
	WHERE `id`=p_id;
END$$
DELIMITER ;