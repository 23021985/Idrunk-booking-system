INSERT INTO users (username, password, enabled, email, first_name, last_name) VALUES ('Hansadmin', '$2a$10$q/rYVLnKiyHpoZv8jD3ce.SB4hbyf0oVOYUZYJyWoT39F/4oGkhta', TRUE, 'hans@debaas.com', 'Hans', 'de Vreugd');
INSERT INTO users (username, password, enabled, email, first_name, last_name) VALUES ('arnie', '$2a$10$q/rYVLnKiyHpoZv8jD3ce.SB4hbyf0oVOYUZYJyWoT39F/4oGkhta', TRUE, 'arnold@counter.com', 'Arnold', 'van Dijk');
INSERT INTO users (username, password, enabled, email, first_name, last_name) VALUES ('stillis', '$2a$10$q/rYVLnKiyHpoZv8jD3ce.SB4hbyf0oVOYUZYJyWoT39F/4oGkhta', TRUE, 'jillis@slaaptnog.com', 'Jillis', 'vd Boom');

INSERT INTO authorities (username, authority) VALUES ('arnie', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('stillis', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('Hansadmin', 'ROLE_ADMIN');

INSERT INTO drink (id, name, price, stock) VALUES (1, 'Martini', 12.20, 32);
INSERT INTO drink (id, name, price, stock) VALUES (2, 'Moscow Mule', 12.40, 48);
INSERT INTO drink (id, name, price, stock) VALUES (3, 'Bloody Mary', 12.40, 65);
INSERT INTO drink (id, name, price, stock) VALUES (4, 'Cosmopolitan', 12.40, 65);
INSERT INTO drink (id, name, price, stock) VALUES (5, 'Moijito', 12.40, 56);
INSERT INTO drink (id, name, price, stock) VALUES (6, 'Dry Martini', 12.40, 9);
INSERT INTO drink (id, name, price, stock) VALUES (7, 'Sour', 12.40, 78);
INSERT INTO drink (id, name, price, stock) VALUES (8, 'Negroni', 12.40, 452);
INSERT INTO drink (id, name, price, stock) VALUES (9, 'Espresso Martini', 12.40, 59);
INSERT INTO drink (id, name, price, stock) VALUES (10, 'V2C Dutch Gin - Fevertree tonic', 12.40, 89);

INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (1, 1, 2);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (2, 2, 2);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (3, 3, 2);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (4, 4, 4);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (5, 5, 4);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (6, 6, 4);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (7, 7, 4);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (8, 8, 6);

INSERT INTO booking(id, end_time, start_time, tafel_id, user_username) VALUES (1, '2021-09-12T08:00:00', '2021-09-14T14:00:00', 2, 'Hansadmin');
INSERT INTO booking(id, end_time, start_time, tafel_id, user_username) VALUES (2, '2021-10-12T09:00:00', '2021-10-14T14:00:00', 3, 'arnie');
INSERT INTO booking(id, end_time, start_time, tafel_id, user_username) VALUES (3, '2021-11-12T10:00:00', '2021-11-14T14:00:00', 4, 'stillis');