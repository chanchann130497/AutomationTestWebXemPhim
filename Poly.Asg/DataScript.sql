USE [master]
GO
/****** Object:  Database [PolyOE]    Script Date: 12/8/2021 10:35:29 AM ******/
CREATE DATABASE [PolyOE]
/*
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PolyOE', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PolyOE.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PolyOE_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PolyOE_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PolyOE] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PolyOE].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PolyOE] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PolyOE] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PolyOE] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PolyOE] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PolyOE] SET ARITHABORT OFF 
GO
ALTER DATABASE [PolyOE] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PolyOE] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PolyOE] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PolyOE] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PolyOE] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PolyOE] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PolyOE] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PolyOE] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PolyOE] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PolyOE] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PolyOE] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PolyOE] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PolyOE] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PolyOE] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PolyOE] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PolyOE] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PolyOE] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PolyOE] SET RECOVERY FULL 
GO
ALTER DATABASE [PolyOE] SET  MULTI_USER 
GO
ALTER DATABASE [PolyOE] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PolyOE] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PolyOE] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PolyOE] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PolyOE] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PolyOE] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'PolyOE', N'ON'
GO
ALTER DATABASE [PolyOE] SET QUERY_STORE = OFF
GO
USE [PolyOE]
GO
/****** Object:  Table [dbo].[Favorites]    Script Date: 12/8/2021 10:35:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
*/
/*
select * from users
go

delete users where fullname = N'Chí Phèo Nam Cao'
go

delete users where email = 'bexuanmai@gmail.com'
go

--------------------------------------------------

select * from videos
go

delete videos where Description = 'One Piece'
go

update Videos set Title = 'One Piece' where VideoId = 'V01'
go
select * from videos
go


*/
GO
CREATE TABLE [dbo].[Favorites](
	[FavoriteId] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](30) NULL,
	[VideoId] [varchar](50) NULL,
	[LikedDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[FavoriteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shares]    Script Date: 12/8/2021 10:35:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shares](
	[ShareId] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [varchar](30) NULL,
	[VideoId] [varchar](50) NULL,
	[Emails] [nvarchar](250) NULL,
	[SharedDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[ShareId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 12/8/2021 10:35:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Username] [varchar](30) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Admin] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Videos]    Script Date: 12/8/2021 10:35:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Videos](
	[VideoId] [varchar](50) NOT NULL,
	[Title] [nvarchar](100) NOT NULL,
	[Poster] [nvarchar](150) NOT NULL,
	[Views] [int] NOT NULL,
	[Description] [nvarchar](1500) NULL,
	[Active] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[VideoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Favorites] ON 

INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (1, N'admin', N'V02', CAST(N'2021-12-12' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (2, N'admin', N'V01', CAST(N'2021-10-10' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (3, N'user01', N'V02', CAST(N'2021-01-12' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (4, N'user02', N'V03', CAST(N'2020-05-10' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (5, N'chuot', N'V10', CAST(N'2020-01-01' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (6, N'chuot', N'V11', CAST(N'2020-02-01' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (7, N'nam1', N'V03', CAST(N'2021-10-20' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (8, N'nam1', N'V10', CAST(N'2021-10-20' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (9, N'nam1', N'V10', CAST(N'2021-10-20' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikedDate]) VALUES (10, N'nam1', N'V10', CAST(N'2021-10-20' AS Date))
SET IDENTITY_INSERT [dbo].[Favorites] OFF
GO
INSERT [dbo].[Users] ([Username], [Password], [Fullname], [Email], [Admin]) VALUES (N'admin', N'admin01', N'Doan Hoai Nam', N'nam@fpt.edu.vn', 1)
INSERT [dbo].[Users] ([Username], [Password], [Fullname], [Email], [Admin]) VALUES (N'chuot', N'123456', N'nghia', N'chuot@gmail.com', 0)
INSERT [dbo].[Users] ([Username], [Password], [Fullname], [Email], [Admin]) VALUES (N'chuot12', N'12', N'aaa', N'aa@gmail.com', 1)
INSERT [dbo].[Users] ([Username], [Password], [Fullname], [Email], [Admin]) VALUES (N'duyenvu', N'heloduyen', N'duyenvu', N'Dv03101998@gmail.com', 0)
INSERT [dbo].[Users] ([Username], [Password], [Fullname], [Email], [Admin]) VALUES (N'nam1', N'123', N'Doãn Hoài Nam', N'halala1102@gmail.com', 0)
INSERT [dbo].[Users] ([Username], [Password], [Fullname], [Email], [Admin]) VALUES (N'poly', N'1', N'poly update', N'poly@gmail.com', 0)
INSERT [dbo].[Users] ([Username], [Password], [Fullname], [Email], [Admin]) VALUES (N'poly1', N'12', N'poly1', N'poly@gmail.com', 0)
INSERT [dbo].[Users] ([Username], [Password], [Fullname], [Email], [Admin]) VALUES (N'user01', N'123', N'Chuot', N'chuot@gmail.com', 0)
INSERT [dbo].[Users] ([Username], [Password], [Fullname], [Email], [Admin]) VALUES (N'user02', N'123', N'Tran Trung Nghia', N'nghia@gmail.com', 0)
GO
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'V01', N'One Piece', N'uploads/V01.jpg', 333333335, N'Anime', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'V02', N'Dragon Ball', N'uploads/V02.jpg', 5000000, N'Anime', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'V03', N'Conan', N'uploads/V03.jpg', 999, N'Anime', 0)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'V10', N'Kimetsu No Yaiba', N'uploads/V10.jpg', 100000, N'Hello World', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'V11', N'Naruto', N'uploads/V11.jpg', 100000000, N'Hello World', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'V13', N'Pokemon', N'uploads/V13.jpg', 555555, N'Anime', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'V14', N'Sword-Art', N'uploads/V14.jpg', 666666, N'Anime', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'V15', N'Sailor-Moon', N'uploads/V15.jpg', 444444, N'Anime', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'V16', N'Death-Note', N'uploads/V16.jpg', 888888888, N'Anime', 1)
GO
ALTER TABLE [dbo].[Favorites]  WITH CHECK ADD  CONSTRAINT [FK_Favorites_Users] FOREIGN KEY([Username])
REFERENCES [dbo].[Users] ([Username])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Favorites] CHECK CONSTRAINT [FK_Favorites_Users]
GO
ALTER TABLE [dbo].[Favorites]  WITH CHECK ADD  CONSTRAINT [FK_Favorites_Videos] FOREIGN KEY([VideoId])
REFERENCES [dbo].[Videos] ([VideoId])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Favorites] CHECK CONSTRAINT [FK_Favorites_Videos]
GO
ALTER TABLE [dbo].[Shares]  WITH CHECK ADD  CONSTRAINT [FK_Shares_Users] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([Username])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Shares] CHECK CONSTRAINT [FK_Shares_Users]
GO
ALTER TABLE [dbo].[Shares]  WITH CHECK ADD  CONSTRAINT [FK_Shares_Videos] FOREIGN KEY([VideoId])
REFERENCES [dbo].[Videos] ([VideoId])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Shares] CHECK CONSTRAINT [FK_Shares_Videos]
GO
USE [master]
GO
ALTER DATABASE [PolyOE] SET  READ_WRITE 
GO
