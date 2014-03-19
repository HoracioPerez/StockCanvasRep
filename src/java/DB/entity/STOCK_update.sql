USE `stock_canvas`;
DROP procedure IF EXISTS `STOCK_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`STOCK_update` 
(IN p_id BIGINT,
IN p_exist_stock BIGINT, 
IN p_trafic_stock BIGINT,
IN p_reserve_stock BIGINT,
IN p_id_product BIGINT)
BEGIN
	UPDATE `STOCK` 
	SET  `exist_stock`=p_exist_stock, `trafic_stock`=p_trafic_stock, `reserve_stock`=p_reserve_stock, `id_product`=p_id_product  
	WHERE `id`=p_id;
END$$
DELIMITER ;