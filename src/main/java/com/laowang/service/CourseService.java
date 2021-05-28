package com.laowang.service;

import com.laowang.entity.Course;
import com.laowang.util.PageUtil;

import java.util.List;

/**
 * @author 隔壁老王
 */
public interface CourseService {
    /**
     * 添加课程
     * @param c 传递的课程对象
     * @return 返回返回信息
     */
    String addCourse(Course c);

    /**
     * 修改课程
     * @param c 需要修改的课程对象
     * @return 返回true表示修改成功，false代表修改失败
     */
    String updateCourse(Course c);

    /**
     * 批量删除课程
     * @param cids 获取的多个课程参数
     * @return 返回true表示删除成功，false为删除失败
     */
    String deleteCourse(String cids);

    int getCountRows(String courseName);

    List<Course> getCountByName(PageUtil pu, String courseName);
}
