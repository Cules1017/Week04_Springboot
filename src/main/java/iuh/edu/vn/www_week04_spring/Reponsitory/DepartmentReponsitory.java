package iuh.edu.vn.www_week04_spring.Reponsitory;

import iuh.edu.vn.www_week04_spring.entities.Department;
import org.springframework.data.repository.CrudRepository;


public interface DepartmentReponsitory extends CrudRepository<Department, Long> {

}
