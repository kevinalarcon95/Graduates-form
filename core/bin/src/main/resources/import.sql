INSERT INTO `Universities` (`uni_nit`, `uni_name`, `uni_email`, `uni_sector`, `uni_webpage`,`createAt`,`updateAt`) VALUES ('891500319:2','Universidad del Cauca','wbenavides@unicauca.edu.co','SECTOR PUBLICO NACIONAL','https://www.unicauca.edu.co/versionP',now(),now());

INSERT INTO `Headquarters` (`hdq_id`, `hdq_name`, `university_nit`,`createAt`,`updateAt`) VALUES (null,'POPAYÁN','891500319:2',now(),now());
INSERT INTO `Headquarters` (`hdq_id`, `hdq_name`, `university_nit`,`createAt`,`updateAt`) VALUES (null,'SANTANDER DE QUILICHAO','891500319:2',now(),now());

INSERT INTO `Faculties` (`fac_id`, `fac_name`,`fac_address`, `headquarter_id`,`createAt`,`updateAt`) VALUES (null,'Facultad de Artes','Cra. 6 #173, Centro, Popayán, Cauca',1,now(),now());
INSERT INTO `Faculties` (`fac_id`, `fac_name`,`fac_address`, `headquarter_id`,`createAt`,`updateAt`) VALUES (null,'Facultad de Ingeniería Electrónica y Telecomunicaciones','Cra. 2 #4N-140, Popayán, Cauca',1,now(),now());

INSERT INTO `Departments` (`dep_id`, `dep_name`, `faculty_id`,`createAt`,`updateAt`) VALUES (null,'Ingeniería De Sistemas',2,now(),now());

INSERT INTO `Programs` (`prog_cod`, `prog_name`, `department_id`,`createAt`,`updateAt`,`prog_type`) VALUES ('1','Ingeniería De Sistemas',1,now(),now(),'DEGREE');
INSERT INTO `Programs` (`prog_cod`, `prog_name`, `department_id`,`createAt`,`updateAt`,`prog_type`) VALUES ('2','Especializacion en Ciencia de Datos',1,now(),now(),'DEGREE');

INSERT INTO `Degrees` (`deg_id`, `deg_name`, `deg_mention`, `deg_type`, `program_code`,`createAt`,`updateAt`) VALUES (null,'Ingeniero de Sistemas','si','UDERGRATUATE','1',now(),now());

--INSERT INTO `Forms` (`id`, `comentarioPrograma`, `expectativaUniversidad`,`docenteInfluyente`,`razonInfluyente`,`observaciones`) VALUES (null,'comentario del programa','','','','');

INSERT INTO `Forms` (`form_id`, `form_universityExpectative`, `form_mostImportantProfessor`, `form_mostImportantReassons`, `form_observations`, `form_programComment`, `createAt`, `updateAt`) VALUES (null,'comentario del programa','','','','',now(),now());

INSERT INTO `Phones` (`ph_id`, `ph_type`, `ph_number`) VALUES (null,'ceular','3005468952');
INSERT INTO `Phones` (`ph_id`, `ph_type`, `ph_number`) VALUES (null,'ceular','3005468952');
INSERT INTO `Phones` (`ph_id`, `ph_type`, `ph_number`) VALUES (null,'ceular','3005468952');
INSERT INTO `Phones` (`ph_id`, `ph_type`, `ph_number`) VALUES (null,'ceular','3005468952');

INSERT INTO `refereds` (`ref_id`, `ref_email`, `ref_name`, `phone_id`) VALUES (null,'marcela','marce@gmail.com',1);

INSERT INTO `locations` (`loc_id`, `loc_natal_dept`, `loc_natal_town`, `loc_residence_city`, `loc_residence_country`, `loc_residence_department`) VALUES (null,'Cauca','Popayán','Popayán','Colombia','Cauca');

INSERT INTO `graduates` (`grad_id`, `grad_idType`, `grad_IDExpeditionLoc`, `grad_IDExpeditionCountry`, `grad_alternativeEmail`, `grad_childsQuantity`, `grad_gradeDate`, `grad_names`, `grad_lastnames`, `grad_birthday`, `grad_gender`, `grad_address`, `grad_institutionalEmail`, `grad_civiState`, `form_id`, `location_id`, `refered_id`, `createAt`, `updateAt`) VALUES ('1061987654','CC','Popayán','Colombia','juan@gmail.com',0,'2022-11-09 00:00:00','juan felipe','martinez sandobal','2022-11-09 00:00:00','M','calle 8 # 52 A 9','juan@unicauca.edu.co','soltero',1,1,1,now(),now());

INSERT INTO `graduated_program` (`program_code`, `graduated_id`) VALUES ('1','1061987654');
INSERT INTO `graduated_program` (`program_code`, `graduated_id`) VALUES ('2','1061987654');

INSERT INTO `phone_graduated` (`phone_id`, `graduated_id`) VALUES (2,'1061987654');
INSERT INTO `phone_graduated` (`phone_id`, `graduated_id`) VALUES (3,'1061987654');

INSERT INTO `degree_graduated` (`graduated_id`, `degree_id`) VALUES ('1061987654',1);

INSERT INTO `bosses` (`boss_id`, `boss_email`, `boss_name`, `createAt`, `updateAt`) VALUES (null,'jefe@gmail.com','Eduardo Gómez',now(),now());

INSERT INTO `jobs` (`id`, `hadJobBefore`, `hasBeenInProfession`, `position`, `enterprise`, `working`, `actualEnterprise`, `jobCity`, `actualPosition`, `salarialRange`, `contractType`, `Sector`, `isInProfession`, `boss_id`, `phone_id`, `createAt`, `updateAt`) VALUES (null,false,true,'cargo','empresa',true,'empresa actual','Ciudad trabajo','cargo actual','rango salarial','tipo contrato','sector',true,1,4,now(),now());

INSERT INTO `job_graduated` (`job_id`, `graduated_id`) VALUES (1,'1061987654');

INSERT INTO `roles` (`rol_type`) VALUES ('GRADUATED');
INSERT INTO `roles` (`rol_type`) VALUES ('STATISTICS');
INSERT INTO `roles` (`rol_type`) VALUES ('POLL');
INSERT INTO `roles` (`rol_type`) VALUES ('ADMIN');

INSERT INTO `users` (`user_id`, `createAt`, `user_email`, `user_lastName`, `user_name`, `user_password`, `updateAt`) VALUES (1061987654, now(), 'juan@unicauca.edu.co', 'Gómez', 'Eduardo', '123', now());

INSERT INTO `user_rol` (`user_id`, `rol_id`) VALUES (1061987654, 1);
INSERT INTO `user_rol` (`user_id`, `rol_id`) VALUES (1061987654, 2);