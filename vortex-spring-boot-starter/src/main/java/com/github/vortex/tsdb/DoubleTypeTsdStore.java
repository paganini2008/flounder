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

import java.util.Arrays;
import java.util.function.Consumer;
import com.github.doodler.common.timeseries.NumberMetric;
import com.github.doodler.common.timeseries.NumberMetrics;
import com.github.doodler.common.timeseries.StringSimpleUserSamplerService;
import com.github.doodler.common.timeseries.UserSampler;
import com.github.doodler.common.timeseries.UserSamplerImpl;
import com.github.doodler.common.utils.ConvertUtils;
import com.github.doodler.common.utils.TimeWindowUnit;

/**
 * 
 * @Description: DoubleTypeTsdStore
 * @Author: Fred Feng
 * @Date: 02/01/2025
 * @Version 1.0.0
 */
public class DoubleTypeTsdStore extends StringSimpleUserSamplerService<NumberMetric<Double>>
        implements TsdStore<NumberMetric<Double>> {

    public DoubleTypeTsdStore(int span, TimeWindowUnit timeWindowUnit, int maxSize,
            TsdOverflowDataHandler<NumberMetric<Double>> dataManager) {
        super(span, timeWindowUnit, maxSize, Arrays.asList(dataManager));
    }

    @Override
    public String getDataType() {
        return "double";
    }

    @Override
    public void store(String category, String dimension, long timestamp,
            Consumer<UserSampler<NumberMetric<Double>>> consumer) {
        collect(category, dimension, timestamp, consumer);
    }

    @Override
    public UserSampler<NumberMetric<Double>> getEmptySampler(String category, String dimension,
            long timestamp) {
        return new UserSamplerImpl<>(timestamp, NumberMetrics.nullDoubleMetric(timestamp));
    }

    @Override
    public DataConverter<NumberMetric<Double>> getDataConverter() {
        return (value, packet) -> {
            Double acutalValue = ConvertUtils.convert(value, Double.class);
            return NumberMetrics.valueOf(acutalValue, packet.getTimestamp());
        };
    }
}
