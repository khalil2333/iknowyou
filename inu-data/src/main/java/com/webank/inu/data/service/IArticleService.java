package com.webank.inu.data.service;

import com.webank.inu.data.dto.ArticleDTO;

/**
 * Created by potato on 2016/8/11.
 */
public interface IArticleService {
    /**
     * 根据情绪值返回一篇文章
     * @param degree 情绪值
     * @return
     */
    public ArticleDTO getArticle(double degree);

    /**
     * 根据id获取对应文章内容
     * @param id
     * @return
     */
    public ArticleDTO getArticleById(int id);
}
