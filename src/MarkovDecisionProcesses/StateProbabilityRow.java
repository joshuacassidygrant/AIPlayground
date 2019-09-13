package MarkovDecisionProcesses;

import java.util.LinkedHashMap;
import java.util.Map;

public class StateProbabilityRow {

    Map<Double, MDPModelState> chancesToStates = new LinkedHashMap<>();

    public void addEntry(MDPModelState state, double frequency) {
        chancesToStates.put(frequency, state);
        //TODO: have these sort by frequency
    }

    //Picks an entry based on frequency. Will warn if entries do not add up to 1
    public MDPModelState pick() {
        //TODO
        return chancesToStates.get(0);
    }

    public StateProbabilityRow() {

    }

    public StateProbabilityRow(SRE[] sres) {
        for (SRE sre : sres){
            addEntry(sre.state, sre.chance);
        }
    }


}
