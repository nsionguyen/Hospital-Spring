package com.lhn.hospital.entity.enums;

public enum PaymentStatus {
    SUCCESS, FAIL;

    @Override
    public String toString()
    {
        return this.name();
    }
}
