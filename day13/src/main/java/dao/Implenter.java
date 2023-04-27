package dao;

import dto.Employee;
import exception.NorecordFoundException;
import exception.somethingwentwrong;
import jakarta.persistence.*;

public class Implenter implements Inter {
	@Override
	public void save(Employee emp) throws somethingwentwrong {
		
		EntityManager em = ConnectionC.getConnection();

		EntityTransaction et = em.getTransaction();
		   et.begin();
		try {
			em.persist(emp);
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		} finally {
			et.commit();
			em.close();

		}
	}

	@Override
	public String getAddressOfEmployee(int empId) throws somethingwentwrong, NorecordFoundException {
		EntityManager em = ConnectionC.getConnection();
		Employee ep=em.find(Employee.class, empId);
		if(ep==null) {
			throw new NorecordFoundException("no record found exception");
		}
		return ep.getAddress();
	}

	@Override
	public String giveBonusToEmployee(int empId, double bonus) throws somethingwentwrong, NorecordFoundException {
		EntityManager em = ConnectionC.getConnection();
		Employee ep=em.find(Employee.class, empId);
		if(ep==null) {
			throw new NorecordFoundException("no record found exception");
		}
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			
			ep.setSalary(ep.getSalary()+bonus);
			em.persist(ep);
			
			return  "Bonus add succesfully";
			
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		} finally {
			et.commit();
			em.close();

		}
		return null;
		
	}

	@Override
	public boolean deleteEmployee(int empId) throws NorecordFoundException {
		
		EntityManager em = ConnectionC.getConnection();
		Employee ep=em.find(Employee.class, empId);
		if(ep==null) {
			throw new NorecordFoundException("no record found exception");
			
		}
		EntityTransaction et=em.getTransaction();
		et.begin();
		try {
			em.remove(ep);
			return true;
		}catch(PersistenceException e) {
			System.out.println(e.getMessage());
		}
		finally {
			et.commit();
			em.close();
		}
		
		return false;
	}
}
