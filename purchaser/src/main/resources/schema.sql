DROP TABLE IF EXISTS PURCHASE;
DROP TABLE IF EXISTS MERCHANT;
--CREATE SCHEMA TRY;
--SET SCHEMA TRY;

CREATE TABLE PURCHASE (
  id UUID PRIMARY KEY,
  occurred_on DATE NOT NULL,
  MERCHANT UUID,
  CUSTOMER UUID,
  REWARD UUID NOT NULL,
  CAMPAIGN UUID NOT NULL
);

CREATE TABLE MERCHANT (
  id UUID DEFAULT random_uuid(),
  registered_on TIMESTAMP NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  company_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);