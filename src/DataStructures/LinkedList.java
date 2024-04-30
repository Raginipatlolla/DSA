package DataStructures;

import java.util.HashSet;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;

        Node prev;

        Node(int value){
            this.value=value;
        }

        @Override
        public String toString() {
            return String.valueOf(value); // Or whatever you want to represent the node content
        }
    }
    public LinkedList(int value){
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;

    }
    public void printList(){
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }

    }
    public void getHead(){
        System.out.println("Head: "+head.value);
    }
    public void getTail(){
        System.out.println("Tail: "+tail.value);
    }
    public  void getLength(){
        System.out.println("Length: "+length);
    }



    public void append(int value){
        Node newNode=new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length==0) return null;
       Node temp=head;
       Node pre=head;
       while(temp.next!=null){
           pre=temp;
           temp=temp.next;
       }
       tail=pre;
       tail.next=null;
       length--;
       if(length==0){
           head=null;
           tail=null;
       }
       return temp;
    }

    public void prepend(int value){
        Node newNode=new Node(value);
        if(length ==0){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        length++;
    }
    public Node removeFirst(){
        if(length==0) return null;
        Node temp =head;
        head=head.next;
        temp.next=null;
        length--;
        if(length==0){
            tail=null;
        }
        return  temp;
    }

   /* public Node get(int index){
        if(index<0 || index>=length){
            return null;
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }*/

    /*public boolean set(int index,int value){
        Node temp =get(index);
        if(temp!=null){
            temp.value=value;
            return true;
        }
        return false;
    }*/

    /*public boolean insert(int index,int value){
        if(index<0 || index>length) return false;
        if(index==0){
            prepend(value);
            return true;
        }
        Node newNode=new Node(value);
        Node temp=get(index-1);
        newNode.next=temp.next;
        temp.next=newNode;
        length++;
        return true;
    }*/


   /* public Node remove(int index){
        if(index<0 || index>=length) return null;
        if(index==0) return removeFirst();
        if(index==length-1) return removeLast();
        Node prev=get(index-1);
        Node temp=prev.next;
        prev.next=temp.next;
        temp.next=null;
        length--;
        return  temp;
    }*/

    public void reverse(){
        Node temp=head;
        head=tail;
        tail=temp;
        Node after=temp.next;
        Node before=null;
        for(int i=0;i<length;i++){
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }

    }

    public Node findMiddleNode(){
        Node slowPtr=head;
        Node fastPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
         slowPtr=slowPtr.next;
         fastPtr=fastPtr.next.next;
        }
        return slowPtr;
    }
    public Node partition(Node head,int x){
        if(head==null || head.next==null) return head;
        Node d1=new Node(0);
        Node d2=new Node(0);
        Node low=d1;
        Node high=d2;
        Node current=head;

        while(current!=null)
        {
            if(current.value<x){
                low.next=current;
                low=current;
            }else{
                high.next=current;
                high=current;
            }
            current=current.next;
        }
        low.next=d2.next;
        high.next=null;
        return d1.next;
    }

    public void removeDuplicates() {
        if (head == null) return;
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            int val = current.value;
            if (hs.contains(val)) {
                prev.next = current.next;
            } else {
                hs.add(val);
                prev = current;
            }
            current = current.next;
        }
    }

    public void reverseBetween(int left, int right){
      // create a dummy node to mark the head of this list
        Node dummy=new Node(0);
        dummy.next=head;
        //make markers for currentNode and for the node before reversing
        Node leftPre=dummy;
        Node currNode=head;
        for(int i=0;i<left-1;i++){
            leftPre=leftPre.next;
            currNode=currNode.next;
        }
        //make a market to the Node where we start reversing
        Node subListHead=currNode;
        Node preNode=null;
        for(int i=0;i<=right-left;i++){
            Node nextNode=currNode.next;
            currNode.next=preNode;
            preNode=currNode;
            currNode=nextNode;
        }
        leftPre.next=preNode;
        subListHead.next=currNode;
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp;
        if(index<(length/2))
        {
            temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
        }
        else{
            temp=tail;
            for(int i=length-1;i>index;i--){
                temp=temp.prev;
            }
        }
        return temp;
    }

    public boolean insert(int index, int value)
    {if(index<0 || index>length){
            return false;}
        if(index==0){
            prepend(value);
            return true;
        }
        if(index==length){
            append(value);
            return true;
        }
        Node newNode=new Node(value);
        Node before=get(index-1);
        Node after=before.next;
        newNode.prev=before;
        newNode.next=after;
        before.next=newNode;
        after.prev=newNode;
        length++;
        return true;
    }


    public Node remove(int index){
        if(index<0 || index>length) return null;
        if (index==0) return removeFirst();
        if (index==length-1) return removeLast();
        Node temp=get(index);
        temp.next.prev=temp.prev;
        temp.prev.next=temp.next;
        temp.next=null;
        temp.prev=null;

        length--;
        return temp;
    }

}
