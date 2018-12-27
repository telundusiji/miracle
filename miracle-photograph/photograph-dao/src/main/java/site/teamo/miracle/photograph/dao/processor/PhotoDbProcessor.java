package site.teamo.miracle.photograph.dao.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.teamo.miracle.photograph.dao.mapper.PhotoMapper;
import site.teamo.miracle.photograph.domain.bean.Photo;
import site.teamo.miracle.util.mds.DataProcessor;

/**
 * @author haocongshun
 * create on 2018/12/27 14:28
 */
@Component
public class PhotoDbProcessor implements DataProcessor<Photo> {
    @Autowired
    private PhotoMapper photoMapper;
    @Override
    public void handle(Photo o) {
        if(!(o instanceof Photo)){
            return;
        }
        Photo photo = (Photo)o;
        photoMapper.insert(photo);
    }
}
