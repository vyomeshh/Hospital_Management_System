
CREATE DATABASE HospitalManagementSystem;


USE HospitalManagementSystem;


CREATE TABLE Patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    contact_number VARCHAR(15),
    email VARCHAR(100),
    address TEXT,
    emergency_contact VARCHAR(15),
    blood_type VARCHAR(5),
    date_admitted DATE,
    status ENUM('Active', 'Discharged', 'Deceased') DEFAULT 'Active'
);


CREATE TABLE Doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    specialty VARCHAR(100),
    contact_number VARCHAR(15),
    email VARCHAR(100),
    hire_date DATE,
    status ENUM('Active', 'Inactive') DEFAULT 'Active'
);


CREATE TABLE Appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATETIME,
    appointment_status ENUM('Scheduled', 'Completed', 'Cancelled') DEFAULT 'Scheduled',
    notes TEXT,
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id)
);


CREATE TABLE Treatments (
    treatment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    treatment_date DATE,
    treatment_details TEXT,
    prescribed_medication TEXT,
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id)
);


CREATE TABLE Staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    role VARCHAR(50),
    contact_number VARCHAR(15),
    email VARCHAR(100),
    hire_date DATE,
    status ENUM('Active', 'Inactive') DEFAULT 'Active'
);


CREATE TABLE Rooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_number VARCHAR(10),
    room_type ENUM('General', 'ICU', 'Emergency', 'Private'),
    bed_count INT,
    available_beds INT
);


CREATE TABLE Admissions (
    admission_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    room_id INT,
    admission_date DATE,
    discharge_date DATE,
    status ENUM('Admitted', 'Discharged') DEFAULT 'Admitted',
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);


CREATE TABLE Bills (
    bill_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    total_amount DECIMAL(10, 2),
    amount_paid DECIMAL(10, 2),
    outstanding_amount DECIMAL(10, 2),
    bill_date DATE,
    payment_status ENUM('Paid', 'Unpaid', 'Partial') DEFAULT 'Unpaid',
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id)
);


