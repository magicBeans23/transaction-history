CREATE TABLE wallet_master (
  wallet_id_pk INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  currency VARCHAR(10) DEFAULT 'INR',
  created_time TIMESTAMP
);

CREATE TABLE transaction_type (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  transaction VARCHAR(250) NOT NULL,
  transaction_id TINYINT NOT NULL
);

CREATE TABLE transactions (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  tx_id INT NOT NULL,
  wallet_id INT NOT NULL,
  transaction_type INT NOT NULL,
  amount DOUBLE NOT NULL,
  tx_time TIMESTAMP
);

CREATE TABLE account_statement (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  wallet_id INT NOT NULL,
  stmt_date DATE NOT NULL,
  balance DOUBLE NOT NULL
);
