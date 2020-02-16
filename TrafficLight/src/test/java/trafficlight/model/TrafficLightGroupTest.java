package trafficlight.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficlight.model.light.TrafficLight;
import trafficlight.model.state.TrafficLightState;
import trafficlight.model.state.TrafficLightStatesDescription;
import trafficlight.model.state.ZebraLight;
import trafficlight.model.state.impl.GreenLight;
import trafficlight.model.state.impl.RedLight;


import static org.junit.jupiter.api.Assertions.*;

class TrafficLightGroupTest {

    private TrafficLightGroup lightGroupRedStart;
    private TrafficLightGroup lightGroupGreenStart;

    @BeforeEach
    public void setUp() {
        TrafficLight carLightRed = new TrafficLight(TrafficLightStatesDescription.RED_TO_REDYELLOW);
        TrafficLight peopleLightRed = new TrafficLight(ZebraLight.RED_TO_GREEN);
        lightGroupRedStart = new TrafficLightGroup(carLightRed, peopleLightRed);
        TrafficLight carLightGreen = new TrafficLight(TrafficLightStatesDescription.GREEN_TO_YELLOW);
        TrafficLight peopleLightGreen = new TrafficLight(ZebraLight.GREEN_TO_BLINKINGGREEN);
        lightGroupGreenStart = new TrafficLightGroup(carLightGreen, peopleLightGreen);
    }

    @Test
    void changeCarToRed() {
        assertEquals(GreenLight.getInstance(), lightGroupGreenStart.getCarLightState());
        lightGroupGreenStart.changeCarToRed();
        assertEquals(RedLight.getInstance(), lightGroupGreenStart.getCarLightState());
    }

    @Test
    void changePeopleToRed() {
        assertEquals(GreenLight.getInstance(), lightGroupGreenStart.getPeopleLightState());
        lightGroupGreenStart.changePeopleToRed();
        assertEquals(RedLight.getInstance(), lightGroupGreenStart.getPeopleLightState());
    }

    @Test
    void changePeopleToGreen() {
        assertEquals(RedLight.getInstance(), lightGroupRedStart.getPeopleLightState());
        lightGroupRedStart.changePeopleToGreen();
        assertEquals(GreenLight.getInstance(), lightGroupRedStart.getPeopleLightState());
    }

    @Test
    void changeCarToGreen() {
        assertEquals(RedLight.getInstance(), lightGroupRedStart.getCarLightState());
        lightGroupRedStart.changeCarToGreen();
        assertEquals(GreenLight.getInstance(), lightGroupRedStart.getCarLightState());
    }

    @Test
    void changeAllToGreen() {
        assertEquals(RedLight.getInstance(), lightGroupRedStart.getPeopleLightState());
        assertEquals(RedLight.getInstance(), lightGroupRedStart.getCarLightState());
        lightGroupRedStart.changeAllToGreen();
        assertEquals(GreenLight.getInstance(), lightGroupRedStart.getPeopleLightState());
        assertEquals(GreenLight.getInstance(), lightGroupRedStart.getCarLightState());
    }

    @Test
    void changeAllToRed() {
        assertEquals(GreenLight.getInstance(), lightGroupGreenStart.getPeopleLightState());
        assertEquals(GreenLight.getInstance(), lightGroupGreenStart.getCarLightState());
        lightGroupGreenStart.changeAllToRed();
        assertEquals(RedLight.getInstance(), lightGroupGreenStart.getPeopleLightState());
        assertEquals(RedLight.getInstance(), lightGroupGreenStart.getCarLightState());
    }
}