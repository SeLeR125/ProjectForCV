package trafficlight.model.state.impl;

import trafficlight.model.state.TrafficLightState;
import trafficlight.model.state.TrafficLightStatesDescription;

public class RedYellowLight extends TrafficLightState {

    private static class Singleton {
        private static RedYellowLight INSTANCE = new RedYellowLight();
    }


    public static RedYellowLight getInstance() {
        return Singleton.INSTANCE;
    }


    public boolean canGo() {
        return false;
    }

    public boolean shouldStop() {
        return false;
    }

    public void printState() {
        System.out.println("You can't go, but You shouldn't stop.");
    }
}
