package com.lhn.hospital.dto.request;

public class AppointmentScheduleDTO {
    private Integer hospital;
    private Integer specialty;
    private Integer doctor;
    private Integer patient;
    private String appointment_date;  // Được truyền là String từ frontend
    private String symptoms;

    public void setHospital(Integer hospital) {
        this.hospital = hospital;
    }

    public void setSpecialty(Integer specialty) {
        this.specialty = specialty;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Integer getHospital() {
        return hospital;
    }

    public Integer getSpecialty() {
        return specialty;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public Integer getPatient() {
        return patient;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public String getSymptoms() {
        return symptoms;
    }


}
