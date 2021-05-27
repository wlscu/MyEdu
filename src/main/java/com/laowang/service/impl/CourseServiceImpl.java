package com.laowang.service.impl;

import com.laowang.dao.impl.CourseDaoImpl;
import com.laowang.entity.Course;
import com.laowang.service.CourseService;

/**
 * @author 隔壁老王
 */
public class CourseServiceImpl implements CourseService {
    CourseDaoImpl cd = new CourseDaoImpl();
    @Override
    public boolean addCourse(Course c) {
        boolean res = true;
        int rows = cd.addCourse(c);
        if (rows == 0){
            res = false;
        }
        return res;
    }

    @Override
    public boolean updateCourse(Course c) {
        boolean res = true;
        int rows = cd.updateCourse(c);
        if (rows == 0){
            res = false;
        }
        return res;
    }

    @Override
    public boolean deleteCourse(String cids) {
        boolean res = true;
        int rows = cd.deleteCourse(cids);
        if (rows == 0){
            res = false;
        }
        return res;
    }
}
