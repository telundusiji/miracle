package site.teamo.miracle.blog;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONWriter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.sql.*;

public class DumpMysqlArticle {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://115.28.228.72:3306/miraclev120180129?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "2470893279";
        Connection con = DriverManager.getConnection(url, user, password);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM article");
        String path = "D:\\temp\\article\\";
        while (rs.next()){
            String title = rs.getString("title");
            System.out.println(title);
            File articleDir = new File(path+title);
            if(!articleDir.exists()){
                articleDir.mkdirs();
            }
            File articleMd = new File(path+title+"\\"+title+".md");
            File articleJson = new File(path+title+"\\"+title+".json");
            if(!articleMd.exists()){
                articleMd.createNewFile();
            }
            FileUtils.writeStringToFile(articleMd,rs.getString("text"),Charset.defaultCharset());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",rs.getString("title"));
            jsonObject.put("category",rs.getString("taxonomy_title"));
            jsonObject.put("tags",rs.getString("tags"));
            jsonObject.put("createTime",rs.getString("gmt_create"));
            if(!articleJson.exists()){
                articleJson.createNewFile();
            }
            FileUtils.writeStringToFile(articleJson,jsonObject.toJSONString(),Charset.defaultCharset());

        }

    }
}

