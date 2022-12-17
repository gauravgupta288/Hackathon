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
public class TeamMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_members_fk", referencedColumnName = "id")
    private List<Employee> emp;

    @OneToOne(cascade = CascadeType.ALL)
    private Projects projects;

}
