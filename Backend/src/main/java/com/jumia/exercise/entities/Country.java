package com.jumia.exercise.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "code")
    private String countryCode;

    @Column(name = "name")
    private String countryName;

}
