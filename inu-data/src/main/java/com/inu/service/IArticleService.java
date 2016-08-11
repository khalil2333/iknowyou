package com.inu.service;

import com.inu.mybatis.model.Article;

/**
 * Created by potato on 2016/8/11.
 */
public interface IArticleService {
    /**
     * 根据情绪值返回一篇文章
     * @param degree 情绪值
     * @return
     */
    public Article getArticle(double degree);
}
