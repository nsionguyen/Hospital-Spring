package com.lhn.hospital.entity.enums;

public enum UserRole {
    USER, ADMIN, STAFF;
    @Override
    public String toString() {
        return this.name();
    }
}
