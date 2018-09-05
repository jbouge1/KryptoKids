create table Actors(
first_name varchar(50) not null,
last_name  varchar(50) not null, 
gender varchar(10) not null,
	zodiac_sign varchar(50)
	movie varchar(100) not null,
primary key(first_name, last_name), 
foreign key(movie) references Movies	
)

create table Movies(
	movie_id int(2),
	title varchar(100) not null,
	director varchar(50) not null,
	distributor varchar(100) not null,
	genre varchar(50),
	rating double(2.0),
	primary key(movie_id)
	foreign key (distributor) references Distributor
	foreign key (rating) references Ratings

create table Directors(
	director_id int(2),
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	years_active int(4)
	primary key(director_id)
	)

create table Distributor(
	distributor_id int(2),
	name varchar(100) not null,
	primary key(distributor_id)
	)

create table Genre( 
	genre_id int(2),
name varchar(50),
primary key(genre_id)
)

create table Ratings(
title varchar(100),
rating double(2.0),
primary key(rating),
foreign key (title) references Movies
)

Oscar Winning Movies(
	name varchar(100),
	year int(4),
	genre varchar(50),
	director varchar(50),
	primary key(name),
	foreign key(genre) references Genre,
	foreign key(director) references Director
	)

Oscar Nominated Movies(
	name varchar(100),
	year int(4),
	genre varchar(50),
	director varchar(50),
	primary key(name),
	foreign key(genre) references Genre,
	foreign key(director) references Director
	)

