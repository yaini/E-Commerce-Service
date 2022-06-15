CREATE USER 'order'@'localhost' IDENTIFIED BY 'order';
CREATE USER 'order'@'%' IDENTIFIED BY 'order';

GRANT ALL PRIVILEGES ON *.* TO 'order'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'order'@'%';

CREATE DATABASE ECOMMERCE_ORDER;
