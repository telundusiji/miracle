package site.teamo.miracle.util.tools;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author haocongshun
 * create on 2019/1/10 15:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Field {
    private String dbName;
    private String esName;
    private String requestName;
    private String responseName;
    private int index;
    private String type;
}
