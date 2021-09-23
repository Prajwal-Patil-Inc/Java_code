import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.*;

class StudentClass {
    public String getQuery(String studentData,String query){
		String res = "";
		String sData[] = studentData.split(" ");
		String qData[] = query.split(",");
		if(qData[0].equals("1")){
		    StudentList<String> s1 = new StudentList<String>();
		    for(int i=0; i<sData.length; i++){
		        s1.addElement(sData[i]);
		    }
		    String beWith = qData[1];
		    res = s1.beginsWith(beWith);
		}
		else if(qData[0].equals("2")){
		    StudentList<String> s1 = new StudentList<String>();
		    for(int i=0; i<sData.length; i++){
		        s1.addElement(sData[i]);
		    }
		    String blood[] = qData[1].split(" ");
		    String searchBlood = qData[2];
		    res = s1.bloodGroupOf(blood, searchBlood);
		}
		else if(qData[0].equals("3")){
		    StudentList<String> s1 = new StudentList<String>();
		    for(int i=0; i<sData.length; i++){
		        s1.addElement(sData[i]);
		    }
		    int thres = Integer.parseInt(qData[1]);
		    int result = s1.thresholdScore(thres); 
		    res = result+" students scored "+thres+" above";
		}
		else if(qData[0].equals("4")){
		    ScoreList<Number> s2 = new ScoreList<Number>();
		    for(int i=0; i<sData.length; i++){
		        s2.addElement(Double.parseDouble(sData[i]));
		    }
		    double avg = s2.averageValues();
		    System.out.println("avg: "+avg);
		    //res = Double.valueOf(avg).toString();
		    res = String.format("%.2f",avg);
		}
		else if(qData[0].equals("5")){
		    ScoreList<Number> s2 = new ScoreList<Number>();
		    for(int i=0; i<sData.length; i++){
		        s2.addElement(Double.parseDouble(sData[i]));
		    }
		    double avg = s2.averageValues();
		    res = Double.valueOf(avg).toString();
		}
		return res;
    }
}


class StudentList<T> {
    ArrayList<T> a1 = new ArrayList<T>();
    public void addElement(T ad){
        a1.add(ad);    
    }
    public void removeElement(T rem){
        a1.remove(rem);
    }
    public T getElement(int ge){
        T newT;
        newT = a1.get(ge);
        return newT;
    }
    public String beginsWith(String begWith){
        String res = "";
        char c = begWith.charAt(0);
		    for(int j=0; j<a1.size(); j++){
	            String anArray[] = new String[a1.size()];
	            String element = a1.get(j).toString();
	            anArray[j] = element.toLowerCase();
	            if(anArray[j].charAt(0)==c){
	                res = res + a1.get(j) + "\n";
	            }
		    }
		    return res;
    }
    //Here string array is for provided blood group in query
    public String bloodGroupOf(String[] bg, String reqBg){
        String res = "";
        for(int i=0; i<a1.size(); i++){
		    if(bg[i].equals(reqBg)){
		        res = res + a1.get(i) +"\n";
		    }
		}
		return res;
    }
    public int thresholdScore(int thresh){
        int res = 0;
        for(int i=0; i<a1.size(); i++){
            int mark = Integer.parseInt(a1.get(i).toString());
		    if(mark>=thresh){
		        res++;
		    }
        }
        return res;
    }
}

//ScoreList

class ScoreList<T> {
    ArrayList<T> a2 = new ArrayList<T>();
    public void addElement(T ad){
        a2.add(ad);    
    }
    public void removeElement(T rem){
        a2.remove(rem);
    }
    public T getElement(int ge){
        T newT;
        newT = a2.get(ge);
        return newT;
    }
    public double averageValues(){
        double avg = 0.0;
        double marksall = 0;
        double total = a2.size() * 100;
        for(int i=0; i<a2.size(); i++){
            double marks = Double.parseDouble(a2.get(i).toString());
		    marksall += marks; 
        }
       avg = (marksall / total) * 100.0;
		String avge = String.format("%.2f",avg);
		avg = Double.parseDouble(avge);
        return avg;
    }
}

public class Main{
    public static void main (String[] args) {
        StudentClass sc = new StudentClass();
        String data = "90 78 69 45 90 42 69";
        String query =  "4";
        String expected = "69.00";
        String res = sc.getQuery(data,query);
        System.out.println(res);
        System.out.println(res.equals(expected));
    }
}
