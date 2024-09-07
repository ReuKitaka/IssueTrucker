package com.reuben.issuetrucker.issuetrucker.Model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
}
