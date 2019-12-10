package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import com.google.common.collect.Range;

public class RangeUtils {

	public static int separatedCount(List<Range> ranges) {
		if (ranges == null || ranges.size() == 0) {
			return 0;
		}
		if (ranges.size() == 1) {
			return 1;
		}
		ranges.sort(Comparator.comparing((Function<Range, Comparable>) Range::lowerEndpoint));
		int separatedCount = 1;
		Range prev = ranges.get(0);
		for (int i = 1; i < ranges.size(); i++) {
			Range range = ranges.get(i);
			if (!range.isConnected(prev)) {
				separatedCount ++;
			}
			if (range.upperEndpoint().compareTo(prev.upperEndpoint()) > 0) {
				prev = range;
			}
		}
		return separatedCount;

	}
}
