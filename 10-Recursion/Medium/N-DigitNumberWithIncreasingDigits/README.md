# N-Digit Numbers with Increasing Digits

A Java backtracking solution that returns all `n`-digit numbers whose digits are **strictly increasing** from left to right, in sorted order — without generating or checking any invalid numbers.

## Problem Statement

Given an integer `n`, return all the `n`-digit numbers, in increasing order, such that their digits are in strictly increasing order (left to right).

**Examples:**
```
Input: n = 1
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Explanation: Single digit numbers are considered strictly increasing.

Input: n = 2
Output: [12, 13, 14, 15, 16, 17, 18, 19, 23, ..., 79, 89]

Input: n = 15
Output: []
Explanation: No such number exists.
```

**Constraints:** `1 ≤ n ≤ 10^5`

## Key Observations

- **`n = 1`** is a special case — every single digit (`0`–`9`) counts as "increasing" since there's nothing to compare it to.
- **`n ≥ 2`** — the first digit cannot be `0` (no leading zeros), so only digits `1`–`9` are usable, and since digits must be strictly increasing, none can repeat.
- Because only 9 distinct digits (`1`–`9`) are available for `n ≥ 2`, the **maximum possible value of `n` is 9**. Any `n > 9` (other than the `n = 1` special case) has no valid answer — the result is `[]`.
- This bound matters a lot given the constraint `n ≤ 10^5` — the solution must reject large `n` immediately rather than trying to process it.

## Code

```java
class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Special case: n=1 -> 0 se 9 tak saare digits valid hain
        if (n == 1) {
            for (int d = 0; d <= 9; d++) ans.add(d);
            return ans;
        }

        // n>=2 ke liye max 9 digits possible hain (1-9 use karke, leading zero allowed nahi)
        if (n < 1 || n > 9) return ans;

        helper(ans, 0, 1, n);
        return ans;
    }

    static void helper(ArrayList<Integer> ans, int current, int nextDigit, int n) {
        int digitsPlaced = (current == 0) ? 0 : String.valueOf(current).length();

        if (digitsPlaced == n) {
            ans.add(current);
            return;
        }

        // agla digit "nextDigit" se 9 tak try karo (strictly increasing ke liye)
        for (int d = nextDigit; d <= 9; d++) {
            helper(ans, current * 10 + d, d + 1, n);
        }
    }
}
```

## How It Works

### `increasingNumbers(n)` — setup

| Check | Purpose |
|---|---|
| `n == 1` | Adds `0`–`9` directly, no recursion needed |
| `n < 1 \|\| n > 9` | Immediately rejects impossible cases — critical since `n` can be as large as `10^5` |
| `helper(ans, 0, 1, n)` | Kicks off recursion: `current = 0` (nothing placed yet), `nextDigit = 1` (smallest usable digit, since leading zero isn't allowed) |

### `helper(ans, current, nextDigit, n)` — recursive backtracking

| Parameter | Meaning |
|---|---|
| `current` | The number built so far (partial or complete) |
| `nextDigit` | The smallest digit allowed at this position |
| `n` | Total digits required |

**Step 1 — count digits placed:**
```java
int digitsPlaced = (current == 0) ? 0 : String.valueOf(current).length();
```
`current == 0` is handled separately because `"0"` has length 1, which would incorrectly count as one digit placed.

**Step 2 — base case:**
```java
if (digitsPlaced == n) {
    ans.add(current);
    return;
}
```
Once `n` digits are placed, the number is complete — add it and **return immediately**. The `for` loop below never runs in this case.

**Step 3 — recursive case:**
```java
for (int d = nextDigit; d <= 9; d++) {
    helper(ans, current * 10 + d, d + 1, n);
}
```
Tries every valid next digit (`nextDigit` through `9`):
- `current * 10 + d` appends `d` to the end of `current`
- `d + 1` ensures the next recursive call can only use digits **greater than** `d` — this single line is what guarantees strictly increasing digits

## Why the output is already sorted

The loop tries digits from **smallest to largest** (`nextDigit` → `9`). Since the first digit is the most significant part of the number, the branch explored first always produces the smaller number. So `ans` fills up in sorted order automatically — no extra sorting needed.

## Full Dry Run: `n = 2`

**Call 1: `helper(0, 1, 2)`**
`digitsPlaced = 0`, not equal to `n=2` → loop `d = 1` to `9`

**d=1 → `helper(1, 2, 2)`** (Call 2)
`digitsPlaced = 1`, not equal to `2` → loop `d = 2` to `9`:
- d=2 → `helper(12, 3, 2)` → digitsPlaced=2==n → **add 12**
- d=3 → `helper(13, 4, 2)` → **add 13**
- d=4 → **add 14**
- d=5 → **add 15**
- d=6 → **add 16**
- d=7 → **add 17**
- d=8 → **add 18**
- d=9 → **add 19**

`ans = [12,13,14,15,16,17,18,19]`

**d=2 → `helper(2, 3, 2)`** (Call 3) → loop d=3 to 9 → adds `23,24,25,26,27,28,29`

**d=3 → `helper(3, 4, 2)`** → loop d=4 to 9 → adds `34,35,36,37,38,39`

**d=4 → `helper(4, 5, 2)`** → adds `45,46,47,48,49`

**d=5 → `helper(5, 6, 2)`** → adds `56,57,58,59`

**d=6 → `helper(6, 7, 2)`** → adds `67,68,69`

**d=7 → `helper(7, 8, 2)`** → adds `78,79`

**d=8 → `helper(8, 9, 2)`** → adds `89`

**d=9 → `helper(9, 10, 2)`**
`digitsPlaced = 1`, not equal to `2` → loop `d = 10` to `9` — condition `d <= 9` fails immediately since `d` starts at `10` → **loop never executes, nothing added**

### Final `ans`:
```
[12,13,14,15,16,17,18,19,
 23,24,25,26,27,28,29,
 34,35,36,37,38,39,
 45,46,47,48,49,
 56,57,58,59,
 67,68,69,
 78,79,
 89]
```

**Total = 8+7+6+5+4+3+2+1 = 36 numbers** ✅ — matches `C(9,2) = 36` (choosing any 2 digits from 1–9 gives exactly one strictly-increasing arrangement).

**Pattern:** fix first digit `1`, second digit ranges over `2–9` (8 options); fix first digit `2`, second digit ranges over `3–9` (7 options); and so on — decreasing by one each time, since the second digit must always exceed the first.

## A Common Confusion — Why doesn't `13` become `130` or `134`?

Once `current = 13` and `digitsPlaced == n` (`2 == 2`), the base case triggers:
```java
if (digitsPlaced == n) {
    ans.add(current);   // adds 13
    return;               // exits immediately — the for loop below never runs
}
```
The `for` loop that would append another digit is **never reached** for a completed number, because `return` exits the function first. This is what stops numbers from growing beyond `n` digits.

## Complexity

| Metric | Value | Why |
|---|---|---|
| **Time** | O(2⁹) ≈ 512 | Each of digits 1–9 is either included or skipped — total subsets = 2⁹. Recursion only explores these branches, regardless of how large the input `n` is (up to 10⁵) |
| **Space** | O(n) recursion depth (max 9) + O(2⁹) for output list | Recursion depth is bounded by digit count (≤9) — no stack overflow risk |

## Why This Beats Brute Force

| | Brute Force (check every number in range) | **This (Backtracking)** |
|---|---|---|
| Time | O(10ⁿ × n) — billions of ops for n=9 | **O(2⁹) = 512** — effectively constant |
| Space (recursion depth) | O(10ⁿ) — **crashes with StackOverflowError for n≥5** | **O(9)** — always safe |
| Approach | Generates every number, checks validity | Only ever generates valid numbers |

Because this approach never wastes time checking invalid numbers, it stays fast and safe even for the largest allowed `n` (9), while a brute-force scan over the full numeric range would be both far slower and prone to crashing due to recursion depth.
