package com.goankart.zoo.events;

/**
 * Created by user on 11/11/2015.
 */
public class DrawerSectionItemClickedEvent {
    public String section;

    public DrawerSectionItemClickedEvent(String section){
        this.section = section;
    }

    public String getSection() {
        return section;
    }
}
