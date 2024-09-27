# 731. My Calendar II
# Difficulty: Medium
# Category: Array, Binary Search, Design

class MyCalendarTwo:
    def __init__(self):
        self.calendar = []
        self.overlaps = []

    def book(self, start: int, end: int) -> bool:
        for ostart, oend in self.overlaps:
            if max(start, ostart) < min(end, oend):
                return False
        
        for cstart, cend in self.calendar:
            if max(start, cstart) < min(end, cend):
                self.overlaps.append((max(start, cstart), min(end, cend)))
        
        self.calendar.append((start, end))
        return True

# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)