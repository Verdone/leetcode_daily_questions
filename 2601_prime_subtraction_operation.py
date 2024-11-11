# 2601. Prime Subtraction Operation
# Difficulty: Medium
# Topics: Array, Number Theory, Math

class Solution:
    def primeSubOperation(self, numbers):
        largest_number = max(numbers)

        sieveOfEratosthenes = [False] * (largest_number + 1)
        sieveOfEratosthenes[0] = sieveOfEratosthenes[1] = True

        for i in range(2, int(largest_number**0.5) + 1):
            if not sieveOfEratosthenes[i]:
                for j in range(2 * i, largest_number + 1, i):
                    sieveOfEratosthenes[j] = True

        prime_numbers = [i for i in range(2, len(sieveOfEratosthenes)) if not sieveOfEratosthenes[i]]

        idx = self.fidx_max_subtraction(prime_numbers, 0, numbers[0])
        if idx != -1:
            numbers[0] -= prime_numbers[idx]

        for i in range(1, len(numbers)):
            idx = self.fidx_max_subtraction(prime_numbers, numbers[i - 1], numbers[i])

            if idx == -1 and numbers[i] <= numbers[i - 1]:
                return False
            elif idx != -1:
                numbers[i] -= prime_numbers[idx]

        return True

    def fidx_max_subtraction(self, primes, previous_value, current_value):
        if not primes:
            return -1

        left_idx, right_idx = 0, len(primes) - 1

        while left_idx <= right_idx:
            mid_idx = (left_idx + right_idx) // 2

            if current_value - primes[mid_idx] <= previous_value:
                right_idx = mid_idx - 1
            else:
                if mid_idx == len(primes) - 1 or current_value - primes[mid_idx + 1] <= previous_value:
                    return mid_idx
                else:
                    left_idx = mid_idx + 1

        mid_idx = right_idx
        return -1 if mid_idx >= 0 and current_value - primes[mid_idx] <= previous_value else mid_idx