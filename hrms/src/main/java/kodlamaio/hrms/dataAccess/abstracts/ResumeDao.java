//package kodlamaio.hrms.dataAccess.abstracts;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import kodlamaio.hrms.entities.concretes.Resume;
//
//public interface ResumeDao extends JpaRepository<Resume, Integer>{
//	
//	Resume findById(int id);
//	Resume findByIdAndCandidateId(int resumeId,int candidateId);
//	Resume findByCandidateId(int candidateId);
//	Resume findByResumeNameAndCandidateId(String resumeName,int candidateId);
//	List<Resume> findAllByCandidateId(int candidateId);
//	List<Resume> findByCandidateIdAndId(int candidateId,int resumeId);
//	
//	//List<Resume> findAll();
//
//}
