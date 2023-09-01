package com.pks.webservicesforemployee.dto;

import lombok.Builder;

@Builder

public record EmployeeRecord(
        String firstName,
        String lastName,
        String emailId,
        String department) {
}
