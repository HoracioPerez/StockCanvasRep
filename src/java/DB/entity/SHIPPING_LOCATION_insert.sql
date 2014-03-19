USE `stock_canvas`;
DROP procedure IF EXISTS `SHIPPING_LOCATION_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`SHIPPING_LOCATION_insert` 
(IN p_contact_name VARCHAR(45), 
IN p_street VARCHAR(45),
IN p_cp VARCHAR(60),
IN p_province VARCHAR(45),
IN p_country VARCHAR(45),
IN p_time VARCHAR(45),
IN p_id_client BIGINT,
IN p_active TINYINT)

BEGIN
	INSERT INTO `SHIPPING_LOCATION` (`contact_name`,`street`,`cp`,`province`,`country`,`time`,`id_client`,`active`) 
	VALUE (p_contact_name,p_street,p_cp,p_province,p_country,p_time,p_id_client,p_active);
	SELECT MAX(`id`) AS id FROM `SHIPPING_LOCATION`;
END$$
DELIMITER ;