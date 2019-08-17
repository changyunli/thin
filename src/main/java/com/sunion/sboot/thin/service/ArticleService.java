package com.sunion.sboot.thin.service;

import com.sunion.sboot.thin.dao.ArticleMapper;
import com.sunion.sboot.thin.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/8/16.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public Article getById(int id){
        System.out.println("id:  "+id);
        return articleMapper.findById(id);
    }

}
