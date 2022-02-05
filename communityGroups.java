
  
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.ArrayList;
import org.jgrapht.*;
import org.jgrapht.graph.*;



public class communityGroups {

    public static boolean checkVertex (int totalSize, int groupSize, Graph<String, DefaultEdge> Graph, String vertex, ArrayList<String> names){
        boolean check1 =false;
        int numEdges = Graph.outDegreeOf(vertex);
        int numLeftEdges = names.size() - numEdges-1;
        if (numLeftEdges < groupSize && numLeftEdges >0){
            check1 = true;
        }
            return check1;
    }

    public static void printArray(String arr[][]){
        
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; (arr[i] != null && j < arr[i].length); j++){
                if(arr[i][j]!= null){
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void deleteNull(String arr[][]){
       
        for(int i=0; i < arr.length; i++){
            ArrayList<String> list = new ArrayList<String>(); // creates a list to store the elements != null
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] != null){
                    list.add(arr[i][j]); // elements != null will be added to the list.
                }
            }
            arr[i] = list.toArray(new String[list.size()]); // all elements from list to an array.
        }
        
    }
    public static void addToGraph(String arr[][],Graph<String, DefaultEdge> Graph ){
       
        for(int i=0; i < arr.length; i++){
            for(int j = 1; j < arr[i].length; j++){
                if(arr[i][j] != null){
                    if(!Graph.containsEdge(arr[i][0], arr[i][j])){
                        Graph.addEdge(arr[i][0],arr[i][j]);
                    }
                }
             }
        }     
        
    }
    public static void clean2DArray( String arr[][] , int groupSize){
       
        for(int i=0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j]=null;
             }
        }
        

    }
    public static void meetGroupSize( int countGroupSize, int groupSize, int i, int numhost,  int curNumHost, String arr[][], ArrayList<String> trackGroupMember, ArrayList<String> names, ArrayList<String> groupMember){
        if (countGroupSize == groupSize) {
            trackGroupMember.add(names.get(i));
            for (String members:groupMember){
                trackGroupMember.add(members);
            }    
            //Add the schedule for each week to 2-D array
            
            for(int m=0; m <groupMember.size(); m++){
                arr[curNumHost][m+1] = groupMember.get(m); 
            }

            if(curNumHost < numhost){        
                curNumHost++;
            }
            groupMember.clear();
            countGroupSize = 1;
        }    
    }
    public static int checkTotalMember (ArrayList<String> trackGroupMember){
        int totalCurrentMember =0; 
            for( int a =0; a <trackGroupMember.size(); a++){
                if(trackGroupMember.get(a).contains(",")){
                        totalCurrentMember+=2;
                }else{
                        totalCurrentMember++;
                }
            }
            return totalCurrentMember;
    }


    public static String[][] AddToSchedule(int curNumHost, String arr[][], ArrayList<String> groupMember){
        for(int m=0; m <groupMember.size(); m++){
            arr[curNumHost][m+1] = groupMember.get(m); 
        }
            return arr;
    }
    public static String[][] AddToSchedule1(int curNumHost, String arr[][], ArrayList<String> groupMember){
        for(int m=0; m <groupMember.size(); m++){
            arr[curNumHost][m] = groupMember.get(m); 
        }
            return arr;
    }

    public static ArrayList<String> takeLeftEdges(String host, ArrayList<String> names, ArrayList<String> groupMember1,Graph<String, DefaultEdge> mydirectedGraph  ){
        for(int i=0; i< names.size(); i++){
            if(names.get(i)== host){
                continue;
            }
            boolean containsEdge = mydirectedGraph.	containsEdge(host,names.get(i));
            if(!containsEdge){
                groupMember1.add(names.get(i));
            }
        }
        return groupMember1;
    }

    public static ArrayList<String> check2Last (ArrayList<String> names,ArrayList<String> trackVerTex,Graph<String, DefaultEdge> mydirectedGraph  ){
        for(int k =0; k<names.size(); k++){
            int numEdgess = mydirectedGraph.outDegreeOf(names.get(k));
                if( numEdgess == names.size()-1){
                    if(!trackVerTex.contains(names.get(k))){
                        trackVerTex.add(names.get(k));
                        continue;
                    }
                }    
        }
        return trackVerTex;
    }

    public static ArrayList<String> contains (ArrayList<String> names,ArrayList<String> trackVerTex, ArrayList<String> leftVerTex ){
        for (int e=0; e< names.size(); e++){
            if(!trackVerTex.contains(names.get(e))){
                leftVerTex.add(names.get(e));
            } 
        }
        return leftVerTex;
    }

// Check to see it is complete graph, IF YES -> Stop the program
        //IF NOT



        // The Third Case before choosing the host, I wanna see how many host already complete, 
            //  this Third Case meet: when there have 2 last host, they need the same the left member
            //  Like host A and host B, they both need the member C and D to connect meet the condition that connect to all everyone else
        //First pick up the host
        //Second, the pick up the members base on its condition (Special Case or Normal Case)
        //Special Case meet: when  this host connect almost all the other member,
            //  however, the amount of member this host did not connect yet is less than groupSize,
            //  therefore, this host can not meet the normal case


        
        //This program stop only when this graph become complete graph
        // For each Case, they have the directed graph, trackGroupMember, groupMember, and 2D array.
            //trackGroupMember is the arrayList that keep track the member who already be schedule for the week
            //groupMember is the arrayList that keep the members's name of each host
            //2D array is the one keep track the data of each week and each host. the first one of each rows is the host 
            // Add the data of the host and groupMember to 2D array
            // Add 2D array to the graph, and use the graph to keep the whole data and run the conditions for next step
            // both trackGroupMember and 2D will be delete when schedule for the week is done, but the graph will keep the data
            //groupMember will be delete after each host have enough member 

            

        // For the case each host meet the groupSize require, but there still have member left,
        // Use  groupLeftMember array to keep the member who did not be schedule yet.
        // put that member on the end of the list and keep move up when the  groupLeftMember array equal size

    public static void main(String[] args) {
            // Getting file name from user
            Scanner myFile = new Scanner(System.in);
            System.out.println("Please input your plaintext file with the smallgroup names:");
            String fileName = myFile.nextLine();
            System.out.println("File name is:" + fileName);
        
            
            ArrayList<String> names = new ArrayList<String>();
            try{
                File myObj = new File(fileName);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()){
                    String data = myReader.nextLine();
                    names.add(data);
                }
                myReader.close();
            }catch(FileNotFoundException e){
                System.out.println("An Error occured.");
                e.printStackTrace();
            }
            System.out.println(names);

            ArrayList<Integer> householdNumber = new ArrayList<Integer>();
            for(int i = 0; i < names.size(); i++){
                if(names.get(i).contains(",")){
                    householdNumber.add(2);
                }else{
                    householdNumber.add(1);
                }
            }
            System.out.println(householdNumber);

            //User Input ( group size input)
            Scanner groupSizeInput = new Scanner(System.in);
            System.out.println("Please input the group size:");
            int groupSize = groupSizeInput.nextInt();

            // Create a directed  graph  
            Graph<String, DefaultEdge> mydirectedGraph =
            new DirectedMultigraph<String, DefaultEdge>(DefaultEdge.class);
            for (int i = 0; i < names.size() ; i++){
                // Add the vertices to the graph ( vertice take from the array)
                mydirectedGraph.addVertex(names.get(i));
            }

           // contain the member per each week
           ArrayList<String> trackGroupMember = new ArrayList<String>();
           ArrayList<String> trackVerTex = new ArrayList<String>();
            // count the total members 
            int totalSize = checkTotalMember (names);

            //to know how many host should have
            int numhost = totalSize /groupSize;
            int curNumHost =0;
            
         // Check to see it is complete graph, IF YES -> Stop the program
        //IF NOT
        String arr[][] = new String[numhost][15];
        int numWeek = 0;
        while(!(GraphTests.isComplete(mydirectedGraph))){
            //The Third Case(the last steps), there have two left vertice, those two vertice have the same needed vetice
            //Like vertex A and vertex B, they both need the vertice C and D to compete
            trackVerTex = check2Last ( names, trackVerTex, mydirectedGraph);
                if(trackVerTex.size() >= names.size()-2){
                    trackGroupMember.clear();
                    curNumHost =0;
                    clean2DArray(arr, 15);
                    ArrayList<String> leftVerTex = new ArrayList<String>();
                    leftVerTex = contains (names, trackVerTex, leftVerTex );

                    while(leftVerTex.size()!=0){
                        ArrayList<String> leftEdgesVerTex = new ArrayList<String>(); 
                        leftEdgesVerTex = takeLeftEdges(leftVerTex.get(0),names,leftEdgesVerTex,mydirectedGraph);
                        
                        //put the host in the fist position of each row
                        
                        int countGroupSize = 1;
                        if(leftVerTex.get(0).contains(",")){
                            countGroupSize++;
                        }
                        ArrayList<String> groupMember = new ArrayList<String>(); 
                        for (int p = 0; p< leftEdgesVerTex.size(); p++){
                            if(trackGroupMember.contains(leftEdgesVerTex.get(p))){   
                                continue;
                            }
                            groupMember.add(leftEdgesVerTex.get(p));
                            countGroupSize++;
                            int indexofP = names.indexOf(leftEdgesVerTex.get(p));
                            if(householdNumber.get(indexofP) == 2){
                                countGroupSize++;
                            }
                            if (countGroupSize == groupSize) {
                                break;
                            }
                            if (countGroupSize == groupSize+1){
                                countGroupSize--;
                                groupMember.remove(leftEdgesVerTex.get(p));   
                                if(leftEdgesVerTex.get(p).contains(",")){
                                    countGroupSize--;
                                }
                                continue;  
                            }
                        }
                        while(countGroupSize < groupSize){
                            for (int q = 0; q < names.size(); q++ ){
                                if(names.get(q) == leftVerTex.get(0) || trackGroupMember.contains(names.get(q))|| leftEdgesVerTex.contains(names.get(q))){
                                    continue;
                                }
                                groupMember.add(names.get(q));
                                countGroupSize++;
                                if(householdNumber.get(q) == 2){
                                    countGroupSize++;
                                }
                                if (countGroupSize > groupSize){
                                    countGroupSize= countGroupSize-2;
                                    groupMember.remove(names.get(q));  
                                    continue;         
                                }
                                if (countGroupSize == groupSize) {
                                    break;
                                }
                                
                            }
                        }
                        if (countGroupSize == groupSize) {
                            trackGroupMember.add(leftVerTex.get(0));
                           
                            for (String members:groupMember){
                                trackGroupMember.add(members);
                            } 
                            arr[curNumHost][0]= leftVerTex.get(0);
                            AddToSchedule( curNumHost, arr, groupMember);  
                        }
                        if(curNumHost < numhost){        
                            curNumHost++;
                        }
                        groupMember.clear();
                        countGroupSize = 0;
    
                        while(curNumHost < numhost){
                            for(int p=0; p< names.size(); p++){
                                if(trackGroupMember.contains(names.get(p))){
                                    continue;
                                }
                                groupMember.add(names.get(p));
                                countGroupSize++;
                                if(householdNumber.get(p) == 2){
                                    countGroupSize++;
                                }
    
                                if (countGroupSize > groupSize){
                                    int num=1;
                                    while(groupMember.get(groupMember.size()-1-num).contains(",")){
                                        num++;
                                    }
                                    groupMember.remove(groupMember.size()-1-num); 
                                    countGroupSize--;        
                                    
                                }
                                if (countGroupSize == groupSize) {
                                        break;
                                }                            
                            } 
                            if (countGroupSize == groupSize) {
                                for (String members:groupMember){
                                    trackGroupMember.add(members);  
                                } 
                                AddToSchedule1( curNumHost, arr, groupMember);  
                            }
                            if(curNumHost < numhost){        
                                curNumHost++;
                            }
                            groupMember.clear();
                            countGroupSize = 0;
                             
                        }
                        //check to see how many members was being schedule 
                        int totalCurrentMember = checkTotalMember (trackGroupMember); 
                       
                        //If each host have enough the GroupSize
                        if(totalCurrentMember == (numhost*groupSize)){
                            int memberleft = totalSize % groupSize;
                            if(memberleft !=0){
                                ArrayList<String> groupLeftMember = new ArrayList<String>(); 
                                groupLeftMember = contains (names, trackVerTex, groupLeftMember );
                                //take one out,because using array, it have index 0    
                                curNumHost--;
                                while(!(groupLeftMember.size()==0)){
                                    if (curNumHost== -1){
                                        curNumHost = numhost-1;
                                    }
                                //if the couple, take the last one on the list, put to the groupLeft
                                    if (groupLeftMember.get(0).contains(",")){
                                        //Find the last one (not null one) of the last host
                                        // move it to the host above 
                                        //add the groupLeftMember.get(0) into the last host 
                                        int num =0;
                                        String num1= arr[curNumHost][arr[curNumHost].length -1 -num];
                                        while(num1 == null){ 
                                            num++;
                                            num1= arr[curNumHost][arr[curNumHost].length -1 -num];
                                        }
                                        String curNum = arr[curNumHost][arr[curNumHost].length - 1-num];
                                        arr[curNumHost][arr[curNumHost].length - 1-num] = groupLeftMember.get(0);
                                        groupLeftMember.add(curNum);
                                        groupLeftMember.remove(0);   
                                        curNumHost--;
                                                
                                    }else{
                                            for(int b = 0; b < arr[curNumHost].length; b++){
                                                if(arr[curNumHost][b] == null){
                                                    arr[curNumHost][b] = groupLeftMember.get(0);
                                                    break;
                                                }
                                            } 
                                            groupLeftMember.remove(groupLeftMember.get(0));
                                            curNumHost--;
                                    }
                                }
                                        System.out.println();
                                        System.out.println("The schedule for week " + numWeek);
                                        numWeek++;
                                        //Print 2-D array 
                                        printArray(arr);
                                        trackGroupMember.clear();
                                        addToGraph(arr,mydirectedGraph);
                                        clean2DArray(arr, 15);
                                        leftVerTex.remove(leftVerTex.get(0));
                                        curNumHost =0;
                                        continue;
                            } else {
                                        System.out.println();
                                        System.out.println("The schedule for week " + numWeek);
                                        numWeek++;
                                        //Print 2-D array 
                                        printArray(arr);
                                        trackGroupMember.clear();
                                        addToGraph(arr,mydirectedGraph);
                                        clean2DArray(arr, 15);
                                        leftVerTex.remove(leftVerTex.get(0));
                                        curNumHost =0;
                                        continue;
                            }
                        }
                    }
                     
                }


            // Chose the host
            for(int i=0; i < names.size(); i++){
                String host =names.get(i);

            //Special Case, the vertex connect almost all the other vertex,
            // and the left vertex connection is less than groupSize
            //If it is not special case, move to the normal case below
                boolean checkVertex = checkVertex (totalSize,  groupSize, mydirectedGraph, host, names);
                if (checkVertex){
                    if (trackGroupMember.contains(host)){
                        continue;
                    } else{
                        ArrayList<String> groupMember1 = new ArrayList<String>();
                        groupMember1 = takeLeftEdges(host,names,groupMember1,mydirectedGraph);
                            for (int c=0; c<names.size(); c++){
                                String member = names.get(c);
                                if(!trackGroupMember.contains(member) && !groupMember1.contains(member) && host!= member){
                                    groupMember1.add(member);
                                }
                            }
                        //put the host in the fist position of each row
                        arr[curNumHost][0]= host;
                        int countGroupSize = 1;
                        if(householdNumber.get(i) == 2){
                            countGroupSize++;
                        }
                        ArrayList<String> groupMember = new ArrayList<String>(); 
                        for (int p = 0; p< groupMember1.size(); p++){
                            if(trackGroupMember.contains(groupMember1.get(p))){   
                                continue;
                            }
                            groupMember.add(groupMember1.get(p));
                            countGroupSize++;
                            int indexofP = names.indexOf(groupMember1.get(p));
                            if(householdNumber.get(indexofP) == 2){
                                countGroupSize++;
                            }
                            if (countGroupSize == groupSize) {
                                break;
                            }
                            if (countGroupSize == groupSize+1){
                                countGroupSize--;
                                groupMember.remove(groupMember1.get(p));   
                                if(groupMember1.get(p).contains(",")){
                                    countGroupSize--;
                                }
                                continue;  
                            }
                        }
                        while(countGroupSize < groupSize){
                            for (int q = 0; q< names.size(); q++ ){
                               
                                if(trackGroupMember.contains(groupMember1.get(q)) || groupMember.contains(groupMember1.get(q))  ){   
                                    continue;
                                }
                                groupMember.add(names.get(q));
                                countGroupSize++;

                                if(householdNumber.get(q) == 2){
                                    countGroupSize++;
                                }
                                if (countGroupSize > groupSize){
                                    countGroupSize= countGroupSize-2;
                                    groupMember.remove(names.get(q));           
                                }
                                if (countGroupSize == groupSize) {
                                    break;
                                }
                                
                            }
                        }
                        
                        if (countGroupSize == groupSize) {
                            trackGroupMember.add(names.get(i));
                            for (String members:groupMember){
                                trackGroupMember.add(members);
                            } 
                            AddToSchedule( curNumHost, arr, groupMember);  
                        }
                        if(curNumHost < numhost){        
                            curNumHost++;
                        }
                        groupMember.clear();
                        countGroupSize = 1;
                            
                        //check to see how many members was being schedule 
                        int totalCurrentMember = checkTotalMember (trackGroupMember);
                                
                        //If each host have enough the GroupSize
                        if(totalCurrentMember == (numhost*groupSize)){
                            int memberleft = totalSize % groupSize;
                            if(memberleft !=0){
                                ArrayList<String> groupLeftMember = new ArrayList<String>(); 
                                for (int m=0; m < names.size(); m++){
                                    //add that left member to the groupLeftMember list
                                    if(!trackGroupMember.contains(names.get(m))){
                                        groupLeftMember.add(names.get(m));
                                    }
                                }
                                //take one out,because using array, it have index 0    
                                curNumHost--;
                                while(!(groupLeftMember.size()==0)){
                                    if (curNumHost== -1){
                                        curNumHost = numhost-1;
                                    }
                                //if the couple, take the last one on the list, put to the groupLeft
                                    if (groupLeftMember.get(0).contains(",")){
                                        //Find the last one (not null one) of the last host
                                        // move it to the host above 
                                        //add the groupLeftMember.get(0) into the last host 
                                        
                                        int num=0;
                                        String num1= arr[curNumHost][arr[curNumHost].length -1 -num];
                                        while(num1 == null){ 
                                            num++;
                                            num1= arr[curNumHost][arr[curNumHost].length -1 -num];
                                        }
                                        String curNum = arr[curNumHost][arr[curNumHost].length - 1-num];
                                        arr[curNumHost][arr[curNumHost].length - 1-num] = groupLeftMember.get(0);
                                        groupLeftMember.add(curNum);
                                        groupLeftMember.remove(0);   
                                        curNumHost--; 
                                                
                                        }else{
                                            for(int b = 0; b < arr[curNumHost].length; b++){
                                                if(arr[curNumHost][b] == null){
                                                    arr[curNumHost][b] = groupLeftMember.get(0);
                                                    break;
                                                }
                                            } 
                                            groupLeftMember.remove(groupLeftMember.get(0));
                                            curNumHost--;
                                            }
                                        }
                                        System.out.println();
                                        System.out.println("The schedule for week " + numWeek);
                                        numWeek++;
                                        //Print 2-D array 
                                        printArray(arr);
                                        addToGraph(arr,mydirectedGraph);
                                        trackGroupMember.clear();
                                        clean2DArray(arr, 15);
                                        curNumHost =0;
                                        break;
                                    } else {
                                    System.out.println();
                                    System.out.println("The schedule for week " + numWeek);
                                    numWeek++;    
                                    //Print 2-D array 
                                    printArray(arr);
                                    curNumHost =0;
                                    addToGraph(arr,mydirectedGraph);
                                    trackGroupMember.clear();
                                    clean2DArray(arr, 15);
                                    break;

                                    
                                }
                            }
                        continue;  
                    }   
                }

            //The Normal Case, chose the members
            if (trackGroupMember.contains(host)){
                continue;
            // If the host did not include in TrackGroupList, move to the members    
            } else {
                // Create a array to keep check the member for each host
                ArrayList<String> groupMember = new ArrayList<String>();  
                // add the fisrt array is the host name
                arr[curNumHost][0]= host;
                int countGroupSize = 1;
                if(householdNumber.get(i) == 2){
                    countGroupSize++;
                }
                //Chose the members for each host
                for (int j = 0 ; j < names.size(); j++){
                    String member = names.get(j);
                    if (host == member){
                        continue;
                    }
                    if(trackGroupMember.contains(member)){
                        continue;
                    }
                    if (mydirectedGraph.containsEdge(names.get(i), names.get(j))){
                        continue;
                    }
                    else {
                        groupMember.add(member);
                        countGroupSize++;
                        if(householdNumber.get(j) == 2){
                            countGroupSize++;
                        }
                        if (countGroupSize > groupSize){
                            countGroupSize= countGroupSize-2;
                            groupMember.remove(names.get(j));           
                            continue;
                        }

                        int totalCurrentMember1 = checkTotalMember (trackGroupMember);
                        if (curNumHost== numhost-1 && totalCurrentMember1 + groupSize == totalSize){
                            groupMember.clear();
                            groupMember =contains( names, trackGroupMember, groupMember);
                            groupMember.remove(names.get(i));
                            countGroupSize=groupSize;
                        }
                         
                        //if countGroupSize meet the groupSize require
                        if (countGroupSize == groupSize) {
                            trackGroupMember.add(names.get(i));
                            for (String members:groupMember){
                                trackGroupMember.add(members);
                            }    
                            //Add the schedule for each week to 2-D array
                            AddToSchedule( curNumHost, arr, groupMember);
                            
                            if(curNumHost < numhost){        
                                curNumHost++;
                            }

                            groupMember.clear();
                            countGroupSize = 1;

                        
                            //check to see how many members was being schedule 
                            int totalCurrentMember = checkTotalMember (trackGroupMember);
                            //If each host have enough the GroupSize
                            if(totalCurrentMember == (numhost*groupSize)){
                                int memberleft = totalSize % groupSize;
                                    if(memberleft !=0){
                                        ArrayList<String> groupLeftMember = new ArrayList<String>(); 
                                        for (int m=0; m < names.size(); m++){
                                             //add that left member to the groupLeftMember list and add the member from the groupLeftMember list to each week, from the last week
                                            if(!trackGroupMember.contains(names.get(m))){
                                                groupLeftMember.add(names.get(m));
                                            }
                                        }    
                                        curNumHost--;
                                        while(!(groupLeftMember.size()==0)){
                                            if (curNumHost== -1){
                                                curNumHost = numhost-1;
                                            }
                                             //if the couple, take the last one on the list, put to the groupLeft
                                            if (groupLeftMember.get(0).contains(",")){

                                                //Find the last one (not null one) of the last host
                                                // move it to the host above 
                                                //add the groupLeftMember.get(0) into the last host 
                                                int num =0;

                                                String num1= arr[curNumHost][arr[curNumHost].length -1 -num];
                                                while(num1 == null){ 
                                                    num++;
                                                    num1= arr[curNumHost][arr[curNumHost].length -1 -num];
                                                }
                                                String curNum = arr[curNumHost][arr[curNumHost].length - 1-num];
                                                arr[curNumHost][arr[curNumHost].length - 1-num] = groupLeftMember.get(0);
                                                groupLeftMember.add(curNum);
                                                groupLeftMember.remove(0);   
                                                curNumHost--;
                                                        
                                            }else{
                                                for(int b = 0; b < arr[curNumHost].length; b++){
                                                    if(arr[curNumHost][b] == null){
                                                        arr[curNumHost][b] = groupLeftMember.get(0);
                                                            break;
                                                        }
                                                } 
                                                groupLeftMember.remove(groupLeftMember.get(0));
                                                curNumHost--;
                                            }
                                        }
                                            System.out.println();
                                            System.out.println("The schedule for week " + numWeek);
                                            numWeek++; 
                                            //Print out 2-D array for each week
                                            printArray(arr);
                                            addToGraph(arr,mydirectedGraph);
                                            trackGroupMember.clear();
                                            clean2DArray(arr, 15);
                                            curNumHost =0;
                                            break;
                                    } else {
                                        //Print out 2-D array for each week
                                        System.out.println();
                                        System.out.println("The schedule for week " + numWeek);
                                        numWeek++;    
                                        printArray(arr);
                                        curNumHost =0;
                                        addToGraph(arr,mydirectedGraph);
                                        trackGroupMember.clear();
                                        clean2DArray(arr, 15);
                                        break;
                                     }
                            }
                                break;
                        }
                        
                        
                     }     }
                }
            }
                    
            
        }  
        System.out.println();
        System.out.println("The program is finish") ;
        
    }
}

