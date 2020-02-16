package trafficlight.model.state;

public abstract class TrafficLightState  {



    public abstract boolean canGo();

    public abstract boolean shouldStop();

    public abstract void printState();


}
