DROP TABLE IF EXISTS partner;

CREATE TABLE partner (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  ocupation VARCHAR(250) DEFAULT NULL
);

INSERT INTO partner (first_name, last_name, ocupation) VALUES
  ('Aliko', 'Dangote', 'Software Engineer'),
  ('Bill', 'Gates', 'Architect'),
  ('Folrunsho', 'Alakija', 'Business Owner');