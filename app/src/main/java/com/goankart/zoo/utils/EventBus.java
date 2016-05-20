package com.goankart.zoo.utils;

import com.squareup.otto.Bus;

/**
 * Created by user on 11/11/2015.
 */
public class EventBus extends Bus {

    private static final EventBus bus = new EventBus();

    public static Bus getInstance(){
        return bus;
    }
    private EventBus(){}
}
