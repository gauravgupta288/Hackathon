package com.hackathon.hackathon.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "projects")
public class Projects {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @Size(min = 2, max = 30)
    private String projectName;

    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date projectStartDate;

    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date projectEndDate;

    @NotBlank
    @Size(min = 2, max = 10, message = "Manager Id is must")
    private int managerId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projects_fk", referencedColumnName = "id")
    private List<Teams> teams;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projects_fk", referencedColumnName = "id")
    private List<MailerList> mailerList;
}
