package com.github.vortex.tsd;

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
 * @Description: TssConfig
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
        return new TssRedisOverflowDataManager<>("tsd:decimal", redisTemplate);
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
        return new TssRedisOverflowDataManager<>("tsd:long", redisTemplate);
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
        return new TssRedisOverflowDataManager<>("tsd:double", redisTemplate);
    }

    @Bean
    public DoubleTypeTsdStore doubleTypeTsdStore(
            @Qualifier("doubleTypeOverflowDataManager") TsdOverflowDataHandler<NumberMetric<Double>> dataManager) {
        return new DoubleTypeTsdStore(tssProperties.getSpan(), TimeWindowUnit.MINUTES,
                tssProperties.getOverflowSize(), dataManager);
    }


}
