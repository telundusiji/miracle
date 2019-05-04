package site.teamo.miracle.util.tools;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
;
import java.util.ArrayList;
import java.util.List;


/**
 * @author haocongshun
 * create on 2019/1/9 20:47
 */
public class MiracleBean {

    private static List<Entity> entities = new ArrayList<>();

    public static Entity getEntity(String name) throws Exception {
        if(entities.size()==0){
            init();
        }
        for(Entity entity:entities){
            if(StringUtils.equals(entity.getName(),name)){
                return entity;
            }
        }
        return null;
    }
    public static void init() throws Exception {
        Yaml yaml = new Yaml();
        InputStream input = MiracleBean.class.getClassLoader().getResourceAsStream("schemas.yml");
        if(input==null){
            throw new Exception("");
        }
        for (Object data:yaml.loadAll(input)){
            String json = JSONObject.toJSONString(data);
            entities.add(JSONObject.parseObject(json,Entity.class));
        }
    }
    public static <T> T toRequest(Object from,Entity entity,Class<T> tClass) throws Exception {
        List<Field> fields = entity.getFields();
        for(Field field:fields){
            
        }
        ArrayList<T> arrayList = new ArrayList<>();
        return (T) arrayList;
    }

    public static void main(String[] args) throws Exception {
        init();
    }
}
