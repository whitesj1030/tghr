INSERT INTO tghrdb.tc_car
(car_id, created_date, modified_date, base_price, car_color, car_exhat, car_nm, car_number, car_register_date, del_yn, drv_dist, flood_yn, fuel, fuel_eff, gear_nm, gear_type, guarantee_type, inspection_end_date, inspection_start_date, motor_type, price, recommend, rid_capa, seizure_yn, smok_yn)
VALUES(1, '2020-09-03 18:45:50.234', '2020-09-03 18:45:50.234', 30000000.00, '빨강', NULL, '그랜저', '경북21가1234', NULL, 'N', NULL, 'N', 'G', NULL, NULL, 'M', 'S', NULL, NULL, 'A', 0.00, NULL, NULL, NULL, 'd');

INSERT INTO tghrdb.tc_car_option_group
(opt_grp_id, created_date, modified_date, opt_grp_nm)
VALUES(1, NULL, '2020-09-04 14:35:21.701', '안전');
INSERT INTO tghrdb.tc_car_option_group
(opt_grp_id, created_date, modified_date, opt_grp_nm)
VALUES(2, NULL, '2020-09-04 11:34:33.608', '편의사양');


INSERT INTO tghrdb.tc_car_option
(opt_id, created_date, modified_date, opt_desc, opt_grp_id, opt_nm, opt_n)
VALUES(1, NULL, NULL, NULL, 1, '에어벡', NULL);
INSERT INTO tghrdb.tc_car_option
(opt_id, created_date, modified_date, opt_desc, opt_grp_id, opt_nm, opt_n)
VALUES(2, NULL, NULL, NULL, 1, 'ABS', NULL);
INSERT INTO tghrdb.tc_car_option
(opt_id, created_date, modified_date, opt_desc, opt_grp_id, opt_nm, opt_n)
VALUES(3, '2020-09-04 11:37:01.286', '2020-09-04 11:37:01.286', '브러쉬 자동 작동', 3, '레인센서', NULL);
INSERT INTO tghrdb.tc_car_option
(opt_id, created_date, modified_date, opt_desc, opt_grp_id, opt_nm, opt_n)
VALUES(4, NULL, '2020-09-04 11:39:05.417', '우천시 자동 작동', NULL, NULL, NULL);


INSERT INTO tghrdb.tc_car_option_detail
(car_option_detail_id, created_date, modified_date, opt_id, opt_val, car_id)
VALUES(1, NULL, '2020-09-04 15:15:45.975', NULL, '에에벡33', 1);
INSERT INTO tghrdb.tc_car_option_detail
(car_option_detail_id, created_date, modified_date, opt_id, opt_val, car_id)
VALUES(2, NULL, '2020-09-04 15:15:45.982', NULL, 'ABS33', 1);
INSERT INTO tghrdb.tc_car_option_detail
(car_option_detail_id, created_date, modified_date, opt_id, opt_val, car_id)
VALUES(3, '2020-09-04 14:57:26.439', '2020-09-04 14:57:26.439', '1', 'EBS', 1);
INSERT INTO tghrdb.tc_car_option_detail
(car_option_detail_id, created_date, modified_date, opt_id, opt_val, car_id)
VALUES(4, '2020-09-04 15:00:05.545', '2020-09-04 15:00:05.545', '1', '자율주행', 1);
