package com.rajesh.practice.hard;

import com.rajesh.practice.easy.ListNode;

public class MergeKSortedLists
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length == 0)
        {
            return null;
        }
        /*
         * ListNode resultNode = lists[0]; for (int i = 1; i < lists.length; i++) { resultNode =
         * mergeTwoLists(resultNode, lists[i]); } return resultNode;
         */

        // divide and conquer

        return divideAndConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideAndConquer(ListNode[] lists, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        if (start == end)
        {
            return lists[start];
        }

        if (start + 1 == end)
        {
            return mergeTwoLists(lists[start], lists[end]);
        }

        int mid = start + (end - start) / 2;
        ListNode l1 = divideAndConquer(lists, start, mid - 1);
        ListNode l2 = divideAndConquer(lists, mid, end);

        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode l3 = null;
        ListNode temp = null;
        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                if (l3 == null)
                {
                    l3 = new ListNode(l1.val);
                    // temp = l1;
                }
                else
                {
                    // temp.next = l1;
                    insertNode(l3, l1.val);
                }
                l1 = l1.next;
            }
            else
            {
                if (l3 == null)
                {
                    l3 = new ListNode(l2.val);
                    // temp = l2;
                }
                else
                {

                    // temp.next = l2;
                    insertNode(l3, l2.val);
                }
                l2 = l2.next;
            }
        }

        while (l1 != null)
        {
            if (l3 == null)
            {
                l3 = insertNode(l3, l1.val);
            }
            else
            {
                insertNode(l3, l1.val);
            }
            l1 = l1.next;
        }

        while (l2 != null)
        {
            if (l3 == null)
            {
                l3 = insertNode(l3, l2.val);
            }
            else
            {
                insertNode(l3, l2.val);
            }
            l2 = l2.next;
        }
        return l3;
    }

    private static ListNode insertNode(ListNode head, int value)
    {
        if (head == null)
        {
            head = new ListNode(value);
            return head;
        }
        ListNode temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = new ListNode(value);
        return head;
    }
}
