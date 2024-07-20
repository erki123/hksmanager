package com.example.hksmanager.component;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Eshop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String sex;
    private String size;
    private String color;
    private String imageUrl;
    private float price;

    @Column(nullable = false, updatable = false)
    private String itemCode;

}
