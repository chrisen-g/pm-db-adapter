package com.pm.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private String id;
    private String name;
    private String description;
    private float amount;
}
