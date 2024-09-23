package in.ac.jssateb.collegemodule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Integer>{
	
	//C - save()
	//R ALL - findAll()
	//R BY ID - findById() and get()
	//U - R BY ID + C
	//D - deleteById()

}
