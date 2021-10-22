INSERT INTO planet ( average_surface_temperature, distance_from_sun, mass, name, surface_area, deleted)
VALUES ( '1', '10000', '111111', 'Jupiter', '121212', false);
INSERT INTO planet ( average_surface_temperature, distance_from_sun, mass, name, surface_area, deleted)
VALUES ( '2', '20000', '222222', 'Mars', '232323', false);
INSERT INTO planet ( average_surface_temperature, distance_from_sun, mass, name, surface_area, deleted)
VALUES ( '3', '30000', '333333', 'Neptune', '343434', false);
INSERT INTO planet ( average_surface_temperature, distance_from_sun, mass, name, surface_area, deleted)
VALUES ( '4', '40000', '444444', 'Earth', '454545', false);

INSERT INTO satellite ( mass, name, natural_satellite, surface_area, planet_id)
VALUES ( '676767', 'Moon', true, '111111', 4);
INSERT INTO satellite ( mass, name, surface_area, planet_id)
VALUES ( '787878', 'Europa', '222222', 1);
INSERT INTO satellite ( mass, name, natural_satellite, surface_area, planet_id)
VALUES ( '898989', 'Deimos ', false, '333333', 1);
INSERT INTO satellite ( mass, name, natural_satellite, surface_area, planet_id)
VALUES ( '909090', 'Triton', true, '44444', 3);

