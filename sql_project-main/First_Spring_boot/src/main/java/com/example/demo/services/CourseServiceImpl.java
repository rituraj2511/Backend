package com.example.demo.services;

import com.example.demo.entities.Course;
import com.example.demo.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;
//    List<Course> list;
    private long courseId;

    public CourseServiceImpl(){
//        list=new ArrayList<>();
//        list.add(new Course(145,"java core","this course contains basic java"));
//        list.add(new Course(143,"Clean Code","This is the programmer Book"));
    }
    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//        Course c=null;
//        for(Course course:list)
//        {
//            if (course.getId()==courseId)
//            {
//                c=course;
//                break;
//            }
//        }
        return courseDao.getOne(courseId);
    }
    @Override
    public Course addCourse(Course course)
    {
//        list.add(course);
        courseDao.save(course);
        return course;
    }
    @Override
    public Course updateCourse(Course course)
    {
//        list.forEach(course1 -> {
//            if(course1.getId()== course.getId()){
//                course1.setTitle(course.getTitle());
//                course1.setDescription(course.getDescription());
//            }
//        });
        courseDao.save(course);
        return course;
    }
    @Override
    public void deleteCourse(long parseLong){
//       list =this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
        Course entity = courseDao.getOne(parseLong);
        courseDao.delete(entity);
    }
}
