USE [banco_wild_fly]
GO
ALTER TABLE [dbo].[comment] DROP CONSTRAINT [CK_Comentario_NaoAutoReferenciado]
GO
ALTER TABLE [dbo].[user_permission] DROP CONSTRAINT [FK_01]
GO
ALTER TABLE [dbo].[user_permission] DROP CONSTRAINT [FK_02]
GO
ALTER TABLE [dbo].[user] DROP CONSTRAINT [FK_03]
GO
ALTER TABLE [dbo].[user] DROP CONSTRAINT [FK_04]
GO
ALTER TABLE [dbo].[phone] DROP CONSTRAINT [FK_05]
GO
ALTER TABLE [dbo].[phone] DROP CONSTRAINT [FK_06]
GO
ALTER TABLE [dbo].[movie_like] DROP CONSTRAINT [FK_07]
GO
ALTER TABLE [dbo].[movie_like] DROP CONSTRAINT [FK_08]
GO
ALTER TABLE [dbo].[movie_like] DROP CONSTRAINT [FK_09]
GO
ALTER TABLE [dbo].[movie_like] DROP CONSTRAINT [FK_10]
GO
ALTER TABLE [dbo].[movie] DROP CONSTRAINT [FK_11]
GO
ALTER TABLE [dbo].[movie] DROP CONSTRAINT [FK_12]
GO
ALTER TABLE [dbo].[movie] DROP CONSTRAINT [FK_13]
GO
ALTER TABLE [dbo].[movie] DROP CONSTRAINT [FK_14]
GO
ALTER TABLE [dbo].[comment_like] DROP CONSTRAINT [FK_15]
GO
ALTER TABLE [dbo].[comment_like] DROP CONSTRAINT [FK_16]
GO
ALTER TABLE [dbo].[comment_like] DROP CONSTRAINT [FK_17]
GO
ALTER TABLE [dbo].[comment_like] DROP CONSTRAINT [FK_18]
GO
ALTER TABLE [dbo].[comment] DROP CONSTRAINT [FK_19]
GO
ALTER TABLE [dbo].[comment] DROP CONSTRAINT [FK_20]
GO
ALTER TABLE [dbo].[comment] DROP CONSTRAINT [FK_21]
GO
ALTER TABLE [dbo].[comment] DROP CONSTRAINT [FK_22]
GO
ALTER TABLE [dbo].[address] DROP CONSTRAINT [FK_23]
GO
ALTER TABLE [dbo].[address] DROP CONSTRAINT [FK_23]
GO
/****** Object:  Table [dbo].[user_permission]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[user_permission]') AND type in (N'U'))
DROP TABLE [dbo].[user_permission]
GO
/****** Object:  Table [dbo].[user]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[user]') AND type in (N'U'))
DROP TABLE [dbo].[user]
GO
/****** Object:  Table [dbo].[rent_history]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[rent_history]') AND type in (N'U'))
DROP TABLE [dbo].[rent_history]
GO
/****** Object:  Table [dbo].[phone]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[phone]') AND type in (N'U'))
DROP TABLE [dbo].[phone]
GO
/****** Object:  Table [dbo].[permission]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[permission]') AND type in (N'U'))
DROP TABLE [dbo].[permission]
GO
/****** Object:  Table [dbo].[movie_like]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[movie_like]') AND type in (N'U'))
DROP TABLE [dbo].[movie_like]
GO
/****** Object:  Table [dbo].[movie]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[movie]') AND type in (N'U'))
DROP TABLE [dbo].[movie]
GO
/****** Object:  Table [dbo].[comment_like]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[comment_like]') AND type in (N'U'))
DROP TABLE [dbo].[comment_like]
GO
/****** Object:  Table [dbo].[comment]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[comment]') AND type in (N'U'))
DROP TABLE [dbo].[comment]
GO
/****** Object:  Table [dbo].[client]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[client]') AND type in (N'U'))
DROP TABLE [dbo].[client]
GO
/****** Object:  Table [dbo].[address]    Script Date: 13/10/2025 14:33:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[address]') AND type in (N'U'))
DROP TABLE [dbo].[address]
GO
/****** Object:  Table [dbo].[address]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[address](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[country] [nvarchar](100) NULL,
	[state] [nvarchar](100) NULL,
	[city] [nvarchar](100) NULL,
	[street_address] [nvarchar](200) NULL,
	[number] [nvarchar](20) NULL,
	[comment] [nvarchar](255) NULL,
	[user_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[client]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[client](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[comment]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comment](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[client_id] [bigint] NOT NULL,
	[comment_text] [varchar](1000) NOT NULL,
	[movie_comment_id] [bigint] NULL,
	[comment_parent_id] [bigint] NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[comment_like]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comment_like](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[comment_id] [bigint] NOT NULL,
	[client_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[movie]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movie](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[description] [nvarchar](max) NULL,
	[is_rented] [bit] NULL,
	[rented_time] [datetime] NULL,
	[client_id] [bigint] NULL,
	[image_url] [varchar](255) NULL,
	[movie_like_id] [bigint] NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[movie_like]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movie_like](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[movie_id] [bigint] NULL,
	[client_id] [bigint] NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [unique_like_for_client] UNIQUE NONCLUSTERED
(
	[movie_id] ASC,
	[client_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[permission]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[permission](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phone]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phone](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[phone_number] [nvarchar](20) NULL,
	[user_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[rent_history]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[rent_history](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[client_id] [bigint] NOT NULL,
	[movie_id] [bigint] NOT NULL,
	[rented_time] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[email] [nvarchar](100) NOT NULL,
	[document_number] [nvarchar](100) NULL,
	[username] [nvarchar](100) NULL,
	[password] [nvarchar](10) NULL,
	[user_type] [nvarchar](10) NULL,
	[client_id] [bigint] NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_permission]    Script Date: 13/10/2025 14:33:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_permission](
	[user_id] [bigint] NOT NULL,
	[permission_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[user_id] ASC,
	[permission_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[address]  WITH CHECK ADD CONSTRAINT [FK_1] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
GO
ALTER TABLE [dbo].[address]  WITH CHECK ADD CONSTRAINT [FK_2] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD CONSTRAINT [FK_3] FOREIGN KEY([comment_parent_id])
REFERENCES [dbo].[comment] ([id])
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD CONSTRAINT [FK_4] FOREIGN KEY([comment_parent_id])
REFERENCES [dbo].[comment] ([id])
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD CONSTRAINT [FK_5] FOREIGN KEY([movie_comment_id])
REFERENCES [dbo].[movie] ([id])
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK_6]  FOREIGN KEY([movie_comment_id])
REFERENCES [dbo].[movie] ([id])
GO
ALTER TABLE [dbo].[comment_like]  WITH CHECK ADD  CONSTRAINT [FK_7] FOREIGN KEY([client_id])
REFERENCES [dbo].[client] ([id])
GO
ALTER TABLE [dbo].[comment_like]  WITH CHECK ADD  CONSTRAINT [FK_8] FOREIGN KEY([client_id])
REFERENCES [dbo].[client] ([id])
GO
ALTER TABLE [dbo].[comment_like]  WITH CHECK ADD  CONSTRAINT [FK_9] FOREIGN KEY([comment_id])
REFERENCES [dbo].[comment] ([id])
GO
ALTER TABLE [dbo].[comment_like]  WITH CHECK ADD  CONSTRAINT [FK_10] FOREIGN KEY([comment_id])
REFERENCES [dbo].[comment] ([id])
GO
ALTER TABLE [dbo].[movie]  WITH CHECK ADD  CONSTRAINT [FK_11] FOREIGN KEY([client_id])
REFERENCES [dbo].[client] ([id])
GO
ALTER TABLE [dbo].[movie]  WITH CHECK ADD  CONSTRAINT [FK_12] FOREIGN KEY([client_id])
REFERENCES [dbo].[client] ([id])
GO
ALTER TABLE [dbo].[movie]  WITH CHECK ADD  CONSTRAINT [FK_13] FOREIGN KEY([movie_like_id])
REFERENCES [dbo].[movie_like] ([id])
GO
ALTER TABLE [dbo].[movie]  WITH CHECK ADD  CONSTRAINT [FK_14] FOREIGN KEY([movie_like_id])
REFERENCES [dbo].[movie_like] ([id])
GO
ALTER TABLE [dbo].[movie_like]  WITH CHECK ADD  CONSTRAINT [FK_15] FOREIGN KEY([client_id])
REFERENCES [dbo].[client] ([id])
GO
ALTER TABLE [dbo].[movie_like]  WITH CHECK ADD  CONSTRAINT [FK_15] FOREIGN KEY([movie_id])
REFERENCES [dbo].[movie] ([id])
GO
ALTER TABLE [dbo].[movie_like]  WITH CHECK ADD  CONSTRAINT [FK_16] FOREIGN KEY([client_id])
REFERENCES [dbo].[client] ([id])
GO
ALTER TABLE [dbo].[movie_like]  WITH CHECK ADD  CONSTRAINT [FK_17] FOREIGN KEY([movie_id])
REFERENCES [dbo].[movie] ([id])
GO
ALTER TABLE [dbo].[phone]  WITH CHECK ADD  CONSTRAINT [FK_18] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
GO
ALTER TABLE [dbo].[phone]  WITH CHECK ADD  CONSTRAINT [FK_19] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [FK_20] FOREIGN KEY([client_id])
REFERENCES [dbo].[client] ([id])
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [FK_21] FOREIGN KEY([client_id])
REFERENCES [dbo].[client] ([id])
GO
ALTER TABLE [dbo].[user_permission]  WITH CHECK ADD  CONSTRAINT [FK_22] FOREIGN KEY([permission_id])
REFERENCES [dbo].[permission] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[user_permission]  WITH CHECK ADD CONSTRAINT [Fk_23] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [CK_Comentario_NaoAutoReferenciado] CHECK  (([id]<>[comment_parent_id]))
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [CK_Comentario_NaoAutoReferenciado]
GO
