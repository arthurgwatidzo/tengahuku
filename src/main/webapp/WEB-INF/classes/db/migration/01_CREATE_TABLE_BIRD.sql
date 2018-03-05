use tengahuku;

--BIRD_TYPE | 1 for layer, 0 for broiler
create table if not exists tengahuku.bird{
	ID bigint not null auto_increment,
	BIRD_TYPE boolean not null default 0,
	RFID_TAG_NUMBER bigint not null,
	PURCHASE_DATE varchar(40) not null,
	BREED_NAME varchar(80) not null,
	SUPPLIER_NAME varchar(120) not null
	PRIMARY KEY(ID)

);