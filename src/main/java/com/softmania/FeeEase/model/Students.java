package com.softmania.FeeEase.model;

import java.time.LocalDate;

//import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String fatherName;
	private String motherName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dob;
	private String contactNo;
	private String schoolClass;
	private String classSection;
	private String session;
	private double feesAmount;
	private boolean isEnabled;
	@ManyToOne
	@JoinColumn(name = "school_id", referencedColumnName = "id", nullable = false)
	private School school;
}