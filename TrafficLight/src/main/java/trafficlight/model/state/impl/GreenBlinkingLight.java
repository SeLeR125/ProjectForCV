package trafficlight.model.state.impl;

import trafficlight.model.state.TrafficLightState;

public class GreenBlinkingLight extends TrafficLightState {

    private static class Singleton {
        private static GreenBlinkingLight INSTANCE = new GreenBlinkingLight();
    }


    private GreenBlinkingLight() {
    }

    public static GreenBlinkingLight getInstance() {
        return GreenBlinkingLight.Singleton.INSTANCE;
    }


    public boolean canGo() {
        return true;
    }

    public boolean shouldStop() {
        return true;
    }

    public void printState() {
        System.out.println("You can go, but should stop.");
    }
}
