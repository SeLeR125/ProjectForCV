package trafficlight.model.light;


import trafficlight.model.state.Light;
import trafficlight.model.state.TrafficLightState;

public class TrafficLight {
    private Light transposition;

    public TrafficLight(Light transposition) {
        this.transposition = transposition;
    }

    public TrafficLightState getState() {
        return transposition.getActual();
    }

    public Class<? extends Light> getTranspositionClass() {
        return transposition.getClass();
    }

    public void changeStateToNext() {
        transposition = transposition.getTranspositionFor(transposition.getNext());
    }


}




