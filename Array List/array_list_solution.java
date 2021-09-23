import java.util.*;

import java.util.List;
class Passanger
{
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
    float fare;
    public Passanger(int id, float fare)
    {
        this.id=id;
        this.fare=fare;
    }
}
public class Arr {

    public static String output(int capacity, int stops, List<String> listOfInputStrings, String query)
    {
        String outstring="";
        int id = 0;
    int count2 = 0;
    boolean isOn = false;
    int countOfPassOn = 0;
    int countOfPassOff = 0;
    int withSix = 0;
    int withThree = 0;
    int withN = 0;
    float f = 0;
    int pid = 0;
    float fare1 = 0;
    float prevFare = 0;
    float my = 0;
    int countHowManyTimesGotOn = 0;
    int countHowManyTimesGotOff = 0;
    String yesOrNo = "";
    double nintosix = 0;
    double nintothree = 0;
    double ninton = 0;
    String q[] = new String[2];
    int z = 0;
    String s = "";
    for (int j = 0; j < listOfInputStrings.size (); j++)
      {
	String col = listOfInputStrings.get (j);
	  String[] arrSplit = col.split (" ");
	for (int i = 0; i < arrSplit.length; i++)
	  {
	    if (arrSplit[i].contains ("+"))
	      {
		count2 = count2 + 1;
		isOn = true;
		countOfPassOn++;
	      }
	    if (arrSplit[i].contains ("-"))
	      {
		count2 = count2 - 1;
		isOn = false;
		countOfPassOff++;
	      }
	  }
	for (int a = 0; a < arrSplit.length; a++)
	  {
	    String idd = arrSplit[a].substring (1);
	    id = Integer.parseInt (idd);
	    float per = ((float) count2) / capacity * 100;
	    fare1 = 0;
	    double fare = 0;
	    if (arrSplit[a].contains ("-"))
	      {
		fare1 = 0;
	      }
	    if (arrSplit[a].contains ("+") && per <= 30)
	      {
		fare = capacity + capacity * 0.6;
		fare1 = (float) fare;
		withSix++;
		nintosix = fare;
	      }
	    else if (arrSplit[a].contains ("+") && per > 30 && per <= 50)
	      {
		fare = capacity + capacity * 0.3;
		fare1 = (float) fare;
		withThree++;
		nintothree = fare;
	      }
	    else if (arrSplit[a].contains ("+") && per > 50)
	      {
		fare1 = capacity;
		withN++;
		ninton = fare1;
	      }
	    Passanger p = new Passanger (id, fare1);
	    pid = p.getId ();
	    f = p.getFare ();
	    if (query.contains (","))
	      {
		query = query.replaceAll ("\\s", "");
		q = query.split (",");
		z = Integer.parseInt (q[1]);
		s = q[0];
	      }
	    else
	      {
		z = Integer.parseInt (query);
		s = query;
	      }
	    if (pid == z)
	      {
		my = my + f;
	      }
	    if (arrSplit[a].contains ("+") && pid == z)
	      {
		countHowManyTimesGotOn++;
	      }
	    else if (arrSplit[a].contains ("-") && pid == z)
	      {
		countHowManyTimesGotOff++;
	      }

	    if (pid == z && arrSplit[a].contains ("+"))
	      {
		yesOrNo = "inside";
	      }
	    else if (pid == z && arrSplit[a].contains ("-"))
	      {
		yesOrNo = "not inside";
	      }
	  }
      }

    //Who got off the bus
    if (s.equals ("1"))
      {
	outstring =
	  countOfPassOn + " passengers got on the bus and " + countOfPassOff +
	  " passengers got out of the bus";
      }

    //Who traveled with fares 0.6 and 0.3
    if (s.equals ("2"))
      {
	outstring =
	  withSix +
	  " passengers traveled with a fare of "+ String.format("%.1f", nintosix)+", "+
	  withThree + " passengers traveled with a fare of "+nintothree+" and " +
	  withN + " passengers traveled with a fare of "+ninton;
      }

    //Total Fares by Particular Passenger
    if (s.equals ("3"))
      {
	outstring = "Passenger " + z + " spent a total fare of " + my;
      }

    //How Many time he got on or off
    if (s.equals ("4"))
      {
	outstring =
	  "Passenger " + z + " has got on the bus for " +
	  countHowManyTimesGotOn + " times";
      }

    //Is On OR NO
    if (s.equals ("5"))
      {
	outstring =
	  "Passenger " + z + " was " + yesOrNo +
	  " the bus at the end of the trip";
      }
    return outstring;
    }

  public static void main (String[]args)
  {
    int cap, stop;
    List<String> listOfInputs=new ArrayList<>();
    cap=30;
    stop=12;
    listOfInputs.add("+100 +101 +102 +103 +104 +105 +106 +107 +108 +109");
    listOfInputs.add("+110 +111 +112 +113 +114 +115 +116 +117 +118 +119 -104 -107");
    listOfInputs.add("+120 +121 +122 +123 +124 +125 -101 -111 -115 -112 -102");
    listOfInputs.add("+126 +127 +128 +129 +130 +131 +132 +133 -120 -110");
    listOfInputs.add("+134 +135 +136 +137 +138 -100 -103");
    listOfInputs.add("+101 +104 +139 +140 -105 -106 -108 -109");
    listOfInputs.add("-113 -114 -116 -117 -118 -119 -121 -122 -123 -124 -125 -126 -127 -128 -129 -130 -131 -132 -133 -134 -135 -136 -137");
    listOfInputs.add("+141 +142");
    listOfInputs.add("+143 +144 +121 +122 +123 +124 +125 +126 -101 -139 -138 -104");
    listOfInputs.add("+145 +146 +147 +148 +149 -143 -144 -124 -125 -126");
    listOfInputs.add("+150 +151 +152 +153 +154 +155 +101 +125 +124 +104 -123 -145 -146");
    listOfInputs.add("+156 -101 -147 -148 -149 -150 -154");
    String query="2";
    String res = output (cap, stop, listOfInputs, query);
    System.out.println (res);
    System.out.println(res.hashCode());
  }
}
