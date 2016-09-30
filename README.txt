**************************************
** Kmeans Clustering				**
** Author: Jui-Ting Hsu				**
** Contact: jh3572@nyu.edu			**
**************************************

This project consists of the Lloyd's Kmean's alogrithm implemented
by Jui-Ting Hsu in Java. The files enclosed consists of two main
parts: the java sources files and the Junit test files.

The source files consists of the following:
Point.java
Centroid.java
Cluster.java
Kmeans.java
Kmeans2.java

with their respective Junit test files named Test_*.java.

Kmeans.java and Kmeans2.java are the class where the main algorithm
is implemented. Kmeans is the Lloyd's algorithm and Kmeans2 is
another approach to Kmeans. 

Both of these files produce an output to the text file "Kmeans.txt"
or "Kmeans2.txt" depending on which one was ran. The output file
will contain information regarding which version was ran, the mean
distance between all the points and the centroid of the cluster they
belong to, as well as information of each cluster including the 
centroid's coordinate and the points they contain.