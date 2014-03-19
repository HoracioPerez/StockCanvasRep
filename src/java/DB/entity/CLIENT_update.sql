USE `stock_canvas`;
DROP procedure IF EXISTS `CLIENT_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`CLIENT_update` 
(IN p_id BIGINT,IN p_name VARCHAR(45), 
IN p_last_name VARCHAR(45),
IN p_email VARCHAR(60),
IN p_phone VARCHAR(45),
IN p_address VARCHAR(45),
IN p_active TINYINT)

BEGIN
	UPDATE `CLIENT` 
	SET  `name`=p_name, `last_name`=p_last_name, `email`=p_email, `phone`=p_phone, `address`=p_address, `active`=p_active  
	WHERE `id`=p_id;
END$$
DELIMITER ;