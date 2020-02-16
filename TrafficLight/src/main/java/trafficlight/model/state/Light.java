package trafficlight.model.state;

import trafficlight.model.light.TrafficLight;

public interface Light {


    TrafficLightState getActual();

    TrafficLightState getNext();

    Light getTranspositionFor(TrafficLightState now);


}
