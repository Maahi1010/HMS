
create table patient_details
(
patient_SSNid int,
patient_id int NOT NULL AUTO INCREMENT, 
patient_name varchar(50),
patient_age int,
patient_doa int,
patient_typeofbed varchar(255),
patient_address varchar(255),
patient_state varchar(255),
patient_city varchar(255),
 patient_status varchar(255),
 PRIMARY KEY (patient_id)
);

insert into patient_details (patient_SSNid,patient_id,patient_name,patient_age,patient_doa,patient_typeofbed,patient_address,patient_state,patient_city)
values(?,?,?,?,?,?,?,?,?);


select * from patient_details where patient_id=?;

delete * from patient_details where patient_id=?;

update patient_details set patient_name=?,patient_age=?,patient_doa=?,patient_typeofbed=?,patient_address=?,patient_state=?,patient_city=? where patient_id=?;


