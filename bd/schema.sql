-- -----------------------------------------------------
-- Table "CATEGORIES"
-- -----------------------------------------------------
CREATE TABLE CATEGORIES (
  "category_id" SERIAL NOT NULL,
  "description" VARCHAR(45) NOT NULL,
  "status" BOOLEAN NOT NULL,
  PRIMARY KEY ("category_id")
);


-- -----------------------------------------------------
-- Table "PRODUCTS"
-- -----------------------------------------------------
CREATE TABLE PRODUCTS (
  "product_id" SERIAL NOT NULL,
  "name" VARCHAR(45) NULL,
  "category_id" INT NOT NULL,
  "barcode" VARCHAR(150) NULL,
  "selling_price" DECIMAL(16,2) NULL,
  "stock_quantity" INT NOT NULL,
  "status" BOOLEAN NULL,
  PRIMARY KEY ("product_id"),
  CONSTRAINT "fk_PRODUCTS_CATEGORIES"
  FOREIGN KEY ("category_id")
  REFERENCES CATEGORIES ("category_id")
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table "CUSTOMERS"
-- -----------------------------------------------------
CREATE TABLE CUSTOMERS (
  "id" VARCHAR(20) NOT NULL,
  "name" VARCHAR(40) NULL,
  "last_name" VARCHAR(100) NULL,
  "phone_number" VARCHAR(50) NULL,
  "address" VARCHAR(80) NULL,
  "email" VARCHAR(70) NULL,
  PRIMARY KEY ("id")
);


-- -----------------------------------------------------
 -- Table "PURCHASES"
-- -----------------------------------------------------
CREATE TABLE PURCHASES (
  "purchase_id" SERIAL NOT NULL,
  "customer_id" VARCHAR(20) NOT NULL,
  "date" TIMESTAMP NULL,
  "payment_method" CHAR(1) NULL,
  "comment" VARCHAR(300) NULL,
  "status" CHAR(1) NULL,
  PRIMARY KEY ("purchase_id"),
  CONSTRAINT "fk_PURCHASES_CUSTOMERS"
  FOREIGN KEY ("customer_id")
  REFERENCES CUSTOMERS ("id")
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table "PURCHASES_PRODUCTS"
-- -----------------------------------------------------
CREATE TABLE PURCHASES_PRODUCTS (
  "purchase_id" INT NOT NULL,
  "product_id" INT NOT NULL,
  "quantity" INT NULL,
  "total" DECIMAL(16,2) NULL,
  "status" BOOLEAN NULL,
  PRIMARY KEY ("purchase_id", "product_id"),
  CONSTRAINT "fk_PURCHASES_PRODUCTS_PRODUCTS"
  FOREIGN KEY ("product_id")
  REFERENCES PRODUCTS ("product_id")
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT "fk_PURCHASES_PRODUCTS_PURCHASES"
  FOREIGN KEY ("purchase_id")
  REFERENCES PURCHASES ("purchase_id")
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
)
