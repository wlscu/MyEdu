package com.laowang.dao.impl;

import com.laowang.dao.CourseDao;
import com.laowang.entity.Course;
import com.laowang.util.QueryRunnerUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author 隔壁老王
 */
public class CourseDaoImpl implements CourseDao {
    QueryRunner qr = QueryRunnerUtil.getQueryRunner();

    @Override
    public int addCourse(Course c) {
        int rows = 0;
        String sql = "insert into course values(?,?,?,?,?,?,?,?,?)";
        try {
            rows = qr.update(sql,null,c.getCourseName(),c.getDescs(),c.getCourseType(),c.getCourseImage(),c.getCourseVideo(),c.getCoursePrice(),c.getStatus(),c.getCreateTime());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int updateCourse(Course c) {
        int rows = 0;
        String sql = "update course set courseName=?,descs=?,courseType=?,courseImage=?,courseVideo=?,coursePrice=?,status=?,createTime=? where cid=?";
        try {
            rows = qr.update(sql,c.getCourseName(),c.getDescs(),c.getCourseType(),c.getCourseImage(),c.getCourseVideo(),c.getCoursePrice(),c.getStatus(),c.getCreateTime(),c.getCid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int deleteCourse(String cids) {
        int rows = 0;
        String sql = "delete from course where course.cid in(" + cids + ")";
        try {
            rows = qr.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
}
