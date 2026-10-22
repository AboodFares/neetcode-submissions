/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // first lets create an empty linkedlist that we will return

        ListNode dummy = new ListNode();   // bookmark — never moves
        ListNode sum = dummy;              // walker — builds the dummy (everytime you are sum.next= whatever ) you are adding a node with value to dummy whiout changing the node

        while(list1 != null && list2 != null){ // its not moving to the next, just checking

            if(list1.val < list2.val){
                sum.next = list1;   //.next needs a whole box(list1) not a number list1.val
                list1 = list1.next;                    // thats how we move it
                sum = sum.next;
            }
            else {
                sum.next = list2;
                list2 = list2.next; 
                sum = sum.next;
            }

        }
        sum.next = (list1 != null) ? list1 : list2; // attatching whatever is left
        return dummy.next; // .next because we want to remove the fake node we created
        
        // when we return a node it will return it with the next nodes attach to it, (without the nodes behind)


      



    }
    } // we compare the first node(list1) with first node(list2), if first node(list1) is smaller, then add it to the list we are making
    // then compare teh second node(list1) to first node(list2)
    // i think we will use nested loop for time complexity of O(n+)