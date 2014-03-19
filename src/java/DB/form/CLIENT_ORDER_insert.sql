USE `stock_canvas`;
DROP procedure IF EXISTS `CLIENT_ORDER_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`CLIENT_ORDER_insert` 
(IN p_state VARCHAR(45), 
IN p_date DATE,
IN p_id_user VARCHAR(45))

BEGIN
	INSERT INTO `CLIENT_ORDER` (`state`,`date`,`id_user`) 
	VALUE (p_state,p_date,p_id_user);
	SELECT MAX(`id`) AS id FROM `CLIENT_ORDER`;
END$$



DELIMITER ;