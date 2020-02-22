#
#濡傛灉瀛樺湪patient_ims_db鏁版嵁搴擄紝鍒欏厛鍒犻櫎�?
#

drop database if exists patientims;
#
# 鍒涘缓Patient_ims_db鏁版嵁搴?
#
create database patientims;
#
#鎵撳紑鏁版嵁�?
#
use patientims;
#
###鍒涘缓鐥呬汉�?
#
drop table if exists patient;
create table patient(
id bigint(20)unsigned not null auto_increment,
name varchar(20),
sex  varchar(10),
age  int(10),
phone varchar(20),
address varchar(100),
logtime datetime,
sickbed_id bigint(20),
primary key(id)
)
default charset=gbk;
#
#鍒涘缓鍖荤敓�?
#
drop table if exists doctor;
create table doctor(
id bigint(20)unsigned not null auto_increment,
username varchar(15),
password  varchar(20),
name varchar(20),
sex varchar(10),
age int(10),
phone varchar(20),
professianl_title varchar(20),
logtime datetime,
department_id bigint(20),
primary key(id)
)default charset=gbk;
#
#鍒涘缓鐥呭簥�?
#
drop table if exists sickbed;
create table sickbed(
id bigint(20)unsigned not null auto_increment,
sickbedid bigint(20),
sickroom_id bigint(20),
primary key(id)
)default charset=gbk;
#
#鍒涘缓鐥呮埧�?
#
drop table if exists sickroom;
create table sickroom(
id bigint(20) unsigned not null auto_increment,
sickroomid bigint(20),
department_id  bigint(20),
primary key(id)
)default charset=gbk;

#
#�������ұ�
#
drop table if exists department;
create table department(
id bigint(20) unsigned not null auto_increment,
departname varchar(20),
primary key(id)
)default charset=gbk;


#
#鍒涘缓璇婃柇�?
#
drop table if exists diagnose;
create table diagnose(
id bigint(20) unsigned not null auto_increment,
illness varchar(60), 
therapeutic  varchar(600),
dignosedate datetime,
patient_id bigint(20),
doctor_id bigint(20),
primary key(id)
)default charset=gbk;
#
#鍒涘缓鑽垂�?
#
drop table if exists expense;
create table expense(
id bigint(20) unsigned not null auto_increment,
expenseillustrate varchar(20),
expensename varchar(20 ),
unitprice  float(20,2 ),
number  int(20),
occurexpense  float(20,2),
occurtime datetime,
patient_id bigint(20),
doctor_id bigint(20),
primary key(id)
)default charset=gbk;
 























