package com.webank.inu.data.service.imp;

import com.webank.inu.data.dto.ArticleDTO;
import com.webank.inu.data.mybatis.model.Article;
import com.webank.inu.data.service.IArticleService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;
import java.util.Random;

/**
 * Created by potato on 2016/8/11.
 */
public class ArticleServiceImp implements IArticleService {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }



    public ArticleDTO getArticle(double degree) {

        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Article> articleList = session.selectList("getArticle", degree);
            if(articleList!=null){
                //随机选择一篇文章
                int max = articleList.size();
                Random random = new Random();
                int ranNum = random.nextInt(max);
                Article article = articleList.get(ranNum);

                return makeArticle(article);
            }
        } finally {
            session.close();
        }

        return null;
    }

    private ArticleDTO makeArticle(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setDegreeMax(article.getDegreeMax());
        articleDTO.setDegreeMin(article.getDegreeMin());
        articleDTO.setUrl(article.getUrl());
        articleDTO.setTitle(article.getTitle());
        articleDTO.setDescription(article.getDescription());
        articleDTO.setPicUrl(article.getPicUrl());
        articleDTO.setContent(article.getContent());

        return articleDTO;
    }


}
