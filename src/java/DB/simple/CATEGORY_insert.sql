USE `stock_canvas`;
DROP procedure IF EXISTS `CATEGORY_insert`;
DELIMITER $$
USE `stock_canvas`$$
CREATE PROCEDURE `stock_canvas`.`CATEGORY_insert` 
(IN p_name VARCHAR(45), 
IN p_summary VARCHAR(100),
IN p_id_active TINYINT)

BEGIN
	INSERT INTO `CATEGORY` (`name`,`summary`,`active`) 
	VALUE (p_name,p_summary,p_id_active);
	SELECT MAX(`id`) AS id FROM `CATEGORY`;
END$$
DELIMITER ;