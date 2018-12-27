package site.teamo.miracle.photograph.dao.mapper;

import org.springframework.stereotype.Component;
import site.teamo.miracle.photograph.domain.bean.Photo;

/**
 * @author haocongshun
 * create on 2018/12/27 14:29
 */
@Component
public interface PhotoMapper {
    int insert(Photo photo);
}
