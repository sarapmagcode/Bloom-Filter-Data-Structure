# Bloom-Filter-Data-Structure
![image](https://user-images.githubusercontent.com/85553852/205939253-fc27b646-03ee-489a-bc21-7e00dcb410ee.png)
A bloom filter is a probabilistic data structure that is used to test whether an element is a member of a set. It is designed to provide a fast way to check whether an element is in a set without having to store the elements of the set in memory. Unlike other data structures, such as a hash table or a binary tree, a bloom filter does not store the elements of the set directly. Instead, it stores a series of bits, and uses a set of hash functions to map elements to the bits in the filter. When an element is added to the set, the hash functions are used to map the element to one or more bits in the filter, and those bits are set to 1. When we want to check whether an element is in the set, the same hash functions are used to map the element to one or more bits in the filter. If all of the bits that are mapped to are 1, then it is likely that the element is in the set. However, if any of the bits that are mapped to are 0, then it is definitely not in the set.

## Performance
![image](https://user-images.githubusercontent.com/85553852/205939426-ac21bf04-5571-48a2-b57b-d51a431b750f.png)  
As we can see from the graph above, the false positive rate will decrease as the number of hash functions, k, is increased. However, a high value of k can also slow down our bloom filter.
## References
- Concept: https://medium.com/system-design-blog/bloom-filter-a-probabilistic-data-structure-12e4e5cf0638
- Code: https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/
