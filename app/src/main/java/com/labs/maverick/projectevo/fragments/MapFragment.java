package com.labs.maverick.projectevo.fragments;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.labs.maverick.projectevo.R;
import com.labs.maverick.projectevo.activities.MainActivity;

/**
 * Created by MTavara on 03/11/2017.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback, View.OnClickListener,LocationListener,GoogleMap.OnMapClickListener {


    private View rootView;
    private MapView mapView;
    private GoogleMap gMap;
    private FloatingActionButton fab;
    private LocationManager locationManager;
    private Location currentLocation;
    private Marker marker;
    private Marker markerFinish;
    private Button solicit;

    public MapFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_map, container, false);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        solicit = (Button) rootView.findViewById(R.id.solicitButton);
        solicit.setOnClickListener(this);
        fab.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) rootView.findViewById(R.id.map);


        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }


    }

    private boolean IfGPSEnabled() {
        try {
            int gpsSignal = Settings.Secure.getInt(getActivity().getContentResolver(), Settings.Secure.LOCATION_MODE);
            if (gpsSignal == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showInfoAlert() {
        new AlertDialog.Builder(getContext())
                .setTitle("GPS Signal")
                .setMessage("No Tienes Señal Amiguito. Quieres activar GPS?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                }).setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        gMap = googleMap;
        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        gMap.setMyLocationEnabled(true);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 80000, 0, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 80000, 0, this);
        //LatLng place = new LatLng(-12.21622, -76.94154);
        //gMap.addMarker(new MarkerOptions().position(place).title("Ubicación"));
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        //gMap.setMinZoomPreference(14.0f);
        //gMap.setMaxZoomPreference(20.0f);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.solicitButton:
                if (marker == null) {
                    marker = gMap.addMarker(new MarkerOptions()
                            .position(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()))
                            .title("Estas Aquí!")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                            .draggable(true));
                }else{
                    marker.setPosition(new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude()));
                }
                solicit.setText("Solicitando Unidades...");


                break;
            case R.id.fab:
                new AlertDialog.Builder(getContext())
                        .setTitle("Destino")
                        .setMessage("Selecciona destino presionando en el Mapa")
                        .show();
                gMap.setOnMapClickListener(this);
                break;


        }


    }


    @Override
    public void onLocationChanged(Location location) {

        currentLocation = location;


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (markerFinish == null) {
            markerFinish = gMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title("Fin")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .draggable(true));

        }
    }
}
