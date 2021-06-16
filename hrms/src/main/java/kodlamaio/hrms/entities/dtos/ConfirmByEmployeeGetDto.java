package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmByEmployeeGetDto {

	private int id;
	private int employerId;
	private String employerCompanyName;
	private String employerWebAdress;
	private String employerPhoneNumber;
	private boolean isConfirmed;
	

}
