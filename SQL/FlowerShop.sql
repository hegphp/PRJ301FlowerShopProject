create database FlowerShop
use FlowerShop
------------------------------------------------Create table------------------------------------------

create table Employee (
	empId nvarchar(20) primary key,
	password nvarchar(20),
	phoneNumber nvarchar(20),
	address nvarchar(50),
	firstName nvarchar(20),
	lastName nvarchar(20),
	gender bit,
	email nvarchar(50),
	role nvarchar(20) not null
);


create table Customer (
	customerId nvarchar(20) primary key,
	password nvarchar(20),
	phoneNumber nvarchar(20),
	address nvarchar(50),
	firstName nvarchar(20),
	lastName nvarchar(20),
	gender bit,
	email nvarchar(50),
);

create table BouquetType(
	typeid int primary key,
	typeName nvarchar(50)
)

CREATE TABLE Bouquet (
  bouquetId   NVARCHAR(20) PRIMARY KEY,
  bouquetName NVARCHAR(50),
  bouquetTypeId int references BouquetType(typeid),
  description ntext,
  price       FLOAT,
  discount    FLOAT,
  imageUrl    NVARCHAR(100),
  quantity    INT,
  isDisplayed	bit
);

alter table Bouquet
alter column imageUrl varchar(500)

create table [Order] (
	orderId nvarchar(20) primary key,
	customerId nvarchar(20) references Customer(customerId),
	employeeId nvarchar(20) references Employee(EmpId),
	orderDate Date,
	requiredDate date,
	shippedDate date,
	shipName nvarchar(20),
	shipAddress nvarchar(50)
)

create table [Order Details](
	orderId nvarchar(20) references [Order](orderId),
	bouquetId nvarchar(20) references Bouquet(bouquetId),
	unitPrice float,
	quantity int,
	discount float
)
--Tạo bảng giỏ hàng
----------------------------------------------------------------------------------------Adding data------------------------------------------------

insert into Employee values(
	'admin','admin','0123456789','Ha Noi','Van A','Nguyen',1 ,N'nguyenvana@gmail.com','admin'
)

insert into Customer values(
	'account1','password','0123456789',N'Hà Đông, Hà Nội',N'Hồng',N'Việt Bùi',1,'henrygphp@gmail.com'
)

insert into Customer values(
	'hegphp','123','0123456789',N'Hà Đông, Hà Nội',N'Hồng',N'Việt Bùi',1,'henrygphp@gmail.com'
)


insert into BouquetType values (
	1,N'Hoa cao cấp'),(
	2,N'Hoa kỉ niệm'),(
	3,N'Hoa khai trương'),(
	4,N'Hoa tang lễ'),(
	5,N'Hoa sinh nhật'),(
	6,N'Hoa tình yêu'),(
	7,N'Hoa cưới'),(
	8,N'Lẵng hoa'),(
	9,N'Hoa sự kiện'),(
	10,N'Hoa bó'
)
--Bouquet
INSERT INTO Bouquet (bouquetId, bouquetName, description,bouquetTypeId, price, discount, imageUrl, quantity, isDisplayed)
VALUES ('B001', 'Classic Rose Bouquet', 'A classic arrangement of red roses',1, 29.99, 0.1, 'rose_bouquet.jpg', 20, 1),
       ('B002', 'Spring Tulip Bouquet', 'A vibrant bouquet of yellow tulips',2, 24.99, 0.2, 'tulip_bouquet.jpg', 15, 1);

----------------------------------------------------------------------Display data-----------------------------
Select * from Customer
where customerId = 'henrygphp'
and password = 'asdasdas'
Select * from Employee

select * from Bouquet
where isDisplayed = 1

select * from BouquetType

Select *
from Bouquet
where bouquetTypeId = 1
and isDisplayed = 1

select * 
from Bouquet
where bouquetName like N'%a%'

where bouquetTypeId = 1


-----------------------------------------------------------------------Delete data
Delete from Customer
where customerId = 'hegphp';

delete from BouquetType
where typeid >= 11

delete from Bouquet
where bouquetId = 'B001'


--Update data
update Bouquet
set bouquetId = ?,
bouquetName = ?,
bouquetTypeId = ?,
description = ?,
discount = ?,
imageUrl = ?,
price = ?,
quantity = ?
where bouquetId = ?;

drop table [Order Details]

drop table Cart_Bouquet
drop table Cart

drop table Bouquet
drop table [Order]
drop table Employee
drop table BouquetType
drop table Customer

Select * from Customer
where email = 'henrygphp@gmail.com'

Delete Customer
where customerId = 'henrygphp'