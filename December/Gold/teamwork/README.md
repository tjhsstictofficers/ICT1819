# Teamwork

## Motivation
This problem is solved using an algorithm called **Dynamic Programming**. If you do not kno what that is, I highly recommoned you 
visit the ICT website and read our lecture about dp. For this solution, I will be refering to the C++ file. The C++ file works backward, in which
get(x) is the optimal sum of all the cows starting from cow x. The program works recursively, and starts by iterating through all the different sizes for the last 
group of cows, or the first m cows, where m is less than or equal to k (line 22). The program keeps track of the maximum value of a cow for each size of the final group (line 23), and then takes 
sum of the cows when everyone in the final group value is changed to the maximum calculated value, line 23, plus the maximum sum of the elements not in the last group, or in other words, the elements after
index j (line 24). The maximum value of this sum is returned,
and when we return get(0), we find the maximum value starting from index 0, or including all the cows. 

## Solutions
[C++](teamwork.cpp)
[Java](teamwork.java)