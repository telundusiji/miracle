package site.teamo.miracle.photograph.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.teamo.miracle.photograph.dao.repository.PhotoRepository;
import site.teamo.miracle.photograph.domain.bean.Photo;
import site.teamo.miracle.photograph.service.PhotoService;

/**
 * @author haocongshun
 * create on 2018/12/25 10:56
 */
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public String save(Photo photo) {

        return photoRepository.save(photo).getId();
    }

    @Override
    public Iterable<Photo> get(String id) {
        return photoRepository.findAll();
    }
}
