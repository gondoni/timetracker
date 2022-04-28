CREATE DATABASE timetracker;
USE timetracker;

CREATE TABLE hibernate_sequence (next_val bigint);
INSERT INTO hibernate_sequence VALUES (1000);

CREATE TABLE project (id bigint not null, code varchar(255), description varchar(255), name varchar(255), PRIMARY KEY (id));
CREATE TABLE task (id bigint not null, code varchar(255), description varchar(255), project_id bigint, PRIMARY KEY (id));
CREATE TABLE user (id bigint not null, name varchar(255), password varchar(255), username varchar(255), PRIMARY KEY (id), UNIQUE KEY unique_username (username));
CREATE TABLE usertask (id bigint not null, task_id bigint, user_id bigint, primary key (id));
CREATE TABLE fulfillment (id bigint not null, description varchar(255), fulfill_date datetime, hours float, usertask_id bigint, PRIMARY KEY (id));

ALTER TABLE fulfillment ADD CONSTRAINT FK35sjqk96ytfh77s7bvhgnwtcg FOREIGN KEY (usertask_id) REFERENCES usertask (id);
ALTER TABLE task ADD CONSTRAINT FKk8qrwowg31kx7hp93sru1pdqa FOREIGN KEY (project_id) REFERENCES project (id);
ALTER TABLE usertask ADD CONSTRAINT FKcqmn9epf69s9d0qfoxnub0y17 FOREIGN KEY (task_id) REFERENCES task (id);
ALTER TABLE usertask ADD CONSTRAINT FK4chcfbnup91ka795vahh3il51 FOREIGN KEY (user_id) REFERENCES user (id);

INSERT INTO user (id, name, username, password) VALUES (1, 'Nagy Feri', 'nferi', 'pwd');
INSERT INTO user (id, name, username, password) VALUES (2, 'Kis Vili', 'kvili', 'pwd');
INSERT INTO user (id, name, username, password) VALUES (3, 'Tóth Ottó', 'totto', 'pwd');
INSERT INTO user (id, name, username, password) VALUES (4, 'Szép Virág', 'szvirag', 'pwd');
INSERT INTO user (id, name, username, password) VALUES (5, 'Ez Ede', 'ezede', 'pwd');
INSERT INTO user (id, name, username, password) VALUES (6, 'Mia Manó', 'mmano', 'pwd');

INSERT INTO project (id, code, name, description) VALUES (1, 'PR1', 'Projekt1', 'Fontos projekt');
INSERT INTO project (id, code, name, description) VALUES (2, 'PR2', 'Projekt2', 'Hasznos projekt');

INSERT INTO task (id, code, description, project_id) VALUES (1, 'F11', 'Feladat1, ami fontos', (SELECT id FROM project WHERE code = 'PR1'));
INSERT INTO task (id, code, description, project_id) VALUES (2, 'F12', 'Feladat2, ami sürgõs', (SELECT id FROM project WHERE code = 'PR1'));
INSERT INTO task (id, code, description, project_id) VALUES (3, 'F21', 'Feladat3, amit senki sem akar', (SELECT id FROM project WHERE code = 'PR2'));
INSERT INTO task (id, code, description, project_id) VALUES (4, 'F22', 'Feladat4, ami felesleges', (SELECT id FROM project WHERE code = 'PR2'));

INSERT INTO usertask (id, user_id, task_id) VALUES (1, (SELECT id FROM user WHERE username = 'nferi'), (SELECT id FROM task WHERE code = 'F11'));
INSERT INTO usertask (id, user_id, task_id) VALUES (2, (SELECT id FROM user WHERE username = 'nferi'), (SELECT id FROM task WHERE code = 'F12'));
INSERT INTO usertask (id, user_id, task_id) VALUES (3, (SELECT id FROM user WHERE username = 'kvili'), (SELECT id FROM task WHERE code = 'F11'));
INSERT INTO usertask (id, user_id, task_id) VALUES (4, (SELECT id FROM user WHERE username = 'kvili'), (SELECT id FROM task WHERE code = 'F12'));
INSERT INTO usertask (id, user_id, task_id) VALUES (5, (SELECT id FROM user WHERE username = 'kvili'), (SELECT id FROM task WHERE code = 'F21'));
INSERT INTO usertask (id, user_id, task_id) VALUES (6, (SELECT id FROM user WHERE username = 'totto'), (SELECT id FROM task WHERE code = 'F21'));
INSERT INTO usertask (id, user_id, task_id) VALUES (7, (SELECT id FROM user WHERE username = 'szvirag'), (SELECT id FROM task WHERE code = 'F21'));
INSERT INTO usertask (id, user_id, task_id) VALUES (8, (SELECT id FROM user WHERE username = 'ezede'), (SELECT id FROM task WHERE code = 'F11'));
INSERT INTO usertask (id, user_id, task_id) VALUES (9, (SELECT id FROM user WHERE username = 'ezede'), (SELECT id FROM task WHERE code = 'F21'));
INSERT INTO usertask (id, user_id, task_id) VALUES (10, (SELECT id FROM user WHERE username = 'mmano'), (SELECT id FROM task WHERE code = 'F22'));

INSERT INTO fulfillment (id, description, fulfill_date, hours, usertask_id) VALUES (1, 'Ez gyors volt!', CURDATE(), 1.5, (SELECT id FROM usertask WHERE user_id = (SELECT id FROM user WHERE username = 'nferi') and task_id = (SELECT id FROM task WHERE code = 'F12')));
INSERT INTO fulfillment (id, description, fulfill_date, hours, usertask_id) VALUES (2, 'Ez könnyû volt!', DATE_SUB(CURDATE(), INTERVAL 2 DAY), 2.2, (SELECT id FROM usertask WHERE user_id = (SELECT id FROM user WHERE username = 'nferi') and task_id = (SELECT id FROM task WHERE code = 'F12')));
INSERT INTO fulfillment (id, description, fulfill_date, hours, usertask_id) VALUES (3, 'Ezt nem igazán értettem.', DATE_SUB(CURDATE(), INTERVAL 2 DAY), 1.1, (SELECT id FROM usertask WHERE user_id = (SELECT id FROM user WHERE username = 'kvili') and task_id = (SELECT id FROM task WHERE code = 'F11')));
INSERT INTO fulfillment (id, description, fulfill_date, hours, usertask_id) VALUES (4, 'Majd kiderül...', DATE_SUB(CURDATE(), INTERVAL 5 DAY), 5.6, (SELECT id FROM usertask WHERE user_id = (SELECT id FROM user WHERE username = 'totto') and task_id = (SELECT id FROM task WHERE code = 'F21')));