package com.pgs.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Users")
public class User {

	@Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private String lastName;
    
    private String address;
    
    private String city;
    
    private String email;   
     
}