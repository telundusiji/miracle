package site.teamo.miracle.photograph.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import site.teamo.miracle.photograph.domain.bean.Photo;

/**
 * @author haocongshun
 * create on 2018/12/25 10:42
 */
@Repository
public interface PhotoRepository extends ElasticsearchRepository<Photo,String> {
}
