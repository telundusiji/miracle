package site.teamo.miracle.blog.core;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

@Component
public class BlogContext {

    private Map<String, JSONObject> articleInfos = new HashMap<>();

    private Map<String, String> articleContents = new HashMap<>();

    private Map<String, List<String>> categoryInfos = new HashMap<>();

    private List<String> articleIds = new ArrayList<>();

    private Map<String, List<String>> tagInfos = new HashMap<>();

    public void init(String articlePath) {
        loadArticles(articlePath);
    }

    private void loadArticles(String articlePath) {
        File[] articles = new File(articlePath).listFiles();
        for (File article : articles) {

            File[] articleInfoFile = article.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".json");
                }
            });
            if (articleInfoFile.length != 1) {
                continue;
            }
            JSONObject articleInfo = null;
            try {
                articleInfo = JSONObject.parseObject(FileUtils.readFileToString(articleInfoFile[0], Charsets.toCharset("utf-8")));
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            File[] articleContentFile = article.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".md");
                }
            });
            if (articleContentFile.length != 1) {
                continue;
            }
            String articleContent = null;
            try {
                articleContent = FileUtils.readFileToString(articleContentFile[0], Charsets.toCharset("utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String articleKey = articleInfo.getString("name");
            if (StringUtils.isEmpty(articleKey)) {
                continue;
            }
            articleInfos.put(articleKey, articleInfo);
            articleContents.put(articleKey, articleContent);
            articleIds.add(articleKey);

        }
        for(Map.Entry<String,JSONObject> entry:articleInfos.entrySet()){
            String category = entry.getValue().getString("category");
            addToMap(category,entry.getKey(),categoryInfos);
            String[] tags = entry.getValue().getString("tags").split(",");
            for (String tag : tags){
                addToMap(tag,entry.getKey(),tagInfos);
            }
        }
    }
    private static void addToMap(String key,String value,Map<String,List<String>> map){
        if(map.containsKey(key)){
            map.get(key).add(value);
        }else {
            List<String> list = new ArrayList<>();
            list.add(value);
            map.put(key,list);
        }
    }

    public void addArticle(JSONObject articleInfo,String content){

    }

}
