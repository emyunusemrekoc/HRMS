package kodlamaio.hrms.core.utilities.dtoConverter.abstracts;

import java.util.List;

public interface DtoConverterService {
	
	<S,T> List<T> entityToDto(List<S> listTypeEntityClass, Class<T> targetDtoClass);
	
	<T> Object dtoToEntity(Object dtoClass,Class<T> targetEntityClass);

	//<T> Object dtoToEntitySingle(Class<T> dtoClass,Class<T> targetEntityClass);

}
