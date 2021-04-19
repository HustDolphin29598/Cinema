INSERT INTO actor(name, age, country) VALUES ('Daniel Radcliffe', 31, 'United Kingdom');
INSERT INTO actor(name, age, country) VALUES ('Rupert Grint', 32, 'United Kingdom');
INSERT INTO actor(name, age, country) VALUES ('Emma Watson', 31, 'France');
INSERT INTO actor(name, country) VALUES ('Alan Rickman', 'United Kingdom');


INSERT INTO film(title, description, thumbnail, running_time, release_date, status) VALUES ('HARRY POTTER VÀ BẢO BỐI TỬ THẦN', 'Không còn sự dẫn dắt của các giáo sư, nhóm bạn Harry (Daniel Radcliffe), Ron (Rupert Grint) và Hermione (Emma Watson) bắt đầu cuộc hành trình phá hủy các Trường Sinh Linh Giá - những vật phẩm giúp Chúa tể Voldemort (Ralph Fiennes) đạt đến sự bất tử. Chính lúc này đây, khi cả ba phải đồng lòng với nhau hơn bất cứ khi nào, những thế lực hắc ám lại đang âm mưu chia rẽ nhóm bạn. Cùng lúc đó, những Tử thần Thực tử của Chúa tể Voldemort chiếm được quyền lãnh đạo Bộ Pháp thuật và Hogwarts, cũng như điên cuồng tìm kiếm Harry và những người bạn thân - trước cuộc chiến tối thượng cuối cùng.', '', 130, PARSEDATETIME('2021/04/01', 'YYYY/mm/dd'), 'ON_THEATER');


INSERT INTO `cast`(actor_id, film_id) VALUES (1, 1);
INSERT INTO `cast`(actor_id, film_id) VALUES (2, 1);
INSERT INTO `cast`(actor_id, film_id) VALUES (3, 1);
INSERT INTO `cast`(actor_id, film_id) VALUES (4, 1);