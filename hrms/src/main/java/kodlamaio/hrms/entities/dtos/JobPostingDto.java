package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingDto {

		private String employerCompanyName;
		private String jobTitleTitle;
		private int numberOfOpenPosition;
		private LocalDateTime createdDate;
		private LocalDateTime applicationDeadline;

}