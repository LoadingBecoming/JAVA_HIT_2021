CREATE DATABASE QuanLyRapPhim
go

use QuanLyRapPhim
go


create table QuanLy(
	IdQL int identity(1,1) primary key,
	TenQL Nchar(30),
	GioiTinh Nchar(30),
	DiaChi Nchar(50),
	Email char(30),
	Phone char(30),
	Username char(30),
	Pass char(30)
)
	
create table KhachHang(
	 IdK int identity(1,1) primary key,
	 TenK Nchar(30),
	 GioiTinhK Nchar(30),
	 DiaChiK Nchar(50),
	 EmailK char(30),
	 PhoneK char(30),
	 UsernameK char(30),
	 PassK char(30),
	 ViTien int 
)

create table LichSu(
	IdK int,
	DaoDich Nchar(100),
	ThoiGian Nchar(100)
)

create table Phim(
	IdFilm int primary key,
	TenFilm Nchar(30),
	ThoiLuong char(30),
	TheLoai Nchar(30),
	ThoiGian Nchar(30)
)

create table Ve(
	NguoiLon int,
	TreEm int,
)

create table DatVe(
	IdP int,
	IdK int,
	LoaiVe Nchar(100),
	SoGheDV Nchar(100),
)

create table DoanhThu(
	VeNL int,
	TienNL int,
	VeTE int,
	TienTE int
)

create table CheckGT(
	IdK int,
	Tien int
)

create table GiaiThuong(
	GT1 int,
	GT2 int,
	GT3 int,
	GT4 int,
	GT5 int,
)

create table DK(
	Dk int
)


insert into Phim values (0, N'Gửi em người bất tử', 90, N'Anime', N'17/1/2022') 
insert into Phim values (1, N'Advanger', 120, N'Hành động', N'18/1/2022') 
insert into Phim values (2, N'Spiderman', 150, N'Hành động', N'19/1/2022')



insert into QuanLy values ( N'Nguyễn Hoàng Nguyên', N'Nam', N'Bắc Giang', 'nguyen.h.nguyen2002@gmail.com', '123456789', 'nguyen', 'nguyen')
insert into QuanLy values ( N'Dương Văn A', N'Nam', N'Hà Nội', 'dva@gmail.com', '123456789', 'dva123', 'dva123@')
insert into QuanLy values ( N'Phạm Thị B', N'Nữ', N'TPHCM', 'ptb@gmail.com', '123456789', 'ptb123', 'ptb123@')



