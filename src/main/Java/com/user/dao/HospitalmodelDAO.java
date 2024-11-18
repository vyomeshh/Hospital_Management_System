package com.user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.hospital.model.Patient;
import com.hospital.model.Doctor;
import com.hospital.model.Appointment;

public class HospitalmodelDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/hospitaldb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    // Database Connection
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // ----- PatientDAO Methods -----

    private static final String INSERT_PATIENT_SQL = "INSERT INTO patients (name, age, gender, phone, email) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_PATIENT_BY_ID = "SELECT * FROM patients WHERE id = ?;";
    private static final String SELECT_ALL_PATIENTS = "SELECT * FROM patients;";
    private static final String DELETE_PATIENT_SQL = "DELETE FROM patients WHERE id = ?;";
    private static final String UPDATE_PATIENT_SQL = "UPDATE patients SET name = ?, age = ?, gender = ?, phone = ?, email = ? WHERE id = ?;";

    public void insertPatient(Patient patient) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT_SQL)) {
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setInt(2, patient.getAge());
            preparedStatement.setString(3, patient.getGender());
            preparedStatement.setString(4, patient.getPhone());
            preparedStatement.setString(5, patient.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient selectPatient(int id) {
        Patient patient = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                patient = new Patient(id, name, age, gender, phone, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    public List<Patient> selectAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                patients.add(new Patient(id, name, age, gender, phone, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public boolean deletePatient(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PATIENT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updatePatient(Patient patient) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PATIENT_SQL)) {
            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getPhone());
            statement.setString(5, patient.getEmail());
            statement.setInt(6, patient.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // ----- DoctorDAO Methods -----

    private static final String INSERT_DOCTOR_SQL = "INSERT INTO doctors (name, specialty, phone, email) VALUES (?, ?, ?, ?);";
    private static final String SELECT_DOCTOR_BY_ID = "SELECT * FROM doctors WHERE id = ?;";
    private static final String SELECT_ALL_DOCTORS = "SELECT * FROM doctors;";
    private static final String DELETE_DOCTOR_SQL = "DELETE FROM doctors WHERE id = ?;";
    private static final String UPDATE_DOCTOR_SQL = "UPDATE doctors SET name = ?, specialty = ?, phone = ?, email = ? WHERE id = ?;";

    public void insertDoctor(Doctor doctor) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOCTOR_SQL)) {
            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getSpecialty());
            preparedStatement.setString(3, doctor.getPhone());
            preparedStatement.setString(4, doctor.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Doctor selectDoctor(int id) {
        Doctor doctor = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCTOR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String specialty = rs.getString("specialty");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                doctor = new Doctor(id, name, specialty, phone, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public List<Doctor> selectAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOCTORS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String specialty = rs.getString("specialty");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                doctors.add(new Doctor(id, name, specialty, phone, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public boolean deleteDoctor(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_DOCTOR_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateDoctor(Doctor doctor) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DOCTOR_SQL)) {
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialty());
            statement.setString(3, doctor.getPhone());
            statement.setString(4, doctor.getEmail());
            statement.setInt(5, doctor.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // ----- AppointmentDAO Methods -----

    private static final String INSERT_APPOINTMENT_SQL = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, ?);";
    private static final String SELECT_APPOINTMENT_BY_ID = "SELECT * FROM appointments WHERE id = ?;";
    private static final String SELECT_ALL_APPOINTMENTS = "SELECT * FROM appointments;";
    private static final String DELETE_APPOINTMENT_SQL = "DELETE FROM appointments WHERE id = ?;";
    private static final String UPDATE_APPOINTMENT_SQL = "UPDATE appointments SET patient_id = ?, doctor_id = ?, appointment_date = ?, status = ? WHERE id = ?;";

    public void insertAppointment(Appointment appointment) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT_SQL)) {
            preparedStatement.setInt(1, appointment.getPatientId());
            preparedStatement.setInt(2, appointment.getDoctorId());
            preparedStatement.setString(3, appointment.getAppointmentDate());
            preparedStatement.setString(4, appointment.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Appointment selectAppointment(int id) {
        Appointment appointment = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPOINTMENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int patientId = rs.getInt("patient_id");
                int doctorId = rs.getInt("doctor_id");
                String appointmentDate = rs.getString("appointment_date");
                String status = rs.getString("status");
                appointment = new Appointment(id, patientId, doctorId, appointmentDate, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    public List<Appointment> selectAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPOINTMENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int patientId = rs.getInt("patient_id");
                int doctorId = rs.getInt("doctor_id");
                String appointmentDate = rs.getString("appointment_date");
                String status = rs.getString("status");
                appointments.add(new Appointment(id, patientId, doctorId, appointmentDate, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public boolean deleteAppointment(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_APPOINTMENT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateAppointment(Appointment appointment) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_APPOINTMENT_SQL)) {
            statement.setInt(1, appointment.getPatientId());
            statement.setInt(2, appointment.getDoctorId());
            statement.setString(3, appointment.getAppointmentDate());
            statement.setString(4, appointment.getStatus());
            statement.setInt(5, appointment.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
