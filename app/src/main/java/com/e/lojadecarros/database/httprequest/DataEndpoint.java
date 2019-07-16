package com.e.lojadecarros.database.httprequest;

import com.e.lojadecarros.model.VehicleGeneral;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataEndpoint {

    @GET("Vehicles")
    Call<List<VehicleGeneral>> getVehicles(
            @Query("Page") int page);
}
