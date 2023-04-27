package dao;

import dto.Employee;
import exception.NorecordFoundException;
import exception.somethingwentwrong;

public interface Inter {
	public void save(Employee emp)throws somethingwentwrong;
	public String getAddressOfEmployee(int empId)throws somethingwentwrong,NorecordFoundException;
	public String giveBonusToEmployee(int empId, double bonus)throws somethingwentwrong,NorecordFoundException;
	public boolean deleteEmployee(int empId)throws somethingwentwrong,NorecordFoundException;
}
