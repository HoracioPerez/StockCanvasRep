USE `stock_canvas`;
DROP procedure IF EXISTS `CATEGORY_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`CATEGORY_update` 
(IN p_id BIGINT,
IN p_name VARCHAR(45), 
IN p_summary VARCHAR(100),
IN p_id_active TINYINT)
BEGIN
	UPDATE `CATEGORY` 
	SET  `name`=p_name, `summary`=p_summary, `active`=p_active
	WHERE `id`=p_id;
END$$



DELIMITER ;