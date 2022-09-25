package com.lsaac.job;

import com.lsaac.domain.entity.Article;
import com.lsaac.service.ArticleService;
import com.lsaac.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UpdateViewCountJob  {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ArticleService articleService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void updateViewCount(){
        //获取redis中的浏览量
        Map<String, Integer> viewCountMap = redisCache.getCacheMap("article:viewCount");
        List<Article> articles = viewCountMap.entrySet().stream().map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue())).collect(Collectors.toList());
        //更新数据到数据库
        articleService.updateBatchById(articles);
    }
}
