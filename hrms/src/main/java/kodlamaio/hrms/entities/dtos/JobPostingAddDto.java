package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingAddDto {
	
	
	private int id;
	private int employerId;
	private int jobTitleId;
	private int cityId;
	private String jobDescription;
	private int minSalary;
	private int maxSalary;
	private int numberOfOpenPosition;
	private LocalDateTime applicationDeadline;
	private boolean isActive;

}
