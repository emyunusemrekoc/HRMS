package kodlamaio.hrms.core.utilities.cloudinary.concretes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.cloudinary.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService{
	
	private Cloudinary cloudinary;
	//private Map<String, String> valuesMap = new HashMap<>();
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<?> save(MultipartFile file) {
		 try{
	            Map cloudinaryUploader = cloudinary.uploader()
	            		.upload(file.getBytes()
	            ,ObjectUtils.emptyMap());
	            return new SuccessDataResult<Map>(cloudinaryUploader);
	        } 
		 
		 catch (IOException e){
	           e.printStackTrace();
	        }
	        return new ErrorDataResult<Map>();
	}


	@Override
	public DataResult<Map> delete(String id) throws IOException {
		 Map<String , Boolean> options = new HashMap<>();
	        options.put("invalidate",true);
	        Map result = cloudinary.uploader().destroy(id,options);
	        return new SuccessDataResult<>(result);
	}

}
