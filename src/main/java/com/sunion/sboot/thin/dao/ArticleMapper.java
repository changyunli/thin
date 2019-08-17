package com.sunion.sboot.thin.dao;

import com.sunion.sboot.thin.domain.Article;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2019/8/16.
 */
public interface ArticleMapper {

//    根据id查询article
    Article findById(@Param(value = "id")Integer id);
}
