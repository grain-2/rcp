use  patientims ;
#
#插入病人表的数据
#
delete from patient;
insert into patient values(1,'秦明','男',35,'87654321','上海虹口','2008-1-25',1);
insert into patient values(2,'李逵','男',39,'43218765','山西运城','2008-4-25',14);
insert into patient values(3,'蔡桓公','男',41,'12345678','河北保定','2008-3-13',2);
insert into patient values(4,'曹操','男',26,'987654123','安徽黄山','2008-2-13',7);
insert into patient values(5,'王五','男',43,'230004321','台湾台北','2008-7-25',22);
#
#插入医生表的数据
#
delete from doctor;
insert into doctor values(1,'shuihu','123456','扁鹊','男',35,'12345678912','主任','2008-1-25',1 );
insert into doctor values(2,'huatuo','654321','华佗','男',39,'98765432101','专家','2008-4-25',2);
insert into doctor values(3,'admin','123456','安道全','男',41,'12345678901','副主任','2008-5-13',3 );
insert into doctor values(4,'zhaoran','123456','喜来乐','男',46,'56789987','副主任','2008-6-13',4 ); 
#
#插入科室表的数据
#
delete from department;
insert into department values(1,'普外科');
insert into department values(2,'脑系科');
insert into department values(3,'消化内科');
insert into department values(4,'耳鼻喉科');
insert into department values(5,'骨科');
insert into department values(6,'神经内科');

#
#插入病房表的数据
#
delete from  sickroom;
insert into sickroom values(1,201,1 );
insert into sickroom values(2,202,1 ) ;
insert into sickroom values(3,301,2 );
insert into sickroom values(4,302,2);
insert into sickroom values(5,401,3 );
insert into sickroom values(6,402,3 );
insert into sickroom values(7,501,4 );
insert into sickroom values(8,502,4 );
insert into sickroom values(9,601,5 );
insert into sickroom values(10,602,5);
insert into sickroom values(11,701,6 );
insert into sickroom values(12,702,6 );
insert into sickroom values(13,801,7 );
insert into sickroom values(14,802,7 ) ;
 
#
#插入病床表数据
#

delete from  sickbed;
insert into sickbed values(1,1,1);
insert into sickbed values(2,2,1);
insert into sickbed values(3,3,1 );
insert into sickbed values(4,1,2 );
insert into sickbed values(5,2,2);
insert into sickbed values(6,3,2);
insert into sickbed values(7,1,3 );
insert into sickbed values(8,2,3 );
insert into sickbed values(9,3,3);
insert into sickbed values(10,1,4);
insert into sickbed values(11,2,4 );
insert into sickbed values(12,3,4 );
insert into sickbed values(13,1,5);
insert into sickbed values(14,2,5);
insert into sickbed values(15,3,5 );
insert into sickbed values(16,1,6 );
insert into sickbed values(17,2,6);
insert into sickbed values(18,3,6 );
insert into sickbed values(19,1,7 );
insert into sickbed values(20,2,7);
insert into sickbed values(21,3,7);
insert into sickbed values(22,1,8 );
insert into sickbed values(23,2,8 );
insert into sickbed values(24,3,8 );
insert into sickbed values(25,1,9 );
insert into sickbed values(26,2,9 );
insert into sickbed values(27,3,9 );
insert into sickbed values(28,1,10 );
insert into sickbed values(29,2,10);
insert into sickbed values(30,3,10 );
insert into sickbed values(31,1,11 );
insert into sickbed values(32,2,11 );
insert into sickbed values(33,3,11 );
insert into sickbed values(34,1,12 );
insert into sickbed values(35,2,12 );
insert into sickbed values(36,3,12 );
insert into sickbed values(37,1,13 );
insert into sickbed values(38,2,13 );
insert into sickbed values(39,3,13 );
insert into sickbed values(40,1,14 );
insert into sickbed values(41,2,14 );
insert into sickbed values(42,3,14 );
#
#插入诊断表数据
#
delete from  diagnose;
insert into diagnose values(1,'外伤','受刀砍造成右臂肌肉撕裂，进行缝合配以药物治疗。','2008-1-25',1,1 );
insert into diagnose values(2,'急性肠炎','由于食用未成熟食品，造成食物中毒，吃药缓解。','2008-4-25',2,3 );
insert into diagnose values(3,'植物神经紊乱','植物性神经紊乱，注意休息，配合理疗。','2008-3-13',3,1);
insert into diagnose values(4,'大脑积水','实施开颅手术。','2008-5-24',4,2);
insert into diagnose values(5,'中耳炎','吃药治疗','2008-7-25',5,4);

#
#插入药费表数据
#
delete from  expense;
insert into expense values(1,'药费','先锋9号', 50,8,400,'2008-1-25',1,1);
insert into expense values(2,'手术费','缝合手术',1000,1,1000,'2008-1-25',1,1);
insert into expense values(3,'药费','胃肠安',14,2,28,'2008-4-25',2,2);
insert into expense values(4,'药费','谷维素',10,3,30, '2008-3-13',3,1);
insert into expense values(5,'药费','甘露醇呋塞米',1000,2,2000, '2008-5-26',4,2);
insert into expense values(6,'手术费','开颅手术',60000,1,60000, '2008-5-26',4,2);
insert into expense values(7,'药费','阿齐酶素',100,3,300,'2008-7-25',5,4);



 

