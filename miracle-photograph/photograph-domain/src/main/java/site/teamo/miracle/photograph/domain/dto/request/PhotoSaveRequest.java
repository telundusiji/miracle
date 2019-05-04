package site.teamo.miracle.photograph.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author haocongshun
 * create on 2018/12/25 11:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoSaveRequest {
    String id;
    String url;
}
