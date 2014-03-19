USE `stock_canvas`;
DROP procedure IF EXISTS `USER_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`USER_update` 
(IN p_id VARCHAR(45), 
IN p_pass VARCHAR(45),
IN p_active TINYINT)
BEGIN
	UPDATE `USER` 
	SET  `pass`=p_pass, `active`=p_active
	WHERE `id`=p_id;
END$$
DELIMITER ;