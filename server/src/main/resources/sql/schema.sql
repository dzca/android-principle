CREATE TABLE IF NOT EXISTS accounts (
      id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    account_number varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    balance DECIMAL(10,2) DEFAULT 0.0,
    UNIQUE (account_number)
);