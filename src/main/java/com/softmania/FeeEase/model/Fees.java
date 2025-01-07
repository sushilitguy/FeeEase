package com.softmania.FeeEase.model;

import java.util.Date;

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
public class Fees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
	private Students student;
	private String depositMonthYear;
	private double amount;
	private Date depositDateTime;
	private String depositMode;
	private String paymentRefId;
	@ManyToOne
	@JoinColumn(name = "fee_type_id", referencedColumnName = "id", nullable = false)
	private FeeType feeType;
	private String comments;
	@ManyToOne
	@JoinColumn(name = "added_by", referencedColumnName = "id", nullable = false)
	private Users addedBy;
}