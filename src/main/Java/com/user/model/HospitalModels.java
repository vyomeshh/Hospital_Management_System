package com.user.model;

import java.math.BigDecimal;

public class HospitalModels {

    public static class Patient {
        private int patientId;
        private String firstName;
        private String lastName;
        private String dateOfBirth;
        private String gender;
        private String contactNumber;
        private String email;
        private String address;
        private String emergencyContact;
        private String bloodType;
        private String dateAdmitted;
        private String status;

        public Patient() {}

        public Patient(String firstName, String lastName, String dateOfBirth, String gender, String contactNumber,
                       String email, String address, String emergencyContact, String bloodType, String dateAdmitted, String status) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
            this.contactNumber = contactNumber;
            this.email = email;
            this.address = address;
            this.emergencyContact = emergencyContact;
            this.bloodType = bloodType;
            this.dateAdmitted = dateAdmitted;
            this.status = status;
        }

        public Patient(int patientId, String firstName, String lastName, String dateOfBirth, String gender,
                       String contactNumber, String email, String address, String emergencyContact, String bloodType,
                       String dateAdmitted, String status) {
            this.patientId = patientId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
            this.contactNumber = contactNumber;
            this.email = email;
            this.address = address;
            this.emergencyContact = emergencyContact;
            this.bloodType = bloodType;
            this.dateAdmitted = dateAdmitted;
            this.status = status;
        }

    }

    public static class Doctor {
        private int doctorId;
        private String firstName;
        private String lastName;
        private String specialty;
        private String contactNumber;
        private String email;
        private String hireDate;
        private String status;

        public Doctor() {}

        public Doctor(String firstName, String lastName, String specialty, String contactNumber, String email,
                      String hireDate, String status) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.specialty = specialty;
            this.contactNumber = contactNumber;
            this.email = email;
            this.hireDate = hireDate;
            this.status = status;
        }

        public Doctor(int doctorId, String firstName, String lastName, String specialty, String contactNumber, String email,
                      String hireDate, String status) {
            this.doctorId = doctorId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.specialty = specialty;
            this.contactNumber = contactNumber;
            this.email = email;
            this.hireDate = hireDate;
            this.status = status;
        }

    }

    public static class Appointment {
        private int appointmentId;
        private int patientId;
        private int doctorId;
        private String appointmentDate;
        private String appointmentStatus;
        private String notes;

        public Appointment() {}

        public Appointment(int patientId, int doctorId, String appointmentDate, String appointmentStatus, String notes) {
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.appointmentDate = appointmentDate;
            this.appointmentStatus = appointmentStatus;
            this.notes = notes;
        }

        public Appointment(int appointmentId, int patientId, int doctorId, String appointmentDate,
                           String appointmentStatus, String notes) {
            this.appointmentId = appointmentId;
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.appointmentDate = appointmentDate;
            this.appointmentStatus = appointmentStatus;
            this.notes = notes;
        }

    }

    public static class Treatment {
        private int treatmentId;
        private int patientId;
        private int doctorId;
        private String treatmentDate;
        private String treatmentDetails;
        private String prescribedMedication;

        public Treatment() {}

        public Treatment(int patientId, int doctorId, String treatmentDate, String treatmentDetails, String prescribedMedication) {
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.treatmentDate = treatmentDate;
            this.treatmentDetails = treatmentDetails;
            this.prescribedMedication = prescribedMedication;
        }

        public Treatment(int treatmentId, int patientId, int doctorId, String treatmentDate, String treatmentDetails,
                         String prescribedMedication) {
            this.treatmentId = treatmentId;
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.treatmentDate = treatmentDate;
            this.treatmentDetails = treatmentDetails;
            this.prescribedMedication = prescribedMedication;
        }

    }

    public static class Staff {
        private int staffId;
        private String firstName;
        private String lastName;
        private String role;
        private String contactNumber;
        private String email;
        private String hireDate;
        private String status;

        public Staff() {}

        public Staff(String firstName, String lastName, String role, String contactNumber, String email,
                     String hireDate, String status) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.role = role;
            this.contactNumber = contactNumber;
            this.email = email;
            this.hireDate = hireDate;
            this.status = status;
        }

        public Staff(int staffId, String firstName, String lastName, String role, String contactNumber, String email,
                     String hireDate, String status) {
            this.staffId = staffId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.role = role;
            this.contactNumber = contactNumber;
            this.email = email;
            this.hireDate = hireDate;
            this.status = status;
        }

    }

    public static class Room {
        private int roomId;
        private String roomNumber;
        private String roomType;
        private int bedCount;
        private int availableBeds;

        public Room() {}

        public Room(String roomNumber, String roomType, int bedCount, int availableBeds) {
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.bedCount = bedCount;
            this.availableBeds = availableBeds;
        }

        public Room(int roomId, String roomNumber, String roomType, int bedCount, int availableBeds) {
            this.roomId = roomId;
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.bedCount = bedCount;
            this.availableBeds = availableBeds;
        }

    }

    public static class Admission {
        private int admissionId;
        private int patientId;
        private int roomId;
        private String admissionDate;
        private String dischargeDate;
        private String status;

        public Admission() {}

        public Admission(int patientId, int roomId, String admissionDate, String dischargeDate, String status) {
            this.patientId = patientId;
            this.roomId = roomId;
            this.admissionDate = admissionDate;
            this.dischargeDate = dischargeDate;
            this.status = status;
        }

        public Admission(int admissionId, int patientId, int roomId, String admissionDate, String dischargeDate,
                         String status) {
            this.admissionId = admissionId;
            this.patientId = patientId;
            this.roomId = roomId;
            this.admissionDate = admissionDate;
            this.dischargeDate = dischargeDate;
            this.status = status;
        }

    }

    public static class Bill {
        private int billId;
        private int patientId;
        private BigDecimal totalAmount;
        private BigDecimal amountPaid;
        private BigDecimal outstandingAmount;
        private String billDate;
        private String paymentStatus;

        public Bill() {}

        public Bill(int patientId, BigDecimal totalAmount, BigDecimal amountPaid, BigDecimal outstandingAmount,
                    String billDate, String paymentStatus) {
            this.patientId = patientId;
            this.totalAmount = totalAmount;
            this.amountPaid = amountPaid;
            this.outstandingAmount = outstandingAmount;
            this.billDate = billDate;
            this.paymentStatus = paymentStatus;
        }

        public Bill(int billId, int patientId, BigDecimal totalAmount, BigDecimal amountPaid, BigDecimal outstandingAmount,
                    String billDate, String paymentStatus) {
            this.billId = billId;
            this.patientId = patientId;
            this.totalAmount = totalAmount;
            this.amountPaid = amountPaid;
            this.outstandingAmount = outstandingAmount;
            this.billDate = billDate;
            this.paymentStatus = paymentStatus;
        }

    }
}
