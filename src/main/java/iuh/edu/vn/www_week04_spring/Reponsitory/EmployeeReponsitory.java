package iuh.edu.vn.www_week04_spring.Reponsitory;

import iuh.edu.vn.www_week04_spring.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EmployeeReponsitory extends CrudRepository<Employee, UUID> {

}
