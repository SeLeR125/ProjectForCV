package trafficlight.model.state.impl;

import trafficlight.model.state.TrafficLightState;
import trafficlight.model.state.TrafficLightStatesDescription;

public class GreenLight extends TrafficLightState {

    private static class Singleton {
        private static GreenLight INSTANCE = new GreenLight();
    }


    private GreenLight() {
    }

    public static GreenLight getInstance() {
        return Singleton.INSTANCE;
    }



    public boolean canGo() {
        return true;
    }

    public boolean shouldStop() {
        return false;
    }

    public void printState() {
        System.out.println("You should go.");
    }

}


