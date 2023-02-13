create table tp_member(
	u_id varchar2(30 char) primary key,
	u_pw varchar2(30 char),
	u_name varchar2(30 char),
	u_nickname varchar2(30 char),
	u_email varchar2(30 char),
	u_tel varchar2(30 char),
	u_addr varchar2(100 char)
);

select * from tp_member

drop table tp_member cascade constraint purge

insert into tp_member values('1','1','1','1','1','1','1')

create table tp_member(
	u_id varchar2(30 char) primary key,
	u_pw varchar2(30 char) not null,
	u_name varchar2(30 char) not null,
	u_nickname varchar2(30 char) not null,
	u_email varchar2(30 char) not null,
	u_tel varchar2(30 char) not null,
	u_addr varchar2(100 char) not null
);