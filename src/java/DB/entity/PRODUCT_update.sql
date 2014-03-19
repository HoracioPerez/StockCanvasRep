USE `stock_canvas`;
DROP procedure IF EXISTS `PRODUCT_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PRODUCT_update` 
(IN p_id BIGINT,
IN p_name VARCHAR(45), 
IN p_price DOUBLE,
IN p_detail TEXT,
IN p_id_category BIGINT,
IN p_active TINYINT)
BEGIN
	UPDATE `PRODUCT` 
	SET  `name`=p_name, `price`=p_price, `detail`=p_detail, `id_category`=p_id_category, `active`=p_active  
	WHERE `id`=p_id;
END$$



DELIMITER ;