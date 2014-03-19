USE `stock_canvas`;
DROP procedure IF EXISTS `BILL_CLIENT_ORDER_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`BILL_CLIENT_ORDER_update` 
(IN p_id BIGINT,
IN p_type VARCHAR(45), 
IN p_cuit VARCHAR(45),
IN p_state VARCHAR(45),
IN p_date DATE,
IN p_id_user VARCHAR(45),
IN p_id_order BIGINT)
BEGIN
	UPDATE `BILL_CLIENT_ORDER` 
	SET  `type`=p_type, `cuit`=p_cuit, `state`=p_state, `date`=p_date,`id_user`=p_id_user, `id_order`=p_id_order 
	WHERE `id`=p_id;
END$$



DELIMITER ;