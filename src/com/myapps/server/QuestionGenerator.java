package com.myapps.server;

import java.util.ArrayList;
import java.util.List;

/**
 * User: basilboli
 * Date: 27/06/12
 */
public class QuestionGenerator {

    private static String[] first = {"General","Others"};
    private static String[] second = {"Professional","Study","Hobbies"};
    private static String[] third = {"What was you last experience?","What is you favourite?"};
    private static List<String> questions = null;


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

    public static String getSampleTree() {
        MyTreeNode sample  = new MyTreeNode();
        return toHTML(sample.load(getQuestions()));
    }

    private static String toHTML(MyTreeNode treeNode){
        StringBuilder sb = new StringBuilder();
        walkThoughTheTree(treeNode.getRoot(),sb," ");
        return sb.toString();
    }

    private static void walkThoughTheTree(Node node, StringBuilder sb, String shift) {
        sb.append("<br>"+shift + node.toString());
        for (Node item : node.getChildren())
            walkThoughTheTree(item, sb, shift+"&nbsp;&nbsp;");
    }
}
