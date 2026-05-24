# Two Sum

## Problem
Given an array of integers and a target value,
return the indices of the two numbers that add up to the target.

## Approach
Use a HashMap to store numbers already visited.

For each number:
1. Calculate the complement
2. Check if complement exists in map
3. If yes, return indices

## Complexity
- Time: O(n)
- Space: O(n)
