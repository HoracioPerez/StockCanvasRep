USE `stock_canvas`;
DROP procedure IF EXISTS `PROVIDER_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PROVIDER_delete` (IN p_id BIGINT)
BEGIN
	UPDATE `PROVIDER` 
	SET  `active`=0 
	WHERE `id`=p_id;
END$$
DELIMITER ;