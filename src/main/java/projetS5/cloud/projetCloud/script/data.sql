
INSERT INTO personne(nom, prenom, age, sexe, telephone, address) VALUES
('RATIATIANA', 'Jean Mirlin', 22, 1, '0348262182', 'Ambohijanaka'),
('NOMENA', 'Sue', 24, 0, '0344334212', 'Tana');

-- Insertion de données dans la table categorie_voiture
INSERT INTO categorie_voiture (nom, description) VALUES
('Compacte', 'Voitures de petite taille et économiques.'),
('Berline', 'Voitures à quatre portes avec un espace intérieur confortable.'),
('SUV', 'Véhicules utilitaires sport pour une conduite robuste.'),
('Cabriolet', 'Voitures décapotables avec un toit rétractable.'),
('Hybride', 'Voitures combinant moteur à combustion interne et moteur électrique.');

-- Insertion de données dans la table marque_voiture
INSERT INTO marque_voiture (nom, description, date_creation) VALUES
('Toyota', 'Constructeur automobile japonais.', '1937-08-28'),
('Ford', 'Constructeur automobile américain.', '1903-06-16'),
('BMW', 'Constructeur automobile allemand.', '1916-03-07'),
('Honda', 'Constructeur automobile japonais.', '1948-09-24'),
('Tesla', 'Constructeur automobile américain spécialisé dans les véhicules électriques.', '2003-07-01');

-- Insertion de données dans la table type_carburant_voiture
INSERT INTO type_carburant_voiture (nom) VALUES
('Essence'),
('Diesel'),
('Électrique'),
('Hybride essence/électrique'),
('Hybride diesel/électrique');

INSERT INTO transmission_voiture (nom) VALUES
('Automatique'),
('Manuelle'),
('CVT (Transmission à variation continue)'),
('Semi-automatique'),
('4 roues motrices');

-- Insertion de données dans la table freinage_voiture
INSERT INTO freignage_voiture (nom) VALUES
('Freins à disque'),
('Freins à tambour'),
('Système de freinage antiblocage (ABS)'),
('Freinage d urgence assisté'),
('Frein de stationnement électronique');

INSERT INTO equipement_interne (nom) VALUES
('Système de navigation GPS'),
('Climatisation automatique'),
('Sièges en cuir chauffants'),
('Toit ouvrant panoramique'),
('Système audio haut de gamme');

-- Insertion de données dans la table voiture
INSERT INTO voiture (annee_fabrication, couleur, consommation, categorie_voiture_id, marque_voiture_id, type_carburant_id, transmission_voiture_id, freignage_voiture_id) VALUES
('2022-01-01', 'Bleu', 6.5, 'CAT0001', 'MRQ0001', 'TYPE_CAR0001', 'TRSM0001', 'FRGN0001'),
('2020-05-15', 'Noir', 7.8, 'CAT0002', 'MRQ0002', 'TYPE_CAR0002', 'TRSM0002', 'FRGN0002'),
('2021-11-20', 'Rouge', 5.9, 'CAT0003', 'MRQ0003', 'TYPE_CAR0003', 'TRSM0003', 'FRGN0003'),
('2019-08-10', 'Blanc', 8.2, 'CAT0004', 'MRQ0004', 'TYPE_CAR0004', 'TRSM0004', 'FRGN0004'),
('2023-03-03', 'Argent', 6.0, 'CAT0005', 'MRQ0005', 'TYPE_CAR0005', 'TRSM0005', 'FRGN0005');

-- Insertion de données dans la table voiture_equipement_interne
INSERT INTO voiture_equipement_interne (voiture_id, equipement_interne_id) VALUES
('VOIT0001', 'EQP_IN0001'), -- Première voiture avec système de navigation GPS
('VOIT0002', 'EQP_IN0002'), -- Deuxième voiture avec climatisation automatique
('VOIT0003', 'EQP_IN0003'), -- Troisième voiture avec sièges en cuir chauffants
('VOIT0004', 'EQP_IN0004'), -- Quatrième voiture avec toit ouvrant panoramique
('VOIT0005', 'EQP_IN0005'); -- Cinquième voiture avec système audio haut de gamme


-- Insertion de données dans la table voiture_prix
INSERT INTO voiture_prix (prix, date, voiture_id) VALUES
(25000.00, '2022-01-01', 'VOIT0001'),
(28000.00, '2022-02-15', 'VOIT0002'),
(22000.00, '2022-03-20', 'VOIT0003'),
(30000.00, '2022-04-10', 'VOIT0004'),
(35000.00, '2022-05-05', 'VOIT0005');
