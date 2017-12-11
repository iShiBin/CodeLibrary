package problem;

import list.*;

public class CheckingCycle {
  public static ListNode hasCycle(ListNode head) {
    ListNode fast = head, slow = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        // There is a cycle, so now let's calculate the cycle length.
        int cycleLen = 0;
        do {
          ++cycleLen;
          fast = fast.next;
        } while (slow != fast);

        // Finds the start of the cycle.
        ListNode cycleLenAdvancedIter = head;
        // cycleLenAdvancedIter pointer advances cycleLen first.
        while (cycleLen-- > 0) {
          cycleLenAdvancedIter = cycleLenAdvancedIter.next;
        }

        ListNode iter = head;
        // Both iterators advance in tandem.
        while (iter != cycleLenAdvancedIter) {
          iter = iter.next;
          cycleLenAdvancedIter = cycleLenAdvancedIter.next;
        }
        return iter; // iter is the start of cycle.
      }
    }
    return null; // no cycle.
  }
}