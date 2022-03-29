DROP TABLE IF EXISTS client;

CREATE TABLE client (
  id serial PRIMARY KEY,
  client_name varchar(100) NOT NULL,
  client_cpf varchar(11) UNIQUE NOT NULL,
  client_address text NOT NULL
);

DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
  id serial PRIMARY KEY,
  order_date timestamp NOT NULL,
  order_value decimal NOT NULL,
  order_status varchar(20) NOT NULL,
  client_id int NOT NULL,
  FOREIGN KEY (client_id) REFERENCES client (id)
);

DROP TABLE IF EXISTS delivery_person;

CREATE TABLE delivery_person (
  id serial PRIMARY KEY,
  dp_name varchar(100) NOT NULL,
  dp_cpf varchar(11) UNIQUE NOT NULL,
  dp_email varchar(100) UNIQUE NOT NULL,
  dp_password varchar(100) NOT NULL,
  dp_phone varchar(11) UNIQUE NOT NULL
);

DROP TABLE IF EXISTS tracking_status;

CREATE TABLE tracking_status (
  id serial PRIMARY KEY,
  status varchar(20) NOT NULL,
  order_id int NOT NULL,
  dp_id int NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders (id),
  FOREIGN KEY (dp_id) REFERENCES delivery_person (id)
);

DROP TABLE IF EXISTS tracking_history;

CREATE TABLE tracking_history (
  id serial PRIMARY KEY,
  th_date timestamp NOT NULL,
  th_latitude varchar(15) NOT NULL,
  th_longitude varchar(15) NOT NULL,
  ts_id int NOT NULL,
  FOREIGN KEY (ts_id) REFERENCES tracking_status (id)
 );






