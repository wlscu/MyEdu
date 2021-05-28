package com.laowang.controller;

import com.laowang.entity.Course;
import com.laowang.entity.ResultVO;
import com.laowang.service.impl.CourseServiceImpl;
import com.laowang.util.JsonUtil;
import com.laowang.util.PageUtil;
import com.laowang.util.UploadUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 隔壁老王
 */
@MultipartConfig
@WebServlet("/courseServlet")
public class CourseServlet extends BaseServlet {
    CourseServiceImpl cs = new CourseServiceImpl();

    protected void getCourseByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseName = req.getParameter("courseName");
        String page = req.getParameter("page");
        int rows = Integer.parseInt(req.getParameter("rows"));
        int countRows = cs.getCountRows(courseName);
        PageUtil pu = new PageUtil(page,rows,countRows);
        List<Course> list = cs.getCountByName(pu,courseName);
        pu.setList(list);
        String res = JsonUtil.toJson(pu);
        System.out.println(res);
        PrintWriter out = resp.getWriter();
        out.print(res);
    }

    protected void uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = UploadUtil.uploadFile(req);
        String  url = "http://localhost:8080/MyEdu/"+fileName;
        System.out.println(url);
        ResultVO r = null;
        if (fileName.endsWith("jpg") || fileName.endsWith("jpeg") || fileName.endsWith("png") || fileName.endsWith("gif")) {
            r = new ResultVO(1,"恭喜你，图片上传成功！",(Object)url);
        }else{
            r = new ResultVO(2,"恭喜你，视频上传成功！",(Object)url);
        }
        PrintWriter out = resp.getWriter();
        out.print(JsonUtil.toJson(JsonUtil.toJson(r)));
    }

    protected void deleteFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        fileName = fileName.substring(fileName.lastIndexOf("/")+1);
        ResultVO r = null;
        if (fileName.endsWith("jpg") || fileName.endsWith("jpeg") || fileName.endsWith("png") || fileName.endsWith("gif")) {
            r = new ResultVO(1,"恭喜你，图片删除成功！",null);
        }else{
            r = new ResultVO(2,"恭喜你，视频删除成功！",null);
        }
        PrintWriter out = resp.getWriter();
        String res = JsonUtil.toJson(r);
        out.print(JsonUtil.toJson(res));
    }

    protected void removeFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        fileName = fileName.substring(fileName.lastIndexOf("/")+1);
        System.out.println(fileName);
        File file = new File("D:\\Stu_System\\MyEdu\\"+fileName);
        file.delete();
        ResultVO v = null;
        if(fileName.endsWith("jpg") || fileName.endsWith("png") || fileName.endsWith("jpeg") || fileName.endsWith("gif")){
            v = new ResultVO(1,"图片删除成功",null);
        }else{
            v = new ResultVO(2,"视频删除成功",null);
        }
        PrintWriter out = resp.getWriter();
        out.print(JsonUtil.toJson(v));
        out.close();
    }

    protected void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //一次性获取请求体中所有数据
        Map<String,String[]> map = req.getParameterMap();
        //将map集合解析成对应的实体
        Course c = new Course();
        BeanUtils.populate(c,map);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = df.format(new Date());
        System.out.println(createTime);
        c.setCreateTime(createTime);
        c.setCourseImage(c.getCourseImage().substring(c.getCourseImage().lastIndexOf("/")+1));
        c.setCourseVideo(c.getCourseVideo().substring(c.getCourseVideo().lastIndexOf("/")+1));
        String res = cs.addCourse(c);
        PrintWriter out = resp.getWriter();
        out.print(res);
        out.close();
    }

    protected void deleteCourse(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String cids = req.getParameter("cids");
        String res = cs.deleteCourse(cids);
        PrintWriter out = resp.getWriter();
        out.print(res);
    }

    protected void updateCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //一次性获取请求体中所有数据
        Map<String,String[]> map = req.getParameterMap();
        //将map集合解析成对应的实体
        Course c = new Course();
        BeanUtils.populate(c,map);
        c.setCourseImage(c.getCourseImage().substring(c.getCourseImage().lastIndexOf("/")+1));
        c.setCourseVideo(c.getCourseVideo().substring(c.getCourseVideo().lastIndexOf("/")+1));
        String res = cs.updateCourse(c);
        PrintWriter out = resp.getWriter();
        out.print(res);
    }
}


