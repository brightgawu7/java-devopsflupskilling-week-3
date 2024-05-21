package com.qwammy.javadevopsflupskillingweek1.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Employee {
    private String id;
    private String name;
    private double salary;
}
