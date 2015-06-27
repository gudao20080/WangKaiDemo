package com.wk.greendao.bean;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.wk.greendao.bean.Employee;
import com.wk.greendao.bean.User;

import com.wk.greendao.bean.EmployeeDao;
import com.wk.greendao.bean.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig employeeDaoConfig;
    private final DaoConfig userDaoConfig;

    private final EmployeeDao employeeDao;
    private final UserDao userDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        employeeDaoConfig = daoConfigMap.get(EmployeeDao.class).clone();
        employeeDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        employeeDao = new EmployeeDao(employeeDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Employee.class, employeeDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        employeeDaoConfig.getIdentityScope().clear();
        userDaoConfig.getIdentityScope().clear();
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
