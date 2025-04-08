package Stacks;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 
 */
class MinStack {
    ListNode head;
    
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        int min = head == null ? val : Math.min(val, head.minSoFar);
        ListNode newNode = new ListNode(val, min);
        newNode.next = head;
        head = newNode;
    }
    
    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }
    
    public int top() {
        if (head != null) {
            return head.data;
        }
        throw new RuntimeException("Stack is empty");
    }
    
    public int getMin() {
        if (head != null) {
            return head.minSoFar;
        }
        throw new RuntimeException("Stack is empty");
    }
}

class ListNode {
    int data;
    int minSoFar;
    ListNode next;

    ListNode(int data, int minSoFar) {
        this.data = data;
        this.minSoFar = minSoFar;
        this.next = null;
    }
}
//TC- O(1) all operations, SC-O(n)
//Thsi could also be implemented with 2 stacks, one for min-value.