CREATE DATABASE sapsi;

CREATE USER 'sapsi_user'@'localhost' IDENTIFIED BY 'qwe123';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, ALTER ON sapsi.* TO 'sapsi_user'@'localhost';