package com.github.vortex.tsd;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @Description: TsdQueryVo
 * @Author: Fred Feng
 * @Date: 04/01/2025
 * @Version 1.0.0
 */
@Getter
@Setter
public class TsdQueryVo {

    private String dataType;
    private String category;
    private String dimension;
    private Map<String, Object> data;
}
