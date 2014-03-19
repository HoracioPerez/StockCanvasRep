USE `stock_canvas`;
DROP procedure IF EXISTS `SHIPPING_LOCATION_update`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`SHIPPING_LOCATION_update` 
(IN p_id BIGINT,
IN p_contact_name VARCHAR(45), 
IN p_street VARCHAR(45),
IN p_cp VARCHAR(60),
IN p_province VARCHAR(45),
IN p_country VARCHAR(45),
IN p_time VARCHAR(45),
IN p_id_client BIGINT,
IN p_active TINYINT)
BEGIN
	UPDATE `SHIPPING_LOCATION` 
	SET  `contact_name`=p_contact_name, `street`=p_street, `cp`=p_cp, `province`=p_province, `country`=p_country,`time`=p_time,`id_client`=p_id_client, `active`=p_active  
	WHERE `id`=p_id;
END$$
DELIMITER ;