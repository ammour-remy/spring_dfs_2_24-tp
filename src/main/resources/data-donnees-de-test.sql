INSERT INTO role (designation)
VALUES ('ROLE_ADMIN'),
       ('ROLE_CLIENT'),
       ('ROLE_WORKER');



INSERT INTO user (pseudo, password, role_id)
VALUES ('admin', '$2y$10$2G7GHMVtHbECJ2E6te7hvekDX087ZLPTuB/XhVrJ6Bp1AEf7rRRAe', 1),
       ('client', '$2y$10$ZV2kiLMF8CmiADHdsLQHGe1yFs7OI5XCubxtQgjIj5oR1FdR1W3Xm', 2),
       ('ouvrier', '$2y$10$Emp4yOsfult8jkLqoFmmNOLeioGVxexuwJAf6zeQv45EPA5crf3xe', 3);

INSERT INTO consumable (nom)
VALUES ('Ciment'),
       ('Peinture'),
       ('Pelle');


INSERT INTO task (nom, temps)
VALUES ('Creuser', 120),
       ('Faire du béton', 90);

INSERT INTO task_consumable (task_id, consumable_id)
VALUES (1, 3),
       (2, 1);


INSERT INTO site (nom, adresse, client_id, ouvrier_id)
VALUES ('Chantier A', '123 Rue de la Construction', 2, 3),
       ('Chantier B', '456 Avenue du Marteau', 2, 3);


INSERT INTO operation (nom, local_date, task_id, user_id, site_id)
VALUES ('Creuser le trou pour la piscine', '2023-06-15', 1, 3, 1),
       ('Préparer le béton pour le garage', '2023-06-16', 2, 3, 1),
       ('Creuser le trou pour la piscine', '2023-06-15', 1, 3, 2),
       ('Creuser le trou pour la piscine', '2023-06-15', 1, 3, 2),
       ('Préparer le béton pour le garage', '2023-06-16', 2, 3, 2);