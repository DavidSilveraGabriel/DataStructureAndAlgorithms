/*Design a class to find the kth largest element in a stream. Note that it is the kth 
largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer 
array nums, which contains initial elements from the stream. For each call to the method 
KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note:
You may assume that nums' length ≥ k-1 and k ≥ 1.*/

//thanks to v82_ranjan
class KthLargest {
    private int K;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.K = k;
        for(int a: nums){
            add(a);
        }
    }
    
    public int add(int val) {
        pq.add(val);
       // We will return kth largest, so removing element once size crossed K
        if(pq.size() > this.K){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */