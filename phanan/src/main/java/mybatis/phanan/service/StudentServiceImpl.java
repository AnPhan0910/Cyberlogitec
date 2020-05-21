package mybatis.phanan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.phanan.entity.Student;
import mybatis.phanan.mapper.StudentMapper;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
 
    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }
 
    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
 
    @Override
    public int deleteStudentById(int studentId) {
        return studentMapper.deleteStudentById(studentId);
    }
 
    @Override
    public List<Student> selectAllStudent() {
        return studentMapper.selectAllStudent();
    }
 
    @Override
    public Student selectStudentById(int studentId) {
        return studentMapper.selectStudentById(studentId);
    }

	@Override
	public List<Student> findStudent(Student student) {
		System.out.println(student);
		return studentMapper.findStudent(student);
	}
}