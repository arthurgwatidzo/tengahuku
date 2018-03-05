USE TENGAHUKU;

create TABLE IF NOT EXISTS USER(

	ID bigint INCREMENT PRIMARY KEY,,
	EMAIL_USERNAME varchar(140) not null,
	PASSWORD varchar(60) not null,
	CUSTOMER_ID int(10) not null,
	foreign key (CUSTOMER_ID) references CUSTOMER(ID)
);