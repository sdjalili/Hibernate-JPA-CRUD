package sd.demo.ioc;

import sd.demo.ioc.entity.students.Student;
import sd.demo.ioc.entity.students.StudentDAO;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		SpringApplication.run(IocApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(StudentDAO studentDAO){
		return runner -> {

			//Student theStudent = new Student("Javad", "Bayzavi", "JBayzavi@gmail.com");
			//findStudentById(studentDAO ,1);
			//createNewStudent(theStudent, studentDAO);
			//showAllStudent(studentDAO);
			//findUserByEmail("jalilisd@gmail.com", studentDAO);
			//updateStudent(studentDAO, 1);
			deleteStudent(studentDAO, "jalilisd@gmail.com");
		};
	}

	private void deleteStudent(StudentDAO studentDAO, String mail) {
		try {
			Student tempStudent = studentDAO.findByEmail(mail);
			System.out.println("Number of deleted students: " + studentDAO.removeStudent(tempStudent.getId()));
		}catch (Exception exp){
			System.out.println(exp.getMessage());
		}

	}

	private void findUserByEmail(String mail, StudentDAO studentDAO) {
		System.out.println(studentDAO.findByEmail(mail));
	}


	private void updateStudent(StudentDAO studentDAO, int i) {
		Student tempStudent = studentDAO.find(i);
		tempStudent.setFirstName("Avesta");
		studentDAO.update(tempStudent);
		System.out.println(tempStudent);
	}

	private void showAllStudent(StudentDAO studentDAO) {

		for(Student std: studentDAO.findAll()){
			System.out.println(std);
		}

	}

	private void createNewStudent(Student theStudent, StudentDAO studentDAO) {
		System.out.println("Creating Student object ...");

		System.out.println("saving Student object into database");
		studentDAO.save(theStudent);

		System.out.println("The Student " + theStudent.getFirstName() +
				" with id : " + theStudent.getId() + ", successfully added to the database.");
	}

	private void findStudentById(StudentDAO dao , int i) {
		System.out.println(dao.find(i));
	}
}
