package trafficlight.model.state;

import trafficlight.model.TrafficLightGroup;

import java.util.concurrent.Semaphore;

public class LightThread extends Thread {

    private TrafficLightGroup group;
    private Semaphore semaphore;


    public LightThread(String name, TrafficLightGroup group, Semaphore semaphore) {
        super(name);
        this.group = group;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        System.out.println("--------------" + this.getName() + "Start--------------");
        while (true) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printLightState();
            group.changePeopleToGreen();

            group.changeCarToGreen();


            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            group.changeAllToRed();
            printLightState();
            System.out.println("--------------" + this.getName() + "End--------------");
            semaphore.release();
        }

    }

    private void printLightState() {
        System.out.println(this.getName() + "people light: ");
        group.getPeopleLightState().printState();
        System.out.println(this.getName() + "car light:");
        group.getCarLightState().printState();
    }
}

