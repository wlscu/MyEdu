package com.laowang.service;

import com.laowang.entity.User;
import com.laowang.util.PageUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 隔壁老王
 */
public interface UserService {
    /**
     * 用户添加
     *
     * @param u servlet生成的user对象
     * @return true为成功，false为失败
     */
    String addUser(User u);

    String delAllUser(String uids);

    /**
     * 用户登录
     *
     * @param username 登录填写的用户名
     * @param password 登录填写的密码
     * @return 通过帐号密码查询用户对象，true为有则登陆成功，false为失无则登录失败
     */
    String loginUser(HttpSession session, String username, String password, String code);

    int getCountRows(String username);

    List<User> getUserByPage(PageUtil pu,String username);

}
