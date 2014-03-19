USE `stock_canvas`;
DROP procedure IF EXISTS `PAYMENT_TYPE_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PAYMENT_TYPE_update` 
(IN p_id BIGINT,
IN p_name VARCHAR(45), 
IN p_summary VARCHAR(100),
IN p_id_active TINYINT)
BEGIN
	UPDATE `PAYMENT_TYPE` 
	SET  `name`=p_name, `summary`=p_summary, `active`=p_active
	WHERE `id`=p_id;
END$$



DELIMITER ;