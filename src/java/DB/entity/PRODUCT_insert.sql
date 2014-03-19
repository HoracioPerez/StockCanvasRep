USE `stock_canvas`;
DROP procedure IF EXISTS `PRODUCT_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PRODUCT_insert` 
(IN p_name VARCHAR(45), 
IN p_price DOUBLE,
IN p_detail TEXT,
IN p_id_category BIGINT,
IN p_active TINYINT)

BEGIN
	DECLARE p_id BIGINT;
	INSERT INTO `PRODUCT` (`name`,`price`,`detail`,`id_category`,`active`) 
	VALUE (p_name,p_price,p_detail,p_id_category,p_active);
	SELECT MAX(`id`) into p_id FROM `PRODUCT`;
	INSERT INTO `STOCK` (`id`,`exist_stock`,`trafic_stock`,`reserve_stock`) 
	VALUE (p_id,0,0,0);
        SELECT MAX(`id`) AS id FROM `PRODUCT`;
END$$



DELIMITER ;