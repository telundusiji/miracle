package site.teamo.miracle.blog.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import site.teamo.miracle.blog.service.ArticleService;

import java.util.List;

/**
 * @author haocongshun
 * create on 2019/5/6 16:46
 */
@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
    @Override
    public JSONObject getArticleByArticleKey(String articleKey) {
        return null;
    }

    @Override
    public JSONArray getArticlesByArticleKeys(List<String> articleKeys) {
        return null;
    }

    @Override
    public JSONArray getArticlesByCategory(String category) {
        return null;
    }

    @Override
    public JSONArray getArticlesByTag(String tag) {
        return null;
    }
}
