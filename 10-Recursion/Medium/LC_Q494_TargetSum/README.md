# Target Sum (findTargetSumWays) — Recursion Tree Deep Dive

Complete explanation of `findTargetSumWays(nums=[1,1,1], target=1)` — samjho kaise `+` aur `-` dono branches explore hote hain, aur ye pichle wale (Combination Sum) se **kaise different** hai.

---

## The Code

```java
class Solution {

    int helper(int[] nums, int idx, int target, int sum) {
        if (idx >= nums.length) {
            if (sum == target) return 1;
            return 0;
        }

        int a = helper(nums, idx + 1, target, sum + nums[idx]);   // Sign +
        int b = helper(nums, idx + 1, target, sum - nums[idx]);   // Sign -

        return a + b;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target, 0);
    }
}
```

**Problem statement:** Har number ke aage `+` ya `-` laga sakte ho. Kitne tarike (ways) hain jisse total expression `target` ke barabar ho jaaye?

---

## Ye Pichle Problem (Combination Sum) Se Kaise Different Hai — Pehle Ye Samjho

| | Combination Sum | Target Sum |
|---|---|---|
| Choices per index | TAKE / SKIP | `+` sign / `-` sign |
| Har index visit hota hai kitni baar | 1 baar TAKE se, phir agla number try | **Har index exactly ek baar** — dono branches idx+1 pe jaate hain |
| State kaise maintain hota hai | `ds` list mein **add/remove** (mutable, shared object) | `sum` **parameter** ke through pass hota hai (value copy, koi mutation nahi) |
| Explicit backtrack (`.remove()`) chahiye? | **Haan** — kyunki `ds` shared list hai | **Nahi** — kyunki har call ka apna `sum` value hai, kisi ko undo karne ki zarurat nahi |

**Ye sabse important cheez hai samajhne wali:** Is code mein `ds.remove()` jaisa kuch nahi hai kyunki `sum` ek **primitive `int`** hai jo **by value** pass hota hai — har recursive call ke paas apna **independent copy** hai. Isliye "backtracking" yahan automatically ho jaati hai, bina kisi extra line likhe.

---

## Full Recursion Tree — `nums=[1,1,1], target=1`

```
helper(idx=0, sum=0)
│
├── (+1) helper(idx=1, sum=1)
│   │
│   ├── (+1) helper(idx=2, sum=2)
│   │   │
│   │   ├── (+1) helper(idx=3, sum=3)
│   │   │       idx==nums.length(3) → check: 3==1? NO
│   │   │       return 0
│   │   │
│   │   └── (-1) helper(idx=3, sum=1)
│   │           idx==nums.length(3) → check: 1==1? YES ✅
│   │           return 1
│   │   │
│   │   → a+b = 0+1 = 1   (ye sum=2 wale call ka return value)
│   │
│   └── (-1) helper(idx=2, sum=0)
│       │
│       ├── (+1) helper(idx=3, sum=1)
│       │       idx==nums.length(3) → check: 1==1? YES ✅
│       │       return 1
│       │
│       └── (-1) helper(idx=3, sum=-1)
│               idx==nums.length(3) → check: -1==1? NO
│               return 0
│       │
│       → a+b = 1+0 = 1   (ye sum=0 wale call ka return value)
│   │
│   → a+b = 1+1 = 2   (ye sum=1 wale call ka return value)
│
└── (-1) helper(idx=1, sum=-1)
    │
    ├── (+1) helper(idx=2, sum=0)
    │   │
    │   ├── (+1) helper(idx=3, sum=1)
    │   │       idx==nums.length(3) → check: 1==1? YES ✅
    │   │       return 1
    │   │
    │   └── (-1) helper(idx=3, sum=-1)
    │           idx==nums.length(3) → check: -1==1? NO
    │           return 0
    │   │
    │   → a+b = 1+0 = 1   (ye sum=0 wale call ka return value)
    │
    └── (-1) helper(idx=2, sum=-2)
        │
        ├── (+1) helper(idx=3, sum=-1)
        │       idx==nums.length(3) → check: -1==1? NO
        │       return 0
        │
        └── (-1) helper(idx=3, sum=-3)
                idx==nums.length(3) → check: -3==1? NO
                return 0
        │
        → a+b = 0+0 = 0   (ye sum=-2 wale call ka return value)
    │
    → a+b = 1+0 = 1   (ye sum=-1 wale call ka return value)

FINAL: a+b = 2+1 = 3   ✅ (helper(idx=0, sum=0) ka return value)

ANSWER: findTargetSumWays([1,1,1], 1) = 3
```

---

## Visual Tree (Compact View)

```
                                sum=0 (idx=0)
                              /              \
                          +1 /                \ -1
                            /                  \
                       sum=1 (idx=1)         sum=-1 (idx=1)
                       /        \              /        \
                   +1 /          \ -1      +1 /          \ -1
                     /            \          /            \
              sum=2(idx=2)   sum=0(idx=2)  sum=0(idx=2)  sum=-2(idx=2)
              /      \        /      \      /      \       /      \
           +1/      \-1   +1/      \-1   +1/      \-1    +1/      \-1
            /        \     /        \     /        \      /        \
        sum=3      sum=1 sum=1    sum=-1 sum=1    sum=-1 sum=-1   sum=-3
        (idx=3)    (idx=3)(idx=3) (idx=3)(idx=3)  (idx=3)(idx=3)  (idx=3)
          ❌         ✅     ✅       ❌     ✅       ❌     ❌       ❌
        (3≠1)      (1=1)  (1=1)   (-1≠1) (1=1)   (-1≠1) (-1≠1)  (-3≠1)
```

**8 leaf nodes total** (kyunki 3 numbers hain, har ek ke 2 choices → 2³ = 8). Inme se **3 leaves** pe `sum == target` match hua — isliye final answer **3** hai.

---

## Step-by-Step: Return Values Kaise Upar Combine Hote Hain

Recursion mein **return values neeche se upar** collect hote hain — ye samajhna zaroori hai:

```
Level 3 (leaves) → return 0 ya 1 (match hua ya nahi)
       ↓
Level 2 → a + b (dono child leaves ka sum) → return karta hai upar
       ↓
Level 1 → a + b (dono Level-2 subtree ke results ka sum) → return karta hai upar
       ↓
Level 0 → a + b (dono Level-1 subtree ke results ka sum) → FINAL ANSWER
```

Har intermediate node **apne dono children ke return values ko add karke** upar bhejta hai. Isiliye root pe pahunchte pahunchte total **saare valid paths ka count** mil jaata hai.

---

## Kyu Isme `ds.remove()` Jaisa Backtrack Nahi Chahiye?

Pichle Combination Sum wale code mein:
```java
ds.add(nums[idx]);
sum(idx, nums, target - nums[idx], ans, ds);
ds.remove(ds.size() - 1);   // explicit undo zaroori tha
```
Yahan `ds` ek **List** thi jo **saare recursive calls ke beech shared** hoti hai — agar remove na karo toh agla branch corrupted state dekhega.

Is Target Sum code mein:
```java
int a = helper(nums, idx+1, target, sum + nums[idx]);   // naya sum banaya, purana intact
int b = helper(nums, idx+1, target, sum - nums[idx]);   // phir se purane sum se naya banaya
```
`sum` yahan **har call mein naya value hai** — `sum + nums[idx]` sirf ek **local calculation** hai jo `a` wale call ko diya jaata hai. Jab `b` wala call hota hai, wo **original `sum`** use karta hai (jo change hi nahi hua tha), na ki `a` wale calculation ka result. Isliye **automatically clean state milta hai**, koi manual undo ki zarurat nahi.

**One-line summary:** Jab state **primitive/immutable** ho (int, string), backtrack **free mein milta hai**. Jab state **mutable/shared object** ho (List, array by reference), tumhe **manually undo** karna padta hai.

---

## Key Takeaways

1. **Har index sirf ek baar visit hota hai**, dono branches (`+` and `-`) uss ek hi index ke liye try hoti hain — phir dono `idx+1` pe chali jaati hain. Ye Combination Sum se different hai jahan TAKE branch **same idx** pe wapas jaati thi.
2. **Return values bottom-up combine hote hain** — `a + b` har level pe apne dono subtrees ka total count leke upar bhejta hai.
3. **No explicit backtrack needed** — kyunki `sum` primitive hai, har recursive call ka apna independent copy hota hai.
4. **Total leaf nodes = 2^n** (n = array length) — har number ke 2 choices (+/-), isliye exponential tree banta hai. Ye brute-force approach hai; is problem ko **memoization/DP** se optimize kiya ja sakta hai (same `idx, sum` pair repeat hone par).
5. **Base case pe hi decision hota hai** — jab `idx >= nums.length`, tab dekha jaata hai ki accumulated `sum` target ke barabar hai ya nahi. Beech mein koi pruning nahi hai (Combination Sum mein `nums[idx] <= target` wali pruning thi, yahan wo bhi nahi hai kyunki negative sums bhi valid intermediate states hain).
