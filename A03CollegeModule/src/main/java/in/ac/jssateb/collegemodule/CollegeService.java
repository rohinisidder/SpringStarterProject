package in.ac.jssateb.collegemodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollegeService {
	
	@Autowired
	private CollegeRepository repo;
	
	//Retrieve All
	public List<College> listAll(){
		return repo.findAll();
	}
	
	//Retrieve by id
	public College get(Integer id) {
		return repo.findById(id).get();
	}
	
	//Create
	public void save(College college) {
		repo.save(college);
	}
	
	//Delete
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
