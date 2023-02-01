package com.pm.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document("account")
public class Account {

    private String id;
    private String name;
    private String description;
    private float amount;

}
