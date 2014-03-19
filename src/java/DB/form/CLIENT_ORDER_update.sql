USE `stock_canvas`;
DROP procedure IF EXISTS `CLIENT_ORDER_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`CLIENT_ORDER_update` 
(IN p_id BIGINT,
IN p_state VARCHAR(45), 
IN p_date DATE,
IN p_id_user VARCHAR(45),
IN p_id_client BIGINT)
BEGIN
	UPDATE `CLIENT_ORDER` 
	SET  `state`=p_state, `date`=p_date, `id_user`=p_id_user, `id_client`=p_id_client
	WHERE `id`=p_id;
END$$



DELIMITER ;