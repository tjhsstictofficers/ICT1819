# Cowpatibility

## Motivation
Our initial idea would be to check every line if every other line had at least one overlap. However, this solution is too inefficent for this
problem and gets at most 1 test case. The correct approach to this problem is to first count the frequency of the subsets of each line. 
There are 31 non-empty subsets of a list of 5 numbers. For example, in the set {1,2,3,4,5}, we have {1}, {1,3,4}, {5}, {1,2,3,5} as examples of some subsets.
Two subsets are considered the same if they contain the same elements, so order does not matter. Now let us say two different cows have a common subset, say cow 
1 is {1,2,3,4,5} and cow 2 is {1,6,7,8,9} with a common subset of {1}. We keep a dictionary of all the different subsets of all the different cows, and because
the frequency of {1} is 2, we add 1 to the number of cows that are compatible. However, let us say we have two cows, cow 1 and cow 2, such that cow 1's 5 flavors are
{1,2,3,4,5} and cow 2's are {1,2,6,7,8}. Now, in our dictionary, we will have the frequency of {1} to be 2, {2} to be 2, and {1,2} to be 2. Therefore, our program
would think there are 3 different pairs of cows that are compatible, not just one. This is because we over counted. One simple fix to this is to think that there is one combination
that contains a 1, one combination that contains a 2, and one that contains both. Therefore, if we add the number of combinations that contain 1 and 2, and subtract the one 
that contains both, we will get there is only 1 combination, our intended solution. But what if the overlap was 3? Let us say cow 1 was {1,2,3,4,5} and cow 2 was
{1,2,3,6,7}. Then the overlapping subsets would be {1}, {2}, {3}, {1,2}, {2,3}, {1,3}, and {1,2,3}. Using our idea from before, we would add the number of subsets of length 1 and subtract
the number of subsets of length two. Sadly, that gives us that there are 0 combinations possible. Obviously, cow 1 and cow 2 are compatible, so to fix this, we add 1 to our solution
because there is 1 overlapping subset of size 3. This principle is called the **Principle of Inclusion and Exclusion**, and I highly recommend you look it up.
So to recap, we will count the frequencies of each subset of every cow, add the number of combinations created by all the odd sized subsets, like size 1,3,5 and subtract
the combinations created by the even sized subsets, or sizes 2 and 4.

However, we are missing a few more things. In all these cases, we dealed with only the situation when only two cows have overlapping subsets. But what if 3 or more cows do.
For example, let us say 3 cows prefer flavor 1. Then the frequency of the subset {1} would be 3 not 2. When 3 cows have the same overlapping subset, 3 combinations can be made -
cow 1 to cow 2, cow 2 to cow 3, and cow 3 to cow 1. In general, if the frequency of a subset is k, then the number of combinations that can be made based on that 
subset is the sum of the first k-1 integers. Formulaically, that is (k) * (k-1) / 2. Finally, all this counting is for the number of cows that ARE compatible. However,
we want to find the number of cows that are NOT. That prompts us to find the total number of combinations of cows, and then subtract the number of combinations in which
the cows are compatitible. The number of combinations of cows that can be made is simply done by n * (n-1) / 2, where n is the number of cows.

## Solutions
[C++](cowpatibility.cpp)
[Java](cowpatibility.java)