use schools;
create table school(
	schoolId int identity,
	name varchar(45) not null,
	number int not null,
	director varchar(45),
	budget decimal not null,
	aditionalCost decimal not null,
	PRIMARY KEY(schoolID)
);

create table subject(
	subjectId int identity,
	name varchar(45),
	PRIMARY KEY(subjectId)
)

create table teacher(
	teacherId int identity,
	name varchar(45) not null,
	age int not null,
	address varchar(100),
	birthdate Date not null,
	salary decimal not null,
	subjectId int not null,
	FOREIGN KEY (subjectId) REFERENCES subject(subjectId),
	PRIMARY KEY(teacherId),

)

create table class(
	classId int identity,
	name varchar(45) not null,
	number int not null,
	headTeacherId int not null unique,
	FOREIGN KEY (headTeacherId) REFERENCES teacher(teacherID),
	PRIMARY KEY(classId),
);


create table teacherClasses(
	classId int not null,
	teacherId int not null,
	FOREIGN KEY (classId) REFERENCES class(classId),
	FOREIGN KEY (teacherId) REFERENCES teacher(teacherId)
);


create table student (
	studentId int identity,
	classId int not null,
	regNumber int ,
	name varchar(45) not null,
	age int not null,
	address varchar(100),
	birthdate Date not null,
	gpa decimal ,
	FOREIGN KEY (classId) REFERENCES class(classId),
	PRIMARY KEY(studentId),
);
use schools;
select * from school;