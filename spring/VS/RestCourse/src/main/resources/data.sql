insert into DEPARTMENT (name, description)
            values  ('Préparatoire', 'Cycle préparatoire');
insert into DEPARTMENT (name, description)
            values  ('Ingénieur', 'Cycle ingénieur');
insert into Department (name, description)
            values  ('Apprentissage', 'Cycle ingénieur par apprentissage');

insert into student (name, birth_Date, email, created_At, department_id)
            values  ('Roxanne Garceau', '04/07/2001', 'rgarou@esme.fr', CURRENT_TIMESTAMP(), 1);
insert into student (name, birth_Date, email, created_At, department_id)
            values  ('Babette Sevier', '04/09/2003', 'bservier@mail.com', CURRENT_TIMESTAMP() - 1.343, 2);
insert into student (name, birth_Date, email, created_At, department_id)
            values  ('Musette Garcia', '09/11/2001', 'mgarcia@esme.fr', CURRENT_TIMESTAMP() - 60, 3);
insert into student (name, birth_Date, email, created_At, department_id)
            values  ('Orson Leclair', '04/05/1999', 'oleclerec@mail.com', CURRENT_TIMESTAMP(), 3);