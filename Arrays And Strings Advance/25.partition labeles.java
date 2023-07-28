// link -> https://leetcode.com/problems/partition-labels/
// partition string such that each letter appears in at most one part.
//left me se right me koi na aaye vha divide kre

/* Approach 
1.Maintain a map to store last index of character 
2.start and end at 0 and loop in string now check for last index of that character and update end to that idx
3.start move to next index if its last is less then last of previous do nothing but if its beyond that then update 
end and if i == end i.e we have one partition calc its length as end-strt + 1 and s = e = i+1 check for another 
partition

i i i i i i i i i
a b a b c b a c a d e  f  e  g  d  e  h  i  g  h  k  l  i  j
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
e,s               e
a->0-2-6-8
b->1-2-5
c->4-7
d->9-14
e->10-12-15
f->11
g->13
h->16-19
i->17,22
j->18-23
k->20
l->21

*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        Arrays.fill(map,-1);
        
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            map[ch - 'a'] = i;
        }
        int st = 0;
        int end = 0;
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            end = Math.max(end,map[ch - 'a']);
            
            if(i == end) {
                int len = end - st + 1;
                res.add(len);
                end = st = i + 1;
            }
        }
        return res;
    }
}