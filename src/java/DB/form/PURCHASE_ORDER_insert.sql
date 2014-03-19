USE `stock_canvas`;
DROP procedure IF EXISTS `PURCHASE_ORDER_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`PURCHASE_ORDER_insert` 
(IN p_state VARCHAR(45), 
IN p_date DATE,
IN p_id_user VARCHAR(45),
IN p_id_provider BIGINT)

BEGIN
	INSERT INTO `PURCHASE_ORDER` (`state`,`date`,`id_user`,`id_client`) 
	VALUE (p_state,p_date,p_id_user,p_id_provider);
	SELECT MAX(`id`) AS id FROM `PURCHASE_ORDER`;
END$$



DELIMITER ;