package com.trg.boot.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/courses")
	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	@GetMapping("/courses/{id}")
	public Course getById(@PathVariable int id) {
		return courseService.getCourseById(id);
	}

	@PostMapping("/courses")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable int id, 
			                 @RequestBody Course course){
		courseService.updateCourse(id, course);
	}

	@DeleteMapping("/courses/{id}")
	public void delCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
	}
}
