package com.codecool.linkedlist;

public class LinkedList<E> {

    private ListElement head;
    private ListElement tail;
    private int length;


    public LinkedList() {
        length = 0;
    }

    public LinkedList(E element) {
        head = new ListElement(element);
        tail = head;
        length = 1;
    }

    public E getItemAtHead() {
        return head.getValue();
    }

    public E getItemAtTail() {
        return tail.getValue();
    }

    public int getLength() {
        return length;
    }

    public void add(E element) {
        ListElement newElement = new ListElement(element);
        if (length == 0) {
            head = newElement;
            tail = head;
        } else {
            tail.setNext(newElement);
            newElement.setPrevious(tail);
            tail = newElement;
        }
        length++;
    }

    public void remove(E element) {
        ListElement actualElement = head;
        while (actualElement.hasNext()) {
            if (actualElement.getValue().equals(element)) {
                if (actualElement.equals(head)) {
                    removeElementAtHead();
                } else if (actualElement.equals(tail)) {
                    removeElementAtTail();
                } else {
                    ListElement previousElement = actualElement.getPrevious();
                    ListElement nextElement = actualElement.getNext();
                    previousElement.setNext(nextElement);
                    nextElement.setPrevious(previousElement);
                    actualElement.setPrevious(null);
                    actualElement.setNext(null);
                    length--;
                }
            }
        }
    }

    public void removeElementAtHead() {
        if (length == 0) {
            return;
        } else if (length == 1) {
            head = null;
            tail = null;
        } else {
            ListElement newHead = head.getNext();
            newHead.setPrevious(null);
            head.setNext(null);
            head = newHead;
            length--;
        }
    }

    public void removeElementAtTail() {
        if (length == 0) {
            return;
        } else if (length == 1) {
            head = null;
            tail = null;
        } else {
            ListElement newTail = tail.getPrevious();
            newTail.setNext(null);
            tail.setPrevious(null);
            tail = newTail;
            length--;
        }
    }

    private class ListElement {

        private ListElement next;
        private ListElement previous;
        private E value;

        private ListElement(E value) {
            this.value = value;
        }

        private ListElement getNext() {
            return next;
        }

        private void setNext(ListElement next) {
            this.next = next;
        }

        private ListElement getPrevious() {
            return previous;
        }

        private void setPrevious(ListElement previous) {
            this.previous = previous;
        }

        private E getValue() {
            return value;
        }

        private boolean hasNext() {
            return next != null;
        }

        private boolean hasPrevious() {
            return previous != null;
        }
    }
}
