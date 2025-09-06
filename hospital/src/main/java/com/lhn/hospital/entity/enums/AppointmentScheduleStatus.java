package com.lhn.hospital.entity.enums;

public enum AppointmentScheduleStatus {
    ACCEPT,PENDING,CANCEL,COMPLETED;

    @Override
    public String toString() {
        return this.name();
    }

}
