INSERT INTO subject (id, name)
VALUES ('7e569bab-dd07-459b-af54-69e5ea6cbfa3', 'math');
INSERT INTO subject (id, name)
VALUES ('a00fcd84-3c47-4cf9-b7fa-0f47e315c14b', 'computer science');

INSERT INTO teacher (id, firstname, lastname, address, zip_code, state, email, password, birthdate)
VALUES ('15e7e4ce-44ec-486a-bb1f-cdc6ce533e25', 'Aldous', 'Huxley', '42 Bourbon st', '70130', 'LA',
        'aldous.huxley@gmail.com', 'newBraveWorld', '1894-06-26');
INSERT INTO teacher (id, firstname, lastname, address, zip_code, state, email, password, birthdate)
VALUES ('f0c4b7ff-3214-4323-992d-f73dacbd79d6', 'Ray', 'Bradbury', '451 Bourbon st', '70130', 'LA',
        'ray.bradbury@gmail.com', 'Farenheit451','1920-08-22');
-- having dates that are BC will cuase weirdness in that they'll all get converted to 0XXX-XX-31
INSERT INTO student (id, firstname, lastname, address, zip_code, state, email, password, birthdate)
VALUES ('3b1ac759-b616-49d4-9914-92428cd7e68f', 'John', 'Socrates', '470 Astoria Blvd', '11102', 'NY',
        'socrates@gmail.com', 'cicuta', '-300-08-27');
INSERT INTO student (id, firstname, lastname, address, zip_code, state, email, password, birthdate)
VALUES ('17fa938e-e70f-42b8-b764-c8e22335b2bd', 'Nik', 'Platon', '470 Astoria Blvd', '11102', 'NY', 'platon@gmail.com',
        'theoryOfForms', '-427-08-01');
INSERT INTO student (id, firstname, lastname, address, zip_code, state, email, password, birthdate)
VALUES ('79f70291-cc22-4980-aa8c-0a410b777f47', 'Zenon', 'De Citio', '300 Astoria Blvd', '11102', 'NY',
        'zenon.de.citio@gmail.com', 'stoicism', '-470-08-27');

-- Aldous Huxley teaches math
INSERT INTO course (id, code, teacher_id, subject_id)
VALUES ('f8ce32ec-3374-46d9-b32c-59c26032aaea', 'K1024', '15e7e4ce-44ec-486a-bb1f-cdc6ce533e25',
        '7e569bab-dd07-459b-af54-69e5ea6cbfa3');
INSERT INTO course (id, code, teacher_id, subject_id)
VALUES ('47a17cce-d94a-4ffe-b9c1-273a22b443ee', 'K1025', '15e7e4ce-44ec-486a-bb1f-cdc6ce533e25',
        '7e569bab-dd07-459b-af54-69e5ea6cbfa3');
-- Ray Bradbury teaches computer science
INSERT INTO course (id, code, teacher_id, subject_id)
VALUES ('23be7032-8779-493e-8a31-06d9e1bd569e', 'Z1024', 'f0c4b7ff-3214-4323-992d-f73dacbd79d6',
        'a00fcd84-3c47-4cf9-b7fa-0f47e315c14b');

-- Socrates is not enrolled to any course
-- Platon is enrolled to a Math Course
INSERT INTO student_course (student_id, course_id)
VALUES ('17fa938e-e70f-42b8-b764-c8e22335b2bd', 'f8ce32ec-3374-46d9-b32c-59c26032aaea');
-- Zenon is enrolled to Math and Computer science
INSERT INTO student_course (student_id, course_id)
VALUES ('79f70291-cc22-4980-aa8c-0a410b777f47', 'f8ce32ec-3374-46d9-b32c-59c26032aaea');
INSERT INTO student_course (student_id, course_id)
VALUES ('79f70291-cc22-4980-aa8c-0a410b777f47', '23be7032-8779-493e-8a31-06d9e1bd569e');

