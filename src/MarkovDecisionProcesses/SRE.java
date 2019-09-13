package MarkovDecisionProcesses;

import java.util.Comparator;

public class SRE {
    double chance;
    MDPModelState state;

    public SRE(MDPModelState state, double chance) {
        this.state = state;
        this.chance = chance;
    }
}

class SRECompare implements Comparator<SRE> {

    @Override
    public int compare(SRE o1, SRE o2) {
        if (o1.chance > o2.chance) return 1;
        return -1;
    }
}
