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

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.doodler.common.events.Context;
import com.github.doodler.common.timeseries.NumberMetric;
import com.github.doodler.common.transmitter.Packet;

/**
 * 
 * @Description: DefaultTsdStoreHandler
 * @Author: Fred Feng
 * @Date: 02/01/2025
 * @Version 1.0.0
 */
@Component
public class DefaultTsdStoreHandler implements TsdStoreHandler {

    @Autowired
    private DecimalTypeTsdStore decimalTypeTsdStore;

    @Autowired
    private LongTypeTsdStore longTypeTsdStore;

    @Autowired
    private DoubleTypeTsdStore doubleTypeTsdStore;

    @Override
    public void consume(Packet packet, Context context) {
        String dataType = packet.getStringField("dataType");
        String category = packet.getStringField("category");
        String dimension = packet.getStringField("dimension");
        Object data = packet.getObject();
        switch (dataType.toLowerCase()) {
            case "long":
                NumberMetric<Long> longData =
                        longTypeTsdStore.getDataConverter().convert(data, packet);
                longTypeTsdStore.store(category, dimension, packet.getTimestamp(), s -> {
                    s.merge(longData);
                });
                break;
            case "decimal":
                NumberMetric<BigDecimal> decimalData =
                        decimalTypeTsdStore.getDataConverter().convert(data, packet);
                decimalTypeTsdStore.store(category, dimension, packet.getTimestamp(), s -> {
                    s.merge(decimalData);
                });
                break;
            case "double":
                NumberMetric<Double> doubleData =
                        doubleTypeTsdStore.getDataConverter().convert(data, packet);
                doubleTypeTsdStore.store(category, dimension, packet.getTimestamp(), s -> {
                    s.merge(doubleData);
                });
                break;
            default:
                throw new IllegalArgumentException("Unknown dataType: " + dataType);
        }
    }

}
