package trafficlight.model.light;

import org.junit.jupiter.api.Test;
import trafficlight.model.state.Light;
import trafficlight.model.state.TrafficLightState;
import trafficlight.model.state.TrafficLightStatesDescription;
import trafficlight.model.state.ZebraLight;
import trafficlight.model.state.impl.*;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {
    @Test


    public void testLight() {
        TrafficLight trafficLight = new TrafficLight(TrafficLightStatesDescription.GREEN_TO_YELLOW);
        //pobranie stanu
        TrafficLightState state = trafficLight.getState();


        //Sprawdzanie czy swiatlo zielone ma dobre zmienne
        assertEquals(state, GreenLight.getInstance());
        assertEquals(state.canGo(), true);
        assertEquals(state.shouldStop(), false);

        //zolte swiatlo

        trafficLight.changeStateToNext();
        state = trafficLight.getState();

        assertEquals(state, YellowLight.getInstance());
        assertEquals(state.canGo(), true);
        assertEquals(state.shouldStop(), true);

        //czerwone swiatlo
        trafficLight.changeStateToNext();
        state = trafficLight.getState();

        assertEquals(state, RedLight.getInstance());
        assertEquals(state.canGo(), false);
        assertEquals(state.shouldStop(), true);

        //zolto-czerwone swiatlo
        trafficLight.changeStateToNext();
        state = trafficLight.getState();

        assertEquals(state, RedYellowLight.getInstance());
        assertEquals(state.canGo(), false);
        assertEquals(state.shouldStop(), false);
    }

    @Test
    public void zebraTest() {

        TrafficLight trafficLight = new TrafficLight(ZebraLight.GREEN_TO_BLINKINGGREEN);

        TrafficLightState state = trafficLight.getState();

        // zielone swiatlo

        assertEquals(state, GreenLight.getInstance());
        assertEquals(state.canGo(), true);
        assertEquals(state.shouldStop(), false);

        //mrygajace swiatlo

        trafficLight.changeStateToNext();
        state = trafficLight.getState();

        assertEquals(state, GreenBlinkingLight.getInstance());
        assertEquals(state.canGo(), true);
        assertEquals(state.shouldStop(), true);

        //czerwone swiatlo

        trafficLight.changeStateToNext();
        state = trafficLight.getState();

        assertEquals(state, GreenBlinkingLight.getInstance());
        assertEquals(state.canGo(), false);
        assertEquals(state.shouldStop(), true);

    }
}
