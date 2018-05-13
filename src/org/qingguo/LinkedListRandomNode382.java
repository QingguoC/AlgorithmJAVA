package org.qingguo;

import java.util.Random;
// Reservoir Sampling k numbers from n numbers;
/*
using the current sample size, sample the current position with the k/n rate, use it to replace one
of sample in the previous selected.

proof:
if n == k, hold;
for n > k :
for any number X in the previous selected's prob is k/(n-1), then the prob staying in current k list is:
k/(n-1) * (
(1-k/n) this is the ratio not select the current number D
+ (k/n) * (1-1/k)  this is the ratio select current number D to replace the other numbers not the number X
)
= k/n
of course D in the k list prob is k/n
So every number has k/n ratio to be selected.
 */
public class LinkedListRandomNode382 {
    ListNode head;
    Random random;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode382(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curr = head;
        int res = curr.val;
        int i = 1;
        while (curr.next != null){
            curr = curr.next;
            if (random.nextInt(++i) == 0){
                res = curr.val;
            }
        }
        return res;
    }
}
