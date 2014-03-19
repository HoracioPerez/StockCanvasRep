USE `stock_canvas`;
DROP procedure IF EXISTS `DISCOUNT_CLIENT_ORDER_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DISCOUNT_CLIENT_ORDER_update` 
(IN p_id BIGINT,
IN p_name VARCHAR(45), 
IN p_summary VARCHAR(100),
IN p_percentage INT,
IN p_id_active TINYINT)
BEGIN
	UPDATE `DISCOUNT_CLIENT_ORDER` 
	SET  `name`=p_name, `summary`=p_summary, `percentage`=p_percentage, `active`=p_active
	WHERE `id`=p_id;
END$$



DELIMITER ;