USE `stock_canvas`;
DROP procedure IF EXISTS `USER_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`USER_delete` (IN p_id BIGINT)
BEGIN	
	UPDATE `USER` 
	SET  `active`=0
	WHERE `id`=p_id;
END$$
DELIMITER ;