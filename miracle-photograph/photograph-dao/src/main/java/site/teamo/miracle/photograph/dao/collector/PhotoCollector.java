package site.teamo.miracle.photograph.dao.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.teamo.miracle.photograph.dao.processor.PhotoDbProcessor;
import site.teamo.miracle.photograph.dao.processor.PhotoEsProcessor;
import site.teamo.miracle.photograph.domain.bean.Photo;
import site.teamo.miracle.util.constant.MiracleConstant;
import site.teamo.miracle.util.exception.DataCollectorCheckException;
import site.teamo.miracle.util.mds.DataCollector;
import site.teamo.miracle.util.mds.DataProcessor;

/**
 * @author haocongshun
 * create on 2018/12/27 14:22
 */
@Component
public class PhotoCollector extends DataCollector<Photo> {
    @Autowired
    public PhotoCollector(PhotoEsProcessor photoEsProcessor, PhotoDbProcessor photoDbProcessor) {
        super.addProcessor(photoEsProcessor);
        super.addProcessor(photoDbProcessor);
    }

    @Override
    public void notifyProcessor(Photo photo) throws DataCollectorCheckException {
        checkPhoto(photo);
        Object[] arrLocal;

        synchronized (this) {
            arrLocal = dps.toArray();
        }
        for (int i = arrLocal.length - 1; i >= 0; i--) {
            ((DataProcessor) arrLocal[i]).handle(photo);
        }
    }

    private static void checkPhoto(Photo p) throws DataCollectorCheckException {
        //TODO Photo实体检查
        if (p == null) {
            throw new DataCollectorCheckException("photo is null", p);
        }
    }

}
