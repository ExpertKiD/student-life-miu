package edu.miu.exercise1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private double price;
}