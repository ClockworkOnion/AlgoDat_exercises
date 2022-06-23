import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
<<<<<<< HEAD
import java.math.BigInteger;
import java.util.Objects;
=======
import java.util.function.Function;
>>>>>>> e687c27a9508fa1ce2428344e1cf350e77ba85d0
import java.util.function.BiFunction;

public class OpenHashmapForStrings {
    public String[] OpenHashMapArray;
    public static final double c1 = 0.5;
    public static final double c2 = 0.5;

    public OpenHashmapForStrings(int len) {
        OpenHashMapArray = new String[len];
    }


    public static int asciiOfString(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            sum += (int) string.charAt(i);
        }
        return sum;
    }

<<<<<<< HEAD
    public static int  radixRepresentation(String string){
        int sum=0;
        for (int i = string.length()-1; i >=0 ; i--) {
            sum+=((int) string.charAt(i))*Math.pow(128,string.length()-1-i);
        }
        return sum;
    }

    public int hashing(String str){
        return radixRepresentation(str)%OpenHashMapArray.length;
=======
    public int hashing(String str) {
        return asciiOfString(str) % OpenHashMapArray.length;
>>>>>>> e687c27a9508fa1ce2428344e1cf350e77ba85d0
    }

    public int linearHashing(String str, int i) {
        return (hashing(str) + i) % OpenHashMapArray.length;
    }

<<<<<<< HEAD
    public  int quadraticHashing(String str,int i){
        return (int) ((hashing(str)+i*c1+Math.pow(i,2)*c2)% OpenHashMapArray.length);
    }

    public int doubledHashing(String str,int i){
        int m_1=OpenHashMapArray.length-1;
        long x=hashing(str);
        long y= (long) i *(1+(radixRepresentation(str)%m_1));
        long result = (x+y)%OpenHashMapArray.length;
        return  (int) result;
=======
    public int quadraticHashing(String str, int i) {
        return (hashing(str) + i) % OpenHashMapArray.length;
    }

    public int doubledHashing(String str, int i) {
        return (hashing(str) + i * (1 + asciiOfString(str) % (OpenHashMapArray.length) - 1));
>>>>>>> e687c27a9508fa1ce2428344e1cf350e77ba85d0
    }

    public interface Hashfunc {
        public int hash(String a, int b);
    }

<<<<<<< HEAD

//    public  int insert(String str) throws CustomException{
//        int i=0,j=0;
//        while (i< OpenHashMapArray.length ){
//            j=doubledHashing(str,i);
//            if (Objects.equals(OpenHashMapArray[j], "Deleted") || OpenHashMapArray[j]==null){
//                OpenHashMapArray[j]=str;
//                return j;
//            }
//            else i++;
//            //if (i==OpenHashMapArray.length && !OpenHashMapArray[j].equals(str)) i--;
//        }
//        throw  new CustomException("Überlauf");
//    }

    public  int insert(String str, BiFunction<String, Integer, Integer> hash) throws CustomException{
        int i=0;
        int j=0;
        while (i< OpenHashMapArray.length ){
            j= hash.apply(str, i);
           // System.out.println(str+"  "+i);
            if (Objects.equals(OpenHashMapArray[(int) j], "Deleted") || OpenHashMapArray[(int) j]==null){
                OpenHashMapArray[(int) j]=str;
=======
    public int insert1(String str, BiFunction<String, Integer, Integer> hashFunc) throws CustomException {
        int i = 0, j;
        while (i < OpenHashMapArray.length) {
            j = hashFunc.apply(str, i);
            if (OpenHashMapArray[j] == "Deleted" || OpenHashMapArray[j] == null) {
                OpenHashMapArray[j] = str;
>>>>>>> e687c27a9508fa1ce2428344e1cf350e77ba85d0
                return j;
            } else i++;
        }
        throw new CustomException("Überlauf");
    }

    public int insert(String str) throws CustomException {
        int i = 0, j;
        while (i < OpenHashMapArray.length) {
            j = linearHashing(str, i);
            if (OpenHashMapArray[j] == "Deleted" || OpenHashMapArray[j] == null) {
                OpenHashMapArray[j] = str;
                return j;
            } else i++;
        }
        throw new CustomException("Überlauf");
    }

//    public void addDataFromFile(String fileName) throws IOException, CustomException {
//        File file = new File(fileName);
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String st;
//        while ((st = br.readLine()) != null){
//            insert(st);
//        }
//    }

    public void addDataFromFile(String fileName,BiFunction<String, Integer, Integer> hash) throws IOException, CustomException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
<<<<<<< HEAD
        while ((st = br.readLine()) != null){
            insert(st,hash);
        }
    }

    public int search(String str, BiFunction<String, Integer, Integer> hash){
        int i=0;
        int j;
        while(i< OpenHashMapArray.length){
            j= hash.apply(str, i);
            if (OpenHashMapArray[(int) j]==null){
                return -1;
            }
            if (OpenHashMapArray[(int) j].equals(str)){
=======
        while ((st = br.readLine()) != null) {
            insert(st);
        }
    }

    public int search(String str) {
        int i = 0, j;
        while (i < OpenHashMapArray.length) {
            j = linearHashing(str, i);
            if (OpenHashMapArray[j] == null) {
                return -1;
            }
            if (OpenHashMapArray[j].equals(str)) {
>>>>>>> e687c27a9508fa1ce2428344e1cf350e77ba85d0
                return j;
            }
            i++;
        }
        return -1;
    }

<<<<<<< HEAD
    public void delete(String str,BiFunction<String, Integer, Integer> hash){

        int j= search(str,hash);
        //System.out.println(j);
        if (j != -1){
            OpenHashMapArray[(int) j]="Deleted";
        }
    }

    public int countNotSuccededSearchs(String fileName,BiFunction<String, Integer, Integer> hash) throws IOException{
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st; int c=0;
        while ((st = br.readLine()) != null){
            if (search(st,hash)!=-1){
=======
    public void delete(String str) {
        int j = search(str);
        if (j != -1) {
            OpenHashMapArray[j] = "Deleted";
        }
    }

    public int countSuccededSearchs(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int c = 0;
        while ((st = br.readLine()) != null) {
            if (search(st) != -1) {
>>>>>>> e687c27a9508fa1ce2428344e1cf350e77ba85d0
                c++;
            }
        }
        return c;
    }

    public void printHashArray() {
        for (int i = 0; i < OpenHashMapArray.length; i++) {
            if (OpenHashMapArray[i] == null) continue;
            System.out.println(" " + i + "  :  " + OpenHashMapArray[i]);
        }
    }

    public  void measureInserting(String Filename,BiFunction<String, Integer, Integer> hash) {
        System.out.println(" Inserting Measurements : ");
        long duration = 0;
        long before = System.nanoTime();
        try {
                this.addDataFromFile(Filename,hash);
            } catch (IOException | CustomException e) {
                e.printStackTrace();
            }
        duration += System.nanoTime() - before;
        System.out.println("Average time of inserting in array with length "+this.OpenHashMapArray.length+" is "  + duration);
    }

    public  void measureSearching(String Filename,BiFunction<String, Integer, Integer> hash) {
        System.out.println(" Inserting Measurements : ");
        int p = 0;
        long duration = 0;
        long before = System.nanoTime();
        try {
            p=countNotSuccededSearchs(Filename,hash);
        } catch (IOException e) {
            e.printStackTrace();
        }
        duration += System.nanoTime() - before;
        System.out.println("Average time of searching is "  + duration +" with : "+p+" Unsuccessful searches.");
    }

    public static void main(String[] args) throws IOException, CustomException {
<<<<<<< HEAD
        //OpenHashmapForStrings object1=new OpenHashmapForStrings(200000);
        OpenHashmapForStrings object2=new OpenHashmapForStrings(200000);
//        object1.measureInserting("C:\\Users\\21260\\Desktop\\Übung10\\OfficialScrabbleWordListGerman.txt",object1::linearHashing);
//       object2.measureInserting("C:\\Users\\21260\\Desktop\\Übung10\\OfficialScrabbleWordListGerman.txt",object2::linearHashing);
        //System.out.println( radixRepresentation("pto"));
        object2.addDataFromFile("C:\\Users\\21260\\Desktop\\Übung10\\OfficialScrabbleWordListGerman.txt",object2::doubledHashing);
        //int x=4420*(radixRepresentation("ABTRUMPFE")%(object2.OpenHashMapArray.length-1));
        //int y=object2.hashing("ABTRUMPFE");//4420
        //System.out.println(object2.doubledHashing("ABTRUMPFE",4420));

=======
        OpenHashmapForStrings object = new OpenHashmapForStrings(200000);
        object.addDataFromFile("OfficialScrabbleWordListGerman.txt");
        object.delete("a");
        //System.out.println(object.search("a"));
        object.printHashArray();
>>>>>>> e687c27a9508fa1ce2428344e1cf350e77ba85d0
    }

}
