/*Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates. 
A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:

Input: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output: 
[null,[4,1],[4,1],[3,3]]
Example 2:

Input: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.*/

//thanks to kunal_mestry

class Solution {
    Random random;
    TreeMap<Integer,int[]> map;
    int areasum=0;
    public Solution(int[][] rects) {
        this.random = new Random();
        this.map = new TreeMap();
        int len = rects.length;
        for(int i=0;i<len;i++){
            int[] coord_rect = rects[i];
            int length = coord_rect[2]-coord_rect[0]+1;//se usa el +1 para considerar el borde
            int breath = coord_rect[3]-coord_rect[1]+1;//se usa el +1 para considerar el borde
            areasum += length*breath;
            map.put(areasum,coord_rect);
        }
    }
    
    public int[] pick() {
        //no te olvides el +1 por que lo necesitamos[1,area] mientras el nextint genera[0,area-1]
        int key = map.ceilingKey(random.nextInt(areasum)+1);
        int[] rectangle = map.get(key);
        int length = rectangle[2]-rectangle[0]+1;//se usa el +1 para considerar el borde
        int breath = rectangle[3]-rectangle[1]+1;//se usa el +1 para considerar el borde
        int x = rectangle[0]+random.nextInt(length);
        int y = rectangle[1]+random.nextInt(breath);
        return new int[]{x,y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */