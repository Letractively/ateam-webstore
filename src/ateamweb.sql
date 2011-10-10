--
-- product
--

DROP TABLE PRODUCT;

CREATE TABLE PRODUCT  (
    product_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY , 
    name VARCHAR(100) NOT NULL ,
    price DOUBLE NOT NULL ,
    description VARCHAR(512) NOT NULL 
)

insert into PRODUCT (product_id, name, price, description)
values(1, "iMac", 5000.0, "iMac computer");

insert into PRODUCT (product_id, name, price, description)
values(2, "iPod", 500.0, "iPod music player");

insert into PRODUCT (product_id, name, price, description)
values(3, "iPhone", 700.0, "iPhone smart phone");

insert into PRODUCT (product_id, name, price, description)
values(4, "iPad", 1000.0, "iPad tablet");

select * from PRODUCT;
