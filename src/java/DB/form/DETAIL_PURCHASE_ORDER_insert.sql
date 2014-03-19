USE `stock_canvas`;
DROP procedure IF EXISTS `DETAIL_PURCHASE_ORDER_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DETAIL_PURCHASE_ORDER_insert` 
(IN p_amount BIGINT, 
IN p_price DOUBLE,
IN p_id_product BIGINT,
IN p_id_order BIGINT)

BEGIN
	INSERT INTO `DETAIL_PURCHASE_ORDER` (`amount`,`price`,`id_product`,`id_order`) 
	VALUE (p_amount,p_price,p_id_product,p_id_order);
	SELECT MAX(`id`) AS id FROM `DETAIL_PURCHASE_ORDER`;
END$$



DELIMITER ;