import java.util.*;

abstract class Student {

	public abstract String result(String MarksOfStudent);

}

//Aided

class Aided extends Student{

    public String result(String allMarks) {
        String res = "";
		double creditInMarks[] = new double[10];
		double gradeByCredit = 0;
		double totalCredit = 0;
		double gradePoint[] = new double[10];
		double grade = 0;
		double marksInSports = 0;
		double creditInSports = 0; 
		double marksInNCA = 0;
		double creditInNCA = 0;
		
		//Subject Marks Calculation
		String arr[] = allMarks.split("\\|");
		String arrOfMarks[] = arr[0].split(",");
		for(int i=0; i<arrOfMarks.length; i++){
		    String Marks1 = arrOfMarks[i];
		    String splitMarks1[] = Marks1.split(" ");
		    int Mark1 = Integer.parseInt(splitMarks1[0]);

		    //Checking for Grade
		    if(Mark1==100){
		        gradePoint[i] = 10;
		    }
		    else if(Mark1>=75 && Mark1<100){
		        for(double ia=75; ia<=100; ia+=2.36){
		            if(ia==75){
		                grade = 0;
		                gradePoint[i] = 9.0;
		            }
		            if(Mark1==76){
		                gradePoint[i] = 9.0;
		            }
		        } 
		    }
		    else if(Mark1>=60 && Mark1<=74){
		        for(double ia=60; ia<=Mark1; ia+=1.5){
		            if(ia==60){
		                grade = 0;
		            }
		            else{
		                grade+=0.1;
		                gradePoint[i] = grade + 8.0;
		            }
		        } 
		    }
		    else if(Mark1>=50 && Mark1<=59){
		        for(double ia=50; ia<=Mark1; ia+=1){
		            if(ia==50){
		                grade = 0;
		                gradePoint[i] = 7.0;
		            }
		            else{
		                grade+=0.1;
		                gradePoint[i] = grade + 7.0;
		            }
		        }
		    }
		    else if(Mark1>=40 && Mark1<=49){
		        for(double ia=40; ia<=Mark1; ia+=1){
		            if(ia==40){
		                grade = 0;
		                gradePoint[i] = 6.0;
		            }
		            else{
		                grade+=0.1;
		                gradePoint[i] = grade + 6.0;
		            }
		        }
		    }
		    else if(Mark1<40){
		        gradePoint[i] = 0;
		    }
		 
		    //Credit    
		        creditInMarks[i] = Double.parseDouble(splitMarks1[1]);
		        totalCredit += 5; 
		    //Grade * Credit
		    
		    //totalCredit = totalCredit + creditInMarks[];
		        gradeByCredit += (gradePoint[i] * creditInMarks[i]);
		}
		//Sports Mark Calculation
		String q = arr[1];
		if(q.charAt(0)=='1'){
		    String arr1[] = q.split(",");
		    marksInSports = Double.parseDouble(arr1[1]);
		    creditInSports = Double.parseDouble(arr1[2]);
		    gradeByCredit += (10*creditInSports);
		    totalCredit += 5;
		}
		
		//NCA Marks Calculation
		String n = arr[2];
		if(n.charAt(0)=='1'){
		    String arr1[] = q.split(",");
		    marksInNCA = Double.parseDouble(arr1[1]);
		    creditInNCA = Double.parseDouble(arr1[2]);
		    gradeByCredit += (10*creditInNCA);
		    totalCredit += 5;
		    
		}
        double calres = gradeByCredit/totalCredit;
        res = String.valueOf(String.format("%.2f",calres));
		return res;

    }

}

//Finance


class SelfFinance extends Student{

    public String result(String allMarks) {
        String res = "";
        double creditInMarks[] = new double[10];
		double gradeByCredit = 0;
		double totalCredit = 0;
		double gradePoint[] = new double[10];
		double grade = 0;
		double marksInSports = 0;
		double creditInSports = 0; 
		
		//Subject Marks Calculation
		String arr[] = allMarks.split("\\|");
		String arrOfMarks[] = arr[0].split(",");
		for(int i=0; i<arrOfMarks.length; i++){
		    String Marks1 = arrOfMarks[i];
		    String splitMarks1[] = Marks1.split(" ");
		    int Mark1 = Integer.parseInt(splitMarks1[0]);

		    //Checking for Grade
		    if(Mark1==100){
		        gradePoint[i] = 10;
		    }
		    else if(Mark1>=75 && Mark1<100){
		        for(double ia=75; ia<=100; ia+=2.36){
		            if(ia==75){
		                grade = 0;
		                gradePoint[i] = 9.0;
		            }
		            if(Mark1==76){
		                gradePoint[i] = 9.0;
		            }
		        } 
		    }
		    else if(Mark1>=60 && Mark1<=74){
		        for(double ia=60; ia<=Mark1; ia+=1.5){
		            if(ia==60){
		                grade = 0;
		            }
		            else{
		                grade+=0.1;
		                gradePoint[i] = grade + 8.0;
		            }
		        } 
		    }
		    else if(Mark1>=50 && Mark1<=59){
		        for(double ia=50; ia<=Mark1; ia+=1){
		            if(ia==50){
		                grade = 0;
		                gradePoint[i] = 7.0;
		            }
		            else{
		                grade+=0.1;
		                gradePoint[i] = grade + 7.0;
		            }
		        }
		    }
		    else if(Mark1>=40 && Mark1<=49){
		        for(double ia=40; ia<=Mark1; ia+=1){
		            if(ia==40){
		                grade = 0;
		                gradePoint[i] = 6.0;
		            }
		            else{
		                grade+=0.1;
		                gradePoint[i] = grade + 6.0;
		            }
		        }
		    }
		    else if(Mark1<40){
		        gradePoint[i] = 0;
		    }
		 
		    //Credit    
		        creditInMarks[i] = Double.parseDouble(splitMarks1[1]);
		        totalCredit += 5; 
		    //Grade * Credit
		    
		    //totalCredit = totalCredit + creditInMarks[];
		        gradeByCredit += (gradePoint[i] * creditInMarks[i]);
		}
		//Sports Mark Calculation
		String q = arr[1];
		if(q.charAt(0)=='1'){
		    String arr1[] = q.split(",");
		    marksInSports = Double.parseDouble(arr1[1]);
		    creditInSports = Double.parseDouble(arr1[2]);
		    gradeByCredit += (10*creditInSports);
		    totalCredit += 5;
		}
		
        double calres = gradeByCredit/totalCredit;
        res = String.valueOf(String.format("%.2f",calres));
		return res;

	}
}
public class Main
{
	public static void main(String[] args) {
		String s = "100 5,100 5,100 5|0,100,5";
//		Aided a1 = new Aided();
		SelfFinance s1 = new SelfFinance();
//		System.out.println(a1.result(s));
//		System.out.println(a1.result(s).hashCode());
		System.out.println(s1.result(s));
		System.out.println(s1.result(s).hashCode());
	}
}
