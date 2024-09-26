# 729. My Calendar I
# Difficulty: Medium
# Array, Binary Search, Design, Segment Tree, Ordered Set

class MyCalendar:

    def __init__(self):
        self.slots = []

    def book(self, start: int, end: int) -> bool:
        i = bisect.bisect_left(self.slots, (start, end))
        ans = True

        if i < len(self.slots): ans &= end <= self.slots[i][0]

        if i - 1 >= 0: ans &= start >= self.slots[i-1][1]

        if ans: bisect.insort_left(self.slots, (start, end))
        return ans

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)