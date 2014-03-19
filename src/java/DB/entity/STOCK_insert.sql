USE `stock_canvas`;
DROP procedure IF EXISTS `STOCK_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`STOCK_insert` 
(IN p_exist_stock BIGINT, 
IN p_trafic_stock BIGINT,
IN p_reserve_stock BIGINT,
IN p_id_product BIGINT)

BEGIN
	INSERT INTO `STOCK` (`exist_stock`,`trafic_stock`,`reserve_stock`,`id_product`) 
	VALUE (p_exist_stock,p_trafic_stock,p_reserve_stock,p_id_product);
	SELECT MAX(`id`) AS id FROM `STOCK`;
END$$
DELIMITER ;