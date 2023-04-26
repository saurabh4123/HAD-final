package com.example.project3.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE employee SET deleted = true WHERE e_id=?")
@Where(clause = "deleted=false")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int e_id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private String mobilenumber;
    private char gender;
    private String roles;
    private String specialization;
    private boolean deleted=Boolean.FALSE;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Patient> patients;

    public Employee(int e_id, String name, String email, String password, String address,String mobilenumber, char gender, String role) {
        this.e_id = e_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.mobilenumber = mobilenumber;
        this.gender=gender;
        this.roles = role;
    }
}
