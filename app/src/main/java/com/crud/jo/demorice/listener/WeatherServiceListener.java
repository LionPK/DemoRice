package com.crud.jo.demorice.listener;

import com.crud.jo.demorice.data.Channel;

public interface WeatherServiceListener {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
