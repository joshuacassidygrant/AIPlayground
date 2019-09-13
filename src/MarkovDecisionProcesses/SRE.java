package MarkovDecisionProcesses;

public class SRE {
    double chance;
    MDPModelState state;

    public SRE(MDPModelState state, double chance) {
        this.state = state;
        this.chance = chance;
    }
}
