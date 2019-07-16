package com.e.lojadecarros.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.e.lojadecarros.R;
import com.e.lojadecarros.database.VehicleDao;
import com.e.lojadecarros.database.VehicleDatabase;
import com.e.lojadecarros.model.VehicleGeneral;
import com.squareup.picasso.Picasso;

import static com.e.lojadecarros.ui.adapter.MainAdapter.INTENT_EXTRA;

public class DetailActivity extends AppCompatActivity {

    private int vehicleGeneralId;
    private ImageView mImageVehicle;
    private VehicleDao vehicleDao;
    private VehicleGeneral mVehicleGeneral;
    private TextView mVehicleTitle;
    private TextView mVehicleDescr;
    private TextView mVehicleYear;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        intent.hasExtra(INTENT_EXTRA);
        vehicleGeneralId = intent.getIntExtra(INTENT_EXTRA, 1);

        mImageVehicle = findViewById(R.id.image_vehicle_view);
        mVehicleTitle = findViewById(R.id.vehicle_title);
        mVehicleDescr = findViewById(R.id.vehicle_descr);
        mVehicleYear = findViewById(R.id.vehicle_year);

        VehicleDatabase vehicleDatabase = VehicleDatabase.getDatabase(this);
        this.vehicleDao = vehicleDatabase.vehicleDao();

        Log.i("RESPONSE", Integer.toString(vehicleGeneralId));
    }

    @Override
    protected void onStart(){
        super.onStart();
        mVehicleGeneral = vehicleDao.getVehicle(vehicleGeneralId);
        Picasso.with(this).load(mVehicleGeneral.image).into(mImageVehicle);
        mVehicleTitle.setText(mVehicleGeneral.model);
        mVehicleDescr.setText(mVehicleGeneral.version);
        mVehicleYear.setText(mVehicleGeneral.getYearModel() + " / " + mVehicleGeneral.getYearFab());
    }
}
