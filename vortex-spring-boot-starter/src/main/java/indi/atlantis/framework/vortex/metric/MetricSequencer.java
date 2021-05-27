package indi.atlantis.framework.vortex.metric;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * MetricSequencer
 * 
 * @author Fred Feng
 *
 * @version 1.0
 */
public interface MetricSequencer<I, T extends Metric<T>> {

	int getSpan();

	SpanUnit getSpanUnit();

	int getBufferSize();

	Collection<I> identifiers();

	int update(I identifier, String metric, long timestamp, T metricUnit, boolean merged);

	int size(I identifier);

	void scan(ScanHandler<I, T> handler);

	Map<String, T> sequence(I identifier, String metric);

}