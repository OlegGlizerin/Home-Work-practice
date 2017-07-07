package linkedListMax;

import person.Person;

import java.util.NoSuchElementException;

/**
 * Created by HawkEye on 01/07/2017.
 */
public  class LinkedListMax<E extends Comparable<E>> {
    private Strategy strategy;
    private Node head;
    private Node tail;
    private int size;

    public LinkedListMax() {
        size = 0;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    private class Node {
        private E element;
        private Node next;
        private Node prev;

        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // add the element O(n) worst case, O(1) best case
    public void addAndKeepSorted(E newElement) {
        Node tmp = new Node(newElement, head, null);
        if(head == null && tail == null) {
            tail = tmp;
            head = tmp;
            head.next = null;
            head.prev = null;
            tail.next = null;
            tail.prev = null;
            size++;
        }
        else if(strategy.compareStrategy(tmp.element, head.element ) < 0){
            tmp.next = head;
            head.prev = tmp;
            head = tmp;
            tmp.prev = null;
            size++;
        }
        else {
            Node after = head.next;
            Node before = head;
            if(after != null) {
                while (strategy.compareStrategy(tmp.element, before.element) >= 0 && strategy.compareStrategy(tmp.element, after.element) >= 0) {
                    before = after;
                    after = after.next;
                    if(after == null) {
                        break;
                    }
                }
            }
            else {
                before.next = tmp;
                tmp.next = null;
                tmp.prev = before;
                tail = tmp;
            }

            if(after == null) {
                before.next = tmp;
                tmp.next = null;
                tmp.prev = before;
                tail = tmp;
            }
            else {
                if (strategy.compareStrategy(tmp.element, before.element) >= 0 && strategy.compareStrategy(tmp.element, after.element) < 0) {
                    before.next = tmp;
                    tmp.next = after;
                    tmp.prev = before;
                    after.prev = tmp;
                } else if (strategy.compareStrategy(tmp.element, before.element) >= 0 && strategy.compareStrategy(tmp.element, after.element) > 0) {
                    tmp.next = after.next;
                    after.next = tmp;
                    tmp.prev = after;
                    tail = tmp;
                }
            }



            size++;
        }
    }

    //prints the linked list forward
    public void iterateForward(){
        System.out.println("iterating forward..");
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.element.toString());
            tmp = tmp.next;
        }
    }


    //remove the element with the maximum value sorted by the strategy variable we choose in the main, O(1) because it will be always the last item.
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node tmp = tail;
        tail = tail.prev;
        size--;
        return tmp.element;
    }

    //check if person in the linked list O(n)
    public boolean contains(Person p) {
        if(p == null) {
            throw new NullPointerException("The person is null - please fix.");
        }
        Node tmp = head;
        while(tmp != null) {
            if(((Person)tmp.element).compareTo(p) == 0 ) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public void addFirst(E element) {
        Node tmp = new Node(element, head, null);
        if(head != null ) {
            head.prev = tmp;
        }
        head = tmp;
        if(tail == null) {
            tail = tmp;
        }
        size++;
        System.out.println("adding: "+element);
    }

    public void addLast(E element) {
        Node tmp = new Node(element, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
        System.out.println("adding: "+element);
    }

    //prints the linked list backword
    public void iterateBackward(){
        System.out.println("iterating backword..");
        Node tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }


    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        return tmp.element;
    }

}
