package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingGetDto {
	
		private int id;
		private String jobPostingName;
		private String employerCompanyName;
		private String jobTitleTitle;
		private int numberOfOpenPosition;
		private LocalDate createdDate;
		private LocalDate applicationDeadline;
		private String jobTypeTypeName;
		private String cityCity;
		private String jobDescription;
		private int minSalary;
		private int maxSalary;
		private boolean isRemote;
		
}