public static List<Long> functionalProgtamming(List<String> listOfIntegers)
    {
        List<Long> resultList = new ArrayList<Long>();
        List<Long> list2 = new ArrayList<Long>();
        for(String s : listOfIntegers){
            list2.add(Long.parseLong(s));
        }
        Stream<Long> ms = list2.stream();
        Stream<Long> ms2 = ms.map(x -> x*x);
        String[] bArray = new String[listOfIntegers.size()]; 
        Long[] myNewArray = ms2.toArray(Long[]::new);
        for(int j=0; j<listOfIntegers.size(); j++){
            long no = list2.get(j);
            long noo = no;
            //System.out.println(no);
            long sq2 = myNewArray[j];
            long sq = sq2;
            int count = 0;
		    boolean res = false;
		    while(sq2>0){
		        count++;
		        sq2 = sq2 / 10;
		    }
		    for(int z=1; z<count; z++){
		        int eq_parts = (int) Math.pow(10, z); 
                if (eq_parts == no) 
                continue; 
                long sum = sq/eq_parts + sq % eq_parts; 
               // System.out.println("Sum: "+sum+" No: "+no);
                if(sum == no){
                    res = true;  
                }
		    }
		    if(no==1){
		        bArray[j+1] = "True " + Long.toString(no);
		    }
		    if(res == true){
		        bArray[j+1] = "True " + Long.toString(no);
		    }
        }
        ArrayList<String> list3 =  new ArrayList<String>();
        for(String ss : bArray){
            list3.add(ss);
        }
        while(list3.remove(null)){}
        Stream<String> ms3 = list3.stream();
        Stream<String> ms4 = ms3.filter(str -> str.contains("True"));
        String[] myNewArray2 = ms4.toArray(String[]::new);
        Long lss[] = new Long[myNewArray2.length];
        for(int d=0; d<myNewArray2.length; d++){
            String ls[] = myNewArray2[d].split(" ");
            lss[d] = Long.parseLong(ls[1]);
        }
        for(Long p : lss){
            resultList.add(p);
        }
        return resultList;
    }
