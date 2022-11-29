package com.indatacore.indatacoretest.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Etudiant {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String lastName;
    int age;
}
