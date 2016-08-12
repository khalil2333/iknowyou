package com.webank.inu.logic.service.message.impl;

import com.webank.inu.data.dto.ArticleDTO;
import com.webank.inu.data.mybatis.model.Article;
import com.webank.inu.data.service.IArticleService;
import com.webank.inu.data.service.IUserService;
import com.webank.inu.data.service.imp.ArticleServiceImp;
import com.webank.inu.data.service.imp.UserServiceImp;
import com.webank.inu.logic.pstream.context.PStreamContext;
import com.webank.inu.logic.pstream.handler.StreamFinishListener;
import com.webank.inu.logic.pstream.process.PStream;
import com.webank.inu.logic.service.handler.Classify.TextClassifyHandler;
import com.webank.inu.logic.service.handler.Sentiment.TextSentimentHandler;
import com.webank.inu.logic.service.message.IMessageService;
import com.webank.inu.logic.service.message.ResponseInfo;
import com.webank.inu.logic.service.message.SingleArticleInfo;
import com.webank.inu.logic.utils.ConfigInfo;

/**
 * Created by adam on 2016/8/11.
 */
public class BaseMessageServiceImpl implements IMessageService {
    private ConfigInfo configInfo = ConfigInfo.getInstance();

    private IArticleService articleService = new ArticleServiceImp();

    private IUserService userService = new UserServiceImp();

    public ResponseInfo processMessage(String openId,String message, int responseType) {
        ResponseInfo responseInfo = null;

        switch(responseType){
            case ResponseType.music:
                responseInfo = processMusic(openId,message);
                break;
            case ResponseType.news:
                responseInfo = processNews(openId,message);
                break;

            case ResponseType.picture:

                break;

            case ResponseType.text:
                responseInfo = processText(openId,message);
                break;

            case ResponseType.video:

                break;

            case ResponseType.voice:

                break;
        }

        //异步插入数据
//        asynInsertMsg(openId,message);

        //公共信息部分
        responseInfo.setToUserName(openId);
        responseInfo.setFromUserName(configInfo.getWXDevelopName());
        responseInfo.setCreateTime(System.currentTimeMillis());

        return responseInfo;
    }

    public SingleArticleInfo queryArticleById(int articleId) {
        ArticleDTO article = articleService.getArticleById(articleId);
        SingleArticleInfo singleArticleInfo = new SingleArticleInfo();
        singleArticleInfo.setContent(article.getContent());
        singleArticleInfo.setPicUrl(article.getPicUrl());
        singleArticleInfo.setTitle(article.getTitle());
        return singleArticleInfo;
    }

    protected void asynInsertMsg(final String openId, final String message, final float sentimentScore){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("插入数据："+message);
                userService.insertUserMessage(openId,message,System.currentTimeMillis(),sentimentScore);
            }
        });

        thread.start();
    }

    protected ResponseInfo processMusic(String openId,String message){
        ResponseInfo responseInfo = null;

        return null;
    }

    protected ResponseInfo processNews(final String openId,final String message){
        final ResponseInfo responseInfo = new ResponseInfo();

        PStream pStream = new PStream();
//        pStream.addHandler(new MessagePersistentHandler());
        pStream.addHandler(new TextSentimentHandler());
        //messagePersistent放最后面会报错
//        pStream.addHandler(new MessagePersistentHandler());
        pStream.addHandler(new TextClassifyHandler());

        //异步插入消息到数据库

        pStream.process(message);
        pStream.synFinish(new StreamFinishListener() {
            public Object actionFinish(PStreamContext context) {
                float sentimentScore = (Float) context.getAttribute(TextSentimentHandler.SENTIMENT_SCORE);
                String classfiyClass = (String) context.getAttribute(TextClassifyHandler.CLASSIFY_CLASS);
                int classNum = (Integer) context.getAttribute(TextClassifyHandler.CLASSIFY_NUM);

                System.out.println(sentimentScore+" : "+classfiyClass + ":"+classNum);
                //异步插入数据
                asynInsertMsg(openId,message,sentimentScore);
                //调用dao获得图文信息
                Article article = articleService.getArticle(sentimentScore);
                responseInfo.setTitle(article.getTitle());
                responseInfo.setDescription(article.getDescription());
                responseInfo.setPicUrl(article.getPicUrl());
                String content = article.getContent();
                if (content == null || content.equals("")) {
                    responseInfo.setUrl(configInfo.getArticleURLPrex()+article.getId());
//                    responseInfo.setContent(article.getContent());
                }
                else responseInfo.setUrl(article.getUrl());

                return null;
            }
        });
        return responseInfo;
    }

    protected ResponseInfo processText(String openId,String message){
        ResponseInfo responseInfo = null;

        return responseInfo;
    }


}
