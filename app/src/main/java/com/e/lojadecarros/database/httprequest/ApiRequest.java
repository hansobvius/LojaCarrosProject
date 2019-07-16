package com.e.lojadecarros.database.httprequest;

import android.content.Context;
import android.util.Log;

import com.e.lojadecarros.database.VehicleDao;
import com.e.lojadecarros.database.VehicleDatabase;
import com.e.lojadecarros.model.VehicleGeneral;
import com.e.lojadecarros.presenter.MainPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRequest {

    private ServiceApi serviceApi;
    private MainPresenter.View view;
    private Context mContext;
    private VehicleDao vehicleDao;

    public ApiRequest(MainPresenter.View view, Context context){
        this.view = view;
        this.mContext = context;
        if(serviceApi == null){
            serviceApi = new ServiceApi();
        }
        VehicleDatabase vehicleDatabase = VehicleDatabase.getDatabase(mContext);
        this.vehicleDao = vehicleDatabase.vehicleDao();
    }

    public void getVehiclesList(int page){

        serviceApi
                .getAPI()
                .getVehicles(page)
                .enqueue(new Callback<List<VehicleGeneral>>() {
                    @Override
                    public void onResponse(Call<List<VehicleGeneral>> call, Response<List<VehicleGeneral>> response) {
                        Log.i("RESPONSE", "SUCCESS");
                        if(response.body() != null){
                            vehicleDao.insert(response.body());
                        }else{
                            Log.i("RESPONSE", "BODY ARE NULL");
                        }
                        view.getVehicleList(vehicleDao.getAll());
                    }

                    @Override
                    public void onFailure(Call<List<VehicleGeneral>> call, Throwable t) {
                        Log.i("RESPONSE", "ERROR " + t.toString());
                    }
                });
    }
}
