INSERT INTO stations (station_id, street) VALUES (1, 'Piotrkowska 1');
INSERT INTO stations (station_id, street) VALUES (2, 'Politechniki 10');
INSERT INTO stations (station_id, street) VALUES (3, 'Zielona 22');
INSERT INTO stations (station_id, street) VALUES (4, 'Zgierska 50');
INSERT INTO stations (station_id, street) VALUES (5, 'Nawrot 10');

INSERT INTO bikes (bike_id, user_id, station_id) VALUES (1, null, 1);
INSERT INTO bikes (bike_id, user_id, station_id) VALUES (2, null, 1);
INSERT INTO bikes (bike_id, user_id, station_id) VALUES (3, null, 2);
INSERT INTO bikes (bike_id, user_id, station_id) VALUES (4, null, 2);
INSERT INTO bikes (bike_id, user_id, station_id) VALUES (5, null, 3);

INSERT INTO users (user_id, contact_number, enabled, first_name, last_name, login, password, user_role) VALUES (1, '600700800', true, 'Jan', 'Kowalski', 'admin', 'admin', 'ROLE_ADMIN');
INSERT INTO users (user_id, contact_number, enabled, first_name, last_name, login, password, user_role) VALUES (2, '600700800', truegit , 'Marian', 'Nowak', 'user', 'user', 'ROLE_USER');