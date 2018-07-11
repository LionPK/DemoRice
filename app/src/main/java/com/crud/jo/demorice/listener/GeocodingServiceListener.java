package com.crud.jo.demorice.listener;

import com.crud.jo.demorice.data.LocationResult;

public interface GeocodingServiceListener {
    void geocodeSuccess(LocationResult location);

    void geocodeFailure(Exception exception);
}
