package trafficlight.model;

import trafficlight.model.light.TrafficLight;
import trafficlight.model.state.TrafficLightStatesDescription;
import trafficlight.model.state.ZebraLight;
import trafficlight.model.state.LightThread;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1, true);

        TrafficLight model = LightModels.CAR_LIGHTS.getModel();

        TrafficLight carLightG1 = new TrafficLight(TrafficLightStatesDescription.RED_TO_REDYELLOW);
        TrafficLight peopleLightG1 = new TrafficLight(ZebraLight.RED_TO_GREEN);
        TrafficLightGroup lightGroupFirst = new TrafficLightGroup(carLightG1, peopleLightG1);


        TrafficLight peopleLightG2 = new TrafficLight(ZebraLight.GREEN_TO_BLINKINGGREEN);
        TrafficLight carLightG2 = new TrafficLight(TrafficLightStatesDescription.REDYELLOW_TO_GREEN);
        TrafficLightGroup lightGroupSecond = new TrafficLightGroup(carLightG2, peopleLightG2);


        LightThread threadFirst = new LightThread("Grupa pierwsza ", lightGroupFirst, semaphore);
        LightThread threadSecond = new LightThread("Grupa druga ", lightGroupSecond, semaphore);

        threadFirst.start();
        threadSecond.start();

    }


}
