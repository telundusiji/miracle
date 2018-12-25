package site.teamo.miracle.photograph.domain.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author haocongshun
 * create on 2018/12/25 10:39
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "photo_index", type = "photo")
public class Photo implements Serializable {
    private static final long serialVersionUID = -1893372374521081122L;
    String id;
    String url;
}
