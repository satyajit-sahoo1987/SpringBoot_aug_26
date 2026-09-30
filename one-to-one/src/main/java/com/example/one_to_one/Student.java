package com.example.one_to_one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentRoll;
    private String studentName;
    private String studentEmail;
//@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
@OneToOne(cascade =CascadeType.ALL )
@JoinColumn(name="address_Id")
    private Address address;
}
