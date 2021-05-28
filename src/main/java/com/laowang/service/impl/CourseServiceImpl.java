package com.laowang.service.impl;

import com.laowang.dao.CourseDao;
import com.laowang.dao.impl.CourseDaoImpl;
import com.laowang.entity.Course;
import com.laowang.entity.ResultVO;
import com.laowang.service.CourseService;
import com.laowang.util.JsonUtil;
import com.laowang.util.PageUtil;

import java.util.List;

/**
 * @author 隔壁老王
 */
public class CourseServiceImpl implements CourseService {
    CourseDao cd = new CourseDaoImpl();
    @Override
    public String addCourse(Course c) {
        int rows = cd.addCourse(c);
        ResultVO r = null;
        if(rows != 0){
            r = new ResultVO(1,"新增成功",null);
        }else{
            r = new ResultVO(2,"新增失败",null);
        }
        return JsonUtil.toJson(r);
    }

    @Override
    public String updateCourse(Course c) {
        int rows = cd.updateCourse(c);
        ResultVO v = null;
        if(rows != 0){
            v = new ResultVO(1,"恭喜你，修改成功！",null);
        }else{
            v = new ResultVO(2,"修改失败，请稍后再试！",null);
        }
        return JsonUtil.toJson(v);
    }

    @Override
    public String deleteCourse(String cids) {
        int rows = cd.deleteCourse(cids);
        ResultVO r = null;
        if(rows == 0){
            r = new ResultVO(2,"删除失败，请稍后再试！",null);
        }else{
            r = new ResultVO(1,"恭喜你，删除成功！",null);
        }
        return JsonUtil.toJson(r);
    }

    @Override
    public int getCountRows(String courseName) {
        return cd.getCountRows(courseName);
    }

    @Override
    public List<Course> getCountByName(PageUtil pu,String courseName) {
        return cd.getCountByName(pu, courseName);
    }
}
