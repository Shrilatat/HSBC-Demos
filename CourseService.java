package com.trg.boot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

	public CourseService() {
		courses.add(new Course(101, "Spring", "Spring quickstart"));
		courses.add(new Course(102, "Java", "Java fundamentals"));
		courses.add(new Course(103, "NodeJS", "Node essentials"));
	}

	List<Course> courses = new ArrayList<>();
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public Course getCourseById(int id){
		for(Course c : courses){
			if(c.getId()==id)
				return c;
		}
		return null;
	}
	
	public boolean addCourse(Course course){
		return courses.add(course);
	}
	
	public void updateCourse(int id, Course course){
		System.out.println(id);
		for(int i=0; i< courses.size() ;i++){
			if(courses.get(i).getId()==id){
			   courses.set(i, course);
				break;
			}
		}
	}
	
	public void deleteCourse(int id){

		Iterator<Course> it = courses.iterator();
		while(it.hasNext()){
			if(it.next().getId()==id)
				it.remove();
		}
	}
	
}
