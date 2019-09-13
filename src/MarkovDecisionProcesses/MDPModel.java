package MarkovDecisionProcesses;

import java.util.ArrayList;
import java.util.List;

public class MDPModel {

    List<MDPModelState> states = new ArrayList<>();
    MDPPolicy policy;

    public void addState(MDPModelState state) {
        states.add(state);
    }

    public void selectPolicy(MDPPolicy policy) {
        this.policy = policy;
    }
}
