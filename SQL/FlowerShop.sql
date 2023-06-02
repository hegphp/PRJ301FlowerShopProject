create database FlowerShop
use FlowerShop

create table Employee (
	empId nvarchar(20) primary key,
	password nvarchar(20),
	phoneNumber nvarchar(20),
	address nvarchar(50),
	firstName nvarchar(20),
	lastName nvarchar(20),
	email nvarchar(20),
	role nvarchar(20) not null
);

create table Customer (
	customerId nvarchar(20) primary key,
	password nvarchar(20),
	phoneNumber nvarchar(20),
	address nvarchar(50),
	firstName nvarchar(20),
	lastName nvarchar(20),
	email nvarchar(50),
);

create table Flower(
	flowerId nvarchar(20) primary key,
	flowerName nvarchar(20), 
	description nvarchar(50),
	price float,
	imageUrl nvarchar(100),
	quantity int
)

create table Bouquet (
	bouquetId nvarchar(20) primary key,
	flowerId nvarchar(20) references Flower(flowerId), 
	bouquetName nvarchar(20),
	description nvarchar(50),
	price float,
	discount float,
	imageUrl nvarchar(100),
	quantity int
)

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

select * from Employee

insert into Employee values(
	'admin','admin','0123456789','Ha Noi','Van A','Nguyen','nguyenvana@fpt.edu.vn','admin'
)