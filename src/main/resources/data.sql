INSERT INTO users (username, password, enabled, email, first_name, last_name) VALUES ('Hansadmin', '$2a$10$q/rYVLnKiyHpoZv8jD3ce.SB4hbyf0oVOYUZYJyWoT39F/4oGkhta', TRUE, 'hans@debaas.com', 'Hans', 'de Vreugd');
INSERT INTO users (username, password, enabled, email, first_name, last_name) VALUES ('arnie', '$2a$10$q/rYVLnKiyHpoZv8jD3ce.SB4hbyf0oVOYUZYJyWoT39F/4oGkhta', TRUE, 'arnold@counter.com', 'Arnold', 'van Dijk');
INSERT INTO users (username, password, enabled, email, first_name, last_name) VALUES ('stillis', '$2a$10$q/rYVLnKiyHpoZv8jD3ce.SB4hbyf0oVOYUZYJyWoT39F/4oGkhta', TRUE, 'jillis@slaaptnog.com', 'Jillis', 'vd Boom');

INSERT INTO authorities (username, authority) VALUES ('arnie', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('stillis', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('Johan', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('Ingeborg', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('Hansadmin', 'ROLE_ADMIN');

INSERT INTO drink (id, name, price) VALUES (1001, 'Martini', 12.20);
INSERT INTO drink (id, name, price) VALUES (1002, 'Moscow Mule', 12.40);
INSERT INTO drink (id, name, price) VALUES (1003, 'Bloody Mary', 12.40);
INSERT INTO drink (id, name, price) VALUES (1004, 'Cosmopolitan', 12.40);
INSERT INTO drink (id, name, price) VALUES (1005, 'Moijito', 12.40);
INSERT INTO drink (id, name, price) VALUES (1006, 'Dry Martini', 12.40);
INSERT INTO drink (id, name, price) VALUES (1007, 'Sour', 12.40);
INSERT INTO drink (id, name, price) VALUES (1008, 'Negroni', 12.40);
INSERT INTO drink (id, name, price) VALUES (1009, 'Espresso Martini', 12.40);
INSERT INTO drink (id, name, price) VALUES (10010, 'V2C Dutch Gin - Fevertree tonic', 12.40);

INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (1001, 1, 2);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (1002, 2, 2);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (1003, 3, 2);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (1004, 4, 4);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (1005, 5, 4);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (1006, 6, 4);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (1007, 7, 4);
INSERT INTO tafel (id, tafel_nr, max_guest) VALUES (1008, 8, 6);

INSERT INTO booking(id, end_time, start_time, tafel_id, user_username) VALUES (1001, '2021-09-12T08:00:00', '2021-09-14T14:00:00', 1001, 'Hansadmin');
INSERT INTO booking(id, end_time, start_time, tafel_id, user_username) VALUES (1002, '2021-10-12T09:00:00', '2021-10-14T14:00:00', 1002, 'arnie');
INSERT INTO booking(id, end_time, start_time, tafel_id, user_username) VALUES (1003, '2021-11-12T10:00:00', '2021-11-14T14:00:00', 1003, 'stillis');
INSERT INTO booking(id, end_time, start_time, tafel_id, user_username) VALUES (1004, '2021-09-12T11:00:00', '2021-09-14T14:00:00', 1004, 'Hansadmin');
INSERT INTO booking(id, end_time, start_time, tafel_id, user_username) VALUES (1005, '2021-10-12T12:00:00', '2021-10-14T14:00:00', 1005, 'arnie');
INSERT INTO booking(id, end_time, start_time, tafel_id, user_username) VALUES (1006, '2021-11-12T13:00:00', '2021-11-14T14:00:00', 1006, 'stillis');

INSERT INTO request(id, has_been_served, username_username) VALUES (1001, false, 'Hansadmin');

INSERT INTO request_drink_amounts(drink_id, request_id, amount) VALUES (1006, 1001, 10);
INSERT INTO request_drink_amounts(drink_id, request_id, amount) VALUES (1002, 1001, 10);