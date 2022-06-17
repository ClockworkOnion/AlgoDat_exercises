import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.constant.Constable;

public class OpenHashmapForStrings {
    public  String[] OpenHashMapArray;
    public static final double c1 = 0.5;
    public static final double c2=0.5;

    public OpenHashmapForStrings(int len) {
        OpenHashMapArray = new String[len];
    }


    public static int asciiOfString(String string){
        int sum=0;
        for (int i = 0; i <string.length() ; i++) {
            sum+=(int) string.charAt(i);
        }
        return sum;
    }

    public int hashing(String str){
        return asciiOfString(str)%OpenHashMapArray.length;
    }

    public  int linearHashing(String str,int i){
        return (hashing(str)+i)% OpenHashMapArray.length;
    }

    public  int quadraticHashing(String str,int i){
        return (hashing(str)+i)% OpenHashMapArray.length;
    }

    public int doubledHashing(String str,int i){
        return (hashing(str) + i*(1+asciiOfString(str)%(OpenHashMapArray.length)-1));
    }


    public  int insert(String str) throws CustomException{
        int i=0,j;
        while (i< OpenHashMapArray.length){
            j=linearHashing(str,i);
            if (OpenHashMapArray[j] == "Deleted" || OpenHashMapArray[j]==null){
                OpenHashMapArray[j]=str;
                return j;
            }
            else i++;
        }
        throw  new CustomException("Überlauf");
    }

    public void addDataFromFile(String fileName) throws IOException, CustomException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            insert(st);
        }
    }

    public int search(String str){
        int i=0,j;
        while(i< OpenHashMapArray.length){
            j=linearHashing(str,i);
            if (OpenHashMapArray[j]==null){
                return -1;
            }
            if (OpenHashMapArray[j].equals(str)){
                return j;
            }
            i++;
        }
        return -1;
    }

    public void delete(String str){
        int j= search(str);
        if (j != -1){
            OpenHashMapArray[j]="Deleted";
        }
    }

    public int countSuccededSearchs(String fileName) throws IOException{
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st; int c=0;
        while ((st = br.readLine()) != null){
            if (search(st)!=-1){
                c++;
            }
        }
        return c;
    }

    public void printHashArray(){
        for (int i = 0; i < OpenHashMapArray.length ; i++) {
            System.out.println(" "+i+"  :  "+OpenHashMapArray[i]);
        }
    }

    public static void main(String[] args) throws IOException, CustomException {
        OpenHashmapForStrings object=new OpenHashmapForStrings(433);
        object.addDataFromFile("C:\\Users\\21260\\Desktop\\Übung10\\bb.txt");
        object.delete("a");
        //System.out.println(object.search("a"));
        object.printHashArray();
    }

}
