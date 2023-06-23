CREATE TABLE client (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (200) CONSTRAINT name_client_ck CHECK
    (LENGTH(name) >2) NOT NULL
);

CREATE TABLE planet (
    id VARCHAR (200) PRIMARY KEY CONSTRAINT planet_id_ck CHECK
    (REGEXP_LIKE (id, '^[A-Z0-9]*$', 'c')) NOT NULL,
    name VARCHAR (500) NOT NULL
);

CREATE TABLE ticket (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP,
    client_id BIGINT NOT NULL,
    from_planet_id VARCHAR NOT NULL,
    to_planet_id VARCHAR NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
    FOREIGN KEY (from_planet_id) REFERENCES planet (id) ON DELETE CASCADE,
    FOREIGN KEY (to_planet_id) REFERENCES planet (id) ON DELETE CASCADE
);