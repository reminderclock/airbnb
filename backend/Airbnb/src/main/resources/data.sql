INSERT INTO `airbnb`.`room` (`id`, `location`, `title`, `image`, `description`, `x_pos`, `y_pos`, `ratings`, `reviews`,
                             `charge`, `cleaning_fee`, `service_fee`)
VALUES ('1', '서울', 'Spacious and Comfortable cozy house #4',
        'https://www.airbnb.com/rooms/29556662/photos/604588770?federated_search_id=6422bc81-ecb8-4381-a7b0-758e46144cbe&source_impression_id=p3_1621340285_vHikcFrealdXlffU&guests=1&adults=1',
        '최대 인원 3명 ・ 원룸 ・ 침대 1개 ・ 욕실 1개・ 주방 ・ 무선 인터넷・ 에어컨 ・ 헤어드라이어', '35.97664845766847', '126.99597295767953', '4.5',
        '272', '82953', '25996', '1822468');
INSERT INTO `airbnb`.`room` (`id`, `location`, `title`, `image`, `description`, `x_pos`, `y_pos`, `ratings`, `reviews`,
                             `charge`, `cleaning_fee`, `service_fee`, `tax_fee`)
VALUES ('2', '서울', '소소한 파티하기 좋은 숙소 / 홍대 / 연남동 / artist house3',
        'https://www.airbnb.com/rooms/29556662/photos/604588770?federated_search_id=6422bc81-ecb8-4381-a7b0-758e46144cbe&source_impression_id=p3_1621340285_vHikcFrealdXlffU&guests=1&adults=1',
        '최대 인원 3명 ・ 원룸 ・ 침대 1개 ・ 욕실 1개・ 주방 ・ 무선 인터넷・ 에어컨 ・ 헤어드라이어', '22.35364454353453', '85.68975653434279', '4.3',
        '301', '72300', '25996', '1822468', '18247');
INSERT INTO `airbnb`.`room` (`id`, `location`, `title`, `image`, `description`, `x_pos`, `y_pos`, `ratings`, `reviews`,
                             `charge`, `cleaning_fee`, `service_fee`, `tax_fee`)
VALUES ('3', '서울', 'B) 3min from Itaewon Stn [ 2 BR ] Rooftop View',
        'https://www.airbnb.com/rooms/29556662/photos/604588770?federated_search_id=6422bc81-ecb8-4381-a7b0-758e46144cbe&source_impression_id=p3_1621340285_vHikcFrealdXlffU&guests=1&adults=1',
        '최대 인원 3명 ・ 원룸 ・ 침대 2개 ・ 욕실 1개・ 주방 ・ 무선 인터넷・ 에어컨 ・ 헤어드라이어', '22.35364454353453', '85.68975653434279', '3.6',
        '56', '64302', '43322', '1245453', '23344');
INSERT INTO `airbnb`.`room` (`id`, `location`, `title`, `image`, `description`, `x_pos`, `y_pos`, `ratings`, `reviews`,
                             `charge`, `cleaning_fee`, `service_fee`, `tax_fee`)
VALUES ('4', '서울', '최고급 럭셔리 하우스',
        'https://www.airbnb.com/rooms/29556662/photos/604588770?federated_search_id=6422bc81-ecb8-4381-a7b0-758e46144cbe&source_impression_id=p3_1621340285_vHikcFrealdXlffU&guests=1&adults=1',
        '최대 인원 3명 ・ 원룸 ・ 침대 1개 ・ 욕실 1개・ 주방 ・ 무선 인터넷・ 에어컨 ・ 헤어드라이어', '127.23254443432437', '110.23232353534342', '4.2',
        '121', '98654', '36533', '2132422', '44332');

INSERT INTO `airbnb`.`user` (`id`, `password`, `nickname`, `email`)
VALUES ('team10', '1010', 'Ship', 'ship@codesquad.com');
INSERT INTO `airbnb`.`user` (`id`, `password`, `nickname`, `email`)
VALUES ('august', '1234', 'Augboot', 'august@gmail.com');
INSERT INTO `airbnb`.`user` (`id`, `password`, `nickname`, `email`)
VALUES ('luke', '1234', 'Luke', 'luke@gmail.com');
INSERT INTO `airbnb`.`user` (`id`, `password`, `nickname`)
VALUES ('ray', '1234', 'Ray');

INSERT INTO `airbnb`.`wishlist` (`id`, `user_id`, `room_id`)
VALUES ('1', 'august', '1');
INSERT INTO `airbnb`.`wishlist` (`id`, `user_id`, `room_id`)
VALUES ('2', 'ray', '2');
INSERT INTO `airbnb`.`wishlist` (`id`, `user_id`, `room_id`)
VALUES ('3', 'luke', '3');
INSERT INTO `airbnb`.`wishlist` (`id`, `user_id`, `room_id`)
VALUES ('4', 'team10', '4');

INSERT INTO `airbnb`.`reserve` (`id`, `user_id`, `room_id`, `check_in`, `check_out`, `guests`)
VALUES ('1', 'august', '1', '2021-05-10', '2021-05-18', '3');
INSERT INTO `airbnb`.`reserve` (`id`, `user_id`, `room_id`, `check_in`, `check_out`, `guests`)
VALUES ('2', 'ray', '2', '2021-04-10', '2021-04-17', '2');
INSERT INTO `airbnb`.`reserve` (`id`, `user_id`, `room_id`, `check_in`, `check_out`, `guests`)
VALUES ('3', 'luke', '3', '2021-06-20', '2021-06-27', '4');
INSERT INTO `airbnb`.`reserve` (`id`, `user_id`, `room_id`, `check_in`, `check_out`, `guests`)
VALUES ('4', 'team10', '4', '2021-11-11', '2021-11-20', '5');
