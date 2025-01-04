package com.github.vortex.tsd;

import com.github.doodler.common.timeseries.OverflowDataHandler;
import com.github.doodler.common.timeseries.OverflowDataManager;
import com.github.doodler.common.timeseries.UserMetric;

/**
 * 
 * @Description: TsdOverflowDataHandler
 * @Author: Fred Feng
 * @Date: 02/01/2025
 * @Version 1.0.0
 */
public interface TsdOverflowDataHandler<T extends UserMetric<T>>
        extends OverflowDataHandler<String, String, T>, OverflowDataManager {

}
