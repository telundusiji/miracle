package site.teamo.miracle.util.tools;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author haocongshun
 * create on 2019/1/10 15:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entity {
    private String name;
    private List<Field> fields;
}
