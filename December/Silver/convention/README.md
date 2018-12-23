# Convention

## Motivation
We are asked to find the *minimum maximum* waiting time. This suggests we should search for an optimal answer. We know that if a certian time t works, any time larger that t will work, and if a certian time x doesn't work, all times less than x will not work. This means we can binary search for the answer. Because our bounds are less than `10^5`, and a binary search adds a `O(logn)` to the solution, our evaluation should be something like `O(n)`. This is easily simulated to get our final solution.


## Solutions
[C++](convention.cpp)
[Java](convention.java)
