/*
 * Copyright 2017-2025 Fred Feng (paganini.fy@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.vortex.tsdb;

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
