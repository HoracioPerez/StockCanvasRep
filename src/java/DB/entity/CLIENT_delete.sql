USE `stock_canvas`;
DROP procedure IF EXISTS `CLIENT_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`CLIENT_delete` (IN p_id BIGINT)
BEGIN
	UPDATE `CLIENT` 
	SET  `active`=0 
	WHERE `id`=p_id;
END$$
DELIMITER ;