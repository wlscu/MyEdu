package com.laowang.dao.impl;

import com.laowang.dao.UserDao;
import com.laowang.entity.User;
import com.laowang.util.PageUtil;
import com.laowang.util.QueryRunnerUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 隔壁老王
 */
public class UserDaoImpl implements UserDao {
    QueryRunner qr = QueryRunnerUtil.getQueryRunner();

    @Override
    public int addUser(User u) {
        int rows = 0;
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            rows = qr.update(sql, null, u.getName(), u.getPhone(), u.getAge(), u.getSex(), u.getUsername(), u.getPassword(), u.getStatus(), u.getCreateTime(), u.getRole(), u.getPicture());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delAllUser(String uids) {
        int rows = 0;
        String sql = "delete from user where uid in ("+uids+")";
        try {
            rows = qr.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public User loginUser(String username, String password) {
        User user = null;
        String sql = "select * from user where username=? and password=?";
        try {
            user = qr.query(sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public int getCountRows(String username) {
        int countRows = 0;
        String sql = "select count(*) from user where username like '%"+username+"%'";
        try {
            countRows = (int) (long) qr.query(sql, new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public List<User> getUserByPage(PageUtil pu,String username) {
        List<User> list = null;
        String sql = "select * from user where username like '%"+username+"%' limit ?,?";
        try {
            list = qr.query(sql, new BeanListHandler<>(User.class), pu.getIndex(), pu.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
