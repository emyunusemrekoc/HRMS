package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingAddDto {
	
	@JsonIgnore
	private int id;
	private int employerId;
	private int jobTitleId;
	private int jobTypeId;
	private int cityId;
	private String jobDescription;
	private int minSalary;
	private int maxSalary;
	private int numberOfOpenPosition;
	private LocalDate applicationDeadline;
	@JsonIgnore
	private LocalDate createdDate;
	private boolean isActive;
	private boolean isRemote;
	private String jobPostingName;
	


}
