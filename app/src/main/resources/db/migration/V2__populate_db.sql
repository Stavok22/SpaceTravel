INSERT INTO client (name) VALUES
    ('Dmytro'),
    ('Valentin'),
    ('Olga'),
    ('Daria'),
    ('Victor'),
    ('Igor'),
    ('Ivan'),
    ('Anna'),
    ('Taras'),
    ('Denys');

INSERT INTO planet (id,name) VALUES
    ('MERC1','Mercury'),
    ('VEN2','Venus'),
    ('EARTH3','Earth'),
    ('MARS4','Mars'),
    ('URAN5','Uranus'),
    ('NEPT6','Neptune'),
    ('SATURN7','Saturn');

INSERT INTO ticket (created_at,client_id,from_planet_id,to_planet_id) VALUES
    (CURRENT_TIMESTAMP(),1,'MERC1','VEN2'),
    (CURRENT_TIMESTAMP(),2,'SATURN7','NEPT6'),
    (CURRENT_TIMESTAMP(),4,'NEPT6','EARTH3'),
    (CURRENT_TIMESTAMP(),5,'EARTH3','VEN2'),
    (CURRENT_TIMESTAMP(),3,'VEN2','MARS4'),
    (CURRENT_TIMESTAMP(),7,'MARS4','MERC1'),
    (CURRENT_TIMESTAMP(),9,'MERC1','MARS4'),
    (CURRENT_TIMESTAMP(),8,'SATURN7','EARTH3'),
    (CURRENT_TIMESTAMP(),10,'MERC1','VEN2'),
    (CURRENT_TIMESTAMP(),6,'EARTH3','NEPT6');

