package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="verification_codes")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="verification_code")
	private String verificationCode;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@JsonIgnore
	@Column(name="verified_date")
	private LocalDateTime verifiedDate;
	
	@OneToOne()
	@JoinColumn(name ="user_id",referencedColumnName = "id")
	private User user;
	
	
	


}
