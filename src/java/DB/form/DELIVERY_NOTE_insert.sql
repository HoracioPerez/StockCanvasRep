USE `stock_canvas`;
DROP procedure IF EXISTS `DELIVERY_NOTE_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DELIVERY_NOTE_insert` 
(IN p_state VARCHAR(45), 
IN p_date DATE,
IN p_id_user VARCHAR(45),
IN p_id_shipping_method BIGINT,
IN p_id_shipping_location BIGINT,
IN p_id_client_order BIGINT)

BEGIN
	INSERT INTO `DELIVERY_NOTE` (`state`,`date`,`id_user`,`id_shipping_method`,`id_shipping_location`,`id_client_order`) 
	VALUE (p_state,p_date,p_id_user,p_id_shipping_method,p_id_shipping_location,p_id_client_order);
	SELECT MAX(`id`) AS id FROM `DELIVERY_NOTE`;
END$$



DELIMITER ;