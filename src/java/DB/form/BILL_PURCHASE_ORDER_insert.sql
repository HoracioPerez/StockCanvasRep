USE `stock_canvas`;
DROP procedure IF EXISTS `BILL_PURCHASE_ORDER_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`BILL_PURCHASE_ORDER_insert` 
(IN p_type VARCHAR(45), 
IN p_cuit VARCHAR(45),
IN p_state VARCHAR(45),
IN p_date DATE,
IN p_id_user VARCHAR(45),
IN p_id_order BIGINT)

BEGIN
	INSERT INTO `BILL_PURCHASE_ORDER` (`type`,`cuit`,`state`,`date`,`id_user`,`id_order`) 
	VALUE (p_type,p_cuit,p_state,p_date,p_id_user,p_id_order);
	SELECT MAX(`id`) AS id FROM `BILL_PURCHASE_ORDER`;
END$$



DELIMITER ;