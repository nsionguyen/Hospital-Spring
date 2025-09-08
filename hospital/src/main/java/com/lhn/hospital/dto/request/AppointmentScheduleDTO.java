package com.lhn.hospital.dto.request;

public class AppointmentScheduleDTO {
    private Integer bookBy;
    private Integer specialty;
    private Integer doctor;
    private Integer patient;
    private String appointment_date;
    private String symptoms;

    public void setBookBy(Integer bookBy) {

        this.bookBy = bookBy;
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

    public Integer getBookBy() {

        return this.bookBy;
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
