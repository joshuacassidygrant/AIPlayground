package MarkovDecisionProcesses;

import java.util.ArrayList;
import java.util.List;

public class MDPModel {

    List<MDPModelState> states = new ArrayList<>();

    public void addState(MDPModelState state) {
        states.add(state);
    }

}
