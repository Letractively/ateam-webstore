--
-- product
--
drop table PRODUCT;

CREATE TABLE PRODUCT (
	productID	INTEGER		NOT NULL AUTO_INCREMENT	,
	productName	VARCHAR(150)	NOT NULL		,
	SKU		CHAR(15)	NOT NULL		,
	price		DECIMAL(10,2)	NOT NULL		,
	percentDiscount	DECIMAL(6,4)	NOT NULL,
	description	VARCHAR(1000)	NOT NULL		,
	imagePath	CHAR(50)				,
	firstOffered	DATE					,
	saleInd		CHAR(1)					,
	lastUpdated	TIMESTAMP				,
		PRIMARY KEY (productID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;


insert into PRODUCT (SKU, productName, price, percentDiscount, description)
values("AB", "iMac", 5000.00, 0, "iMac computer");

insert into PRODUCT (SKU, productName, price, percentDiscount, description)
values("CD", "iPod", 500.00, 0, "iPod music player");

insert into PRODUCT (SKU, productName, price, percentDiscount, description)
values("EF", "iPhone", 700.00, 0, "iPhone smart phone");

insert into PRODUCT (SKU, productName, price, percentDiscount, description)
values("ZZ", "iPad", 1000.00, 0, "iPad tablet");


select * from PRODUCT;
delete from PRODUCT where productId=100001

select * from BRAND;
delete from BRAND where brandID=100001


    <class name="Person" identity-type="application" detachable="true" >   
      <field name="id" value-strategy="identity" primary-key="true"/>         
      <field name="login"/>
      <field name="password"/>
      <field name="securityQuesID"/>
      <field name="securityAnswer"/>
    </class> 
    
    <class name="SecurityQuery" identity-type="application" detachable="true" >   
      <field name="id" value-strategy="identity" primary-key="true"/>         
      <field name="question"/>
    </class>     
    
    <class name="Customer" identity-type="application" detachable="true" >   
      <field name="id" value-strategy="identity" primary-key="true"/>         
      <field name="login"/>
      <field name="password"/>
      <field name="securityQuesID"/>
      <field name="securityAnswer"/>
    </class> 
