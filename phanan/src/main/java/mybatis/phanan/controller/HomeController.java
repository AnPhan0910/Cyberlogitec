package mybatis.phanan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.phanan.entity.Student;
import mybatis.phanan.service.StudentService;

@Controller
public class HomeController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/getStudentList")
	@ResponseBody
	public List<Student> getStudentList() {
		List<Student> output = studentService.selectAllStudent();
		return output;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, headers = {"content-type=application/json"})
	@ResponseBody
	public List<Student> searchStudent(@RequestBody Student student) {
		List<Student> output = studentService.findStudent(student);
		return output;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = {"content-type=application/json"})
	@ResponseBody
	public int addStudent(@RequestBody Student student) {
		if(student.getId() == 0) {
			return studentService.insertStudent(student);
		} else {
			return studentService.updateStudent(student);
		}
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST, headers = {"content-type=application/json"})
	@ResponseBody
	public int delStudent(@RequestBody Student student) {
		return studentService.deleteStudentById(student.getId());
	}
}
