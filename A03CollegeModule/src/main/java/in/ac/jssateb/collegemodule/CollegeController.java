package in.ac.jssateb.collegemodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService service;
	
	//Retrieve All
	@GetMapping("/colleges")
	public List<College> list(){
		return service.listAll();
	}
	
	//Retrieve by id
	@GetMapping("/colleges/{id}")
	public ResponseEntity<College> get(@PathVariable Integer id){
		try {
			College college = service.get(id);
			return new ResponseEntity<College>(college,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Create
	@PostMapping("/colleges")
	public void add(@RequestBody College college) {
		service.save(college);
	}
	
	//Update
	@PutMapping("/colleges/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody College college){
		try {
			College existcollege = service.get(id);
			service.save(college);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete
	@DeleteMapping("/colleges/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
