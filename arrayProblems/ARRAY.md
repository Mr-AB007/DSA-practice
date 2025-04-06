# Array Problems - Quick Revision & Practice

## 📌 Quick Notes for Revision

1. **Types of Arrays:**
   - **1D Array**: `[1, 2, 3, 4]`
   - **2D Array (Matrix)**: `[[1, 2], [3, 4]]`
   - **Jagged Array**: Rows may have different lengths.

2. **Common Operations:**
   - Traversal: `for(int i = 0; i < arr.length; i++)`
   - Insertion: `arr[i] = value;`
   - Deletion: Remove by shifting elements.
   - Searching: Linear Search `O(n)`, Binary Search `O(log n)` (sorted array).
   - Sorting: QuickSort `O(n log n)`, MergeSort `O(n log n)`, BubbleSort `O(n²)`.

3. **Important Concepts:**
   - **Prefix Sum:** Used for range queries in `O(1)` time.
   - **Sliding Window:** Optimized approach for subarray problems.
   - **Kadane’s Algorithm:** Find the maximum subarray sum in `O(n)` time.
   - **Two Pointers:** Useful for searching pairs and optimizing space.
   - **Hashing:** Used for quick lookups (e.g., `Map<Integer, Integer>`).

---

## 🔥 Must-Do Array Questions

### **1️⃣ Running Sum of 1D Array**
**Problem:** Given an array `nums`, return an array where `arr[i] = sum(nums[0]...nums[i])`.
**Example:**  
```java
Input: [1, 2, 3, 4]
Output: [1, 3, 6, 10]
```
[Solution](https://github.com/Mr-AB007/DSA-practice/blob/main/arrayProblems/RunningSumof1dArray.java)

### **2️⃣ Maximum Subarray (Kadane’s Algorithm)**
**Problem:** Find the contiguous subarray with the maximum sum.
**Example:**  
```java
Input: [-2,1,-3,4,-1,2,1,-5,4]
Output: 6 (subarray: [4,-1,2,1])
```
[Solution](https://github.com/Mr-AB007/DSA-practice/blob/main/arrayProblems/MaxSumSubArray.java)

### **3️⃣ Two Sum**
**Problem:** Given `nums` and `target`, return indices of two numbers that sum to `target`.
**Example:**  
```java
Input: nums = [2,7,11,15], target = 9
Output: [0,1] (nums[0] + nums[1] = 9)
```
[Solution](https://github.com/Mr-AB007/DSA-practice/blob/main/arrayProblems/TwoSum.java)

### **4️⃣ Product of Array Except for Self**
**Problem:** Return an array `output[i]` such that `output[i] = product of all elements except nums[i]`.
**Example:**  
```java
Input: [1,2,3,4]
Output: [24,12,8,6]
```
[Solution](#)

### **5️⃣ Best Time to Buy and Sell Stock**
**Problem:** Given prices where `prices[i]` is the price of a stock on day `i`, return max profit.
**Example:**  
```java
Input: [7,1,5,3,6,4]
Output: 5 (Buy at 1, Sell at 6)
```
[Solution](#)

### **6️⃣ Group Anagrams**

**Problem Statement**
Given an array of strings, group the anagrams together. An anagram is a word or phrase formed by rearranging the letters of a different word.
**Example:**
```java
 Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
```
[Solution](https://github.com/Mr-AB007/DSA-practice/blob/main/arrayProblems/GroupAnagrams.java)
---

## 📖 Resources
- **LeetCode Arrays:** [LeetCode](https://leetcode.com/tag/array/)
- **GeeksforGeeks:** [Arrays](https://www.geeksforgeeks.org/arrays-in-java/)
- **Java Docs:** [Array Class](https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html)

Happy Coding! 🚀

