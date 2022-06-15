import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class HashmapForStrings {
    CustomLinkedList<String>[] HashingArray;

    public HashmapForStrings(int len) {
        HashingArray = new CustomLinkedList[len];
    }

    public static int AsciiOfString(String string){
        int sum=0;
        for (int i = 0; i <string.length() ; i++) {
            sum+=(int) string.charAt(i);
        }
        return sum;
    }

    public  void insert(String string){
        if (search(string)==null){
            int code= AsciiOfString(string);
            int hashcode=code%HashingArray.length;
            if (HashingArray[hashcode]==null){
                HashingArray[hashcode]=new CustomLinkedList<String>();
                HashingArray[hashcode].ListInsertAtFirst(string);
            }
            else{
                HashingArray[hashcode].ListInsertAtFirst(string);
            }
        }
        else return;

    }

    public int delete(String string){
        int code= AsciiOfString(string);
        int hashcode=code%HashingArray.length;
        HashingArray[hashcode].ListDelete(string);
        return hashcode;
    }

    public String search(String string){
        int code= AsciiOfString(string);
        int hashcode=code%HashingArray.length;
        if (HashingArray[hashcode]==null) return null;
        else if (HashingArray[hashcode].ListSearch(string)==null) return null;
        else return (String) HashingArray[hashcode].ListSearch(string).elem;
    }

    public  void addDataFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            insert(st);
        }
    }

    public  void printHashArray(){
        for (int i = 0; i < HashingArray.length; i++) {
            if (HashingArray[i]==null) System.out.println(i+"  : ");
            else{
                System.out.print(i+"  : ");
                HashingArray[i].printList(HashingArray[i]);
                System.out.println();
            }
        }
    }

    public int countNotSuccededSearchs(String fileName) throws IOException{
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st; int c=0;
        while ((st = br.readLine()) != null){
            if (search(st)!=null){
            }else {
                c++;
            }
        }
        return c;
    }

    public  void measureInserting(String Filename) {
        System.out.println(" Inserting Measurements : ");
        int[] lengths = { 1000, 10000};
        Arrays.stream(lengths).forEach(x -> {
            long duration = 0;
            long before = System.nanoTime();
            try {
                addDataFromFile(Filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
            duration += System.nanoTime() - before;
            System.out.println("Average time of inserting is int array with length "+x+" is "  + duration);
        });
    }

    public  void measureSearching(String Filename) {

        System.out.println(" Inserting Measurements : ");
        int[] lengths = { 1000, 10000};
        Arrays.stream(lengths).forEach(x -> {
            int p = 0;
            long duration = 0;
            long before = System.nanoTime();
            try {
                p=countNotSuccededSearchs(Filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
            duration += System.nanoTime() - before;
            System.out.println("Average time of searching is int array with length "+x+" is "  + duration +" with : "+p+" Unsuccessful searches.");
        });
    }

    public static void main(String[] args) throws IOException {
            HashmapForStrings object=new HashmapForStrings(1000);
            object.measureSearching("C:\\Users\\21260\\Desktop\\Übung9\\OfficialScrabbleWordListGerman.txt");
            //object.addDataFromFile("C:\\Users\\21260\\Desktop\\Übung9\\OfficialScrabbleWordListGerman.txt");
//
            //int counted = object.countSuccededSearchs("C:\\Users\\21260\\Desktop\\Übung9\\AreMyFriendsCheating.txt");
//            //System.out.println(counted);
//            System.out.println(object.delete("ÜBERSTÜRZ"));
//            object.printHashArray();


        //System.out.println(test.hashtable[2].head.data);

        //object.printHashArray();

    }
}
