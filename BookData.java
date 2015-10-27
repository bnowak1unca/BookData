/*
Team    :   Fancy Team 1
Members :   Jason Andre, Nicholas Blum, Jordan Mincey, Ben Nowak
Assignment  :   Third normal form of Book data from spreadsheet data
*/
package bookdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Ben Nowak <bnowak1@unca.edu>
 */
public class BookData {
    public String title;
    public int isbn;
    public String fName;
    public String lName;
    public String pubName;
    public String pubAddr;
    public int totalCopiesOrdered;
    public int totalCopiesInStock;
    public String pubDate;
    public String catName;
    public double price;
    public double cost;
    
    public BookData(String filename) throws Exception {
        File file = new File(filename);
        FileWriter bookInfo = new FileWriter("book.csv");
        FileWriter authorInfo = new FileWriter("author.csv");
        FileWriter categoryInfo = new FileWriter("category.csv");
        FileWriter publisherInfo = new FileWriter("publisher.csv");
        FileWriter authorListInfo = new FileWriter("authorlist.csv");
        
        int bookId = 1, categoryId = 1, pubId = 1, authorId = 1;
        int lastWroteISBN = 0;
        
        Set<String> category = new HashSet<>();
        Set<String> publishers = new HashSet<>();
        Map<String, Integer> catMap = new HashMap<>();
        Scanner sc = new Scanner(file);
        
        while(sc.hasNextLine()){
            String[] tokens = new String[12];
            tokens = sc.nextLine().split(",");
            for(int i=0; i<tokens.length; i++){
                tokens[i].trim();
            }
            title = tokens[0];
            isbn = Integer.parseInt(tokens[1]);
            fName = tokens[2];
            lName = tokens[3];
            pubName = tokens[4];
            pubAddr = tokens[5];
            totalCopiesOrdered = Integer.parseInt(tokens[6]);
            totalCopiesInStock = Integer.parseInt(tokens[7]);
            pubDate = tokens[8];
            catName = tokens[9];
            cost = Double.parseDouble(tokens[11]);
            
            if(catMap.containsKey(catName)){
                catMap.put(catName, categoryId);
                categoryInfo.write("" + categoryId++ + ", " + catName + "\n");
            }
            
            authorInfo.write("" + authorId++ + ", " + fName + ", " + lName + "\n");
            categoryInfo.write("" + categoryId + ", " + catName + "\n");
            publisherInfo.write("" + pubId++ + ", " + pubName + ", " + pubAddr + "\n");
            authorListInfo.write("" + isbn + ", " + categoryId++ + "\n");
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
