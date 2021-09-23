import java.util.*;
class TreemapHandson {
    
    public TreeMap<Integer,String> createPlayerPositionMap(String cricketDataset)
    {
        TreeMap<Integer,String> res = new TreeMap<Integer,String>();
        String playerwithPos[] = cricketDataset.split("\\|");
        //3,Dhoni,120 | 1,Virat,103 | 5,Jadeja,90 | 2,Rohit,70 | 4,Pandya,30 | 6,Rahul,150
        for(int i=0; i<playerwithPos.length; i++){
            String pos_name[] = playerwithPos[i].split(",");
            int pos = Integer.parseInt(pos_name[0]);
            res.put(pos,pos_name[1]);
        }
        return res;
    }
    public TreeMap<String,Integer> createPlayerScoreMap(String cricketDataset)
    {
        TreeMap<String, Integer> res = new TreeMap<String,Integer>();
        String playerScore[] = cricketDataset.split("\\|");
        for(int i=0; i<playerScore.length; i++){
            String name_score[] = playerScore[i].split(",");
            int score = Integer.parseInt(name_score[2]);
            res.put(name_score[1],score);
        }
        return res;
    }
    public TreeMap<Integer,String> createMatchesMap(String cricketDataset)
    {
        TreeMap<Integer, String> result = new TreeMap<Integer,String>();
        String allMatches[] = cricketDataset.split("\\n");
        HashMap<Integer, String> hsm = new HashMap<Integer, String>();
        HashSet<String> openPlayers = new HashSet<String>(); 
        for(int i=0; i<allMatches.length; i++){
            String allScores[] = allMatches[i].split("\\|");
            for(int j=0; j<allScores.length; j++){
               if(allScores[j].charAt(0)=='1'){
                   //System.out.println(split1[j]);
                   String use = allScores[j].substring(2);
                   String arr[] = use.split(",");
                   int sco = Integer.parseInt(arr[1]);
                   hsm.put(sco,arr[0]);
                   openPlayers.add(arr[0]);
               }
               } 
            }
        String players[] = new String[openPlayers.size()]; 
          int matchCount[] = new int[players.length];
          int totalScore[] = new int[players.length];
          TreeMap<Integer, String> res = new TreeMap<Integer, String>(); 
          for(int i=0; i<matchCount.length; i++){
              matchCount[i] = 0;
              totalScore[i] = 0;
          }
          openPlayers.toArray(players);
          for (Map.Entry<Integer, String> pair : hsm.entrySet()) {
            //System.out.println(pair.getKey()+" "+pair.getValue());
            int key = pair.getKey();
            for(int i=0; i<players.length; i++){
                int count = 0;
                int score = 0;
                if(hsm.get(key).equals(players[i])){
                    count++;
                    score = key;
                    matchCount[i] = matchCount[i] + count;
                    totalScore[i] = totalScore[i] + score;
                }
            }
        }
        for(int i=0; i<matchCount.length; i++){
              int avg = totalScore[i] / matchCount[i];
              result.put(avg, players[i]);
        }
        //result = res.get(res.lastKey());
        return result;
    }
    
    
    public String getQuery(String cricketDataset,String query)
    {
        String result = "";
        if(query.charAt(0)=='1'){
            String completeQuery[] = query.split(" ");
            int start = Integer.parseInt(completeQuery[1]);
            int end = Integer.parseInt(completeQuery[2]);
            TreeMap<Integer,String> res = createPlayerPositionMap(cricketDataset);
            for(int i=start; i<=end; i++){
                String strt = String.valueOf(i);
                String player = strt+" "+res.get(i);
                result = result + player + "\n";
            }    
        }
        if(query.charAt(0)=='2'){
            //2 50          "2 Rohit\n3 Dhoni\n5 Jadeja\n"
            String completeQuery[] = query.split(" ");
            
            TreeMap<Integer, String> ress = new TreeMap<Integer,String>();
            String playerScore[] = cricketDataset.split("\\|");
            for(int i=0; i<playerScore.length; i++){
                String name_score[] = playerScore[i].split(",");
                int posit = Integer.parseInt(name_score[0]);
                ress.put(posit, name_score[1]);
            }
            int thresholdScore = Integer.parseInt(completeQuery[1]);
            TreeMap<String,Integer> res = createPlayerScoreMap(cricketDataset);
            TreeMap<Integer,String> test = new TreeMap<Integer, String>();
            for (Map.Entry<String, Integer> pair : res.entrySet()){
                int scoreToCheck = pair.getValue();
                if(scoreToCheck>thresholdScore){
                    String pName = pair.getKey();
                    for(Map.Entry<Integer, String> pair2 : ress.entrySet()){
                       String name = pair2.getValue();
                        if(name.equals(pair.getKey())){
                           test.put(pair2.getKey(),pName);
                        }
                    }
                }
            }
            for(Map.Entry<Integer, String> pair3 : test.entrySet()){
                result = result + pair3.getKey() + " " + pair3.getValue() + "\n";    
            }
        }
        if(query.charAt(0)=='3'){
            //The Efficient Opener is Rohit
            TreeMap<Integer,String> res = createMatchesMap(cricketDataset);
            result = "The Efficient Opener is "+res.get(res.lastKey());
        }
        return result;
    }
    
}

public class Main
{
    public static void main(String[] args) {
        //String data = "3,Dhoni,100|1,Virat,50|5,Jadeja,90|2,Rohit,70|4,Pandya,30";// "2 50";
        //String exp = "4 Pandya\n5 Jadeja\n6 Rahul\n";
        
        TreemapHandson tm1 = new TreemapHandson();
        //TreeMap<Integer,String> result = new TreeMap<Integer,String>();
        //TreeMap<String,Integer> result = new TreeMap<String,Integer>();
        String res = "";
        res = tm1.getQuery("3,Rohit,100|2,Virat,56|1,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69", "3");
        //result = tm1.createPlayerScoreMap(data);
        System.out.println(res);
    }
}
