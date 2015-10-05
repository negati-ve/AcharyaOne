package com.example.jokerlol.acharyaone;

/**
 * Created by Joker LOL on 8/28/2015.
 */
public class arraytimetable {

    public arraytimetable() {
    }

    public String[][] choosetimetable(int sem,int sec){
        String sample = Integer.toString(sem)+Integer.toString(sec);
        String[][] displaytimetable= new String[][] {{"-","-","-","-","-","-","-","-"},
                {"-","-","-","-","-","-","-","-"},
                {"-","-","-","-","-","-","-","-"},
                {"-","-","-","-","-","-","-","-"},
                {"-","-","-","-","-","-","-","-"}};;
        switch(sample){
            case "31" :
                displaytimetable = new String[][] {{"EC LAB-A2/DS LAB-A1","EC LAB-A2/DS LAB-A1","EC LAB-A2/DS LAB-A1","OOPS","DMS","EC","LD","M-III"},
                        {"M-III","EC","LD","OOPS","DMS","DS","DS","-"},
                        {"EC","DMS","DS","LD","M-III","FORUM ACTIVITY","FORUM ACTIVITY","FORUM ACTIVITY"},
                        {"DMS","M-III","DS","OOPS","LD","EC LAB-A1/DS LAB-A2","EC LAB-A1/DS LAB-A2","EC LAB-A1/DS LAB-A2"},
                        {"EC","M-III","SPT","SPT","SPT","DMS","OOPS","-"}};
                break;
            case "32" :
                displaytimetable = new String[][] {{"OOPS","DS","LD","DMS","EC","M-III","-","-"},
                        {"DMS","LD","M-III","EC","DS","EC LAB-B1/DS LAB-B2","EC LAB-B1/DS LAB-B2","EC LAB-B1/DS LAB-B2"},
                        {"LD","OOPS","DMS","M-III","DS","FORUM ACTIVITY","FORUM ACTIVITY","FORUM ACTIVITY"},
                        {"M-III","DMS","DS","EC","OOPS","SPT","SPT","SPT"},
                        {"LD","OOPS","M-III","EC","DMS","EC LAB-B2/DS LAB-B1","EC LAB-B2/DS LAB-B1","EC LAB-B2/DS LAB-B1"}};
                break;
            case "33" :
                displaytimetable = new String[][] {{"M-III","EC","DS","LD","OOPS","DMS","SPT","SPT"},
                        {"LD","DS","M-III","EC","DMS","OOPS","LD","-"},
                        {"EC LAB-C2/DS LAB-C1","EC LAB-C2/DS LAB-C1","EC LAB-C2/DS LAB-C1","OOPS","M-III","FORUM ACTIVITY","FORUM ACTIVITY","FORUM ACTIVITY"},
                        {"EC LAB-C1/DS LAB-C2","EC LAB-C1/DS LAB-C2","EC LAB-C1/DS LAB-C2","EC","DS","DMS","M-III","-"},
                        {"DS","EC","OOPS","LD","M-III","DMS","DMS","-"}};

                break;
            case "41" :
                displaytimetable = new String[][] {{"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"}};

                break;
            case "42" :
                displaytimetable = new String[][] {{"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"}};

                break;
            case "43" :
                displaytimetable = new String[][] {{"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"}};

                break;
            case "51" :
                displaytimetable = new String[][] {{"OS","FLAT","DBMS LAB A1/SS&OS LAB A2","DBMS LAB A1/SS&OS LAB A2","DBMS LAB A1/SS&OS LAB A2","SS","DBMS","-"},
                        {"FLAT","DBMS","SPT","SPT","SPT","CN-1","SE","SS"},
                        {"OS","DBMS","SS","SE","CN-1","FORUM ACTIVITY","FORUM ACTIVITY","FORUM ACTIVITY"},
                        {"SE","OS","DBMS LAB A2/SS&OS LAB A1","DBMS LAB A2/SS&OS LAB A1","DBMS LAB A2/SS&OS LAB A1","FLAT","CN-1","-"},
                        {"CN-1","SS","SE","OS","FLAT","DBMS","-","-"}};

                break;
            case "52" :
                displaytimetable = new String[][] {{"OS","SE","CN-1","SS","DBMS","FLAT","-","-"},
                        {"DBMS","OS","SS","CN-1","SE","DBMS LAB B1/SS&OS LAB B2","DBMS LAB B1/SS&OS LAB B2","DBMS LAB B1/SS&OS LAB B2"},
                        {"FLAT","DBMS","OS","DBMS LAB B2/SS&OS LAB B1","DBMS LAB B2/SS&OS LAB B1","FORUM ACTIVITY","FORUM ACTIVITY","FORUM ACTIVITY"},
                        {"SS","FLAT","DBMS","SE-1","CN-1","-","-","-"},
                        {"FLAT","OS","SS","CN-1","SE","SPT","SPT","SPT"}};

                break;
            case "53" :
                displaytimetable = new String[][] {{"OS[103]","CN-1[103]","DBMS[304]","OS[304]","SE[304]","FLAT[305]","SS[305]","-"},
                        {"SLS","SLS","DBMS[305]","OS[305]","SE[305]","-","-","-"},
                        {"CN-1[303]","FLAT[303]","OS[303]","SE[301]","SS[301]","SPT[301]","SPT[301]","SPT[301]"},
                        {"DBMS[303]","SS[303]","FLAT[304]","CN-1[304]","SE[304]","DBMS LAB C1/SS&OS LAB C2","DBMS LAB C1/SS&OS LAB C2","DBMS LAB C1/SS&OS LAB C2"},
                        {"FLAT[101]","DBMS[101]","DBMS LAB C2/SS&OS LAB C1","DBMS LAB C2/SS&OS LAB C1","DBMS LAB C2/SS&OS LAB C1","SS[203]","CN-1[203]","-"}};

                break;
            case "61" :
                displaytimetable = new String[][] {{"OS","FLAT","DBMS LAB A1/SS&OS LAB A2","DBMS LAB A1/SS&OS LAB A2","DBMS LAB A1/SS&OS LAB A2","SS","DBMS","-"},
                        {"FLAT","DBMS","SPT","SPT","SPT","CN-1","SE","SS"},
                        {"OS","DBMS","SS","SE","CN-1","FORUM ACTIVITY","FORUM ACTIVITY","FORUM ACTIVITY"},
                        {"SE","OS","DBMS LAB A2/SS&OS LAB A1","DBMS LAB A2/SS&OS LAB A1","DBMS LAB A2/SS&OS LAB A1","FLAT","CN-1","-"},
                        {"CN-1","SS","SE","OS","FLAT","DBMS","-","-"}};

                break;
            case "62" :
                displaytimetable = new String[][] {{"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"}};

                break;
            case "63" :
                displaytimetable = new String[][] {{"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"}};

                break;
            case "71" :
                displaytimetable = new String[][] {{"OOMD","ECS","C#","ACA","WEB","N/W LAB A1/WEB LAB A2","N/W LAB A1/WEB LAB A2","N/W LAB A1/WEB LAB A2"},
                        {"C#","JAVA","N/W LAB A2/WEB LAB A1","N/W LAB A2/WEB LAB A1","N/W LAB A2/WEB LAB A1","WEB","JAVA","-"},
                        {"ACA","OOMD","ECS","JAVA","WEB","FORUM ACTIVITY","FORUM ACTIVITY","FORUM ACTIVITY"},
                        {"ACA","ECS","WEB","C#","OOMD","-","-","-"},
                        {"JAVA","OOMD","ECS","C#","ACA","-","-","-"}};
                break;
            case "72" :
                displaytimetable = new String[][] {{"JAVA","C#","ECS","OOMD","ACA","-","-","-"},
                        {"WEB","ECS","OOMD","JAVA","ACA","-","-","-"},
                        {"N/W LAB B1/WEB LAB B2","N/W LAB B1/WEB LAB B2","WEB","ECS","C#","FORUM ACTIVITY","FORUM ACTIVITY","FORUM ACTIVITY"},
                        {"JAVA","C#","ACA","WEB","OOMD","ACA","ECS","-"},
                        {"N/W LAB B2/WEB LAB B1","N/W LAB B2/WEB LAB B1","JAVA","WEB","C#","-","-","-"}};
                break;
            case "73" :
                displaytimetable = new String[][] {{"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"}};
                break;
            case "81" :
                displaytimetable = new String[][] {{"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"}};

                break;
            case "82" :
                displaytimetable = new String[][] {{"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"}};

                break;
            case "83" :
                displaytimetable = new String[][] {{"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"},
                        {"os","os","os","os","os","os","os","os"}};

                break;
        }
        return displaytimetable;
    }

    public int[][] choosetimetableweight(int sem,int sec){
        String sample = Integer.toString(sem)+Integer.toString(sec);
        int[][] displaytimetableweight = new int[][] {{1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1}};
        switch(sample){
            case "31" :
                displaytimetableweight = new int[][] {{3,0,0,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,3,0,0},
                        {1,1,1,1,1,3,0,0},
                        {1,1,1,2,0,1,1,1}};
                break;
            case "32" :
                displaytimetableweight = new int[][] {{1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,3,0,0},
                        {1,1,1,1,1,3,0,0},
                        {1,1,1,1,1,3,0,0},
                        {1,1,1,1,1,3,0,0}};
                break;
            case "33" :
                displaytimetableweight = new int[][] {{1,1,1,1,1,1,2,0},
                        {1,1,1,1,1,1,1,1},
                        {3,0,0,1,1,3,0,0},
                        {3,0,0,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1}};
                break;
            case "41" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                    {1,1,2,1,0,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,3,0,0},
                    {2,0,1,1,1,1,1,1}};
            break;
            case "42" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                    {1,1,2,1,0,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,3,0,0},
                    {2,0,1,1,1,1,1,1}};
            break;
            case "43" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                    {1,1,2,1,0,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,3,0,0},
                    {2,0,1,1,1,1,1,1}};
            break;
            case "51" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                        {1,1,3,0,0,1,1,1},
                        {1,1,1,1,1,3,0,0},
                        {1,1,3,0,0,1,1,1},
                        {1,1,1,1,1,1,1,1}};
                break;
            case "52" :
                displaytimetableweight = new int[][] {{1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,3,0,0},
                        {1,1,1,2,0,3,0,0},
                        {1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,3,0,0}};
                break;
            case "53" :
                displaytimetableweight = new int[][] {{1,1,1,1,1,1,1,1},
                        {2,0,1,1,1,1,1,1},
                        {1,1,1,1,1,3,0,0},
                        {1,1,1,1,1,3,0,0},
                        {1,1,3,0,0,1,1,1}};
                break;
            case "61" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                    {1,1,3,0,0,1,1,1},
                    {1,1,1,1,1,3,0,0},
                    {1,1,3,0,0,1,1,1},
                    {1,1,1,1,1,1,1,1}};
            break;
            case "62" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                    {1,1,2,1,0,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,3,0,0},
                    {2,0,1,1,1,1,1,1}};
            break;
            case "63" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                    {1,1,2,1,0,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,3,0,0},
                    {2,0,1,1,1,1,1,1}};
            break;
            case "71" :
                displaytimetableweight = new int[][] {{1,1,1,1,1,3,0,0},
                        {1,1,3,0,0,1,1,1},
                        {1,1,1,1,1,3,0,0},
                        {1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1}};
                break;
            case "72" :
                displaytimetableweight = new int[][] {{1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1},
                        {2,0,1,1,1,3,0,0},
                        {1,1,1,1,1,1,1,1},
                        {2,0,1,1,1,1,1,1}};
                break;
            case "73" :
                displaytimetableweight = new int[][] {{1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1},
                        {2,0,1,1,1,3,0,0},
                        {1,1,1,1,1,1,1,1},
                        {2,0,1,1,1,1,1,1}};
                break;
            case "81" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                    {1,1,2,1,0,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,3,0,0},
                    {2,0,1,1,1,1,1,1}};
            break;
            case "82" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                    {1,1,2,1,0,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,3,0,0},
                    {2,0,1,1,1,1,1,1}};
            break;
            case "83" :
                displaytimetableweight = new int[][] {{1,1,3,0,0,1,1,1},
                    {1,1,2,1,0,1,1,1},
                    {1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,3,0,0},
                    {2,0,1,1,1,1,1,1}};
            break;
        }
        return displaytimetableweight;
    }

}
