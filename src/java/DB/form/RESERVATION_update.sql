USE `stock_canvas`;
DROP procedure IF EXISTS `RESERVATION_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`RESERVATION_update` 
(IN p_id BIGINT,
IN p_state VARCHAR(45), 
IN p_date DATE,
IN p_id_user VARCHAR(45),
IN p_id_client_order BIGINT)
BEGIN
	UPDATE `RESERVATION` 
	SET  `state`=p_state, `date`=p_date, `id_user`=p_id_user, `id_client_order`=p_id_client_order
	WHERE `id`=p_id;
END$$



DELIMITER ;