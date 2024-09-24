CREATE TABLE category
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    created_at        datetime NULL,
    updated_at        datetime NULL,
    is_deleted        BIT(1)       NOT NULL,
    category_name     VARCHAR(255) NOT NULL,
    `description`     VARCHAR(255) NULL,
    subcategories_id  BIGINT NULL,
    count_of_products INT          NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    is_deleted    BIT(1) NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    imageurl      VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE sub_category
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    is_deleted BIT(1) NOT NULL,
    name       VARCHAR(255) NULL,
    CONSTRAINT pk_subcategory PRIMARY KEY (id)
);

ALTER TABLE category
    ADD CONSTRAINT uc_category_category_name UNIQUE (category_name);

ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_SUBCATEGORIES FOREIGN KEY (subcategories_id) REFERENCES sub_category (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);