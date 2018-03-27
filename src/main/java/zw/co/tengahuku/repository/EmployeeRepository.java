package zw.co.tengahuku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zw.co.tengahuku.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository  extends JpaRepository<Employee,Long>{

}
