LOAD DATA
INFILE "Category.dat"
REPLACE INTO TABLE category
FIELDS TERMINATED BY '|'
(categoryName)
;

LOAD DATA
INFILE "Subcategory.dat"
REPLACE INTO TABLE subcategory
FIELDS TERMINATED BY '|'
(categoryID,subcategoryName)
;

LOAD DATA
INFILE "Brand.dat"
REPLACE INTO TABLE brand
FIELDS TERMINATED BY '|'
(brandName)
;

LOAD DATA
INFILE "Security_Question.dat"
REPLACE INTO TABLE security_question
FIELDS TERMINATED BY '|'
(question)
;

LOAD DATA
INFILE "Sales_Tax.dat"
REPLACE INTO TABLE sales_tax
FIELDS TERMINATED BY '|'
(state,percent)
;

LOAD DATA
INFILE "Accepted_Cards.dat"
REPLACE INTO TABLE accepted_cards
FIELDS TERMINATED BY '|'
(cardType)
;

LOAD DATA
INFILE "Role.dat"
REPLACE INTO TABLE role
FIELDS TERMINATED BY '|'
(roleDescription)
;

LOAD DATA
INFILE "Product.dat"
REPLACE INTO TABLE product
FIELDS TERMINATED BY '|'
(productName,SKU,modelNumber,subcategoryID,brandID,price,percentDiscount,description,qtyOnHand)
;
