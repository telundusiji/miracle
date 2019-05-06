package site.teamo.miracle.blog.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import site.teamo.miracle.blog.service.TagService;

/**
 * @author haocongshun
 * create on 2019/5/6 16:47
 */
@Service("TagService")
public class TagServiceImpl implements TagService {
    @Override
    public JSONObject getTag(String tag) {
        return null;
    }

    @Override
    public JSONArray getTags() {
        return null;
    }
}
