package com.hackathon.hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "mailer_list")
public class MailerList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int empId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mailerList_fk", referencedColumnName = "id")
    private List<Employee> emp;

    @OneToOne(cascade = CascadeType.ALL)
    private Projects projects;
}
