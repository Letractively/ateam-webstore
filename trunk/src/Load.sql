LOAD DATA
INFILE "Category.dat"
REPLACE INTO TABLE CATEGORY
FIELDS TERMINATED BY '|'
(categoryName)
;

LOAD DATA
INFILE "Subcategory.dat"
REPLACE INTO TABLE SUBCATEGORY
FIELDS TERMINATED BY '|'
(categoryID,subcategoryName)
;

LOAD DATA
INFILE "Brand.dat"
REPLACE INTO TABLE BRAND
FIELDS TERMINATED BY '|'
(brandName)
;

LOAD DATA
INFILE "Security_Question.dat"
REPLACE INTO TABLE SECURITY_QUESTION
FIELDS TERMINATED BY '|'
(question)
;

LOAD DATA
INFILE "Sales_Tax.dat"
REPLACE INTO TABLE SALES_TAX
FIELDS TERMINATED BY '|'
(state,percent)
;

LOAD DATA
INFILE "Accepted_Cards.dat"
REPLACE INTO TABLE ACCEPTED_CARDS
FIELDS TERMINATED BY '|'
(cardType)
;

LOAD DATA
INFILE "Role.dat"
REPLACE INTO TABLE ROLE
FIELDS TERMINATED BY '|'
(roleDescription)
;

LOAD DATA
INFILE "Product.dat"
REPLACE INTO TABLE PRODUCT
FIELDS TERMINATED BY '|'
(productName,SKU,modelNumber,subcategoryID,brandID,price,percentDiscount,description,qtyOnHand)
;

LOAD DATA
INFILE "Person.dat"
REPLACE INTO TABLE PERSON
FIELDS TERMINATED BY '|'
(login,password,securityQuesID,securityAnswer)
;

LOAD DATA
INFILE "Customer.dat"
REPLACE INTO TABLE CUSTOMER
FIELDS TERMINATED BY '|'
(personID,firstName,lastName,dateOfBirth,sex)
;

SET foreign_key_checks=0
;

LOAD DATA
INFILE "Department.dat"
REPLACE INTO TABLE DEPARTMENT
FIELDS TERMINATED BY '|'
(departmentCode,departmentName,managerID)
;

LOAD DATA
INFILE "Employee.dat"
REPLACE INTO TABLE EMPLOYEE
FIELDS TERMINATED BY '|'
(personID,firstName,lastName,dateOfBirth,sex,ssn,jobTitle,dateOfHire,departmentCode,salary)
;

SET foreign_key_checks=1
;

LOAD DATA
INFILE "Address.dat"
REPLACE INTO TABLE ADDRESS
FIELDS TERMINATED BY '|'
(personID,streetAddress1,city,state,zip,phone,defaultInd)
;

LOAD DATA
INFILE "Credit_Card.dat"
REPLACE INTO TABLE CREDIT_CARD
FIELDS TERMINATED BY '|'
(customerID,cardType,cardNumber,expMonth,expYear,securityCode,nameOnCard,billingAddrID,defaultInd)
;

LOAD DATA
INFILE "Vendor.dat"
REPLACE INTO TABLE VENDOR
FIELDS TERMINATED BY '|'
(vendorName,streetAddress1,city,state,zip)
;

LOAD DATA
INFILE "Shipper.dat"
REPLACE INTO TABLE SHIPPER
FIELDS TERMINATED BY '|'
(shipperName,streetAddress1,city,state,zip)
;

LOAD DATA
INFILE "Shipping_Code.dat"
REPLACE INTO TABLE SHIPPING_CODE
FIELDS TERMINATED BY '|'
(shippingCode,shipperID,itemQty,cost,description)
;

LOAD DATA
INFILE "Cart.dat"
REPLACE INTO TABLE CART
FIELDS TERMINATED BY '|'
(customerID)
;

LOAD DATA
INFILE "Wish_List.dat"
REPLACE INTO TABLE WISH_LIST
FIELDS TERMINATED BY '|'
(customerID,wishListName)
;

LOAD DATA
INFILE "Employee_Roles.dat"
REPLACE INTO TABLE EMPLOYEE_ROLES
FIELDS TERMINATED BY '|'
(employeeID,roleCode,effectiveDate)
;

LOAD DATA
INFILE "Orders.dat"
REPLACE INTO TABLE ORDERS
FIELDS TERMINATED BY '|'
(customerID,numOfItems,itemSubtotal,shippingTotal,salesTaxPaid,addressID,cardID,timePlaced,timeShipped,shippingCode,trackingNumber,transactNumber)
;

LOAD DATA
INFILE "Items_Ordered.dat"
REPLACE INTO TABLE ITEMS_ORDERED
FIELDS TERMINATED BY '|'
(orderID,productID,unitPrice,itemQty,shippedInd)
;

LOAD DATA
INFILE "Service_Case.dat"
REPLACE INTO TABLE SERVICE_CASE
FIELDS TERMINATED BY '|'
(customerID)
;

LOAD DATA
INFILE "Message.dat"
REPLACE INTO TABLE MESSAGE
FIELDS TERMINATED BY '|'
(caseID,personID,empOrCust,sequence,message)
;

LOAD DATA
INFILE "Review.dat"
REPLACE INTO TABLE REVIEW
FIELDS TERMINATED BY '|'
(productId,customerID,rating,review)
;

LOAD DATA
INFILE "Products_In_Cart.dat"
REPLACE INTO TABLE PRODUCTS_IN_CART
FIELDS TERMINATED BY '|'
(cartID,productId,quantity)
;

LOAD DATA
INFILE "Products_In_Wish_List.dat"
REPLACE INTO TABLE PRODUCTS_IN_WISH_LIST
FIELDS TERMINATED BY '|'
(wishListID,productId,quantity)
;

LOAD DATA
INFILE "Product_Qty_At_Vendor.dat"
REPLACE INTO TABLE PRODUCT_QTY_AT_VENDOR
FIELDS TERMINATED BY '|'
(productID,vendorId,vendorSKU,qtyAvailable)
;

UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100001 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100008 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100014 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100021 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100027 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100019 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100038 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100051 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100046 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100030 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100004 ;
UPDATE PRODUCT SET saleInd = 'Y' WHERE productID = 100031 ;