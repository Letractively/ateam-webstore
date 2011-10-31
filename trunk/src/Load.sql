LOAD DATA
INFILE "Category.dat"
REPLACE INTO TABLE category
FIELDS TERMINATED BY '|'
(categoryName)

LOAD DATA
INFILE "Subcategory.dat"
REPLACE INTO TABLE subcategory
FIELDS TERMINATED BY '|'
(categoryID,subcategoryName)