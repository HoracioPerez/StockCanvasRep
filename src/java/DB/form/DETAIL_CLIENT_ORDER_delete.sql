USE `stock_canvas`;
DROP procedure IF EXISTS `DETAIL_CLIENT_ORDER_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DETAIL_CLIENT_ORDER_delete` (IN p_id BIGINT)
BEGIN
	DELETE FROM `DETAIL_CLIENT_ORDER` 
	WHERE `id`=p_id;
END$$
DELIMITER ;