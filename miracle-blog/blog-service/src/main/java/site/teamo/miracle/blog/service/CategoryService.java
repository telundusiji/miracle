package site.teamo.miracle.blog.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author haocongshun
 * create on 2019/5/6 16:39
 */
public interface CategoryService {
    JSONObject getCategory(String category);
    JSONArray getCategories();
}
