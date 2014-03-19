USE `stock_canvas`;
DROP procedure IF EXISTS `PRODUCT_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PRODUCT_delete` (IN p_id BIGINT)
BEGIN
	UPDATE `PRODUCT` 
	SET  `active`=0 
	WHERE `id`=p_id;
END$$
DELIMITER ;