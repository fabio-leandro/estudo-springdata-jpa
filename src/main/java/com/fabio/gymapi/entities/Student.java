package com.fabio.gymapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tb_students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, length = 15)
    private String cpf;

    @Column(nullable = false, length = 50)
    private String neighborhood;

    @Column(nullable = false, length = 10)
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AssessmentPhysical> assessments = new ArrayList<>();

}
