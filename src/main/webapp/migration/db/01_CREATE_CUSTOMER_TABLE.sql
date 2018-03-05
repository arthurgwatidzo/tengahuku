USE TENGAHUKU;

create TABLE IF NOT EXISTS CUSTOMER(

	ID bigint AUTO INCREMENT PRIMARY KEY,
	COMPANY_NAME varchar(200) not null,
	CONTACT_NAME varchar(140) not null,
	CONTACT_TITLE varchar(5) not null,
	DELIVERY_ADDRESS varchar(5) not null,
	CITY varchar(5) not null,
	TELEPHONE_NUMBER varchar(5) not null,
	EMAIL_ADDRESS varchar(5) not null,
	ENABLED varchar(5) not null
);