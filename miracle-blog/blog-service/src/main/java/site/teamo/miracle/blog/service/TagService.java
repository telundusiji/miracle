package site.teamo.miracle.blog.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author haocongshun
 * create on 2019/5/6 16:38
 */
public interface TagService {
    JSONObject getTag(String tag);
    JSONArray getTags();
}
