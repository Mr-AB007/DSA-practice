# QuickSort Algorithm  

QuickSort is an efficient, in-place, divide-and-conquer sorting algorithm with an average time complexity of **O(n log n)**. It works by selecting a pivot, partitioning the array around it, and recursively sorting the subarrays.  

## Time Complexity  
| Case       | Time Complexity | Explanation |
|------------|---------------|-------------|
| **Best Case** | **O(n log n)** | When the pivot divides the array into equal halves, leading to balanced recursion. |
| **Average Case** | **O(n log n)** | Typically occurs when partitions are reasonably balanced. |
| **Worst Case** | **O(n²)** | Happens when partitions are highly unbalanced, e.g., sorted/reversed input with poor pivot selection. |

**Optimizations like Median-of-Three pivot selection, Hoare's partitioning, and Tail Recursion help prevent the worst case.**  

## Space Complexity  
| Scenario | Space Complexity | Explanation |
|----------|---------------|-------------|
| **In-Place Implementation** | **O(log n)** (Auxiliary) | QuickSort sorts in-place, but recursive calls require O(log n) stack space in the best/average case. |
| **Worst Case** | **O(n)** | If partitions are unbalanced, recursion depth reaches O(n), leading to higher space usage. |

## Optimizations  
- **Hoare’s Partitioning:** Reduces unnecessary swaps and improves efficiency.  
- **Median-of-Three Pivot Selection:** Helps avoid worst-case time complexity.  
- **Tail Recursion Optimization:** Reduces recursion depth and prevents stack overflow.  
- **Insertion Sort for Small Subarrays:** Improves performance for small partition sizes.  

QuickSort is widely used due to its efficiency and adaptability, making it one of the fastest sorting algorithms for general-purpose sorting. 🚀  
