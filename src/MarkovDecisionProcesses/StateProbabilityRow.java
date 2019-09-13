package MarkovDecisionProcesses;

import java.util.ArrayList;
import java.util.List;

public class StateProbabilityRow {

    List<SRE> cells;


    //Picks an entry based on frequency.
    public MDPModelState pick() {
        double roll = Math.random();
        double acc = 0;
        for (SRE cell: cells) {
            acc += cell.chance;
            if (roll <= acc) return cell.state;
        }

        System.out.println("Something went wrong with roll " + roll);
        return null;
    }


    public StateProbabilityRow(SRE[] sres) {
        cells = new ArrayList<>();
        double totalChance = 0;
        for (SRE sre : sres){
            cells.add(sre);
            totalChance += sre.chance;
        }

        if (totalChance != 1) {
            System.out.println("SRE does not add up to 1");
        }

        cells.sort(new SRECompare());
    }




}
