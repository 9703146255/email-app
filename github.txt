package in.thiru.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import in.thiru.entity.Employee;
import in.thiru.repo.EmployeeDAO;

@Service
public class EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeService(EmployeeDAO employeeDAO) {

		this.employeeDAO = employeeDAO;
	}

	public void saveEmps() {

		Employee emp1 = new Employee(101, "thirumala", 10000.00);
		Employee emp2 = new Employee(102, "vijay", 90000.00);
		Employee emp3 = new Employee(103, "charan", 80000.00);
		Employee emp4 = new Employee(104, "kiran", 10000.00);
		Employee emp5 = new Employee(105, "vinay", 20000.00);
		Employee emp6 = new Employee(106, "balu", 60000.00);
		Employee emp7 = new Employee(107, "bablu", 20000.00);
		Employee emp8 = new Employee(108, "pavan", 50000.00);
		Employee emp9 = new Employee(109, "monalisa", 330000.00);
		Employee emp10 = new Employee(110, "keeravani", 440000.00);

		List<Employee> asList = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10);

		employeeDAO.saveAll(asList);
		System.out.println("records inserted succeesfully....");

	}

	public void empSort(String column) {

		// List<Employee> findAll = employeeDAO.findAll(Sort.by(column)); //by default
		// ascending order these

//		Sort reverse = Sort.by(column).reverse();
//		
//		List<Employee> findAll = employeeDAO.findAll(reverse);

		List<Employee> findAll = employeeDAO.findAll(Sort.by(column).reverse());

		findAll.forEach(s -> System.out.println(s));

	}

	public void empPagingation(int pageSize, int pageNo) {

//		PageRequest of = PageRequest.of(pageNo - 1, pageSize);
//
//		Page<Employee> findAll = employeeDAO.findAll(of);

		Page<Employee> findAll = employeeDAO.findAll(PageRequest.of(pageNo - 1, pageSize));

		List<Employee> content = findAll.getContent();

		content.forEach(s -> System.out.println(s));
	}

	public void empQBE() {
		Employee emp = new Employee();

		emp.setEmpName("bablu");
		emp.setEmpSal(20000.00);

//		Example<Employee> of = Example.of(emp);
//		List<Employee> findAll = employeeDAO.findAll(of);

		List<Employee> findAll = employeeDAO.findAll(Example.of(emp));
		findAll.forEach(s -> System.out.println(s));

	}

}
