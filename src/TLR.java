/**
 * Created by AN039ME on 10/28/2015.
 */
public class TLR {

    public static void main(String[] args){
        Node rootNode = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(3);

        Tree tree = new Tree(rootNode);
        tree.addNode(rootNode, node2);
        tree.addNode(rootNode, node3);
        tree.print(rootNode);

        treeToList(rootNode);
    }

    private static void treeToList(Node rootNode) {
        if(rootNode.left != null){
            rootNode.previous = rootNode.left;
            rootNode.left.next = rootNode;
        }
        if(rootNode.right != null){
            rootNode.next = rootNode.right;
            rootNode.right.previous = rootNode;
        }
        if(rootNode.left != null && rootNode.right != null){
            rootNode.left.previous = rootNode.right;
            rootNode.right.next = rootNode.left;
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node next;
    Node previous;

    Node(int data){
        this.data = data;
    }
}

class Tree {
    Node startNode;

    Tree(Node startNode){
        this.startNode = startNode;
    }

    public void addNode(Node parentNode, Node node) {
        if(node.data <= parentNode.data){
            if(parentNode.left == null){
                parentNode.left = node;
            }
            else {
                addNode(parentNode.left, node);
            }
        }
        else if(node.data > parentNode.data){
            if(parentNode.right == null){
                parentNode.right = node;
            }
            else
            {
                addNode(parentNode.right, node);
            }
        }
    }

    public void print(Node node){
        if(node.left != null){
            print(node.left);
        }
        System.out.println(node.data);
        if(node.right != null){
            print(node.right);
        }
    }
}
