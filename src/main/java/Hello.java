import dataStructure.BST;
import utils.printer.BinaryTrees;

public class Hello {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        Integer[] integers = {7, 4, 9, 2, 5, 8, 11, 3};

        for (Integer ele : integers){
            bst.add(ele);
        }

        BinaryTrees.println(bst);

        bst.preorderTraversal();
    }


}
