package trafficlight.model.state.impl;

import trafficlight.model.state.TrafficLightState;
import trafficlight.model.state.TrafficLightStatesDescription;

public class YellowLight extends TrafficLightState {


    private static class Singleton {
        private static YellowLight INSTANCE = new YellowLight();
    }


    private YellowLight() {
    }

    public static YellowLight getInstance() {
        return Singleton.INSTANCE;
    }


    public boolean canGo() {
        return true;
    }

    public boolean shouldStop() {
        return true;
    }

    public void printState() {
        System.out.println("You can go, but You should stop.");
    }
}
