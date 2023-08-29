// Link -> https://www.geeksforgeeks.org/minimum-number-of-increasing-subsequences/

// divide integer arr to minimum number of increasing sequences.

/* Approach:

get longest decresing subseq. length -> that will be total number of increasing seq.
[1324] -> [134] and [2] -> 2 -> [3,2] -> LDS -> 2
[1234] -> [1234] -> 1 -> [1][2][3][4] -> longest length- 1
[16243] ->[124] and [6] and[3] -> 3

for LDS -> multiply all elements by -1 then take LIS you will get lds or reverse the logic of lds
*/