package trafficlight.model;

import trafficlight.model.light.TrafficLight;
import trafficlight.model.state.Light;
import trafficlight.model.state.TrafficLightStatesDescription;
import trafficlight.model.state.ZebraLight;

public enum LightModels {
    CAR_LIGHTS(TrafficLightStatesDescription.RED_TO_REDYELLOW),
    PEOPLE_LIGHTS(ZebraLight.RED_TO_GREEN);


    private Light transpositionInterface;

    LightModels(Light transpositionInterface) {
        this.transpositionInterface = transpositionInterface;
    }

    public TrafficLight getModel() {
        return new TrafficLight(transpositionInterface);
    }

    public Class<? extends Light> getTranspositionClass() {
        return transpositionInterface.getClass();
    }
}

