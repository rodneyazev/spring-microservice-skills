INSERT OR IGNORE INTO ROLES VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
INSERT OR IGNORE INTO USERS_ROLES VALUES (1,1),(2,2);
INSERT OR IGNORE INTO USERS VALUES (1,'admin@gmail.com','admin','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu','admin');
INSERT OR IGNORE INTO USERS VALUES (2,'test@gmail.com','test','$2a$12$TYSPPDsgR1T9vpgMSavOteZoqzjGVLt7rzsqKLrGL4oQdE3rWDNru','test');