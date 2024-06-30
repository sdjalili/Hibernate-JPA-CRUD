package sd.demo.ioc.entity.students;

import java.util.List;

public interface StudentDAO {

    public Integer save(Student theStudent);
    public Student find(Integer id);
    public Student findByEmail(String email) ;
    public List<Student> findAll();
    public Student update(Student theStudent);
    public int removeStudent(int studentId);
}
