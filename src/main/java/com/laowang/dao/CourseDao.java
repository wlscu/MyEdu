package com.laowang.dao;

import com.laowang.entity.Course;

/**
 * @author 隔壁老王
 */
public interface CourseDao {

    /**
     * 添加课程
     * @param c 传递的课程对象
     * @return 返回1表示添加成功，0代表添加失败
     */
    int addCourse(Course c);

    /**
     * 修改课程
     * @param c 需要修改的课程对象
     * @return 返回1表示修改成功，0代表修改失败
     */
    int updateCourse(Course c);

    /**
     * 批量删除课程
     * @param cids 获取的多个课程参数
     * @return 返回删除条数，0为删除失败
     */
    int deleteCourse(String cids);
}

