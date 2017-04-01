INSERT INTO public.stations (station_id, street) VALUES (1, 'Piotrkowska 1');
INSERT INTO public.stations (station_id, street) VALUES (2, 'Politechniki 10');
INSERT INTO public.stations (station_id, street) VALUES (3, 'Zielona 22');
INSERT INTO public.stations (station_id, street) VALUES (4, 'Zgierska 50');
INSERT INTO public.stations (station_id, street) VALUES (5, 'Nawrot 10');

INSERT INTO public.bikes (bike_id, user_id, station_id) VALUES (1, null, 1);
INSERT INTO public.bikes (bike_id, user_id, station_id) VALUES (2, null, 1);
INSERT INTO public.bikes (bike_id, user_id, station_id) VALUES (3, null, 2);
INSERT INTO public.bikes (bike_id, user_id, station_id) VALUES (4, null, 2);
INSERT INTO public.bikes (bike_id, user_id, station_id) VALUES (5, null, 3);

INSERT INTO public.users (user_id, contact_number, first_name, last_name, login, password, user_role, enabled) VALUES (1, '600700800', 'Jan', 'Kowalski', 'Kowal', '123kowal', 'ROLE_USER', true);
INSERT INTO public.users (user_id, contact_number, first_name, last_name, login, password, user_role, enabled) VALUES (2, '500100200', 'Marian', 'Nowak', 'Nowak01', 'nowakmarian', 'ROLE_USER', true);
INSERT INTO public.users (user_id, contact_number, first_name, last_name, login, password, user_role, enabled) VALUES (3, '700100300', 'Maria', 'Marchewka', 'Marchewa1', 'mary666', 'ROLE_USER', true);
INSERT INTO public.users (user_id, contact_number, first_name, last_name, login, password, user_role, enabled) VALUES (4, '650300400', 'Patrycja', 'Ziemniak', 'PZiem', 'test', 'ROLE_USER', true);
INSERT INTO public.users (user_id, contact_number, first_name, last_name, login, password, user_role, enabled) VALUES (5, '770320200', 'Przemek', 'Przygoda', 'PPAdv', 'adv01', 'ROLE_USER', true);
