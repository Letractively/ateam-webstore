SET foreign_key_checks = 0;

DROP TABLE IF EXISTS SECURITY_QUESTION;

DROP TABLE IF EXISTS SALES_TAX;

DROP TABLE IF EXISTS PRODUCT_QTY_ON_HAND;

DROP TABLE IF EXISTS PRODUCT_QTY_AT_VENDOR;

DROP TABLE IF EXISTS PRODUCTS_IN_CART;

DROP TABLE IF EXISTS PRODUCTS_IN_WISH_LIST;

DROP TABLE IF EXISTS ITEMS_ORDERED;

DROP TABLE IF EXISTS EMPLOYEE_ROLES;

DROP TABLE IF EXISTS REVIEW;

DROP TABLE IF EXISTS VENDOR;

DROP TABLE IF EXISTS ROLE;

DROP TABLE IF EXISTS ORDERS;

DROP TABLE IF EXISTS SHIPPING_CODE;

DROP TABLE IF EXISTS SHIPPER;

DROP TABLE IF EXISTS WISH_LIST;

DROP TABLE IF EXISTS CART;

DROP TABLE IF EXISTS CREDIT_CARD;

DROP TABLE IF EXISTS ADDRESS;

DROP TABLE IF EXISTS DEPARTMENT;

DROP TABLE IF EXISTS EMPLOYEE;

DROP TABLE IF EXISTS CUSTOMER;

DROP TABLE IF EXISTS PERSON;

DROP TABLE IF EXISTS PRODUCT;

DROP TABLE IF EXISTS CATEGORY;

DROP TABLE IF EXISTS SUBCATEGORY;

CREATE TABLE PRODUCT (
	productID	INTEGER		NOT NULL AUTO_INCREMENT	,
	productName	VARCHAR(150)	NOT NULL		,
	SKU		CHAR(15)	NOT NULL		,
	subcategoryID	INTEGER		NOT NULL 	,
	price		DECIMAL(10,2)	NOT NULL		,
	percentDiscount	DECIMAL(6,4)	NOT NULL,
	description	VARCHAR(1000)	NOT NULL		,
	qtyOnHand	INTEGER		NOT NULL 	,
	imagePath	CHAR(50)				,
	firstOffered	DATE					,
	saleInd		CHAR(1)					,
	lastUpdated	TIMESTAMP				,
		PRIMARY KEY (productID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE PERSON (
	personID	INTEGER		NOT NULL AUTO_INCREMENT	,
	login		CHAR(50)	NOT NULL		,
	password	CHAR(50)	NOT NULL		,
	securityQuesID	INTEGER	NOT NULL		,
	securityAnswer	CHAR(25)	NOT NULL		,
		PRIMARY KEY (personID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE SECURITY_QUESTION (
	securityQuesID	INTEGER		NOT NULL AUTO_INCREMENT	,
	question	CHAR(60)	NOT NULL		,
		PRIMARY KEY (securityQuesID))
		ENGINE=INNODB
;

CREATE TABLE CUSTOMER (
	customerID	INTEGER		NOT NULL AUTO_INCREMENT	,
	personID	INTEGER		UNIQUE NOT NULL		,
	firstName	CHAR(20)	NOT NULL		,
	middleName	CHAR(20)				,
	lastName	CHAR(30)	NOT NULL		,
	dateOfBirth	DATE					,
	sex			CHAR(1)					,
		PRIMARY KEY (customerID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE EMPLOYEE (
	employeeID	INTEGER		NOT NULL AUTO_INCREMENT	,
	personID	INTEGER		UNIQUE NOT NULL		,
	firstName	CHAR(20)	NOT NULL		,
	middleName	CHAR(20)				,
	lastName	CHAR(30)	NOT NULL		,
	dateOfBirth	DATE					,
	sex			CHAR(1)					,
	ssn		CHAR(9)		UNIQUE NOT NULL		,
	jobTitle	CHAR(25)	NOT NULL		,
	dateOfHire	DATE		NOT NULL		,
	departmentCode	CHAR(4)		NOT NULL		,
	salary		DECIMAL(10,2)	NOT NULL		,
		PRIMARY KEY (employeeID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE DEPARTMENT (
	departmentCode	CHAR(4)		NOT NULL		,
	departmentName	CHAR(20)	NOT NULL		,
	managerID	INTEGER		NOT NULL		,
		PRIMARY KEY (departmentCode))
		ENGINE=INNODB
;


CREATE TABLE ADDRESS (
	addressID	INTEGER		NOT NULL AUTO_INCREMENT	,
	personID	INTEGER		NOT NULL		,
	streetAddress1	CHAR(50)	NOT NULL		,	
	streetAddress2	CHAR(50)				,
	city		CHAR(25)	NOT NULL		,
	state		CHAR(2)		NOT NULL		,
	zip		CHAR(5)		NOT NULL		,
	plusFour	CHAR(4)					,
	defaultInd	CHAR(1)					,
		PRIMARY KEY (addressID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE CREDIT_CARD (
	cardID		INTEGER		NOT NULL AUTO_INCREMENT	,
	customerID	INTEGER		NOT NULL		,
	cardNumber	CHAR(16)	NOT NULL		,
	expMonth	CHAR(2)		NOT NULL		,
	expYear		CHAR(2)		NOT NULL		,
	securityCode	CHAR(4)		NOT NULL		,
	nameOnCard	CHAR(50)	NOT NULL		,
	billingAddrID	INTEGER		NOT NULL		,
	defaultInd	CHAR(1)					,
		PRIMARY KEY (cardID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE CART (
	cartID		INTEGER		NOT NULL AUTO_INCREMENT	,
	customerID	INTEGER		NOT NULL		,
	lastUpdated	TIMESTAMP				,
	lastOrderDate	DATE					,
		PRIMARY KEY (cartID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE WISH_LIST (
	wishListID	INTEGER		NOT NULL AUTO_INCREMENT	,
	customerID	INTEGER		NOT NULL		,
	createdDate	DATE					,
	lastUpdated	TIMESTAMP				,
		PRIMARY KEY (wishListID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE SALES_TAX (
	state		CHAR(2)		NOT NULL		,
	percent		DECIMAL(7,5)	NOT NULL		,
		PRIMARY KEY (state))
		ENGINE=INNODB
;

CREATE TABLE SHIPPER (
	shipperID	INTEGER		NOT NULL AUTO_INCREMENT	,
	shipperName	CHAR(40)	NOT NULL		,
	streetAddress1	CHAR(50)	NOT NULL		,	
	streetAddress2	CHAR(50)				,
	city		CHAR(25)	NOT NULL		,
	state		CHAR(2)		NOT NULL		,
	zip		CHAR(5)		NOT NULL		,
	plusFour	CHAR(4)					,
	acctNumber	CHAR(20)				,
	acctMgrFirstNm	CHAR(15)				,
	acctMgrLastNm	CHAR(25)				,
		PRIMARY KEY (shipperID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE SHIPPING_CODE (
	shippingCode	SMALLINT	NOT NULL		,
	shipperID	INTEGER		NOT NULL		,
	cost		DECIMAL(8,2)	NOT NULL	,
	description	CHAR(50)	NOT NULL		,
		PRIMARY KEY (shippingCode))
		ENGINE=INNODB
;

CREATE TABLE ORDERS (
	orderID		INTEGER		NOT NULL AUTO_INCREMENT	,
	customerID	INTEGER		NOT NULL		,
	numOfItems	INTEGER		NOT NULL		,
	itemSubtotal	DECIMAL(10,2)	NOT NULL		,
	shippingTotal	DECIMAL(8,2)	NOT NULL		,
	salesTaxPaid DECIMAL(8,2)	NOT NULL		,
	addressID	INTEGER		NOT NULL		,
	cardID		INTEGER		NOT NULL		,
	timePlaced	TIMESTAMP	,
	timeShipped	TIMESTAMP	DEFAULT 0		,
	shippingCode	SMALLINT	NOT NULL		,
	trackingNumber	CHAR(20)				,
	transactNumber	CHAR(20)				,
	returnInd	CHAR(1)					,
		PRIMARY KEY (orderID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE ROLE (
	roleCode	SMALLINT	NOT NULL		,
	roleDescription	CHAR(20)	NOT NULL		,
		PRIMARY KEY (roleCode))
		ENGINE=INNODB
;

CREATE TABLE VENDOR (
	vendorID	INTEGER		NOT NULL AUTO_INCREMENT	,
	vendorName	CHAR(50)	NOT NULL		,
	streetAddress1	CHAR(50)	NOT NULL		,	
	streetAddress2	CHAR(50)				,
	city		CHAR(25)	NOT NULL		,
	state		CHAR(2)		NOT NULL		,
	zip		CHAR(5)		NOT NULL		,
	plusFour	CHAR(4)					,
	firstOrderDate	DATE					,
	lastOrderDate	DATE					,
		PRIMARY KEY (vendorID))
		AUTO_INCREMENT=100001
		ENGINE=INNODB
;

CREATE TABLE PRODUCT_QTY_AT_VENDOR (
	productID	INTEGER		NOT NULL		,
	vendorID	INTEGER		NOT NULL		,
	vendorSKU	CHAR(15)	NOT NULL		,
	qtyAvailable	INTEGER		NOT NULL		,
		PRIMARY KEY (productID, vendorID))
		ENGINE = INNODB
;

CREATE TABLE PRODUCTS_IN_CART (
	cartID		INTEGER		NOT NULL		,
	productID	INTEGER		NOT NULL		,
	quantity	SMALLINT	NOT NULL DEFAULT 1  ,
	timeAdded	TIMESTAMP	,
		PRIMARY KEY (cartID, productID))
		ENGINE = INNODB
;

CREATE TABLE PRODUCTS_IN_WISH_LIST (
	wishListID	INTEGER		NOT NULL		,
	productID	INTEGER		NOT NULL		,
	quantity	SMALLINT	NOT NULL DEFAULT 1	,
	timeAdded	TIMESTAMP	,
		PRIMARY KEY (wishListID, productID))
		ENGINE = INNODB
;

CREATE TABLE ITEMS_ORDERED (
	orderID		INTEGER		NOT NULL		,
	productID	INTEGER		NOT NULL		,
	unitPrice	DECIMAL(10,2)	NOT NULL		,
	itemQty		INTEGER		NOT NULL		,
	shippedInd	CHAR(1)					,
		PRIMARY KEY (orderID, productID))
		ENGINE=INNODB
;

CREATE TABLE EMPLOYEE_ROLES (
	employeeID	INTEGER		NOT NULL		,
	roleCode	SMALLINT	NOT NULL		,
	effectiveDate	DATE		NOT NULL		,
	endDate		DATE					,
		PRIMARY KEY (employeeID, roleCode))
		ENGINE=INNODB
;


CREATE TABLE REVIEW (
	reviewID	INTEGER		NOT NULL AUTO_INCREMENT	,
	productID	INTEGER		NOT NULL		,
	customerID	INTEGER		NOT NULL		,
	review		VARCHAR(2000)	NOT NULL		,
		PRIMARY KEY (reviewID))
		AUTO_INCREMENT = 100001
		ENGINE=INNODB
;

CREATE TABLE CATEGORY (
	categoryID		INTEGER		NOT NULL AUTO_INCREMENT ,
	categoryName	CHAR(20)	UNIQUE NOT NULL			,
		PRIMARY KEY (categoryID))
		AUTO_INCREMENT = 101
		ENGINE=INNODB
;

CREATE TABLE SUBCATEGORY (
	subcategoryID	INTEGER		NOT NULL AUTO_INCREMENT	,
	categoryID		INTEGER		NOT NULL				,
	subcategoryName	CHAR(25)	NOT NULL				,
		PRIMARY KEY (subcategoryID))
		AUTO_INCREMENT = 1001
		ENGINE=INNODB
;


ALTER TABLE SUBCATEGORY
	ADD CONSTRAINT FK_SUB_TO_CATEGORY
		FOREIGN KEY (categoryID) REFERENCES CATEGORY (categoryID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE PRODUCT
	ADD CONSTRAINT FK_PRODUCT_TO_SUB
		FOREIGN KEY (subcategoryID)	REFERENCES SUBCATEGORY (subcategoryID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE REVIEW
	ADD CONSTRAINT FK_REVIEW_TO_PRODUCT
		FOREIGN KEY (productID) REFERENCES PRODUCT (productID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE REVIEW
	ADD CONSTRAINT FK_REVIEW_TO_CUSTOMER
		FOREIGN KEY (customerID) REFERENCES CUSTOMER (customerID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE EMPLOYEE
	ADD CONSTRAINT FK_EMPLOYEE_TO_PERSON
		FOREIGN KEY (personID) REFERENCES PERSON (personID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE EMPLOYEE
	ADD CONSTRAINT FK_EMPLOYEE_TO_DEPT
		FOREIGN KEY (departmentCode) REFERENCES DEPARTMENT (departmentCode)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE DEPARTMENT
	ADD CONSTRAINT FK_MANAGER
		FOREIGN KEY (managerID)	REFERENCES EMPLOYEE (employeeID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
; 

ALTER TABLE CREDIT_CARD
	ADD CONSTRAINT FK_CREDIT_CARD_TO_CUSTOMER
		FOREIGN KEY (customerID) REFERENCES CUSTOMER (customerID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE CREDIT_CARD
	ADD CONSTRAINT FK_CREDIT_CARD_TO_ADDRESS
		FOREIGN KEY (billingAddrID) REFERENCES ADDRESS (addressID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE CART
	ADD CONSTRAINT FK_CART_TO_CUSTOMER
		FOREIGN KEY (customerID) REFERENCES CUSTOMER (customerID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE WISH_LIST
	ADD CONSTRAINT FK_WISH_LIST_TO_CUSTOMER
		FOREIGN KEY (customerID) REFERENCES CUSTOMER (customerID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE PRODUCTS_IN_WISH_LIST
	ADD CONSTRAINT FK_PROD_IN_WISH_LIST_TO_LIST
		FOREIGN KEY (wishListID) REFERENCES WISH_LIST (wishListID)		
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE PRODUCTS_IN_WISH_LIST
	ADD CONSTRAINT FK_PROD_IN_WISH_LIST_TO_PROD
		FOREIGN KEY (productID) REFERENCES PRODUCT (productID)		
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE SHIPPING_CODE
	ADD CONSTRAINT FK_SHIPPING_CODE_TO_SHIPPER
		FOREIGN KEY (shipperID) REFERENCES SHIPPER (shipperID)
;

ALTER TABLE ORDERS
	ADD CONSTRAINT FK_ORDERS_TO_CUSTOMER
		FOREIGN KEY (customerID) REFERENCES CUSTOMER (customerID )
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE ORDERS
	ADD CONSTRAINT FK_ORDERS_TO_ADDRESS
		FOREIGN KEY (addressID) REFERENCES ADDRESS (addressID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE ORDERS
	ADD CONSTRAINT FK_ORDERS_TO_CREDIT_CARD
		FOREIGN KEY (cardID) REFERENCES CREDIT_CARD (cardID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE ORDERS
	ADD CONSTRAINT FK_ORDERS_TO_SHIPPING_CODE
		FOREIGN KEY (shippingCode) REFERENCES  SHIPPING_CODE (shippingCode)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE ITEMS_ORDERED
	ADD CONSTRAINT FK_ITEMS_ORDERED_TO_ORDER
		FOREIGN KEY (orderID) REFERENCES ORDERS (orderID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE ITEMS_ORDERED
	ADD CONSTRAINT FK_ITEMS_ORDERED_TO_PRODUCT
		FOREIGN KEY (productID) REFERENCES PRODUCT (productID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE EMPLOYEE_ROLES
	ADD CONSTRAINT FK_EMPLOYEE_ROLES_TO_EMPLOYEE
		FOREIGN KEY (employeeID) REFERENCES EMPLOYEE (employeeID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE EMPLOYEE_ROLES
	ADD CONSTRAINT FK_EMPLOYEE_ROLES_TO_ROLE
		FOREIGN KEY (roleCode) REFERENCES ROLE (roleCode)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE PRODUCTS_IN_CART
	ADD CONSTRAINT FK_PROD_IN_CART_TO_CART
		FOREIGN KEY (cartID) REFERENCES CART (cartID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE PRODUCTS_IN_CART
	ADD CONSTRAINT FK_PROD_IN_CART_TO_PROD
		FOREIGN KEY (productID) REFERENCES PRODUCT (productID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE ADDRESS
	ADD CONSTRAINT FK_ADDRESS_TO_PERSON
		FOREIGN KEY (personID) REFERENCES PERSON (personID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE CUSTOMER
	ADD CONSTRAINT FK_CUSTOMER_TO_PERSON
		FOREIGN KEY (personID) REFERENCES PERSON (personID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE PRODUCT_QTY_AT_VENDOR
	ADD CONSTRAINT FK_QTY_VENDOR_TO_PROD
		FOREIGN KEY (productID) REFERENCES PRODUCT (productID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE PRODUCT_QTY_AT_VENDOR
	ADD CONSTRAINT FK_QTY_VENDOR_TO_VENDOR
		FOREIGN KEY (vendorID) REFERENCES VENDOR (vendorID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

ALTER TABLE PERSON
	ADD CONSTRAINT FK_PERSON_TO_SECURITY
		FOREIGN KEY (securityQuesID) REFERENCES SECURITY_QUESTION (securityQuesID)
		ON UPDATE CASCADE
		ON DELETE CASCADE
;

SET foreign_key_checks = 1;