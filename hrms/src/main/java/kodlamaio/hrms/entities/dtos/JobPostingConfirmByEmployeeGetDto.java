package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingConfirmByEmployeeGetDto {
	
	private int id;
	private int employeeId;
	private int jobPostingId;
	private String jobPostingName;
	private boolean isConfirmed;
	private LocalDateTime confirmedDate;

}
