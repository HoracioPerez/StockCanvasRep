USE `stock_canvas`;
DROP procedure IF EXISTS `DELIVERY_NOTE_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`DELIVERY_NOTE_update` 
(IN p_id BIGINT,
IN p_state VARCHAR(45), 
IN p_date DATE,
IN p_id_user VARCHAR(45),
IN p_id_shipping_method BIGINT,
IN p_id_shipping_location BIGINT,
IN p_id_client_order BIGINT)
BEGIN
	UPDATE `DELIVERY_NOTE` 
	SET  `state`=p_state, `date`=p_date, `id_user`=p_id_user, `id_shipping_method`=p_id_shipping_method, `id_shipping_location`=p_id_shipping_location, `id_client_order`=p_id_client_order
	WHERE `id`=p_id;
END$$



DELIMITER ;