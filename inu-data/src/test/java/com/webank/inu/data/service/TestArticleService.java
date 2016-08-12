package com.webank.inu.data.service;

import com.webank.inu.data.dto.ArticleDTO;
import com.webank.inu.data.service.imp.ArticleServiceImp;
import org.junit.Test;

/**
 * Created by potato on 2016/8/11.
 */
public class TestArticleService {
    ArticleServiceImp articleServiceImp = new ArticleServiceImp();

    @Test
    public void getArticleTest() {
        ArticleDTO articleDTO = articleServiceImp.getArticle(0.9);
        System.out.println(articleDTO.getId());
    }

    @Test
    public void getArticleByIdTest() {
        ArticleDTO articleDTO = articleServiceImp.getArticleById(45);
        System.out.println("id:"+ articleDTO.getId() + ",内容:" + articleDTO.getContent());
    }

}
