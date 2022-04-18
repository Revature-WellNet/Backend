/*
CREATE TABLE specialization (
  SPECIALIZATION_ID int NOT NULL,
  SPECIALIZATION varchar(45) NOT NULL,
  PRIMARY KEY (SPECIALIZATION_ID),
  UNIQUE KEY specialization_id_UNIQUE (SPECIALIZATION_ID),
  UNIQUE KEY specialization_UNIQUE (SPECIALIZATION)
)
*/
REPLACE INTO SPECIALIZATION (SPECIALIZATION_ID, SPECIALIZATION) VALUES
  (1, 'primary_care'),
  (2, 'pediatrician'),
  (3, 'radiologist'),
  (4, 'general_surgeon');
/*
CREATE TABLE role(
  ROLE_ID int NOT NULL,
  ROLE varchar(45) NOT NULL,
  PRIMARY KEY (ROLE_ID),
  UNIQUE KEY role_id_UNIQUE (ROLE_ID),
  UNIQUE KEY role_UNIQUE (ROLE)
)
*/
REPLACE INTO ROLE (ROLE_ID, ROLE) VALUES
  (1, 'nurse'),
  (2, 'doctor');
