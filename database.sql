CREATE DATABASE shopapp;
USE shopapp;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname NVARCHAR(100) DEFAULT '',
    phone_number VARCHAR(10) NOT NULL,
    address NVARCHAR(200) DEFAULT '',
    password NVARCHAR(100) NOT NULL DEFAULT '',
    create_at DATETIME,
    update_at DATETIME,
    is_active TINYINT DEFAULT 1,
    date_of_birth DATE,
    facebook_account_id INT DEFAULT 0,
    google_account_id INT DEFAULT 0
);
ALTER TABLE users ADD COLUMN role_id INT;

CREATE TABLE roles(
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL 
);
ALTER TABLE users ADD FOREIGN KEY (role_id) REFERENCES roles (id);
CREATE TABLE tokens (
    id INT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) UNIQUE NOT NULL,
    token_type VARCHAR(50) NOT NULL,
    expiration_date DATETIME,
    revoked TINYINT(1) NOT NULL,
    user_id INT REFERENCES users(id)
);

CREATE TABLE social_accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    provider VARCHAR(20) NOT NULL COMMENT 'e.g., facebook, google',  
    email VARCHAR(150) NOT NULL COMMENT 'Social account email',
    name VARCHAR(100) NOT NULL COMMENT 'Social account name',
    user_id INT REFERENCES users(id)
);

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(100) NOT NULL COMMENT 'Category name',
    description LONGTEXT COMMENT 'Category description'
);

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(350) NOT NULL COMMENT 'Product name',
    price DECIMAL(10, 2) NOT NULL CHECK(price >= 0) COMMENT 'Product price',
    thumbnail VARCHAR(300) DEFAULT '' COMMENT 'Product thumbnail URL',
    description LONGTEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_active TINYINT DEFAULT 1 COMMENT 'Is the product active',
    category_id INT REFERENCES categories(id)
);

CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT REFERENCES users(id),
    fullname NVARCHAR(100) DEFAULT '',
    email VARCHAR(1000) DEFAULT '',
    phone_number VARCHAR(20) NOT NULL,
    address NVARCHAR(200) NOT NULL,
    note NVARCHAR(100) DEFAULT '',
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20),
    total_money DECIMAL(10, 2) CHECK(total_money >= 0)COMMENT 'Total order amount'
);

ALTER TABLE orders ADD COLUMN `shipping_method` VARCHAR(100);
ALTER TABLE orders ADD COLUMN `shipping_address` VARCHAR(200);
ALTER TABLE orders ADD COLUMN `shipping_date` DATE;
ALTER TABLE orders ADD COLUMN `tracking_number` VARCHAR(100);
ALTER TABLE orders ADD COLUMN `payment_method` VARCHAR(100);

ALTER TABLE orders ADD COLUMN active TINYINT(1);
ALTER TABLE orders 
MODIFY COLUMN status ENUM('pending', 'processing', 'shipped', 'delivered', 'cancelled') ;
COMMENT 'Trạng thái đơn hàng';

CREATE TABLE order_details(
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES products (id),
    price DECIMAL(10, 2) CHECK(price >= 0),
    number_of_products INT CHECK(number_of_products > 0),
    total_money DECIMAL(10, 2) CHECK(total_money >= 0),
    color NVARCHAR(20) DEFAULT ''
);
