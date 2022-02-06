


create database PolyOE
go
use PolyOE
go
create table Users
(
	Username varchar(50) primary key not null,
	Password varchar(50) not null,
	Email varchar(50) not null,
	Fullname nvarchar(50) not null,
	Admin bit not null ,  --số 1 admin số 0 user thường	
)
go
create table Videos
(
	VideoId varchar(50) primary key ,
	Title nvarchar(50) not null,	
	Poster varchar(255) null,
	[Views] int not null default 0,	
	[Description] nvarchar(50),
	Active bit not null default 1
)
go
create table Favorites
(
	FavoriteId int identity(1,1)  primary key,
	Username varchar(50) references Users(Username),
	VideoId varchar(50) references Videos(VideoId),
	LikeDate date
)
go
create table Shares
(
	ShareId int identity(1,1)  primary key,
	UserID varchar(50) references Users(Username),
	VideoId varchar(50) references Videos(VideoId),
	Emails varchar(50),
	ShareDate date
)

go
insert into Users values
('tnhh630','123456','tnhh630@gmail.com',N'Hồ Trung Tính',1),
('nghia123','123456','nghia123@gmail.com',N'Trần Trung Nghĩa',0),
('nam456','123456','nam456@gmail.com',N'Doãn Hoài Nam ',0),
('hai789','123456','hai789@gmail.com',N'Trần Nguyên Hải  ',1),
('vuong012','123456','vuong012@gmail.com',N'Lê Quý Vương',0)
go
insert into Videos values
('VD1',N'Chung kết thế giới 2017','',1000000,''s,1),
('VD2',N'Chung kết thế giới 2018','',2000000,'',1),
('VD3',N'Chung kết thế giới 2019','',3000000,'',0),
('VD4',N'Chung kết thế giới 2020','',4000000,'',0),
('VD5',N'Chung kết thế giới 2021','',5000000,'',1)
insert into Favorites values
('tnhh630','VD5','20210929'),
('nghia123','VD4','20210929'),
('nam456','VD2','20210929'),
('hai789','VD1','20210929'),
('vuong012','VD3','20210929')
insert into Shares values
('tnhh630','VD5','tnhh630@gmail.com','20210929'),
('nghia123','VD4','nghia123@gmail.com','20210929'),
('nam456','VD2','nam456@gmail.com','20210929'),
('hai789','VD1','hai789@gmail.com','20210929'),
('vuong012','VD3','vuong012@gmail.com','20210929')


select*from Users
select * from Videos