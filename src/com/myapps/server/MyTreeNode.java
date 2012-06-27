package com.myapps.server;

import java.util.List;

/**
 *
 * User: basilboli
 * Date: 27/06/12
 * Note : due to the task specification the method should be called MyTreeNode. I found it better MyTree instead
 */

 public class MyTreeNode {

    private Node root;

    public MyTreeNode () {
        super();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * loading items to the tree using dot format :see 0.0.0,0.0.1 etc in the specification.
     * @param paths
     * @return
     */
    public MyTreeNode load (List<String> paths) {
        Node rootNode  = new Node ();
        rootNode.setData("ROOT");
        this.setRoot(rootNode);

        for (String elem : paths) {
            populate(elem.split("\\."),rootNode,0);
        }
        return this;
    }

    /**
     * recursively populating the tree using the dot format (see spec: we can have smth like 0.0.0.1 as input)
     * @param elem
     * @param rootNode
     * @param depth using tree depth to define return point of the recursion
     */
    public void populate(String [] elem,Node rootNode, int depth) {

        if (depth>=elem.length-1) {
            Node newChildNode = new Node();
            newChildNode.setData(elem[depth]);
            rootNode.addChild(newChildNode);
            return;
        }
        Node child = rootNode.getChild(elem[depth]);

        if (child==null) {
            child = new Node();
            child.setData(elem[depth]);
            rootNode.addChild(child);
        }
        depth++;
        populate(elem, child,depth);
    }

    /**
     *this is the only method which is a bit tricky =), fighting to get print layout asked in the specification.
     * TODO:  can and should be revised
     * @param node
     * @param sb
     * @param prefix
     * @param shift
     */
    public void walkThrough (Node node, StringBuilder sb,String prefix,String shift) {
        Node parent = node.getParent();
        if (parent!=null && !parent.getData().equals("ROOT")) {
            prefix+=node.getParent().toString()+".";
        }
        sb.append("\n" + shift + prefix + node.toString());

        if (node.isLeaf())
            prefix="";

        for (Node item : node.getChildren())
            walkThrough(item,sb,prefix,shift+"   ");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String prefix = new String();
        walkThrough(root,sb,prefix,"");
        return sb.toString();
    }
}
