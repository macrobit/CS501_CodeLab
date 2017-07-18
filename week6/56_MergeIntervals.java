// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

public class Interval {
	int start, end;
	public Interval() {
		start = 0;
		end = 0;
	}
	public Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class myComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval l1, Interval l2) {
		return l1.start - l2.start;
	}
}

public List<Interval> merge(List<Interval> intervals) {
	List<Interval> res = new ArrayList<>();
	if (intervals == null || intervals.size() == 0) {
		return intervals;
	}

	Collection.sort(intervals, new myComparator());

	int head = intervals.get(0).start;
	int end = intervals.get(0).end;

	for (int i = 0; i < intervals.size(); i++) {
		Interval cur = intervals.get(i);

		if (end >= cur.start) {
			end = Math.max(end, cur.end);
		} else {
			res.add(new Interval(head, end));
			head = cur.start;
			end = cur.end;
		}
	}

	res.add(new Interval(head, end));
	return res;
}