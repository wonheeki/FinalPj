create table subway(
	sub_no number(5) primary key,
	sub_line_name varchar2(10 char) not null,
	sub_station varchar2(15 char) not null,
	sub_telno_info varchar2(30 char) not null
)

create sequence sub_no_seq;

select * from SUBWAY order by sub_no

insert into subway values(sub_no_seq.nextval, '분당선', '개포동', '긴급전화(역무실):02-3412-4418')

drop table subway cascade constraint
drop sequence sub_no_seq

create table facilities(
	f_no number(5) primary key,
	f_fclt_nm varchar2(20 char) not null,
	f_FCLT_KIND_NM varchar2(20 char) not null,
	f_JRSD_SGG_NM varchar2(10 char) not null,
	f_FCLT_ADDR varchar2(50 char) not null
)

create sequence f_no_seq

insert into facilities values(f_no_seq.nextval, '주몽재활의원', '(장애인) 장애인의료재활시설', '강동구', '서울특별시 강동구 상암로 369 상일동 179')

drop table facilities cascade constraint
drop sequence f_no_seq

select * from facilities order by f_no
create table charge(
	c_no number(5) primary key,
	c_FCLTYNM varchar2(20 char) not null,
	c_SIGNGUNM varchar2(10 char) not null,
	c_RDNMADR varchar2(50 char) not null,
	c_INSTLLCDESC varchar2(50 char) not null,
	c_WEEKDAYOPEROPENHHMM date not null,
	c_WEEKDAYOPERCOLSEHHMM date not null,
	c_SATOPEROPEROPENHHMM date not null,
	c_SATOPERCLOSEHHMM date not null,
	c_INSTITUTIONNM varchar2(50 char) not null,
	c_INSTITUTIONPHONENUMBER varchar2(15 char) not null
)

drop table charge cascade constraint
create sequence c_no_seq;
drop sequence c_no_seq

insert into charge values(c_no_seq.nextval, '용산행복장애인자립생활센터', '용산구', '서울특별시 중랑구 중랑역로 9', '중랑역 (엘리베이터 옆)', to_date('05:00', 'hh24:mi'), to_date('00:00', 'hh24:mi'), to_date('05:00', 'hh24:mi'), to_date('00:00', 'hh24:mi'), '종암경찰서', '182')

select * from charge order by c_no

drop table tp_member cascade constraint


create table tp_member(
   u_id varchar2(30 char) primary key,
   u_pw varchar2(30 char) not null,
   u_name varchar2(30 char) not null,
   u_nickname varchar2(30 char) not null,
   u_email varchar2(50 char) not null,
   u_tel varchar2(30 char) not null,
   u_addr varchar2(100 char) not null
);

select * from tp_member
insert into tp_member values('sadg','1','asdf','asdfg','asdf@asdf.com','232323','ㅁㄴㅇㅁㄴㅇ');

drop table tp_member cascade constraint purge

-- 게시판 DB
create table tp_board(
	b_no number(5) primary key,
	b_title varchar2(200 char) not null,
	b_txt varchar2(1000 char) not null,
	b_writer varchar2(20 char) not null,
	b_regDate date not null,
	b_readCounter number(5) default 0 not null,
	
	constraint fk_b_writer foreign key(b_writer) references tp_member(u_id)
	on delete cascade
);
insert into tp_board values(b_no_seq.nextval, '웨안돼?', 'asdsadasda', 'qqqqq', sysdate, )
select rownum, TP_BOARD. * from TP_BOARD where rownum between 1 and 10;
select * from tp_board;
update tp_board set b_title = '원희씨 바보ㅋ', b_txt='원희씨 바보~' where b_no = 3;

delete tp_board where b_no = 2;
insert into tp_board values(b_no_seq.nextval, 'sdf', 'sadg' ,'sadg', sysdate)

create sequence b_no_seq

select * from tp_board order by b_no asc

select rownum as rn, b_title, b_writer, b_txt, b_regDate from tp_board where rn = 1

select * from TP_BOARD where b_no = 50

drop table tp_board cascade constraint purge
drop sequence b_no_seq

select rownum as rn, b_title, b_writer, b_regDate from
(select b_title, b_writer, b_regDate from TP_BOARD, TP_MEMBER where b_writer = u_id order by b_regDate desc)
order by rn

-------------------------------------
-- 댓글 테이블
create table tp_comment(
   c_no number(5),
   b_no number(5) not null, -- 게시글 번호
   c_writer varchar2(30 char) not null, 
   c_regDate Date not null, 
   c_txt varchar2(1000 char) not null,
   primary key(c_no,b_no)
);

create sequence c_no_seq
drop table tp_comment cascade constraint purge

alter table tp_comment add constraint tp_comment_b_no foreign key(b_no) references tp_board(b_no);

select * from tp_comment;

insert into tp_comment values(c_no_seq.nextval, 'sdf',sysdate,'asdasd나는바보')
where c_bno =(select b_no from tp_board where b_no = 1)

insert into tp_comment values(c_no_seq.nextval,1,'asd',sysdate,'원희씨바보~ㅋ')

select * from tp_comment where b_no=1 order by c_regDate desc

create table tp_comment(
   c_no number(5) primary key, -- 댓글번호
   b_no number(5) not null, -- 소속된 글 번호
   c_writer varchar2(30 char) not null, 
   c_regDate Date not null, 
   c_txt varchar2(1000 char) not null,
   constraint fk_board_replys
   		foreign key(b_no) references tp_board(b_no)
   		on delete cascade,
   constraint fk_c_writer foreign key(c_writer) references tp_member(u_id)
   on delete cascade
);
drop table tp_comment cascade constraint purge
create sequence c_no_seq
drop sequence c_no_seq
delete from tp_comment where c_no = 62






