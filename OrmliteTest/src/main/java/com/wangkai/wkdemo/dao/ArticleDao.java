package com.wangkai.wkdemo.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.wangkai.wkdemo.bean.Article;
import com.wangkai.wkdemo.bean.User;
import com.wangkai.wkdemo.db.AppDbHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * User: WangKai(123940232@qq.com)
 * 2014-12-23 18:07
 */
public class ArticleDao {
    private Context context;
    private AppDbHelper helper;
    private Dao dao;

    public ArticleDao(Context context) {
        this.context = context;
        helper = AppDbHelper.getAppDbHelper(context);
        try {
            dao = helper.getDao(Article.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Article article) {
        try {

            dao.create(article);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Article getArticleWithUser(int id) {
        try {
            Article article = (Article) dao.queryForId(id);
            Dao userDao = helper.getDao(User.class);
            userDao.refresh(article.getUser());
            return article;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Article get(int id) {
        try {
            Article article = (Article) dao.queryForId(id);
            return article;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Article> getArticlesByid(int id) {
        try {
            List<Article> articles = dao.queryBuilder().where().eq("user_id", id).query();
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
