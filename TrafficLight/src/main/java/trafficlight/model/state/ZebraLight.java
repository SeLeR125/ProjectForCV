package trafficlight.model.state;

import trafficlight.model.state.Light;
import trafficlight.model.state.TrafficLightState;
import trafficlight.model.state.impl.GreenBlinkingLight;
import trafficlight.model.state.impl.GreenLight;
import trafficlight.model.state.impl.RedLight;

public enum ZebraLight implements Light {
    GREEN_TO_BLINKINGGREEN(GreenLight.getInstance(), GreenBlinkingLight.getInstance()),
    BLINKINGGREEN_TO_RED(GreenBlinkingLight.getInstance(), RedLight.getInstance()),
    RED_TO_GREEN(RedLight.getInstance(), GreenLight.getInstance());

    ZebraLight(TrafficLightState actualLight, TrafficLightState nextLight) {
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

        ZebraLight[] values = values();
        for (int i = 0; i < values.length; i++) {
            ZebraLight value = values[i];
            if (value.actualLight.equals(now)) {
                return value;
            }
        }

        return null;
    }
}


