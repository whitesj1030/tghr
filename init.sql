INSERT INTO tghrdb.tc_car
(car_id, created_date, modified_date, base_price, car_color, car_exhat, car_nm, car_number, car_register_date, del_yn, drv_dist, flood_yn, fuel, fuel_eff, gear_nm, gear_type, guarantee_type, inspection_end_date, inspection_start_date, motor_type, price, recommend, rid_capa, seizure_yn, smok_yn)
VALUES(3, '2020-09-03 18:45:50.234', '2020-09-03 18:45:50.234', 30000000.00, '빨강', NULL, '그랜저', '경북21가1234', NULL, 'N', NULL, 'N', 'G', NULL, NULL, 'M', 'S', NULL, NULL, 'A', 0.00, NULL, NULL, NULL, 'd');

INSERT INTO tghrdb.tc_car_option_group
(opt_grp_id, created_date, modified_date, opt_grp_nm)
VALUES(1, NULL, NULL, '안전');


INSERT INTO tghrdb.tc_car_option_detail
(car_option_detail_id, created_date, modified_date, opt_id, opt_val, car_id)
VALUES(1, NULL, NULL, '1', '10 에에벡', 1);


INSERT INTO tghrdb.tc_car_option (created_date,modified_date,opt_desc,opt_grp_id,opt_nm) VALUES 
(NULL,NULL,NULL,1,'에어벡')
,(NULL,NULL,NULL,1,'ABS');
;
