package com.inu.service;

import com.inu.dto.ArticleDTO;
import com.inu.service.imp.ArticleServiceImp;
import org.junit.Test;

/**
 * Created by potato on 2016/8/11.
 */
public class TestArticleService {
    ArticleServiceImp articleServiceImp = new ArticleServiceImp();

    @Test
    public void getArticleTest() {
        ArticleDTO articleDTO = articleServiceImp.getArticle(0.5);
        System.out.println(articleDTO.getId());
    }
}
