package com.company;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.google.common.collect.Range;

class RangeUtilsTest {

	@Test
	@DisplayName("Test with 2 connected ranges")
	void saparatedCountTest1() {
		List<Range> ranges = new ArrayList<>();
		ranges.add(Range.closed(1,3));
		ranges.add(Range.closed(2,4));
		ranges.add(Range.closed(5,6));

		assertEquals(RangeUtils.separatedCount(ranges), 2);
	}
	@Test
	@DisplayName("Test with ranges overlap")
	void saparatedCountTest2() {
		List<Range> ranges = new ArrayList<>();
		ranges.add(Range.closed(1,7));
		ranges.add(Range.closed(2,4));
		ranges.add(Range.closed(5,6));

		assertEquals(RangeUtils.separatedCount(ranges), 1);
	}

	@Test
	@DisplayName("Test with open ranges")
	void saparatedCountTest3() {
		List<Range> ranges = new ArrayList<>();
		ranges.add(Range.open(1,2));
		ranges.add(Range.open(2,4));
		ranges.add(Range.open(5,7));
		ranges.add(Range.open(6,8));

		assertEquals(RangeUtils.separatedCount(ranges), 3);
	}

	@Test
	@DisplayName("Test with open and closed ranges")
	void saparatedCountTest4() {
		List<Range> ranges = new ArrayList<>();
		ranges.add(Range.open(1,2));
		ranges.add(Range.openClosed(2,4));
		ranges.add(Range.openClosed(5,7));
		ranges.add(Range.closedOpen(7,8));

		assertEquals(RangeUtils.separatedCount(ranges), 3);
	}
}