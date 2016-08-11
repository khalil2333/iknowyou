package com.inu.service.imp;

import com.inu.dto.ArticleDTO;
import com.inu.service.IArticleService;

/**
 * Created by potato on 2016/8/11.
 */
public class ArticleServiceImp implements IArticleService {

    public ArticleDTO getArticle(double degree) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(11);
        articleDTO.setDegreeMax(1);
        articleDTO.setDegreeMin(0);
        articleDTO.setDescription("一篇文章");
        articleDTO.setTitle("文章");
        articleDTO.setUrl("http://www.baidu.com");

        return articleDTO;
    }

}
