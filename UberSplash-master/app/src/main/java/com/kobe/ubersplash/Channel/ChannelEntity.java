package com.kobe.ubersplash.Channel;

/**
 * Created by HP on 2017/2/10.
 */

public class ChannelEntity {
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String name;
}
