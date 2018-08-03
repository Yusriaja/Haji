package com.example.manasatpc.haji;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Leg;
import com.akexorcist.googledirection.util.DirectionConverter;
import com.google.android.gms.location.LocationServices;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener{

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    ArrayList<LatLng> directionPositionList;
    MarkerOptions arafat;
    MarkerOptions mena;
    MarkerOptions mozdlfa;
    MarkerOptions arharam_elmaky;
    MarkerOptions arharam_elmadany;
    private Button bt_arafa,bt_mozdlfa,bt_mena, bt_elharam;

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView mVoiceInputTv;
    private ImageButton mSpeakBtn;
    String saveVoice = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mVoiceInputTv = (TextView) findViewById(R.id.voiceInput);
        mSpeakBtn = (ImageButton) findViewById(R.id.btnSpeak);
        mSpeakBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startVoiceInput();
            }
        });
        bt_arafa = (Button)findViewById(R.id.arafa);
        bt_mena = (Button)findViewById(R.id.mena);
        bt_mozdlfa = (Button)findViewById(R.id.mozdlfa);
        bt_elharam = (Button)findViewById(R.id.elharam);

        bt_arafa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MapsActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},1);
                }else {
                    Location userCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    if (userCurrentLocation != null){
                        MarkerOptions currentUserLocation = new MarkerOptions();
                        LatLng currrentUserLAtLang = new LatLng(userCurrentLocation.getLatitude(),userCurrentLocation.getLongitude());
                        mVoiceInputTv.setText(userCurrentLocation.getLatitude() + " : " + userCurrentLocation.getLongitude());
                        currentUserLocation.position(currrentUserLAtLang);
                        mMap.clear();
                        mMap.addMarker(currentUserLocation);
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currrentUserLAtLang,15));

                        GoogleDirection.withServerKey(getResources().getString(R.string.google_maps_key))
                                .from(currrentUserLAtLang)
                                .to(new LatLng(21.353925,39.984159))
                                .execute(new DirectionCallback() {
                                    @Override
                                    public void onDirectionSuccess(Direction direction, String rawBody) {
                                        if (direction.isOK()){
                                            //  Toast.makeText(getApplicationContext(),"Direction success",Toast.LENGTH_LONG).show();
                                            Leg leg = direction.getRouteList().get(0).getLegList().get(0);
                                             directionPositionList = leg.getDirectionPoint();
                                            PolylineOptions polylineOptions = DirectionConverter.createPolyline(MapsActivity.this,
                                                    directionPositionList,5, Color.RED);
                                            mMap.addPolyline(polylineOptions);
                                            mMap.addMarker(mena);
                                            mMap.addMarker(mozdlfa);
                                            mMap.addMarker(arharam_elmaky);
                                            mMap.addMarker(arharam_elmaky);

                                        }else {
                                            Toast.makeText(getApplicationContext(),"Direction :"+ direction.getErrorMessage(),Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    @Override
                                    public void onDirectionFailure(Throwable t) {
                                        Toast.makeText(getApplicationContext(),"Direction :"+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                }
            }
        });
        bt_mozdlfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MapsActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},1);
                }else {
                    Location userCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    if (userCurrentLocation != null){
                        MarkerOptions currentUserLocation = new MarkerOptions();
                        LatLng currrentUserLAtLang = new LatLng(userCurrentLocation.getLatitude(),userCurrentLocation.getLongitude());
                        currentUserLocation.position(currrentUserLAtLang);
                        mMap.clear();
                        mMap.addMarker(currentUserLocation);
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currrentUserLAtLang,15));

                        GoogleDirection.withServerKey(getResources().getString(R.string.google_maps_key))
                                .from(currrentUserLAtLang)
                                .to(new LatLng(21.381949,39.917020))
                                .execute(new DirectionCallback() {
                                    @Override
                                    public void onDirectionSuccess(Direction direction, String rawBody) {
                                        if (direction.isOK()){
                                            //  Toast.makeText(getApplicationContext(),"Direction success",Toast.LENGTH_LONG).show();
                                            Leg leg = direction.getRouteList().get(0).getLegList().get(0);
                                            directionPositionList = leg.getDirectionPoint();
                                            PolylineOptions polylineOptions = DirectionConverter.createPolyline(MapsActivity.this,
                                                    directionPositionList,5, Color.RED);
                                            mMap.addPolyline(polylineOptions);
                                            mMap.addMarker(mena);
                                            mMap.addMarker(mozdlfa);
                                            mMap.addMarker(arharam_elmaky);
                                            mMap.addMarker(arharam_elmaky);

                                        }else {
                                            Toast.makeText(getApplicationContext(),"Direction :"+ direction.getErrorMessage(),Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    @Override
                                    public void onDirectionFailure(Throwable t) {
                                        Toast.makeText(getApplicationContext(),"Direction :"+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                }

            }
        });
        bt_mena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MapsActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},1);
                }else {
                    Location userCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    if (userCurrentLocation != null){
                        MarkerOptions currentUserLocation = new MarkerOptions();
                        LatLng currrentUserLAtLang = new LatLng(userCurrentLocation.getLatitude(),userCurrentLocation.getLongitude());
                        currentUserLocation.position(currrentUserLAtLang);
                        mMap.clear();
                        mMap.addMarker(currentUserLocation);
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currrentUserLAtLang,15));
                        GoogleDirection.withServerKey(getResources().getString(R.string.google_maps_key))
                                .from(currrentUserLAtLang)
                                .to(new LatLng(21.404699,39.890166))
                                .execute(new DirectionCallback() {
                                    @Override
                                    public void onDirectionSuccess(Direction direction, String rawBody) {
                                        if (direction.isOK()){
                                            //  Toast.makeText(getApplicationContext(),"Direction success",Toast.LENGTH_LONG).show();
                                            Leg leg = direction.getRouteList().get(0).getLegList().get(0);
                                            directionPositionList = leg.getDirectionPoint();
                                            PolylineOptions polylineOptions = DirectionConverter.createPolyline(MapsActivity.this,
                                                    directionPositionList,5, Color.RED);
                                            mMap.addPolyline(polylineOptions);
                                            mMap.addMarker(mena);
                                            mMap.addMarker(mozdlfa);
                                            mMap.addMarker(arharam_elmaky);
                                            mMap.addMarker(arharam_elmaky);

                                        }else {
                                            Toast.makeText(getApplicationContext(),"Direction :"+ direction.getErrorMessage(),Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    @Override
                                    public void onDirectionFailure(Throwable t) {
                                        Toast.makeText(getApplicationContext(),"Direction :"+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                }

            }
        });
        bt_elharam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MapsActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},1);
                }else {
                    Location userCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    if (userCurrentLocation != null){
                        MarkerOptions currentUserLocation = new MarkerOptions();
                        LatLng currrentUserLAtLang = new LatLng(userCurrentLocation.getLatitude(),userCurrentLocation.getLongitude());
                        currentUserLocation.position(currrentUserLAtLang);
                        mMap.clear();
                        mMap.addMarker(currentUserLocation);
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currrentUserLAtLang,15));

                        GoogleDirection.withServerKey(getResources().getString(R.string.google_maps_key))
                                .from(currrentUserLAtLang)
                                .to(new LatLng(21.423071,39.825745))
                                .execute(new DirectionCallback() {
                                    @Override
                                    public void onDirectionSuccess(Direction direction, String rawBody) {
                                        if (direction.isOK()){
                                            //  Toast.makeText(getApplicationContext(),"Direction success",Toast.LENGTH_LONG).show();
                                            Leg leg = direction.getRouteList().get(0).getLegList().get(0);
                                            directionPositionList = leg.getDirectionPoint();
                                            PolylineOptions polylineOptions = DirectionConverter.createPolyline(MapsActivity.this,
                                                    directionPositionList,5, Color.RED);
                                            mMap.addPolyline(polylineOptions);
                                            mMap.addMarker(mena);
                                            mMap.addMarker(mozdlfa);
                                            mMap.addMarker(arharam_elmaky);
                                            mMap.addMarker(arharam_elmaky);
                                        }else {
                                            Toast.makeText(getApplicationContext(),"Direction :"+ direction.getErrorMessage(),Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    @Override
                                    public void onDirectionFailure(Throwable t) {
                                        Toast.makeText(getApplicationContext(),"Direction :"+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                }

            }
        });


        mena = new MarkerOptions().position(new LatLng(21.620399,39.259360))
                .title(getString(R.string.mohamed)).icon(BitmapDescriptorFactory.fromResource(R.drawable.hag));

        mozdlfa = new MarkerOptions().position(new LatLng(21.625399,39.159360))
                .title(getString(R.string.ahmed)).icon(BitmapDescriptorFactory.fromResource(R.drawable.hag));

        arharam_elmaky = new MarkerOptions().position(new LatLng(21.620399,39.159560))
                .title(getString(R.string.mahmoud)).icon(BitmapDescriptorFactory.fromResource(R.drawable.hag));

        arharam_elmadany = new MarkerOptions().position(new LatLng(21.624399,39.189760))
                .title(getString(R.string.merfat)).icon(BitmapDescriptorFactory.fromResource(R.drawable.haga));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Toast.makeText(this, "GPS is Enabled in your device", Toast.LENGTH_SHORT).show();
            return;
        }else{
           // showGPSDisabledAlertToUser();
        }
        if (googleApiClient == null){
            googleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Goto Settings Page To Enable GPS",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(mena);
        mMap.addMarker(mozdlfa);
        mMap.addMarker(arharam_elmaky);
        mMap.addMarker(arharam_elmaky);

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION},1);
        }else {
            Location userCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            if (userCurrentLocation != null){
                MarkerOptions currentUserLocation = new MarkerOptions();
                LatLng currrentUserLAtLang = new LatLng(userCurrentLocation.getLatitude(),userCurrentLocation.getLongitude());
                currentUserLocation.position(currrentUserLAtLang);
                mMap.addMarker(currentUserLocation);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currrentUserLAtLang,15));


            }
        }

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MapsActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},1);
                }else {
                    Location userCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    if (userCurrentLocation != null){
                        MarkerOptions currentUserLocation = new MarkerOptions();
                        LatLng currrentUserLAtLang = new LatLng(userCurrentLocation.getLatitude(),userCurrentLocation.getLongitude());
                        currentUserLocation.position(currrentUserLAtLang);
                        mMap.clear();
                        mMap.addMarker(currentUserLocation);
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currrentUserLAtLang,15));
                        mMap.addMarker(mena);
                        mMap.addMarker(mozdlfa);
                        mMap.addMarker(arharam_elmaky);
                        mMap.addMarker(arharam_elmaky);
                        GoogleDirection.withServerKey(getResources().getString(R.string.google_maps_key))
                                .from(currrentUserLAtLang)
                                .to(latLng)

                                .execute(new DirectionCallback() {
                                    @Override
                                    public void onDirectionSuccess(Direction direction, String rawBody) {
                                        if (direction.isOK()){
                                            //  Toast.makeText(getApplicationContext(),"Direction success",Toast.LENGTH_LONG).show();
                                            Leg leg = direction.getRouteList().get(0).getLegList().get(0);
                                            ArrayList<LatLng> directionPositionList = leg.getDirectionPoint();
                                            PolylineOptions polylineOptions = DirectionConverter.createPolyline(MapsActivity.this,
                                                    directionPositionList,5, Color.RED);
                                            mMap.addPolyline(polylineOptions);

                                        }else {
                                            Toast.makeText(getApplicationContext(),"Direction :"+ direction.getErrorMessage(),Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    @Override
                                    public void onDirectionFailure(Throwable t) {
                                        Toast.makeText(getApplicationContext(),"Direction :"+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                }


            }
        });

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            onConnected(null);
        } else {
            Toast.makeText(MapsActivity.this, "No Permitions Granted", Toast.LENGTH_SHORT).show();
        }
    }


    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.help));
        try {mVoiceInputTv.setText(" ");

            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),getString(R.string.speech_not_supported),Toast.LENGTH_LONG).show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    saveVoice = result.get(0);
                    mVoiceInputTv.setText(saveVoice);
/*
                    String how = getString(R.string.test);
                    if (saveVoice == how)
                    {
                        mVoiceInputTv.setText(saveVoice);
                    }else {
                        mVoiceInputTv.setText("Error:  ");
                        mVoiceInputTv.append(saveVoice);


                    }
*/
                }
                break;
            }

        }}
    }






















