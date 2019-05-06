package site.teamo.miracle.blog.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.teamo.miracle.blog.dao.core.BlogContext;
import site.teamo.miracle.blog.service.ArticleService;
import site.teamo.miracle.blog.service.CategoryService;
import site.teamo.miracle.blog.service.TagService;

import java.util.List;

@CrossOrigin
@RestController
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogContext blogContext;

    @GetMapping("/blog/article")
    public JSONArray articles(){
        List<String> articles = blogContext.getArticleIds();
        JSONArray result = new JSONArray();
        articles.forEach((articleKey)->result.add(blogContext.getArticleInfo(articleKey)));
        return result;
    }

    @GetMapping("/blog/article/{articleName}")
    public JSONObject article(@PathVariable String articleName){
        return blogContext.getArticle(articleName);
    }

    @GetMapping("/category")
    public JSONArray categories(){
        return categoryService.getCategories();
    }

    @GetMapping("/category/{categoryName}")
    public JSONObject category(@PathVariable String categoryName){
        return categoryService.getCategory(categoryName);
    }

    @GetMapping("/tag")
    public JSONArray tags(){
        return tagService.getTags();
    }

    @GetMapping("/tag/{tagName}")
    public JSONObject tag(@PathVariable String tagName){
        return tagService.getTag(tagName);
    }



    @GetMapping("/category/{categoryName}/article")
    public JSONArray categoryArticles(@PathVariable String categoryName){
        return articleService.getArticlesByCategory(categoryName);
    }

    @GetMapping("/category/{categoryName}/article/{articleName}")
    public JSONObject categoryArticle(@PathVariable String categoryName,@PathVariable String articleName){
        JSONObject category = categoryService.getCategory(categoryName);

        return new JSONObject();
    }

    @GetMapping("/tag/{tagName}/article")
    public JSONArray tagArticles(@PathVariable String tagName){
        return tagService.getTags();
    }

    @GetMapping("/tag/{tagName}/article/{articleName}")
    public JSONObject tagArticle(@PathVariable String tagName,@PathVariable String articleName){
        return tagService.getTag(tagName);
    }
}
