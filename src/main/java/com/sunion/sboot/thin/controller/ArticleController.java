package com.sunion.sboot.thin.controller;

import com.sunion.sboot.thin.domain.Article;
import com.sunion.sboot.thin.domain.Resource;
import com.sunion.sboot.thin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/8/14.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private Resource resource;

//    注入redis
    @javax.annotation.Resource
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 测试redis是否链接成功
     * **/
    @RequestMapping("/redisArticle/{id}")
    @ResponseBody
    public Article redisArticle(@PathVariable("id")int id){

        redisTemplate.opsForValue().set("id",id);
        redisTemplate.opsForValue().set("title","人");
        redisTemplate.opsForValue().set("content","我是中国人");

        Article article=new Article();
        int ids=(int)redisTemplate.opsForValue().get("id");
        article.setId(ids);
        article.setTitle(redisTemplate.opsForValue().get("title").toString());
        article.setContent(redisTemplate.opsForValue().get("content").toString());

        System.out.println(article);
        return article;
    }
    /**
     * 测试mybatis与springboot
     * **/
    @RequestMapping("/getArticleId")
    @ResponseBody
    public Article findByID(@RequestParam("id")int id){
        Article article=articleService.getById(id);
        System.out.println("id: "+article.getId()+"title: "+article.getTitle()+"content: "+article.getContent());
        return article;
    }

    /**
     * 测试thymeleaf模板
     * **/
    @RequestMapping("/thymeleaf")
    public String content(ModelMap modelMap){
        modelMap.addAttribute("name","thymeleaf...");
        return "thymeleaf/content";
    }
    @RequestMapping("/index")
    public String getIndex(){
        return "thymeleaf/index";
    }

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
