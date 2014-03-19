USE `stock_canvas`;
DROP procedure IF EXISTS `RESERVATION_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`RESERVATION_insert` 
(IN p_state VARCHAR(45), 
IN p_date DATE,
IN p_id_user VARCHAR(45),
IN p_id_client_order BIGINT)

BEGIN
	INSERT INTO `RESERVATION` (`state`,`date`,`id_user`,`id_client_order`) 
	VALUE (p_state,p_date,p_id_user,p_id_client_order);
	SELECT MAX(`id`) AS id FROM `RESERVATION`;
END$$



DELIMITER ;