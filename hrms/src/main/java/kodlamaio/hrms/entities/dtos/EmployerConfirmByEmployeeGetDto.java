package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerConfirmByEmployeeGetDto {

	private int id;
	private int employerId;
	private int employeeId;
	private String employerCompanyName;
	private String employerWebAdress;
	private String employerPhoneNumber;
	private boolean isConfirmed;
	private LocalDateTime confirmedDate;
	

}
