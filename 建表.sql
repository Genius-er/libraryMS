
create table tb_user (user_id numeric (38), username varchar (50), password varchar (50), china_name varchar (50), user_type varchar (50), sex numeric (38), tel varchar (50), favorite longtext, primary key(user_id));

create table tb_book (book_id numeric (11), isbn varchar (50), title varchar (50), author varchar (50), publish varchar (50), booktype_no varchar (50), booktype_name varchar (50), price numeric (38), cover varchar (500), primary key(book_id));

create table tb_count (isbn varchar (50), storage numeric (11), leaving numeric (11), primary key(isbn));

create table tb_borrower (bb_id int, user_id numeric (38), book_id numeric (11), title varchar (50), author varchar (50), bb_date bigint, peality_date bigint, return_date bigint , state int, primary key(bb_id));

create table Interest_recommend (user_id numeric (38), book_type varchar (30), author varchar (50), book_language varchar (30), Rec_pool varchar(50), primary key(user_id));

create table Hot_recommend (book_id numeric (11), storage numeric (11), Lended_times numeric (18), primary key(book_id));

INSERT INTO `library`.`tb_book` (`book_id`, `isbn`, `title`, `author`, `publish`, `booktype_no`, `booktype_name`) VALUES ('1', '978-7-5001-3017-8', '朱自清散文精选', '朱自清', '中国对外翻译出版公司', 'I266', '散文集');
INSERT INTO `library`.`tb_book` (`book_id`, `isbn`, `title`, `author`, `publish`, `booktype_no`, `booktype_name`) VALUES ('2', '978-7-5600-9581-3', '直到永远', '方卫平', '外语教学与研究出版社', 'I287', '儿童文学');
INSERT INTO `library`.`tb_book` (`book_id`, `isbn`, `title`, `author`, `publish`, `booktype_name`) VALUES ('3', '', '白给的艺术', '茄子', 'csgo', '辅导书');
INSERT INTO `library`.`tb_book` (`book_id`, `isbn`, `title`, `author`, `publish`, `booktype_name`) VALUES ('4', '978-7-208-06164-4', '追风筝的人', '卡勒德·胡赛尼', '上海人民出版社', '长篇小说');
INSERT INTO `library`.`tb_book` (`book_id`, `title`, `author`, `publish`, `booktype_name`) VALUES ('6', '百年孤独', '加夫列尔·加西亚·马尔克斯', '上海人民出版社', '长篇小说');
INSERT INTO `library`.`tb_book` (`book_id`, `title`, `author`, `publish`, `booktype_name`) VALUES ('7', '西游记', '吴承恩', '北京教育出版社', '长篇小说');
INSERT INTO `library`.`tb_book` (`book_id`, `title`, `author`, `publish`, `booktype_name`) VALUES ('8', '红楼梦', '曹雪芹', '上海人民出版社', '长篇小说');
INSERT INTO `library`.`tb_book` (`book_id`, `title`, `author`, `publish`, `booktype_name`) VALUES ('9', '水浒传', '施耐庵', '上海人民出版社', '长篇小说');
INSERT INTO `library`.`tb_book` (`book_id`, `isbn`, `title`, `author`, `publish`, `booktype_name`) VALUES ('10', '9787557006792', '三国演义', '罗贯中', '上海人民出版社', '长篇小说');
INSERT INTO `library`.`tb_book` (`book_id`, `isbn`, `title`, `author`, `publish`, `booktype_name`) VALUES ('11', '978-7-5522-8307-5', '骆驼祥子', '老舍', '北京教育出版社', '长篇小说');
INSERT INTO `library`.`tb_book` (`book_id`, `title`, `author`, `publish`, `booktype_name`) VALUES ('12', 'A1高闪的投掷方法', '茄子', 'csgo', '辅导书');
