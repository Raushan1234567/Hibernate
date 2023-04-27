package Dao;



import DtoEntity.Student;
import Exception.SomethingWentWrongException;
import jakarta.persistence.*;


public class imple implements inter {
//Connection c=null;  
	@Override
	public void addStudent(Student s) throws SomethingWentWrongException {
		//c=connectionclass.methodcall();in simple dao layer .in simple dao and need to keep inside try ,catch block because its throws catched exception
		EntityManager em = Connectionentity.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(s);	//book object: managed state		
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException(ex.getMessage());
		}finally {
			et.commit();
			em.close();			
		}
	}

	@Override
	public void updateStudent(int id,String title,String author,String price,int level) throws SomethingWentWrongException, ClassNotFoundException {
	
		EntityManager em= Connectionentity.getAnEntityManager();
		
		EntityTransaction et = em.getTransaction();
		Student stu= em.find(Student.class, id);
		stu.setAddress(author);
		stu.setEmail(title);
		stu.setCourse(price);
		stu.setLevel(level);
		
		et.begin();
		try {
			em.merge(stu);
		}catch(IllegalArgumentException a) {
			throw new SomethingWentWrongException(a.getMessage());
			
		}
		
		
		et.commit();
		em.close();
		
		
		
	}

}
