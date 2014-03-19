USE `stock_canvas`;
DROP procedure IF EXISTS `CATEGORY_delete`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`CATEGORY_delete` (IN p_id BIGINT)
BEGIN
	UPDATE `CATEGORY` 
	SET  `active`=0
	WHERE `id`=p_id;
END$$
DELIMITER ;