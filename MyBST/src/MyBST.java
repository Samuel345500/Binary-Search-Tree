public class MyBST {
    

    private class Node{
        int data;
        Node left;
        Node right;
    

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
    private Node root;




    //to Insert a node in the BST
    public void insert(int data){
        root = insert_aux(root, data);
    }

    private Node insert_aux(Node current, int data){
        if (current == null){
            return new Node(data);
        }

        if (data < current.data){
            current.left = insert_aux(current.left, data);
        } else if (data > current.data){
            current.right = insert_aux(current.right, data);
        }
        return current;
    }


    public void delete(int data){
        root = delete_aux(root, data);
    }

    private Node delete_aux(Node curr, int data){
        //empty tree
        if (curr == null){
            return null;
        }

        //navigate the tree for the node
        if (data < curr.data){
            curr.left = delete_aux(curr.left, data);
        } else if (data > curr.data){
            curr.right = delete_aux(curr.right, data);
        }
        else { //if node is found
            // case 1, if its only the node by itself(no children)
            if(curr.left == null){
                return curr.right;
            }
            else if(curr.right == null){
                return curr.left;
               
            }
        }

        curr.data = minValue(curr.right);
        curr.right = delete_aux(curr.right, curr.data);
        return curr;
    }

    //to find the minimum value in the right subtree of the node to be deleted
    //a little help from copilot
    private int minValue(Node curr){
        int minv = curr.data;
        while (curr.left != null){
            minv = curr.left.data;
            curr = curr.left;
        }
        return minv;
    }


public boolean search (int data){
    return search_aux(root, data);
}

//to search for a node in the BST
//not so hard.
private boolean search_aux(Node curr, int data){

    if (curr == null){
        return false;
    }

    if (data > curr.data){
        return  search_aux(curr.right, data);
    }
    if (data < curr.data){
        return search_aux(curr.left, data);
    }

    return true;
}

//printing tree in pre order (root, left, right)
private void preOrder(Node curr){
    if (curr != null){
        System.out.print(curr.data + "");
        preOrder(curr.left);
        preOrder(curr.right);
        
    }
}
//printing tree in order (left, root, right)
private void inOrder(Node curr){
    if (curr != null){
        inOrder(curr.left);
        System.out.print(curr.data + " ");
        inOrder(curr.right);
    }
}




}