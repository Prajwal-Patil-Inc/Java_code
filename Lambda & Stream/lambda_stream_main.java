//LambdaFn


//FnCheck

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FnCheck {
    public boolean isFnProgrammingPresent() throws FileNotFoundException, IOException
    {
        File file = new File("/projects/challenge/FunctionalProgramming/src/main/java/com/fresco/LambdaFn.java");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line, string="";
        while((line=br.readLine())!=null)
        {
            string+=line;
        }
        String fn=string.substring(string.indexOf("functionalProgtamming(List<String> listOfIntegers)"),string.indexOf("return outputList;"));
        br.close();
        if(fn.contains("stream()")&&fn.contains("map(")&&fn.contains("filter("))
        {
            return true;
        }
        return false;
    }
}


//LambdaFnTest
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class LambdaFnTest {
    LambdaFn fn;
    FnCheck fc;
    public LambdaFnTest() {
    }
    
    @Before
    public void setUp() {
        fn = new LambdaFn();
        fc = new FnCheck();
    }
    
    long a,b;
    
    @Test
    public void testFunctionalProgtamming1() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
            a=46;
            b=1000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
            assertEquals(82680324, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming2() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=2000;
			b=150000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(502459534, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming3() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=7500;
			b=655000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(-1098260422, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming4() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=100000;
			b=850000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(401433813, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming5() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=1;
			b=10000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(-369768520, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming6() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=99;
			b=99999;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(2026753492, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming7() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=100000;
			b=500000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(-1256774641, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming8() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=813;
			b=75000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(2033200353, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming9() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=210000;
			b=310000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(1, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming10() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=1;
			b=10000000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(-446571705, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming11() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=1;
			b=100000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(-833230654, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming12() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=500000;
			b=510000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(500531, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
    @Test
    public void testFunctionalProgtamming13() throws IOException {
        if(fc.isFnProgrammingPresent())
        {
			a=1;
			b=1000000;
			List<String> listOfIntegers = new ArrayList<>();
			for(long i=a;i<=b;i++)
			{
				listOfIntegers.add(i+"");
			}
			int actual = fn.functionalProgtamming(listOfIntegers).hashCode();
			assertEquals(635152215, actual);
        }
        else
        {
            assertEquals(8394283, 76387468);
        }
    }
    
}
