package zw.co.tengahuku.dto;

public class ManagerDTO {

	private int id;
	private EmployeeDTO employee;
	private String designation;
	private String headedDivision;

	public ManagerDTO(int id, EmployeeDTO employee, String designation, String headedDivision) {
		this.id = id;
		this.employee = employee;
		this.designation = designation;
		this.headedDivision = headedDivision;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getHeadedDivision() {
		return headedDivision;
	}

	public void setHeadedDivision(String headedDivision) {
		this.headedDivision = headedDivision;
	}

}
