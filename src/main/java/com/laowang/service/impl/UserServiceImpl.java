package com.laowang.service.impl;

import com.laowang.dao.impl.UserDaoImpl;
import com.laowang.entity.ResultVO;
import com.laowang.entity.User;
import com.laowang.service.UserService;
import com.laowang.util.JsonUtil;
import com.laowang.util.PageUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 隔壁老王
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl ud = new UserDaoImpl();

    @Override
    public String addUser(User u) {
        ResultVO r;
        int rows = ud.addUser(u);
        if (rows == 0){
            //注册失败有误
            r = new ResultVO(0,"添加失败，请稍后重试！",null);
        }else{
            //注册成功
            r = new ResultVO(1,"恭喜你，添加成功！",null);
        }
        return JsonUtil.toJson(r);
    }

    @Override
    public String updateUser(User u) {
        ResultVO r;
        int rows = ud.updateUser(u);
        if (rows == 0){
            //修改失败有误
            r = new ResultVO(0,"修改失败，请稍后重试！",null);
        }else{
            //修改成功
            r = new ResultVO(1,"恭喜你，修改成功！",null);
        }
        return JsonUtil.toJson(r);
    }

    @Override
    public String delAllUser(String uids) {
        ResultVO r;
        int rows = ud.delAllUser(uids);
        if (rows == 0){
            //删除失败有误
            r = new ResultVO(0,"删除失败，请稍后重试！",null);
        }else{
            //删除成功
            r = new ResultVO(1,"恭喜你，删除成功！",null);
        }
        return JsonUtil.toJson(r);
    }

    @Override
    public String loginUser(HttpSession session,String username, String password, String code) {
        String res = "";
        ResultVO r = null;
        String verCode = (String) session.getAttribute("verCode");
        if (code.equals(verCode)){
            // 验证码正确
            User user = ud.loginUser(username,password);
            if (user == null){
                //帐号密码有误
                r = new ResultVO(2,"帐号或密码错误！",null);
            }else{
                if (user.getStatus() != 1){
                    //状态是禁用的
                    r = new ResultVO(3,"帐号未启用，请联系系统管理员！",null);
                }else if(user.getRole() != 1){
                    //没有权限
                    r = new ResultVO(4,"该账号没有权限，请联系工作人员！",null);
                }else{
                    //传递用户登录信息
                    session.setAttribute("user",user);
                    r = new ResultVO(5,"恭喜你，登录成功！",null);
                }
            }
        }else{
            // 验证码失败
            r = new ResultVO(1,"验证码错误！",null);
        }
        res = JsonUtil.toJson(r);
        return res;
    }

    @Override
    public int getCountRows(String username) {
        return ud.getCountRows(username);
    }

    @Override
    public List<User> getUserByPage(PageUtil pu,String username) {
        return ud.getUserByPage(pu,username);
    }
}
