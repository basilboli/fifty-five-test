package com.myapps.server;

import java.util.ArrayList;
import java.util.List;

/**
 * Home-made famous Node class. Nothing special
 * User: basilboli
 * Date: 27/06/12
 */
public class Node {
    private String data;
    private List<Node> children;
    private Node parent;
    private boolean isLeaf=true;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Node> getChildren() {
        if (this.children == null)
            this.children = new ArrayList<Node>();
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void addChild(Node newChild) {
        if (this.children == null)
            this.children = new ArrayList<Node>();
        this.setLeaf(false);
        newChild.setParent(this);
        children.add(newChild);
    }

    public int getChildCount () {
        return this.getChildren().size();
    }

     public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getData().toString());
        return sb.toString();
    }

    public Node getChild(String data) {
        for (Node node : getChildren())
            if (node.getData().equals(data))
                return node;
        return null;
    }
}
