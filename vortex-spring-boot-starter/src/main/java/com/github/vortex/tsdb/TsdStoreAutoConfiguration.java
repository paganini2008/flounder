/*
 * Copyright 2017-2025 Fred Feng (paganini.fy@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.vortex.tsdb;

import java.math.BigDecimal;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import com.github.doodler.common.timeseries.NumberMetric;
import com.github.doodler.common.utils.TimeWindowUnit;

/**
 * 
 * @Description: TsdStoreAutoConfiguration
 * @Author: Fred Feng
 * @Date: 02/01/2025
 * @Version 1.0.0
 */
@EnableConfigurationProperties({TsdStoreProperties.class})
@ComponentScan("com.github.vortex.tsd")
@Configuration(proxyBeanMethods = false)
public class TsdStoreAutoConfiguration {

    static {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    }

    @Autowired
    private TsdStoreProperties tssProperties;

    @Bean("decimalTypeOverflowDataManager")
    public TsdOverflowDataHandler<NumberMetric<BigDecimal>> decimalTypeTssRedisOverflowDataManager(
            RedisTemplate<String, Object> redisTemplate) {
        return new TsdRedisOverflowDataManager<>("tsd:decimal", redisTemplate);
    }

    @Bean
    public DecimalTypeTsdStore decimalTypeTsdStore(
            @Qualifier("decimalTypeOverflowDataManager") TsdOverflowDataHandler<NumberMetric<BigDecimal>> dataManager) {
        return new DecimalTypeTsdStore(tssProperties.getSpan(), TimeWindowUnit.MINUTES,
                tssProperties.getOverflowSize(), dataManager);
    }

    @Bean("longTypeOverflowDataManager")
    public TsdOverflowDataHandler<NumberMetric<Long>> longTypeTssRedisOverflowDataManager(
            RedisTemplate<String, Object> redisTemplate) {
        return new TsdRedisOverflowDataManager<>("tsd:long", redisTemplate);
    }

    @Bean
    public LongTypeTsdStore longTypeTsdStore(
            @Qualifier("longTypeOverflowDataManager") TsdOverflowDataHandler<NumberMetric<Long>> dataManager) {
        return new LongTypeTsdStore(tssProperties.getSpan(), TimeWindowUnit.MINUTES,
                tssProperties.getOverflowSize(), dataManager);
    }

    @Bean("doubleTypeOverflowDataManager")
    public TsdOverflowDataHandler<NumberMetric<Double>> doubleTypeTssRedisOverflowDataManager(
            RedisTemplate<String, Object> redisTemplate) {
        return new TsdRedisOverflowDataManager<>("tsd:double", redisTemplate);
    }

    @Bean
    public DoubleTypeTsdStore doubleTypeTsdStore(
            @Qualifier("doubleTypeOverflowDataManager") TsdOverflowDataHandler<NumberMetric<Double>> dataManager) {
        return new DoubleTypeTsdStore(tssProperties.getSpan(), TimeWindowUnit.MINUTES,
                tssProperties.getOverflowSize(), dataManager);
    }


}
