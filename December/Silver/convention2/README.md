# Convention 2

## Motivation
The bounds suggest an `O(nlogn)` solution. Note that there isn't anything we can do about the process of eating to minimize the time waiting like the last problem - which means that if we find a way to simulate the problem we will arrive at the correct answer. Note that there are a few operations that are `O(nlogn)`, which include sorting and `O(n)` operations of a priority queue. 

With this, we literally simulate this problem as well. First, we have to sort the cows by starting time so we know in what order they will come in, keeping in mind that cows with a higher seniority will be "inserted" first of all with the same starting time. Next, note that cows are "popped" from the waiting queue based off seniority. Thus, we just need a sorted list of cows based on initial entering time, and a priority queue with a sorting method based off seniority. We pop cows from the sorted list into the priority queue when it is their time to join the queue, and we pop off the queue after the cow currently in the grass is done, keeping in track when the cow entered the queue and when the came to the grass to calculate the max. Note all these operations are sorting (nlogn) and N operations of push and pop from the priority queue (logn * n = nlogn) to keep our time in track.

A slight slipup that some competitors make is when simulating just having a while loop and incrementing time. This means the number of iterations the loop goes through is the total time, instead of the number of cows. Note that nothing really happens when a cow is in the pasture, other than more cows joining the queue. Instead of incrementing time, we do the while loop based off of the cow thats in the pasture, and this is fully optimized. 

## Solutions
[C++](convention2.cpp)
[Java](convention2.java)
