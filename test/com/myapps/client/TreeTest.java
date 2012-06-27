package com.myapps.client;

import com.myapps.server.MyTreeNode;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a mock class to generate sample questions instead of using db
 * User: basilboli
 * Date: 27/06/12
 */
public class TreeTest extends TestCase {

    private static List<String> paths = null;
    private static List<String> questions = null;
    private static String[] first = {"General","Others"};
    private static String[] second = {"Professional","Study","Hobbies"};
    private static String[] third = {"What was you last experience?","What is you motivated by?"};

    private static List<String> getPaths() {
        if (paths == null) {
            paths = new ArrayList<String>();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 3; j++) {
                    //String[] arr = new String[5];
                    for (int k = 0; k < 5; k++) {
                        paths.add(i + "." + j+"."+k);
                    }
                }
            }
        }
        return paths;
    }
    private static List<String> getQuestions() {
        if (questions == null) {
            questions = new ArrayList<String>();
            for (String i : first)
                for (String j : second)
                    for (String k : third)
                        questions.add(i+"."+j+"."+k);


        }
        return questions;
    }


    public void testLoadTree () {
        MyTreeNode tree = new MyTreeNode();
        getPaths();
        System.out.println(paths.toString());
        System.out.print(tree.load(paths));
        assertEquals (tree.getRoot().getChildren().size(),10); //checking whether we have 10 children
        assertEquals(tree.getRoot().getChildren().get(0).getChildren().get(0).getChildren().size(),5);//checking we have 5 leaves
        //TODO can do much more like check whether we have certain depth etc.
    }

    public void testLoadQuestions() {
        MyTreeNode tree = new MyTreeNode();
        System.out.print(tree.load(getQuestions()));
    }

}
