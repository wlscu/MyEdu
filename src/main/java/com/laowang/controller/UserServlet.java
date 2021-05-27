package com.laowang.controller;

import com.laowang.entity.ResultVO;
import com.laowang.entity.User;
import com.laowang.service.impl.UserServiceImpl;
import com.laowang.util.JsonUtil;
import com.laowang.util.PageUtil;
import com.laowang.util.VerifyCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author 隔壁老王
 */

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    UserServiceImpl us = new UserServiceImpl();

    protected void loginUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        //调用UserServiceImpl方法获取json对象
        String res = us.loginUser(session, username, password, code);
        PrintWriter out = resp.getWriter();
        out.print(res);
    }

    protected void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String res = JsonUtil.toJson(user);
        PrintWriter out = resp.getWriter();
        out.print(res);
        out.close();
    }

    protected void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        Integer status = Integer.valueOf(req.getParameter("status"));
        Integer role = Integer.valueOf(req.getParameter("role"));
        Integer age = Integer.valueOf(req.getParameter("age"));
        Integer sex = Integer.valueOf(req.getParameter("sex"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        String createTime = df.format(new Date());
        User user = new User(null,name,phone,age,sex,username,password,status,createTime,role,null);
        String res = us.addUser(user);
        PrintWriter out = resp.getWriter();
        out.print(res);
    }

    protected void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer uid = Integer.valueOf(req.getParameter("uid"));
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        Integer status = Integer.valueOf(req.getParameter("status"));
        Integer role = Integer.valueOf(req.getParameter("role"));
        Integer age = Integer.valueOf(req.getParameter("age"));
        Integer sex = Integer.valueOf(req.getParameter("sex"));
        User user = new User(uid,name,phone,age,sex,username,password,status,null,role,null);
        String res = us.updateUser(user);
        PrintWriter out = resp.getWriter();
        out.print(res);
    }

    protected void delAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uids = req.getParameter("uids");
        String res = us.delAllUser(uids);
        PrintWriter out = resp.getWriter();
        out.print(res);
    }

    protected void logoutUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        ResultVO r = new ResultVO(200, "退出登陆成功！", null);
        PrintWriter out = resp.getWriter();
        out.print(JsonUtil.toJson(r));
    }

    protected void getImageCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成字符串
        String verCode = VerifyCodeUtils.generateVerifyCode(4);
        //将生成的验证码保存起来，用户后与用户输入的相对比
        HttpSession session = req.getSession();
        //将之前的验证码清楚掉（看不清，换一张）
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verCode);
        //将验证码生成图片输出
        int w = 100, h = 30;
        VerifyCodeUtils.outputImage(w, h, resp.getOutputStream(), verCode);
    }

    protected void getUserByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        int rows = Integer.parseInt(req.getParameter("rows"));
        String username = req.getParameter("username");
        int countRows = us.getCountRows(username);
        PageUtil pu = new PageUtil(page, rows, countRows);
        List<User> list = us.getUserByPage(pu,username);
        pu.setList(list);
        String res = JsonUtil.toJson(pu);
        System.out.println(res);
        PrintWriter out = resp.getWriter();
        out.print(res);
    }
}
