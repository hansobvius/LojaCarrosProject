package com.e.lojadecarros.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.lojadecarros.R;
import com.e.lojadecarros.model.VehicleGeneral;
import com.e.lojadecarros.database.httprequest.ApiRequest;
import com.e.lojadecarros.presenter.MainPresenter;
import com.e.lojadecarros.ui.adapter.MainAdapter;
import com.facebook.stetho.Stetho;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private RecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;
    private ApiRequest apiRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);

        this.mRecyclerView = findViewById(R.id.main_recycler_view);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mMainAdapter = new MainAdapter(this);
        mRecyclerView.setAdapter(mMainAdapter);
        apiRequest = new ApiRequest(this, getApplicationContext());

    }

    @Override
    protected void onStart(){
        super.onStart();
        getApiRequest();
    }

    private void getApiRequest() {
        for(int c = 1; c < 3; c++) apiRequest.getVehiclesList(c);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    public void getVehicleList(List<VehicleGeneral> vehicleGenerals) {
        mMainAdapter.setAdapterData(vehicleGenerals);
    }
}
