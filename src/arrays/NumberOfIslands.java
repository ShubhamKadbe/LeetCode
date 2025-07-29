package arrays;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberOfIslands {
    public static void main(String[] args) {
//        char[][] grid = {{'1','1','1','1','0'},
//                         {'1','1','0','1','0'},
//                         {'1','1','0','0','0'},
//                         {'0','0','0','0','0'}};

        char[][] grid = {
                           {'1','1','0','0','0'},
                           {'1','1','0','0','0'},
                           {'0','0','1','0','0'},
                           {'0','0','0','1','1'}};

//        numberOfIslands(grid);

        System.out.println();
        long startTime = System.nanoTime(); // Start time

        System.out.println(numberOfIslands(grid));

        long endTime = System.nanoTime();   // End time

        System.out.println("Execution time (nanoseconds): " + (endTime - startTime));
        System.out.println("Execution time (milliseconds): " + (endTime - startTime) / 1_000_000);
    }

    public static int numberOfIslands(char [][] grid){

//        int count = 0;
//        LinkedList<LinkedList<Character>> charToList = new LinkedList();
//
//        for(char [] ch : grid){
//            LinkedList list = new LinkedList();
//            for(char c : ch){
//                list.add((Character) c);
//            }
//            charToList.add(list);
//        }
//
//        int totalChar = charToList.size() * charToList.get(0).size();
//        System.out.println(totalChar);

//        {'1','1','1','1','0'},
//        {'1','1','0','1','0'},
//        {'1','1','0','0','0'},
//        {'0','0','0','0','0'}


//        {"1","1","0","0","0"},
//        {"1","1","0","0","0"},
//        {"0","0","1","0","0"},
//        {"0","0","0","1","1"}}

//        System.out.println(charToList);
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        Set<Map.Entry<Integer, Integer>> visitedIndex = new HashSet();

        LinkedList<Map.Entry<Integer, Integer>> searchedIndex = new LinkedList();
        int [][] directions = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
//                System.out.println("FinalI = " + i + " FinalJ = " + j);
                    if(grid[i][j] == '1' && !visitedIndex.contains(Map.entry(i,j))){
                        visitedIndex.add(Map.entry(i, j));

                        if(j != col-1 && grid[i][j + 1] == '1'){ // Right
                            visitedIndex.add(Map.entry(i, j+1));
                            searchedIndex.add(Map.entry(i, j+1));

                        }
                        if(j != 0 && grid[i][j-1] == '1'){ // Left
                            visitedIndex.add(Map.entry(i, j-1));
                            searchedIndex.add(Map.entry(i, j-1));
                        }
                        if(i != 0 && grid[i -1 ][j] == '1'){ // Up
                            visitedIndex.add(Map.entry(i-1, j));
                            searchedIndex.add(Map.entry(i-1, j));
                        }
                        if(i != row-1 && grid[i+1][j] == '1'){ // Down
                            visitedIndex.add(Map.entry(i+1, j));
                            searchedIndex.add(Map.entry(i+1, j));
                        }

//                        System.out.println(searchedIndex);
//                        LinkedList<Map.Entry<Integer, Integer>> searchedIndex = new LinkedList<>();
//                        searchedIndex.addAll(searchedIndex);

                        while(!searchedIndex.isEmpty()){
                             Map.Entry map = searchedIndex.size() == 1 ? searchedIndex.remove(0) : searchedIndex.remove(searchedIndex.size()-1);

                            int x = (int) map.getKey();
                            int y = (int) map.getValue();
//                            System.out.println( "x = "+ x + " y = " + y) ;
//                            System.out.println(j);

                            if(y != col-1 && grid[x][y + 1] == '1' && !visitedIndex.contains(Map.entry(x,y+1))){ // Right
                                visitedIndex.add(Map.entry(x, y+1));
                                searchedIndex.add(Map.entry(x, y+1));

                            }
                            if(y != 0 && grid[x][y-1] == '1' && !visitedIndex.contains(Map.entry(x,y-1))){ // Left
                                visitedIndex.add(Map.entry(x, y-1));
                                searchedIndex.add(Map.entry(x, y-1));
                            }
                            if(x != 0 && grid[x -1 ][y] == '1' && !visitedIndex.contains(Map.entry(x-1,y))){ // Up
                                visitedIndex.add(Map.entry(x-1, y));
                                searchedIndex.add(Map.entry(x-1, y));
                            }
                            if(x != row-1 && grid[x+1][y] == '1' && !visitedIndex.contains(Map.entry(x+1,y))){ // Down
                                visitedIndex.add(Map.entry(x+1, y));
                                searchedIndex.add(Map.entry(x+1, y));
                            }
//                            System.out.println(searchedIndex);
//                            System.exit(0);

                        }
                        count += 1;

                    }
            }
        }

//        System.out.println(visitedIndex);
        return count;
    }

    public static int numberOfIslands2(char [][] grid){
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        Set<Map.Entry<Integer, Integer>> visitedIndex = new HashSet();

        LinkedList<Map.Entry<Integer, Integer>> searchedIndex = new LinkedList();
        int [][] directions = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
//                System.out.println("FinalI = " + i + " FinalJ = " + j);
                if(grid[i][j] == '1' && !visitedIndex.contains(Map.entry(i,j))){
                    visitedIndex.add(Map.entry(i, j));

                    if(j != col-1 && grid[i][j + 1] == '1'){ // Right
                        visitedIndex.add(Map.entry(i, j+1));
                        searchedIndex.add(Map.entry(i, j+1));

                    }
                    if(j != 0 && grid[i][j-1] == '1'){ // Left
                        visitedIndex.add(Map.entry(i, j-1));
                        searchedIndex.add(Map.entry(i, j-1));
                    }
                    if(i != 0 && grid[i -1 ][j] == '1'){ // Up
                        visitedIndex.add(Map.entry(i-1, j));
                        searchedIndex.add(Map.entry(i-1, j));
                    }
                    if(i != row-1 && grid[i+1][j] == '1'){ // Down
                        visitedIndex.add(Map.entry(i+1, j));
                        searchedIndex.add(Map.entry(i+1, j));
                    }

                    while(!searchedIndex.isEmpty()){
                        Map.Entry map = searchedIndex.size() == 1 ? searchedIndex.remove(0) : searchedIndex.remove(searchedIndex.size()-1);

                        int x = (int) map.getKey();
                        int y = (int) map.getValue();

                        if(y != col-1 && grid[x][y + 1] == '1' && !visitedIndex.contains(Map.entry(x,y+1))){ // Right
                            visitedIndex.add(Map.entry(x, y+1));
                            searchedIndex.add(Map.entry(x, y+1));

                        }
                        if(y != 0 && grid[x][y-1] == '1' && !visitedIndex.contains(Map.entry(x,y-1))){ // Left
                            visitedIndex.add(Map.entry(x, y-1));
                            searchedIndex.add(Map.entry(x, y-1));
                        }
                        if(x != 0 && grid[x -1 ][y] == '1' && !visitedIndex.contains(Map.entry(x-1,y))){ // Up
                            visitedIndex.add(Map.entry(x-1, y));
                            searchedIndex.add(Map.entry(x-1, y));
                        }
                        if(x != row-1 && grid[x+1][y] == '1' && !visitedIndex.contains(Map.entry(x+1,y))){ // Down
                            visitedIndex.add(Map.entry(x+1, y));
                            searchedIndex.add(Map.entry(x+1, y));
                        }
                    }
                    count += 1;

                }
            }
        }
        return count;
    }

}
