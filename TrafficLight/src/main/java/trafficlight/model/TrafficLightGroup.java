package trafficlight.model;

import trafficlight.model.light.TrafficLight;
import trafficlight.model.state.TrafficLightState;
import trafficlight.model.state.impl.RedLight;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrafficLightGroup {

    private List<TrafficLight> lightsList;

    public TrafficLightGroup(List<TrafficLight> lightsList) {
        this.lightsList = lightsList;
    }

    public TrafficLightState getStateFor(LightModels model) {
        Optional<TrafficLight> first = lightsList.stream()
                .filter(p -> p.getTranspositionClass().equals(LightModels.CAR_LIGHTS.getTranspositionClass()))
                .findFirst();
        if (first.isPresent()) {
            return first.get().getState();
        } else {
            return null;
        }   // return first.isPresent() ? first.get().getState() : null; --> to samo, krocej
    }
//SWIATLA SAMOCHOD

    public void changeToRedFor(LightModels model) {
        lightsList.stream()
                .filter(p -> p.getTranspositionClass().equals(model.getTranspositionClass()))
                .forEach(p -> {
                    while (p.getState().canGo() || !p.getState().shouldStop()) {
                        p.changeStateToNext();
                    }
                });
    }


    public void changeToGreenFor(LightModels model) {
        lightsList.stream()
                .filter(p -> p.getTranspositionClass().equals(model.getTranspositionClass()))
                .forEach(p -> {
                    while (!p.getState().canGo() || p.getState().shouldStop()) {
                        p.changeStateToNext();
                    }
                });


    }
    //SWIATLA WSZYSCY ZIELONE

    public void changeAllToGreen() {

        lightsList.stream()
                .forEach(p -> {
                    while (!p.getState().canGo() || p.getState().shouldStop()) {
                        p.changeStateToNext();
                    }
                    ;

                });
    }

    //SWIATLA WSZYSCY CZERWONE

    public void changeAllToRed() {
        lightsList.stream()
                .forEach(p -> {
                    while (p.getState().canGo() || !p.getState().shouldStop()) {
                        p.changeStateToNext();
                    }

                });
    }

}




