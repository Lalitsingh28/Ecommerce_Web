package com.masai.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@NotNull
	@Pattern(regexp="[a-zA-Z]{3,12}", message = "First Name should not be less than 3 and more than 12.")
	private String firstName;
	
	@NotNull
	@Pattern(regexp="[a-zA-Z]{3,12}", message = "Last Name should not be less than 3 and more than 12.")
	private String lastName;
	
	@NotNull
	@Pattern(regexp="[6-9]{1}[0-9]{9}", message = "Mobile number must be in proper format.")
	private String mobile;

	@NotNull
	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain 6 to 12 characters.")
	private String password;
	
	@Email
	@NotNull
	private String email;

}
