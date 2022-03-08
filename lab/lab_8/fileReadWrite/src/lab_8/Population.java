package lab_8;

import java.util.ArrayList;
import java.util.List;

public class Population {

    private List<Pair<String, String>> populationPairList;

    public Population() {
        populationPairList = new ArrayList<>();
    }

    public void calculatePop(List<String> lines) {
        String age = "0";
        int ageTotalPop = 0;
        for (int i = 0; i < lines.size(); i++) {
            age = lines.get(i);
            int menCount = parsePopCountStr(lines.get(++i));
            int womenCount = parsePopCountStr(lines.get(++i));
            ageTotalPop += (menCount + womenCount);
            populationPairList.add(new Pair<>(age, String.valueOf(menCount + womenCount)));
        }
        populationPairList.add(new Pair<>("Total:", String.valueOf(ageTotalPop)));
    }

    private int parsePopCountStr(String str) {
        str = str.replaceAll("\\D+", "");
        return Integer.parseInt(str);
    }

    public List<Pair<String, String>> getPopulationPairList(){
        return populationPairList;
    }
}