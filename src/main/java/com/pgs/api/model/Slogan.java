package com.pgs.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Slogans")
public class Slogan {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long userId;
    
	private String slogan;
}
