# User schema
 
# --- !Ups
 
set ignorecase true;

create table user (
	id                bigint not null,
	email             varchar(100) not null unique,
	password          varchar(100) not null,
	fullname          varchar(255),
	constraint pk_user primary key (id)
);
 
create sequence user_seq start with 1000;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_seq;


