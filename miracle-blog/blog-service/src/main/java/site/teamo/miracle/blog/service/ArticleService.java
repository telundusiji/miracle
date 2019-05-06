package site.teamo.miracle.blog.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author haocongshun
 * create on 2019/5/6 16:37
 */
public interface ArticleService {
    JSONObject getArticleByArticleKey(String articleKey);
    JSONArray getArticlesByArticleKeys(List<String> articleKeys);
    JSONArray getArticlesByCategory(String category);
    JSONArray getArticlesByTag(String tag);
}
