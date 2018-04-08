'''
Given a list, rotate the list to the right by k places, where k is non-negative.

Example: 
Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
'''

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head == None or head.next == None or k==0:
            return head


        old_head = head
        t1 = head
        t2 = head
        while t1.next:
            t1 = t1.next
            if k==0:
                t2 = t2.next
            else:
                k-=1
        new_head = t2.next
        t2.next = None
        t1.next = old_head
        return new_head
        


if __name__ == "__main__":
    solution = Solution()
    t1 = ListNode(1)
    t1.next = ListNode(2)
    t1.next.next = ListNode(3)
    t1.next.next.next = ListNode(4)
    t1.next.next.next.next = ListNode(5)
    result1 = solution.rotateRight(t1, 2)
    while result1:
        print(result1.val)
        result1=result1.next

    print()
    t2 = ListNode(1)
    t2.next = ListNode(2)
    result2 = solution.rotateRight(t2, 0)
    while result2:
        print(result2.val)
        result2 = result2.next