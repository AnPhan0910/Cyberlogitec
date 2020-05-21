package mybatis.phanan.service;

import java.util.List;

import mybatis.phanan.entity.Student;

public interface StudentService {
    public int insertStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudentById(int studentId);
    public List<Student> selectAllStudent();
    public Student selectStudentById(int studentId);
    public List<Student> findStudent(Student student);
}
