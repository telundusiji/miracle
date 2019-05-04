package site.teamo.miracle.photograph.dao.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.teamo.miracle.photograph.dao.repository.PhotoRepository;
import site.teamo.miracle.photograph.domain.bean.Photo;
import site.teamo.miracle.util.mds.DataProcessor;

/**
 * @author haocongshun
 * create on 2018/12/27 14:16
 */
@Component
public class PhotoEsProcessor implements DataProcessor {
    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public void handle(Object o) {
        Photo photo = (Photo)o;
        photoRepository.save(photo);
    }
}
