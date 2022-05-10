package com.company;

public class CircularDoubleLinkedList {

    private static class Node{
        private int ID;
        private String Name;
        private Node next;
        private Node prev;

        public Node(int ID,String Name , Node next , Node prev) {
            this.ID = ID;
            this.Name = Name;
            this.prev = prev;
            this.next = next;
        }

        public int getID() {
            return ID;
        }
        public String getName(){
            return Name;
        }
        public Node getNext(){
            return next;
        }
        public Node getPrev(){
            return prev;
        }


        public void setID(int ID) {
            this.ID = ID;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
    private Node head = null;
    private Node tail = null;
    private  int size = 0;
    public CircularDoubleLinkedList(){}

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return  size == 0;
    }
    public int firstID(){

        return head.getID();
    }

    public int lastID(){

        return tail.getID();
    }

    public void forwardTraversing(){
        if (size == 0){
            System.out.println("list is empty");
        }
        else {

            Node current = head;
            do {
                System.out.println(" ID: " + current.ID + "  name: " + current.Name);
                current = current.next;
            } while (current != head);

        }

    }

    public void backwardTraversing(){
        if (size == 0){
            System.out.println("list is empty");
        }

        Node current = head;
        do {
            System.out.println("course ID: " + current.ID + " course name: " + current.Name);
            System.out.println("---------------------------");
            current = current.prev;
        }while (current != head);

    }

    public void find(int ID){
        if (size == 0 ){
            System.out.println("list is empty");
        }
        boolean flag =false;
        Node current = head;
        int counter = 0;
        do {
            if (current.ID == ID){
                flag = true;
            }

            current = current.next;
            counter++;
        }while (current != head);

        if (flag == true){
            System.out.println(ID + " has been found at node #" + counter);
        }
        else {
            System.out.println("course ID is not found");
        }
    }


    public void addFirst(int ID , String Name){
        Node newNode =new Node(ID , Name , null , null);
        if (head == null){
            head = newNode;
            tail = head;
            newNode.next = head;
            newNode.prev = head;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = tail;
            tail.next = newNode;
            head = newNode;
        }
        size++;

    }

    public void addLast(int ID , String Name){
        Node newNode =new Node(ID , Name , null , null);
        if (head == null){
            head = newNode;
            tail = head;
            newNode.next = head;
            newNode.prev = head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
        size++;


    }

    public void addNode(int ID , String name , int pos){
        if (pos == 1){
            addFirst(ID , name);
            return;
        }

        Node newNode = new Node( ID , name , null , null);
        Node current = head;
        int count = 1;
        while (count < pos - 1 && current.next != head){
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;

    }


    public void removeFirst(){
        if (head == null){
            System.out.println("list is empty");
        }
        head = head.next;
        tail.next = head;
        head.prev = tail;
        size -= 1;

        if (size == 0 ){
            head = tail = null;
        }

    }

    public void removeLast(){
        if (head == null){
            System.out.println("list is empty");
        }
        else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
            size--;

        }
        if (size == 0 ){
            head = tail = null;
        }

    }


    public void removeNode(int ID) {
        if (size == 0) {
            System.out.println("list is empty");
        }


        if (head.ID == ID) {
            removeFirst();
        }
        Node current = head;
        Node previous = head;

        while (current.ID != ID){
            if (current.next == head){
                System.out.println("can't find value");
                return;
            }
            else{
                previous = current;
                current = current.next;
            }
        }

        previous.next = current.next;
        current = current.next;
        current.prev = previous;
        size -= 1;

    }

    public void findDuplicate(){

        if (size==0){
            System.out.println("List is empty");
            return;
        }

        Node current=head;
        Node temp;
        int id;

        if(size==0){
            System.out.println("list is empty");
            return;
        }
        if(size==1){
            System.out.println("no duplicate found");
            return;
        }

        for(int i=0;i<size;i++){
            id=current.ID;
            temp=current.next;

            for(int j=i;j<size-1;j++){

                if(temp.ID==id)
                    System.out.println("Duplicated ID is "+id+" for course: "+current.Name+" ,"+temp.Name);

                temp=temp.next;
            }
            current=current.next;
        }
    }




}
