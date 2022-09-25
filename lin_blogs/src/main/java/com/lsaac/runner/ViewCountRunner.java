package com.lsaac.runner;

import com.lsaac.domain.entity.Article;
import com.lsaac.mapper.ArticleMapper;
import com.lsaac.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.data.redis.cache.RedisCache;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ViewCountRunner implements CommandLineRunner {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private RedisCache redisCache;


    //在程序启动时将文章浏览量存入redis中
    @Override
    public void run(String... args) throws Exception {
        //查询博客信息id viewCount
        List<Article> articles = articleMapper.selectList(null);
   /*
        articles.stream().collect(Collectors.toMap(new Function<Article, Long>() {
            @Override
            public Long apply(Article) {
                return article.getId();
            }
        }, new Function<Article, Integer>() {
            @Override
            public Integer apply(Article) {
                return article.getViewCount().intValue();
            }
        }));
    */
        Map<String, Integer> viewCountMap = articles.stream().collect(Collectors.toMap(article -> article.getId().toString(), article -> article.getViewCount().intValue()));
        //存储到redis
        redisCache.setCacheMap("article:viewCount",viewCountMap);

    }
}
