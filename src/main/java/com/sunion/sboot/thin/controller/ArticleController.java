package com.sunion.sboot.thin.controller;

import com.sunion.sboot.thin.domain.Article;
import com.sunion.sboot.thin.domain.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/8/14.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private Resource resource;

    @RequestMapping("/resource")
    @ResponseBody
    public Resource getResource(){

        Resource bean=new Resource();

        bean.setName(resource.getName());
        bean.setLanguage(resource.getLanguage());
        bean.setWebsite(resource.getWebsite());

        return bean;
    }

    @RequestMapping("/getArticle/{id}")
    @ResponseBody
    public Article getArticle(@PathVariable("id")int id){
        System.out.println("id:  "+id);

        Article article=new Article();
        article.setId(id);
        article.setTitle("人物");
        article.setContent("我是中国人");

        return article;
    }
}
