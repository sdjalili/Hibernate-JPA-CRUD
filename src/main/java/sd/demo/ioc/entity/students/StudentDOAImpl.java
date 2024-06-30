package sd.demo.ioc.entity.students;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sd.demo.ioc.common.exceptions.NoRecordsFoundException;

import java.util.List;

@Repository
public class StudentDOAImpl implements StudentDAO{


    private EntityManager entityManager;

    @Autowired
    public StudentDOAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public int removeStudent(int studentId) {
        return entityManager.createQuery("DELETE FROM Student s WHERE s.id=:id")
                .setParameter("id" , studentId).executeUpdate();
    }

    @Override
    public Student findByEmail(String email) {

        Student tempStudent = null;
        try {
            tempStudent = entityManager.createQuery("SELECT s FROM Student s WHERE s.email=:email", Student.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (RuntimeException exp) {
            throw new NoRecordsFoundException("No records found.");
        }
        return tempStudent;
    }

    @Override
    @Transactional
    public Student update(Student theStudent) {
        return entityManager.merge(theStudent);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s from Student s" ,Student.class).getResultList();
    }

    @Override
    @Transactional
    public Integer save(Student theStudent) {
        entityManager.persist(theStudent);
        return theStudent.getId();
    }

    @Override
    public Student find(Integer id) {
        return entityManager.find(Student.class, id);
    }
}
