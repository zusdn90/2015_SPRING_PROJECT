select * from Travelmember;

drop table Travelmember;

create table Travelmember(
   memberPicture    varchar(100) default 'nothing.jpg , nothing.png, nothing.gif',
   num				integer(100) auto_increment not null,
   id               varchar(255) not null unique,
   password         varchar(255),
   name             varchar(255),
   register_date	date,
   birthday			date,
   tel              varchar(255),
   address          varchar(255),
   addressNum       integer(100),
   constraint pk_tr primary key(num)
);

delete from RecommandList;


update Travelmember set num ='1' where num='3'
select * from Travelmember;
drop table RecommandList;

create table RecommandList (
  listNo int(11) auto_increment,
  title char(35) NOT NULL,
  area char(20),
  name char(20),
  content longtext NOT NULL,
  picture char(100) default 'nothing.jpg , nothing.png, nothing.gif',
  PRIMARY KEY (listNo)
);

alter table RecommandList MODIFY name char(20);
alter table RecommandList MODIFY listNo int(11) auto_increment

insert into RecommandList(title,content,picture) values('우와된당','너는누구냐나야야누이할','1')

select * from RecommandList
select count(*) from RecommandList;

create table TravelShareBoard(
	boardNum int auto_increment,
	memberPicture    varchar(255),
	birthday			date,
    tel              varchar(100),
	id		  varchar(100),
	writer    varchar(100),
	title	  varchar(100),
	term	  varchar(100),		
	number	  int(100), 		
	transCost	  int(255),
	stayCost	  int(255),
	eatCost		  int(255),
	totalCost	  int(255),
	content   longtext,
	picture	  varchar(255) default 'nothing.jpg , nothing.png, nothing.gif',
	map		  varchar(255),
	constraint boardNum primary key(boardNum)
);


delete from TravelShareBoard
drop table TravelShareBoard;
select * from TravelShareBoard


create table Comment(
	listNo    int,
	cono 	  int auto_increment,
	id 		  varchar(255),
	content   varchar(255),
	PRIMARY KEY (cono)
);

create table ShareComment(
	listNo    int,
	cono 	  int auto_increment,
	id 		  varchar(255),
	content   varchar(255),
	PRIMARY KEY (cono)
);

select * from ShareComment

drop table Comment
insert into Comment(listNo,id,content) values('24','zz','하하')
update Comment set listNo = '28' where listNo='25'
select * from Comment 



drop table Travelmember
delete from Travelmember

select * from Travelmember
select count(*) from RecommandList

create table RealTimeBoard(
	number int auto_increment,
	id		varchar(255),
	content longtext,
	real_date	date,
	constraint number primary key(number)
);

insert into RealTimeBoard(number,id,content,Real_date) 
values('2','dfg','같이 여행갑시다','2016/01/06');

select * from RealTimeBoard
drop table RealTimeBoard
delete from RealTimeBoard
