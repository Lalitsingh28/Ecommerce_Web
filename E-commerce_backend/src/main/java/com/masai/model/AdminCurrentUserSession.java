package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminCurrentUserSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer adminId;
	private String uUid;
	private LocalDateTime localDateTime;
		
	public AdminCurrentUserSession(Integer adminId, String uuid, LocalDateTime localDateTime) {
		super();
		this.adminId = adminId;
		this.uUid = uuid;
		this.localDateTime = localDateTime;
	}
	
}