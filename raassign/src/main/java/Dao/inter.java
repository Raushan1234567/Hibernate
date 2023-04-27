package Dao;

import DtoEntity.Student;
import Exception.SomethingWentWrongException;

public interface inter {

	public void addStudent(Student s) throws SomethingWentWrongException;
	public void updateStudent(int id,String title,String author,String price,int level) throws SomethingWentWrongException, ClassNotFoundException;
	
}
