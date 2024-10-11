package in.kitcoek.libraryapp.controller;

import in.kitcoek.libraryapp.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    static List<Student> students = new ArrayList<>();

    @PostMapping
    public boolean insertStudent(@RequestBody Student s) {
        students.add(s);
        return true;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/{prn}")
    public Student getStudentByPrn(@PathVariable int prn) {
        for(int i=0; i<students.size(); i++) {
            if(students.get(i).getPrn() == prn) {
                return students.get(i);
            }
        }
        return null;
    }
    @PutMapping("/{prn}")
    public boolean updateStudent(@PathVariable int prn, @RequestBody Student student) {
        for(int i=0; i<students.size(); i++) {
            if(students.get(i).getPrn() == prn) {
                students.set(i, student);
            }
        }
        return true;
    }
    @DeleteMapping("/delete/{prn}")
    public boolean deleteByPrn(@PathVariable int prn) {
        for(int i=0; i<students.size(); i++) {
            if(students.get(i).getPrn() == prn) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    @DeleteMapping("/deleteAll")
    public boolean deleteAllStudents() {
        students.clear();
        return true;
    }
}
