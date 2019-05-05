package site.teamo.miracle.blog.core;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

@ComponentScan
public class BlogContext {

    private Map<String, JSONObject> articleInfos = new HashMap<>();

    private Map<String, String> articleContents = new HashMap<>();

    private Map<String, List<String>> categoryInfos = new HashMap<>();

    private List<String> articleIds = new ArrayList<>();

    private Map<String, List<String>> tagInfos = new HashMap<>();

    private void init(String articlePath, String articleZipPath) {
        loadArticles(articlePath);
    }

    public void loadArticles(String articlePath) {
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
    }
}
