package SpringBootProject.Advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import SpringBootProject.Exception.IdNotFoundException;


@RestControllerAdvice
public class ApplicationExceptionhandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex)
	{
		Map<String, String> errorMap = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		return errorMap;
		}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(IdNotFoundException.class)
	public Map<String, String> handleIdNotFoundArgument(IdNotFoundException ex)
	{
		
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("errormessage", "Id is not present");

		
		return errorMap;

	
		}
	
}
