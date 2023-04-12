package com.example.project3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class MedicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int m_id;

    private String bp;
    private String sugar_level;
    private String temperature;
    @Lob
    @Column(columnDefinition ="LONGTEXT")
    private String photo;

    private String bloodoxygen;


}
