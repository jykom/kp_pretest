-- Host: localhost:3306
-- database 생성 : kakaodb
create database kakaodb;

-- 사용자 계정정보 생성 id : lyan, pw : 1234
create user 'lyan'@'localhost' identified by '1234';
grant all privileges on kakaodb.* to 'lyan'@'localhost';

create user 'lyan'@'%' identified by '1234';
grant all privileges on kakaodb.* to 'lyan'@'%';

-- INSERT/UPDATE/DELETE문을 이용해서 MySQL의 사용자를 추가,삭제하거나, 사용자 권한 등을 변경하였을 때
-- MySQL에 변경사항을 적용하기 위해서 사용하는 명령어
flush privileges;

--  사용할 database 선택
use kakaodb;

-- 거래내역 TABLE 생성
CREATE TABLE `trans_info` (
  `trans_dt` date NOT NULL,
  `acct_no` varchar(8) NOT NULL,
  `trans_no` int(5) NOT NULL,
  `amt` int(10) NOT NULL,
  `cmsn` int(10) NOT NULL,
  `cncl_yn` varchar(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 거래내역 TABLE DATA 입력
INSERT INTO `trans_info` (`trans_dt`, `acct_no`, `trans_no`, `amt`, `cmsn`, `cncl_yn`) VALUES
('20180102', '11111111', '1', '1000000', '0', 'N'),
('20180203', '11111111', '1', '500000', '1000', 'Y'),
('20180203', '11111111', '2', '500000', '1000', 'N'),
('20180305', '11111111', '1', '2000000', '0', 'N'),
('20180305', '11111111', '2', '3000000', '2000', 'N'),
('20180401', '11111113', '1', '2000000', '0', 'N'),
('20180401', '11111113', '2', '3000000', '1000', 'N'),
('20180401', '11111113', '3', '10000000', '3000', 'Y'),
('20180402', '11111113', '1', '20000000', '2000', 'Y'),
('20180403', '11111113', '1', '5000000', '0', 'N'),
('20180601', '11111112', '1', '1000000', '100', 'N'),
('20180601', '11111112', '2', '1000000', '100', 'N'),
('20180601', '11111112', '3', '3000000', '100', 'Y'),
('20180601', '11111112', '4', '2000000', '100', 'N'),
('20180601', '11111112', '5', '10000', '0', 'N'),
('20180701', '11111114', '1', '5000000', '0', 'N'),
('20180702', '11111114', '1', '100000', '0', 'N'),
('20180703', '11111114', '1', '30000000', '0', 'Y'),
('20180704', '11111114', '1', '8000000', '8000', 'N'),
('20180705', '11111114', '1', '50000000', '5000', 'Y'),
('20180706', '11111114', '1', '9000000', '0', 'N'),
('20180707', '11111114', '1', '8000000', '0', 'Y'),
('20180708', '11111114', '1', '6000000', '0', 'N'),
('20180709', '11111114', '1', '500000', '0', 'N'),
('20180710', '11111114', '1', '400000', '0', 'N'),
('20180801', '11111116', '1', '90000000', '9000', 'Y'),
('20180801', '11111116', '2', '8000000', '8000', 'N'),
('20180802', '11111116', '1', '400000', '0', 'N'),
('20180803', '11111116', '1', '500000', '0', 'N'),
('20180804', '11111116', '1', '600000', '0', 'N'),
('20180920', '11111117', '1', '200000', '0', 'N'),
('20180921', '11111117', '1', '300000', '1000', 'N'),
('20180922', '11111117', '1', '400000', '0', 'N'),
('20180923', '11111117', '1', '500000', '0', 'N'),
('20180924', '11111117', '1', '600000', '0', 'N'),
('20181010', '11111118', '1', '1000000', '100', 'Y'),
('20181011', '11111118', '1', '1000000', '100', 'Y'),
('20181012', '11111118', '1', '1000000', '100', 'Y'),
('20181013', '11111118', '1', '1000000', '100', 'Y'),
('20181014', '11111118', '1', '1000000', '100', 'Y'),
('20181101', '11111119', '1', '2000000', '0', 'N'),
('20181101', '11111119', '2', '2000000', '0', 'N'),
('20181101', '11111119', '3', '2000000', '0', 'N'),
('20181101', '11111119', '4', '2000000', '0', 'N'),
('20181101', '11111119', '5', '2000000', '0', 'N'),
('20181101', '11111119', '6', '2000000', '0', 'N'),
('20181101', '11111119', '7', '2000000', '0', 'N'),
('20181225', '11111120', '1', '30000000', '3000', 'Y'),
('20181225', '11111120', '2', '20000000', '2000', 'Y'),
('20181225', '11111120', '3', '9000000', '300', 'N'),
('20181231', '11111120', '1', '8000000', '400', 'N'),
('20181231', '11111120', '2', '1234567', '0', 'N'),
('20190405', '11111112', '1', '20000000', '0', 'N'),
('20190406', '11111112', '1', '10000000', '1000', 'N'),
('20190407', '11111112', '1', '300000', '100', 'Y'),
('20190408', '11111112', '1', '5000000', '300', 'N'),
('20190409', '11111112', '1', '6000000', '300', 'N'),
('20190501', '11111111', '1', '100000', '500', 'N'),
('20190502', '11111111', '1', '10000000', '1800', 'N'),
('20190503', '11111111', '1', '10000000', '0', 'Y'),
('20190503', '11111111', '2', '20000000', '0', 'Y'),
('20190503', '11111111', '3', '1000000', '0', 'N'),
('20190601', '11111113', '1', '1000000', '0', 'N'),
('20190602', '11111113', '1', '700000', '0', 'N'),
('20190602', '11111113', '2', '70000000', '7000', 'Y'),
('20190603', '11111113', '1', '9000000', '0', 'N'),
('20190604', '11111113', '1', '4000000', '1000', 'N'),
('20190701', '11111115', '1', '3000000', '300', 'N'),
('20190701', '11111115', '2', '3000000', '300', 'N'),
('20190701', '11111115', '3', '3000000', '300', 'N'),
('20190701', '11111115', '4', '3000000', '300', 'N'),
('20190701', '11111115', '5', '3000000', '300', 'N'),
('20190701', '11111115', '6', '3000000', '300', 'N'),
('20190701', '11111115', '7', '3000000', '300', 'N'),
('20190701', '11111115', '8', '3000000', '300', 'N'),
('20190701', '11111115', '9', '3000000', '300', 'N'),
('20190701', '11111115', '10', '3000000', '300', 'N'),
('20190805', '11111116', '1', '700000', '0', 'N'),
('20190806', '11111116', '1', '800000', '0', 'N'),
('20190807', '11111116', '1', '900000', '0', 'N'),
('20190808', '11111116', '1', '10000000', '0', 'N'),
('20190809', '11111116', '1', '3000000', '300', 'N'),
('20190924', '11111117', '1', '700000', '0', 'N'),
('20190924', '11111117', '2', '800000', '0', 'N'),
('20190924', '11111117', '3', '900000', '0', 'N'),
('20190924', '11111117', '4', '1000000', '0', 'N'),
('20190924', '11111117', '5', '1100000', '0', 'N'),
('20191015', '11111118', '1', '1000000', '100', 'Y'),
('20191016', '11111118', '1', '1000000', '100', 'Y'),
('20191017', '11111118', '1', '1000000', '100', 'Y'),
('20191018', '11111118', '1', '1000000', '100', 'Y'),
('20191019', '11111118', '1', '1000000', '100', 'Y'),
('20191101', '11111119', '1', '2000000', '0', 'N'),
('20191101', '11111119', '2', '2000000', '0', 'N'),
('20191101', '11111119', '3', '2000000', '0', 'N'),
('20191224', '11111120', '1', '3000000', '0', 'N'),
('20191224', '11111120', '2', '3000000', '0', 'N'),
('20191224', '11111120', '3', '3000000', '0', 'N'),
('20191224', '11111120', '4', '3000000', '0', 'N'),
('20191224', '11111120', '5', '3000000', '0', 'N')
;

-- 계좌정보 TABLE 생성
CREATE TABLE `account_info` (
  `acct_no` varchar(8) NOT NULL,
  `name` varchar(12) NOT NULL,
  `br_code` varchar(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 계좌정보 TABLE DATA 입력
INSERT INTO `account_info` (`acct_no`, `name`, `br_code`) VALUES
('11111111', '제이', 'A'),
('11111112', '에이스', 'A'),
('11111113', '리노', 'A'),
('11111114', '테드', 'B'),
('11111115', '사라', 'B'),
('11111116', '린', 'B'),
('11111117', '케빈', 'C'),
('11111118', '제임스', 'D'),
('11111119', '주디', 'D'),
('11111120', '로이', 'C')
;

-- 관리점정보 TABLE 생성
CREATE TABLE `branch_info` (
  `br_code` varchar(2) NOT NULL,
  `br_name` varchar(12) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 관리점정보 TABLE DATA 입력
INSERT INTO `branch_info` (`br_code`, `br_name`) VALUES
('A', '판교점'),
('B', '분당점'),
('C', '강남점'),
('D', '잠실점');

COMMIT;