package com.wangkai.wkdemo.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.wangkai.wkdemo.bean.Credit;
import com.wangkai.wkdemo.db.AppDbHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * User: WangKai(123940232@qq.com)
 * 2014-12-18 11:04
 */
public class CreditDao {
    private Context context;

    public CreditDao(Context context) {
        this.context = context;
    }

    public void add(Credit credit) throws SQLException {
        AppDbHelper dbHelper = AppDbHelper.getAppDbHelper(context);
        Dao<Credit, Integer> creditDao = dbHelper.getCreditDao();
        creditDao.create(credit);

    }

    public List<Credit> getCredits(){
        List<Credit> credits = null;
        try {
            AppDbHelper dbHelper = AppDbHelper.getAppDbHelper(context);
            Dao<Credit, Integer> creditDao = dbHelper.getCreditDao();


            credits = creditDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credits;
    }


}
