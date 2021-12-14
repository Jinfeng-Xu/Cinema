package com.group11.observer;

import com.group11.pojo.Seat;

import java.util.Observable;

// An observer to observe timetable's seats change
public interface SeatsObserver {

    public void update(Observable o, Seat seat);

}
