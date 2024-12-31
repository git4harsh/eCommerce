CREATE TABLE category
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at VARCHAR(255) NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE mps_it
(
    id             INT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialisation VARCHAR(255) NULL,
    CONSTRAINT pk_mps_it PRIMARY KEY (id)
);

CREATE TABLE mps_me
(
    id        INT NOT NULL,
    name      VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    password  VARCHAR(255) NULL,
    comp_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_mps_me PRIMARY KEY (id)
);

CREATE TABLE mps_ta
(
    id             INT   NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    no_of_sessions FLOAT NOT NULL,
    rating         FLOAT NOT NULL,
    CONSTRAINT pk_mps_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    VARCHAR(255) NULL,
    title         VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id   BIGINT NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);