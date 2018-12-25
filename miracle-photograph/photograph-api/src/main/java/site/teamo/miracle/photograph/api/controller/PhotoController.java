package site.teamo.miracle.photograph.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.teamo.miracle.photograph.domain.bean.Photo;
import site.teamo.miracle.photograph.domain.dto.request.PhotoSaveRequest;
import site.teamo.miracle.photograph.service.PhotoService;

/**
 * @author haocongshun
 * create on 2018/12/25 10:59
 */
@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    private PhotoService photoService;
    @RequestMapping("/save")
    public String save(@RequestBody @Validated PhotoSaveRequest photoSaveRequest){
        return photoService.save(Photo.builder().id(photoSaveRequest.getId()).url(photoSaveRequest.getUrl()).build());
    }
}
