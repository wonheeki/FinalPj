create table subway(
	sub_no number(5) primary key,
	sub_line_name varchar2(10 char) not null,
	sub_station varchar2(15 char) not null,
	sub_latitude number(15,10) not null,
	sub_longitude number(15,10) not null,
	sub_telno_info varchar2(30 char) not null
);

create sequence sub_no_seq;

select * from SUBWAY order by sub_no

insert into subway values(sub_no_seq.nextval, '분당선', '개포동', '긴급전화(역무실):02-3412-4418')

drop table subway cascade constraint
drop sequence sub_no_seq

create table facilities(
	f_no number(5) primary key,
	f_fclt_nm varchar2(50 char) not null,
	f_FCLT_KIND_NM varchar2(20 char) not null,
	f_JRSD_SGG_NM varchar2(100 char) not null,
	f_FCLT_ADDR varchar2(100 char) not null,
	f_Latitude number(15,10) not null,
	f_Longitude number(15,10) not null
)

create sequence f_no_seq

insert into facilities values(f_no_seq.nextval, '주몽재활의원', '(장애인) 장애인의료재활시설', '강동구', '서울특별시 강동구 상암로 369 상일동 179')

drop table facilities cascade constraint
drop sequence f_no_seq

select * from facilities order by f_no
create table charge(
   ch_no number(5) primary key,
   ch_FCLTYNM varchar2(20 char) not null,
   ch_SIGNGUNM varchar2(10 char) not null,
   ch_RDNMADR varchar2(50 char) not null,
   ch_Latitude number(15,10) not null,
   ch_Longitude number(15,10) not null,
   ch_INSTLLCDESC varchar2(50 char) not null,
   ch_WEEKDAYOPEROPENHHMM varchar2(20 char) not null,
   ch_WEEKDAYOPERCOLSEHHMM varchar2(20 char) not null,
   ch_SATOPEROPEROPENHHMM varchar2(10 char) not null,
   ch_SATOPERCLOSEHHMM varchar2(10 char) not null,
   ch_INSTITUTIONNM varchar2(50 char) not null,
   ch_INSTITUTIONPHONENUMBER varchar2(20 char) not null
)

drop table charge cascade constraint
create sequence ch_no_seq;
drop sequence ch_no_seq

insert into charge values(ch_no_seq.nextval, '용산행복장애인자립생활센터', '용산구', '서울특별시 중랑구 중랑역로 9', '중랑역 (엘리베이터 옆)', to_date('05:00', 'hh24:mi'), to_date('00:00', 'hh24:mi'), to_date('05:00', 'hh24:mi'), to_date('00:00', 'hh24:mi'), '종암경찰서', '182')

select * from charge order by ch_no



select * from dba_tablespaces;
-----------------즐겨찾기--------------------
create table bookmark(
	bk_no number(5) primary key,
	u_id varchar2(30 char) not null,
	sub_no number(5),
	f_no number(5),
	ch_no number(5),
	
	constraint fk_u_id foreign key(u_id) references tp_member(u_id),
	constraint fk_sub_no foreign key(sub_no) references subway(sub_no),
	constraint fk_f_no foreign key(f_no) references facilities(f_no),
	constraint fk_ch_no foreign key(ch_no) references charge(ch_no)
)
create sequence bk_no_seq
insert into bookmark values()
drop table bookmark cascade constraint purge
drop sequence bk_no_seq

select * from bookmark
delete from bookmark where ch_no = 620 and u_id = 'nah0912'

select sub_line_name,sub_station from subway where sub_no in (select distinct sub_no from bookmark where u_id =#{u_id})

insert into bookmark (bk_no_seq.nextval,'nah0912',885,NULL,NULL) 
	select 'nah0912',885 from bookmark where not exists(select * from bookmark where u_id='nah0912' and sub_no=885);

insert into bookmark from (bk_no_seq.nextval,'nah0912',885,NULL,NULL) select * from bookmark where not exists (select * from bookmark where u_id='nah0912' and sub_no=885);
delete from bookmark 
