package trafficlight.model.state;

import trafficlight.model.state.impl.GreenLight;
import trafficlight.model.state.impl.RedLight;
import trafficlight.model.state.impl.RedYellowLight;
import trafficlight.model.state.impl.YellowLight;

public enum TrafficLightStatesDescription implements Light {
    GREEN_TO_YELLOW(GreenLight.getInstance(), YellowLight.getInstance()),
    YELLOW_TO_RED(YellowLight.getInstance(), RedLight.getInstance()),
    RED_TO_REDYELLOW(RedLight.getInstance(), RedYellowLight.getInstance()),
    REDYELLOW_TO_GREEN(RedYellowLight.getInstance(), GreenLight.getInstance());


    TrafficLightStatesDescription(TrafficLightState actualLight, TrafficLightState nextLight) {
        this.actualLight = actualLight;
        this.nextLight = nextLight;
    }

    private TrafficLightState actualLight;


    private TrafficLightState nextLight;

    @Override
    public TrafficLightState getActual() {
        return actualLight;
    }

    @Override
    public TrafficLightState getNext() {
        return nextLight;
    }

    public Light getTranspositionFor(TrafficLightState now) {

        TrafficLightStatesDescription[] values = values();
        for (int i = 0; i < values.length; i++) {
            TrafficLightStatesDescription value = values[i];
            if (value.actualLight.equals(now)) {
                return value;
            }
        }

        return null;

    }

}
