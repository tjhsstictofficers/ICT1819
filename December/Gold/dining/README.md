# Dining

## Motivation

Reading this problem, we see we want to find the shortest path from each node to the end node.
This prompts us to run a `Dijkstra's Shortest Path` Algorithm from node N. We begin by running Dijkstra from this node
N, and we will refer to these values as the original Dijkstra throught the rest of this solution. However, we also have 
the situation of the haybales. Our first idea would be take the shortest path from each node to each 
haybale then the shortest path from that haybale to the end and see if the difference between this path 
and the original path is less than the yumminess of the haybale. However, this method is too inefficent. 
If we think of each haybale as a negative edge with weight of the edge being -1 * the yumminess of the 
haybale, and run Dijkstra on this new graph, we can find the new shortest path with one haybale taken. 
We then compare this new value to our original shortest path, and if the new value is less than or equal to the shortest
path of the original graph for each node, we print 1 else we print 0.

The idea behind this is that we choose to eat a haybale if the time it increases in our shortest path is at most the yumminess of the 
haybale. In other words, original shortest path + yumminess is greater than or equal to new shortest path. Therefore, if we force a cow to 
eat at a haybale, then take this path and subtract the yumminess, this value must be less than or equal to the original shortest path to be 
a viable path for the cow. One way to implement this idea is to create a new end node and add paths to each haybale whose edge weight is the difference
between the original path and the yumminess. Then, we Dijkstra from this new node. For each of the nodes, we then compare the original Dijkstra value and the new one.
If the new value is less than or equal to the original Dijkstra value, we print 1, else we print 0.

Our Dijkstra implementation is done using a priority queue, giving a `O(n log n)` solution. 

## Solutions
[C++](dining.cpp)
[Java](dining.java)