package com.wangkai.wkdemo.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.wangkai.wkdemo.bean.User;
import com.wangkai.wkdemo.db.AppDbHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * User: WangKai(123940232@qq.com)
 * 2014-12-19 17:45
 */
public class UserDao {
    private AppDbHelper helper;

    private Dao<User, Integer> userDao;


    public UserDao(Context context) {

        helper = AppDbHelper.getAppDbHelper(context);

        userDao = helper.getUserDao();
    }

    /**
     * @param user
     */
    public void add(User user) {

        try {

            userDao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(User user) {
        try {
            userDao.delete(user);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(List<User> list) {
        try {
            userDao.delete(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        try {
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {

        List<User> users = null;
        try {
            users = userDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }


    public void releaseHelper() {

    }

}
