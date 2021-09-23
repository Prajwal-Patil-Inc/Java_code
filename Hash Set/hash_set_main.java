//Hash Set
public class Hashset
{
    public static String getOut(int numberOfMatches, String squads, int squad1, int squad2)
    {
        //write your code here
        return null;
    }
}


//HSPresent

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HSPresent {
    
    public static boolean isHSPresent() throws FileNotFoundException, IOException
    {
        String line,s="";
        File file=new File("/projects/challenge/HashSet/src/main/java/com/fresco/Hashset.java");
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        while((line=br.readLine())!=null)
            s+=line;
        String str1 = null,str2=null;
        if(s.contains("import java.util.HashSet;") || s.contains("import java.util.*"))
        {
            try
            {
                str1=s.substring(s.indexOf("HashSet<"),s.indexOf("new HashSet"));
            }
            catch(Exception e)
            {
            }
            try
            {
                str2=s.substring(s.indexOf("Set<"),s.indexOf("new HashSet"));
            }
            catch(Exception e)
            {
            }
        }
        if(str1 != null) {
            if(str1.length()>10)
                return true;
        }
        if(str2 != null) {
            if(str2.length()>5)
                return true;
        }
            return false;
    }
}

//HashsetTest
import java.io.IOException;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class HashsetTest {
    Hashset hashset;
    HSPresent hsp;
    public HashsetTest() {
    }
    
    @Before
    public void setUp() {
        hashset = new Hashset();
        hsp = new HSPresent();
    }

    public String sortItOut(String hash) throws IOException
    {
        String[] string = hash.split(" ");
        Arrays.sort(string);
        String str = "";
        for(String s : string)
        {
           str += s+" ";
        }
        if(hsp.isHSPresent())
        {
            return str;
        }
        return null;
    }
    
    
    @Test
    public void testGetOut1() throws IOException {
        String output = hashset.getOut(4, "Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi Paciencia Jota Daniel Patrício Ronaldo Eder Andre Bruma Ricardo Domingos#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira#Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patrício Nelson Pepe Mario Pereira Rafa Renato#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi", 1, 4);
        String[] stringArray = output.split(", ");
        String actual = sortItOut(stringArray[0])+sortItOut(stringArray[1]);
        assertEquals(-1920977219, actual.hashCode());
    }
    
    @Test
    public void testGetOut2() throws IOException {
        String output = hashset.getOut(6, "Messi Saravia Tagliafico Pezzella Saravia Lamela Nehuen Marcos Leandro Celso Andrada Paul Rodriguez Dominguez Palacios Tagliafico Pezzella Saravia Balerdi Nehuen Marcos Leandro Celso Musso Otamendi Tagliafico Pezzella Saravia Balerdi#Ocampos Allister Messi Aguero Dybala Martinez Alario Gonzalez Marchesin Andrada Lamela Kannemann Saravia Montiel Quarta Allister Messi Aguero Dybala Martinez Alario Andrada Foyth Kannemann Rojo Montiel Quarta#Figal Messi Casco Mercado Saravia Lisandro Lamela Andrada Lanzini Maria Lamela Meza Fernandez Gimenez Marcone Casco Mercado Sigali Lisandro Lamela Zaracho Lanzini Lisandro Lamela Zaracho Lanzini Maria Pizarro#Blanco Correa Vargas Correa Gaich Armani Suarez Icardi Gonzalo Benedetto Messi Saravia Sigali Andrada Lamela Armani Suarez Icardi Gonzalo Benedetto Messi Saravia Sigali#Musso Otamendi Tagliafico Pezzella Saravia Balerdi Ocampos Allister Messi Aguero Dybala Martinez Andrada Lamela Gonzalo Pezzella Saravia Balerdi Ocampos Allister Messi Aguero Dybala Dybala Martinez Andrada Lamela Gonzalo Pezzella Saravia#Messi Saravia Tagliafico Pezzella Saravia Ocampos Allister Andrada Lamela Foyth Kannemann Rojo Montiel Quarta Sigali Pezzella Saravia Ocampos Allister Andrada Lamela Foyth Kannemann Rojo Saravia Tagliafico Pezzella Saravia Ocampos Allister Andrada Lamela", 2, 5);
        String[] stringArray = output.split(", ");
        String actual = sortItOut(stringArray[0])+sortItOut(stringArray[1]);
        assertEquals(-1122289136, actual.hashCode());
    }
    
    @Test
    public void testGetOut3() throws IOException {
        String output = hashset.getOut(8, "Gurpreet Rahul Golui Sunil Karanjit Anirudh Jeje Vishal Golui Gahlot Nishu Adil Kotal Edathodika Sahal Rahul Golui Sunil Karanjit Anirudh Jeje Vishal Golui Gahlot Nishu Adil Kotal Jeje Vishal Golui Gahlot Nishu Adil Kotal Edathodika#Sunil Chhangte Dessai Udanta Karanjit Kuruniyan Vinit Anirudh Halder Jeje Vishal Fernandes Manvir Choudhary Doungel Dessai Udanta Karanjit Kuruniyan Vinit Anirudh Halder Jeje Vishal Fernandes Manvir Dessai Udanta Karanjit Kuruniyan Vinit#Kamaljit Sunil Kaith Bose Jhingan Lalrinzuala Ranjan Jeje Das Anirudh Lalruatthara Vishal Raynier Nikhil Karanjit Bose Jhingan Lalrinzuala Ranjan Jeje Das Anirudh Lalruatthara Vishal Raynier#Jeje Borges Amarjit Sunil Jackichand Arindam Michael Karanjit Germanpreet Narzary Vishal Bikash Komal Jobby Anirudh Sunil Jackichand Arindam Michael Karanjit Germanpreet Narzary Vishal Jeje Borges Amarjit Sunil Jackichand Arindam#Gurpreet Rahul Golui Sunil Karanjit Chhangte Dessai Udanta Anirudh Borges Amarjit Jeje Vishal Arindam Michael Karanjit Chhangte Dessai Udanta Anirudh Borges Udanta Anirudh Borges Amarjit Jeje Vishal#Sunil Karanjit Jeje Vishal Anirudh Adil Kotal Edathodika Sahal Kaith Bose Jhingan Lalrinzuala Ranjan Jobby#Kuruniyan Vinit Jhingan Lalrinzuala Sunil Karanjit Jeje Vishal Anirudh Borges Amarjit Fernandes Manvir Dessai Udanta Jhingan Lalrinzuala Sunil Karanjit Jeje Vishal Anirudh Borges Amarjit Fernandes Manvir#Gurpreet Rahul Golui Choudhary Doungel Dessai Udanta Karanjit Kuruniyan Sunil Jeje Anirudh Vishal Jhingan Lalrinzuala Rahul Golui Choudhary Doungel Dessai Udanta Karanjit Kuruniyan Sunil Jeje Anirudh Vishal Karanjit Kuruniyan Sunil Jeje Anirudh Vishal Jhingan Lalrinzuala Rahul Golui Choudhary", 3, 7);
        String[] stringArray = output.split(", ");
        String actual = sortItOut(stringArray[0])+sortItOut(stringArray[1]);
        assertEquals(-921672526, actual.hashCode());
    }
    
    @Test
    public void testGetOut4() throws IOException {
        String output = hashset.getOut(3, "Messi Saravia Tagliafico Pezzella Saravia Lamela Nehuen Gurpreet Rahul Golui Sunil Karanjit Anirudh Jeje Vishal Saravia Tagliafico Pezzella Saravia Lamela Nehuen Gurpreet Rahul Golui Sunil Karanjit Gurpreet Rahul Golui Sunil Karanjit Anirudh Jeje Vishal#Messi Jeje Sunil Karanjit Vishal Raynier Nikhil Casco Mercado Borges Amarjit Fernandes Manvir Dessai Udanta Messi Jeje Sunil Karanjit Vishal Raynier Nikhil Casco Mercado Borges Amarjit Fernandes#Sunil Karanjit Chhangte Dessai Udanta Anirudh Borges Amarjit Jeje Vishal Lamela Nehuen Marcos Leandro Celso Chhangte Dessai Udanta Anirudh Borges Amarjit Jeje Vishal Lamela Nehuen Marcos Leandro Celso", 1, 2);
        String[] stringArray = output.split(", ");
        String actual = sortItOut(stringArray[0])+sortItOut(stringArray[1]);
        assertEquals(-516258268, actual.hashCode());
    }
    
}
