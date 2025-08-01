package com.springboot_practice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="student")
public class Student extends BaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="roll_no",unique = true)
    private Long rollNo;

    private String name;

    private String city;

    @Column(name="marks",length=3)
    private Float marks;

    @ColumnDefault("false")
    private Boolean pass=false;

}
