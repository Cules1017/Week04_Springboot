package iuh.edu.vn.www_week04_spring;

import iuh.edu.vn.www_week04_spring.Reponsitory.DepartmentReponsitory;
import iuh.edu.vn.www_week04_spring.Reponsitory.EmployeeReponsitory;
import iuh.edu.vn.www_week04_spring.entities.Department;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WwwWeek04SpringApplicationTests {
    @Autowired
    private DepartmentReponsitory departmentReponsitory;
    @Autowired
    private EmployeeReponsitory employeeReponsitory;
    @PostConstruct
    void init(){
        Department d1 = new Department("SE");
        Department d2 = new Department("DS");
        departmentReponsitory.save(d1);
        departmentReponsitory.save(d2);
    }
    @Test
    void text_01() {
        departmentReponsitory.findAll();
    }
    @Test
    void contextLoads() {
    }

}
