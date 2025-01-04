package com.github.vortex.tsd;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
    private DecimalTypeTsdStore decimalTypeTsd;

    @Autowired
    private LongTypeTsdStore longTypeTsd;

    @Autowired
    private DoubleTypeTsdStore doubleTypeTsd;

    @Override
    public void consume(Packet packet) {
        String dataType = packet.getStringField("dataType");
        String category = packet.getStringField("category");
        String dimension = packet.getStringField("dimension");
        Object data = packet.getObject();
        switch (dataType.toLowerCase()) {
            case "long":
                NumberMetric<Long> longData = longTypeTsd.getDataConverter().convert(data, packet);
                longTypeTsd.store(category, dimension, packet.getTimestamp(), s -> {
                    s.merge(longData);
                });
                break;
            case "decimal":
                NumberMetric<BigDecimal> decimalData =
                        decimalTypeTsd.getDataConverter().convert(data, packet);
                decimalTypeTsd.store(category, dimension, packet.getTimestamp(), s -> {
                    s.merge(decimalData);
                });
                break;
            case "double":
                NumberMetric<Double> doubleData =
                        doubleTypeTsd.getDataConverter().convert(data, packet);
                doubleTypeTsd.store(category, dimension, packet.getTimestamp(), s -> {
                    s.merge(doubleData);
                });
                break;
            default:
                throw new IllegalArgumentException("Unknown dataType: " + dataType);
        }
    }

}
