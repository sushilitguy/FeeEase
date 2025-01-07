package com.softmania.FeeEase.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	@ManyToOne
	@JoinColumn(name = "school_id", referencedColumnName = "id", nullable = false)
	private School school;
	private String role;
	private boolean isEnabled;
}