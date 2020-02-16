package trafficlight.model.state.impl;

import trafficlight.model.state.TrafficLightState;
import trafficlight.model.state.TrafficLightStatesDescription;

public class RedLight extends TrafficLightState {

    private static class Singleton {
        private static RedLight INSTANCE = new RedLight();
    }


    private RedLight() {
    }

    public static RedLight getInstance() {
        return Singleton.INSTANCE;
    }


    public boolean canGo() {
        return false;
    }

    public boolean shouldStop() {
        return true;
    }

    public void printState() {
        System.out.println("You must stop!");

    }

}
