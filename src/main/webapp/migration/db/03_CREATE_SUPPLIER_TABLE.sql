USE TENGAHUKU;

create TABLE IF NOT EXISTS SUPPLIER(

	ID int(10) INCREMENT PRIMARY KEY,
	NAME varchar(140) not null,
	PHYSICAL_ADDRESS varchar(260) not null,
	CITY varchar(100) not null,
	CONTACT_PERSON varchar(100) not null,
	ALTERNATIVE_CONTACT_PERSON varchar(100) not null,
	TELEPHONE_NUMBER_ONE varchar(16) not null,
	TELEPHONE_NUMBER_TWO varchar(100) not null,
	EMAIL_ADDRESS varchar(100) not null
);