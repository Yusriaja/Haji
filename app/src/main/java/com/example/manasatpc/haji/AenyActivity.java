package com.example.manasatpc.haji;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

public class AenyActivity extends AppCompatActivity  implements OnMapReadyCallback {
    LatLng re = new LatLng(47.6204,-122.2491);
    LatLng res = new LatLng(47.7301986,-122.1768858);
    LatLng ress = new LatLng(47.978748,-122.202001);
    LatLng resss = new LatLng(47.819533,-122.32288);
    LatLng resa = new LatLng(47.385938,-122.258212);
    LatLng rsae = new LatLng(47.38702,-122.23986);
    static final CameraPosition SEATLITE = CameraPosition.builder().target(new LatLng(47.6204,-122.2491))
            .zoom(10).bearing(0).tilt(45).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aeny);
        Button map_show_street = (Button)findViewById(R.id.map_show_street);
       /* map_show_street.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Polyline.this,StreetName.class);
                startActivity(intent);
            }
        });*/
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map_polyline);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(SEATLITE));
      /*  googleMap.addPolyline(new PolylineOptions().geodesic(true).add(re)
                .add(res).add(ress).add(resss).add(resa).add(rsae).add(re));
        googleMap.addPolygon(new PolygonOptions().add(res).fillColor(Color.GREEN));*/
        googleMap.addCircle(new CircleOptions().center(re)
                .radius(500).strokeColor(Color.RED).fillColor(Color.argb(64,0,255,0)));
    }
}
