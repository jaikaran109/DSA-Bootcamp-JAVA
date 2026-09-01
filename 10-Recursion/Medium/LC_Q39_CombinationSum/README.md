# Combination Sum — Recursion Tree Deep Dive

Complete explanation of `combinationSum(candidates=[2,3,6,7], target=7)` — samjho ki recursion kaise backtrack karta hai, idx 0 pe "wapas" kyu nahi jaata, aur poora call stack kaise unwind hota hai.

---

## The Code

```java
class Solution {

    private void sum(int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (idx == nums.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (nums[idx] <= target) {
            ds.add(nums[idx]);
            sum(idx, nums, target - nums[idx], ans, ds);   // TAKE: idx same rehta hai (reuse allowed)
            ds.remove(ds.size() - 1);                       // BACKTRACK: undo the take
        }
        sum(idx + 1, nums, target, ans, ds);                // SKIP: move to next index
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        sum(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
```

---

## The Core Idea — Do Choices, Har Level Pe

Har recursive call pe sirf **do decisions** hote hain:

1. **TAKE** — current number ko `ds` mein daalo, aur **usi index** pe wapas call karo (kyunki ek number **multiple baar use** ho sakta hai)
2. **SKIP** — current number ko chhod do, **idx+1** pe move karo

Jab TAKE wala call **poora explore ho jaata hai** (return kar deta hai), toh us number ko `ds.remove()` se **hata diya jaata hai** — taaki SKIP wala path clean state se try ho sake.

**Ye "wapas idx 0 pe jaana" nahi hai — ye ek level upar jaake dusra option try karna hai.**

---

## Full Recursion Tree — `candidates=[2,3,6,7], target=7`

```
sum(idx=0, target=7, ds=[])
│
├── TAKE 2 → ds=[2]
│   sum(idx=0, target=5, ds=[2])
│   │
│   ├── TAKE 2 → ds=[2,2]
│   │   sum(idx=0, target=3, ds=[2,2])
│   │   │
│   │   ├── TAKE 2 → ds=[2,2,2]
│   │   │   sum(idx=0, target=1, ds=[2,2,2])
│   │   │   │
│   │   │   ├── 2 <= 1? NO → TAKE skip ho gaya
│   │   │   └── sum(idx=1, target=1, ds=[2,2,2])
│   │   │       │
│   │   │       ├── 3 <= 1? NO → skip
│   │   │       └── sum(idx=2, target=1, ds=[2,2,2])
│   │   │           │
│   │   │           ├── 6 <= 1? NO → skip
│   │   │           └── sum(idx=3, target=1, ds=[2,2,2])
│   │   │               │
│   │   │               ├── 7 <= 1? NO → skip
│   │   │               └── sum(idx=4, target=1, ds=[2,2,2])
│   │   │                   │
│   │   │                   └── idx==nums.length, target=1 != 0
│   │   │                       ❌ NO ANSWER ADDED, return
│   │   │   ↑ (sab wapas unwind, koi ds.remove() nahi hua kyunki koi TAKE nahi hua tha yahan se)
│   │   │
│   │   │   ds.remove() → ds=[2,2]   👈 BACKTRACK: last TAKE (jo [2,2,2] banaya tha) undo hua
│   │   │
│   │   └── SKIP idx=0 → sum(idx=1, target=3, ds=[2,2])
│   │       │
│   │       ├── TAKE 3 → ds=[2,2,3]
│   │       │   sum(idx=1, target=0, ds=[2,2,3])
│   │       │   │
│   │       │   └── idx=1 != nums.length, but target check happens at base case
│   │       │       (Note: is code mein target==0 check idx==nums.length pe hi hota hai,
│   │       │       toh recursion aage chalti rahegi jab tak idx=4 na ho jaaye)
│   │       │       sum(idx=2, target=0, ds=[2,2,3])
│   │       │       │  6<=0? NO → skip → sum(idx=3, target=0, ds=[2,2,3])
│   │       │       │  7<=0? NO → skip → sum(idx=4, target=0, ds=[2,2,3])
│   │       │       │  idx==nums.length, target==0 ✅
│   │       │       │  ✅ ANSWER FOUND: [2,2,3]
│   │       │
│   │       │   ds.remove() → ds=[2,2]   👈 BACKTRACK: 3 hataya
│   │       │
│   │       └── SKIP idx=1 → sum(idx=2, target=3, ds=[2,2])
│   │           │  6<=3? NO → skip → sum(idx=3, target=3, ds=[2,2])
│   │           │  7<=3? NO → skip → sum(idx=4, target=3, ds=[2,2])
│   │           │  idx==nums.length, target=3 != 0 → ❌ no answer
│   │
│   │   ds.remove() → ds=[2]   👈 BACKTRACK: doosra 2 hataya
│   │
│   └── SKIP idx=0 → sum(idx=1, target=5, ds=[2])
│       │
│       ├── TAKE 3 → ds=[2,3]
│       │   sum(idx=1, target=2, ds=[2,3])
│       │   │  3<=2? NO → skip → sum(idx=2, target=2, ds=[2,3])
│       │   │  6<=2? NO → skip → sum(idx=3, target=2, ds=[2,3])
│       │   │  7<=2? NO → skip → sum(idx=4, target=2, ds=[2,3])
│       │   │  idx==nums.length, target=2 != 0 → ❌ no answer
│       │
│       │   ds.remove() → ds=[2]   👈 BACKTRACK: 3 hataya
│       │
│       └── SKIP idx=1 → sum(idx=2, target=5, ds=[2])
│           │
│           ├── 6<=5? NO → skip
│           └── sum(idx=3, target=5, ds=[2])
│               │  7<=5? NO → skip
│               └── sum(idx=4, target=5, ds=[2])
│                   idx==nums.length, target=5 != 0 → ❌ no answer
│
│   ds.remove() → ds=[]   👈 BACKTRACK: pehla 2 bhi hataya
│
└── SKIP idx=0 → sum(idx=1, target=7, ds=[])
    │
    ├── TAKE 3 → ds=[3]
    │   sum(idx=1, target=4, ds=[3])
    │   │
    │   ├── TAKE 3 → ds=[3,3]
    │   │   sum(idx=1, target=1, ds=[3,3])
    │   │   │  3<=1? NO → skip → ... → idx=4, target=1 != 0 → ❌
    │   │
    │   │   ds.remove() → ds=[3]
    │   │
    │   └── SKIP idx=1 → sum(idx=2, target=4, ds=[3])
    │       │  6<=4? NO → skip → sum(idx=3, target=4, ds=[3])
    │       │  7<=4? NO → skip → sum(idx=4, target=4, ds=[3])
    │       │  idx==nums.length, target=4 != 0 → ❌
    │
    │   ds.remove() → ds=[]
    │
    └── SKIP idx=1 → sum(idx=2, target=7, ds=[])
        │
        ├── TAKE 6 → ds=[6]
        │   sum(idx=2, target=1, ds=[6])
        │   │  6<=1? NO → skip → sum(idx=3, target=1, ds=[6])
        │   │  7<=1? NO → skip → sum(idx=4, target=1, ds=[6])
        │   │  idx==nums.length, target=1 != 0 → ❌
        │
        │   ds.remove() → ds=[]
        │
        └── SKIP idx=2 → sum(idx=3, target=7, ds=[])
            │
            ├── TAKE 7 → ds=[7]
            │   sum(idx=3, target=0, ds=[7])
            │   │  7<=0? NO → skip → sum(idx=4, target=0, ds=[7])
            │   │  idx==nums.length, target==0 ✅
            │   │  ✅ ANSWER FOUND: [7]
            │
            │   ds.remove() → ds=[]
            │
            └── SKIP idx=3 → sum(idx=4, target=7, ds=[])
                idx==nums.length, target=7 != 0 → ❌ no answer

FINAL ANSWER: [[2,2,3], [7]]
```

---

## Line-by-Line: Kya Ho Raha Hai Har Baar

| Step | Line | Effect |
|---|---|---|
| 1 | `if (nums[idx] <= target)` | Check karo ki current number lena valid hai ya nahi (negative target avoid karne ke liye) |
| 2 | `ds.add(nums[idx])` | Number ko current combination mein daalo — **state change** |
| 3 | `sum(idx, ...)` | Recursive call — **idx same** rakha kyunki same number dobara use ho sakta hai |
| 4 | `ds.remove(ds.size()-1)` | Jaise hi upar wala call **return karta hai** (chahe answer mila ho ya na mila ho), is number ko wapas nikaal do — **state restore, backtrack** |
| 5 | `sum(idx+1, ...)` | Ab agla number try karo, is baar current number ko permanently skip karke |

**Step 4 hi wo jagah hai jahan tumhara confusion tha.** Jab `ds=[2,2,2]` wala deep call fully explore ho ke return karta hai, control **wapas Level 2 pe** aata hai (jahan teesra `2` add kiya tha) — **idx 0 pe nahi**. Wahi pe `ds.remove()` chalta hai, `ds` `[2,2]` ban jaata hai, aur phir Level 2 ki agli line (`sum(idx+1,...)`) chalti hai jo `idx=1` (yaani `3`) try karti hai.

---

## Analogy — Maze Solving

Socho tum ek **maze** solve kar rahe ho:

1. Tum ek raste pe chalte ho (TAKE)
2. Agar wo raasta dead-end pe pahunch jaata hai, tum **shuru se nahi chalte** — tum sirf **ek kadam peeche** aate ho (backtrack / `ds.remove()`)
3. Wahi se **doosra raasta** try karte ho (SKIP → next option)
4. Agar wo bhi dead-end hai, phir ek aur kadam peeche

Recursion tree mein bhi yahi ho raha hai — **call stack hi tumhara "peeche jaane ka raasta" hai**, idx 0 wapas jaana kabhi hota hi nahi.

---

## Kyu `idx` Same Rehta Hai TAKE Mein, Lekin `idx+1` Hota Hai SKIP Mein?

- **TAKE branch** (`sum(idx, ...)`): Isi index ka number **dobara** use ho sakta hai (unlimited supply — jaise coin change problem). Isiliye `idx` change nahi hota.
- **SKIP branch** (`sum(idx+1, ...)`): Agar tum current number **nahi le rahe**, toh usko permanently chhod do aur **agle** number pe move karo. Wapas isi number pe aane ka koi matlab nahi — wo already reject ho chuka is decision point pe.

---

## Key Takeaways

1. **Recursion never "restarts" from idx 0** — it always unwinds one call at a time, back to the exact point where the last decision was made.
2. **`ds.remove()` is the backtrack step** — it undoes the most recent `ds.add()`, restoring the state before trying the next option.
3. **Every leaf node in the tree is a full decision path** — a sequence of TAKE/SKIP choices ending either in a valid answer (`target == 0`) or a dead end.
4. **Same index can repeat in TAKE branch** because `combinationSum` allows reusing the same number multiple times — this is what makes `[2,2,3]` a valid answer using `2` twice.
5. **Total number of leaf nodes = 2^n roughly** (each index has a TAKE-or-SKIP decision), though the `nums[idx] <= target` pruning cuts off many branches early — this is why the code is efficient enough despite looking exponential.
