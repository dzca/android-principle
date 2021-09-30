CREATE TABLE accounts (
    id int NOT NULL,
    account_number varchar(255) NOT NULL,
    password varchar(255),
    balance DECIMAL(10,2),
    UNIQUE (account_number)
);

ALTER TABLE accounts ADD CONSTRAINT unique_account_number UNIQUE (account_number)
