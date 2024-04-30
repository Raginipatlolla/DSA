import javax.xml.soap.Node;

import DataStructures.BinarySearchTree;
import DataStructures.LinkedList;

public class Main {
    public static void main(String[] args) {

/*
        LinkedList linkedList=new LinkedList(4);
        BinarySearchTree bst=new BinarySearchTree();
        linkedList.append(8);
        linkedList.append(15);
        linkedList.append(16);
        linkedList.append(23);
        linkedList.append(42);
*/


     //   linkedList.printList();

        System.out.println("--------");
   //     System.out.println("getValue: "+linkedList.remove(2));
      //  linkedList.get(3);
  //      linkedList.printList();
        BinarySearchTree bst=new BinarySearchTree();
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(52);
        bst.insert(82);
        bst.insert(27);
bst.printTreeInOrder();

    }
}