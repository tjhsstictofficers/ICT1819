# Mooyomooyo

## Motivation
Another implementation problem. This problem can be broken down into three parts, checking if a section can be deleted,
deleting it, and applying gravity. The first two parts are accomplished using a DFS search, in which we start at each cell
and check the size of each section. If a piece has been visited already, we make sure not to visit again by keeping a visited array.
We then apply gravity, in which we shift every column down so that there are no zeros at the bottom or inbetween pieces. These three steps continue
until no change has been made to the board, in which case we know that we have finished the problem.

## Solutions
[C++](mooyomooyo.cpp)
[Java](mooyomooyo.java)
