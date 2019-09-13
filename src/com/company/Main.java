package com.company;

import MarkovDecisionProcesses.MDPModel;
import MarkovDecisionProcesses.MDPModelState;
import MarkovDecisionProcesses.MDPModelStateGrid;
import MarkovDecisionProcesses.SRE;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("a");
        runSampleMDP();
    }

    public static void runSampleMDP(){
        MDPModel model = new MDPModel();

        MDPModelState s11 = new MDPModelStateGrid(1, 1, -0.04);
        MDPModelState s12 = new MDPModelStateGrid(1, 2, -0.04);
        MDPModelState s13 = new MDPModelStateGrid(1, 3, -0.04);
        MDPModelState s21 = new MDPModelStateGrid(2, 1, -0.04);
        MDPModelState s23 = new MDPModelStateGrid(2, 3, -0.04);
        MDPModelState s31 = new MDPModelStateGrid(3, 1, -0.04);
        MDPModelState s32 = new MDPModelStateGrid(3, 2, -0.04);
        MDPModelState s33 = new MDPModelStateGrid(3, 3, -0.04);
        MDPModelState s41 = new MDPModelStateGrid(4, 1, -0.04);
        MDPModelState s42 = new MDPModelStateGrid(4, 2, -1);
        MDPModelState s43 = new MDPModelStateGrid(4, 3, 1);

        s11.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s12, 0.8), new SRE(s11, 0.1), new SRE(s21, 0.1)});
        s11.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s11, 0.9), new SRE(s21, 0.1)});
        s11.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s11, 0.9), new SRE(s12, 0.1)});
        s11.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s21, 0.8), new SRE(s11, 0.1), new SRE(s12, 0.1)});

        //TODO: connect the rest

    }
}
