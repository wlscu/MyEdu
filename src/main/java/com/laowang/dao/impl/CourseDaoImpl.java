package com.laowang.dao.impl;

import com.laowang.dao.CourseDao;
import com.laowang.entity.Course;
import com.laowang.util.PageUtil;
import com.laowang.util.QueryRunnerUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 隔壁老王
 */
public class CourseDaoImpl implements CourseDao {
    QueryRunner qr = QueryRunnerUtil.getQueryRunner();

    @Override
    public int addCourse(Course c) {
        int rows = 0;
        String sql = "insert into course(courseName,descs,courseType,courseImage,courseVideo," +
                "coursePrice,status,createTime) values(?,?,?,?,?,?,?,?)";
        try {
            rows =  qr.update(sql, c.getCourseName(), c.getDescs(), c.getCourseType(), c.getCourseImage(),
                    c.getCourseVideo(),c.getCoursePrice(), c.getStatus(), c.getCreateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int updateCourse(Course c) {
        int rows = 0;
        String sql = "update course set courseName=?,descs=?,courseType=?,courseImage=?,courseVideo=?,coursePrice=?,status=? where cid=?";
        try {
            rows = qr.update(sql,c.getCourseName(),c.getDescs(),c.getCourseType(),c.getCourseImage(),c.getCourseVideo(),c.getCoursePrice(),c.getStatus(),c.getCid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int deleteCourse(String cids) {
        int rows = 0;
        String sql = "delete from course where cid in(" + cids + ")";
        try {
            rows = qr.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int getCountRows(String courseName) {
        int rows = 0;
        String sql = "select count(*) from course where courseName like '%"+courseName+"%'";
        try {
            rows =(int)(long)qr.query(sql,new ScalarHandler<>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<Course> getCountByName(PageUtil pu,String courseName) {
        List<Course> list = null;
        String sql = "select * from course where courseName like '%"+courseName+"%' limit ?,?";
        try {
            list =qr.query(sql,new BeanListHandler<>(Course.class),pu.getIndex(),pu.getRows());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
