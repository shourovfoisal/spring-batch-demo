package com.shourov.springBatchDemo.dto;

import lombok.Builder;

@Builder
public record VisitorsDto(Long id,
                          String firstName,
                          String lastName,
                          String emailAddress,
                          String phoneNumber,
                          String address,
                          String visitDate) {
}
