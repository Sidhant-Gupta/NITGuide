package com.example.nit_guide;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    Spinner location_spin;
    Location location;
    String place;
    Location currentLocation;
    FusedLocationProviderClient flpc;
    private static final int REQUEST_CODE = 101;

    public void addPlaceSpinner(){
        location_spin=(Spinner) findViewById (R.id.search_bar);
        List<String> allPlaces =new ArrayList<String> ();
        allPlaces.add("Select Place:");
        allPlaces.add("Guest House");
        allPlaces.add("Library");
        allPlaces.add("CCN(Centre of Computer Networking)");
        allPlaces.add("NIT Market");
        allPlaces.add("NIT Sports Complex");
        allPlaces.add("Senate Hall");
        allPlaces.add("Administrative Block");
        allPlaces.add("Moxie's Grill Canteen");
        allPlaces.add("Amul Canteen");
        allPlaces.add("Jubilee Hall");
        allPlaces.add("Juice Corner");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,allPlaces);
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        location_spin.setAdapter (adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_maps);

        flpc = LocationServices.getFusedLocationProviderClient (this);
        fetchLastLocation();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        mapFragment = (SupportMapFragment) getSupportFragmentManager ( )
//                .findFragmentById (R.id.map);
//
        addPlaceSpinner ();
//        mapFragment.getMapAsync (this);

    }

    private void fetchLastLocation() {
        if(ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions (this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = flpc.getLastLocation ();
        task.addOnSuccessListener (new OnSuccessListener<Location> ( ) {
            @Override
            public void onSuccess(Location loc) {
                if(loc!=null){
                    currentLocation = loc;
                    Toast.makeText (getApplicationContext (),currentLocation.getLatitude ()+" "+currentLocation.getLongitude (), Toast.LENGTH_LONG).show ();
                    mapFragment = (SupportMapFragment) getSupportFragmentManager ( )
                            .findFragmentById (R.id.map);

//                    addPlaceSpinner ();
                    mapFragment.getMapAsync (MapsActivity.this);

                }
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {


        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */

        mMap = googleMap;

        LatLng myspot = new LatLng(currentLocation.getLatitude (), currentLocation.getLongitude ());
        MarkerOptions mo = new MarkerOptions().position(myspot).title ("You are here!!");

        CameraPosition camPos = new CameraPosition(myspot, 15, 0,0);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));
        mMap.animateCamera (CameraUpdateFactory.zoomTo (14) );
        mMap.addMarker (mo);


        final LatLng sydney[] = new LatLng[1];
        final String[] address = new String[1];
        location_spin.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener (){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                address[0] = adapterView.getItemAtPosition(i).toString();
                if(address[0].equals ("Select Place:")){
                    // do nothing
                    return;
                }
                else if(address[0].equals ("Guest House")){
                    //  Add a marker in Sydney and move the camera
                    sydney[0] = new LatLng(29.947557, 76.815517);

                }
                else if(address[0].equals ("Library")){
                   //  Add a marker in Sydney and move the camera
                    sydney[0] = new LatLng (29.947557, 76.815517);

                }
                else if(address[0].equals ("CCN(Centre of Computer Networking)")){
                    sydney[0] = new LatLng (29.947799, 76.815474);
                }
                else if(address[0].equals ("NIT Market")){
                    sydney[0] = new LatLng (29.948959, 76.818145);

                }
                else if(address[0].equals ("NIT Sports Complex")){
                    sydney[0] = new LatLng (29.950508, 76.815637);

                }

                else if(address[0].equals ("Senate Hall")){
                    sydney[0] = new LatLng (29.947447, 76.815453);
                }
                else if(address[0].equals ("Administrative Block")){
                    sydney[0] = new LatLng (29.948910, 76.817110);

                }else if(address[0].equals ("Moxie's Grill Canteen")){
                    sydney[0] = new LatLng (29.947447, 76.815453);
                }
                else if(address[0].equals ("Amul Canteen")){
                    sydney[0] = new LatLng (29.947447, 76.815453);
                }
                else if(address[0].equals ("Jubilee Hall")){
                    sydney[0] = new LatLng (29.947447, 76.815453);
                }
                else if(address[0].equals ("Juice Corner")){
                    sydney[0] = new LatLng (29.947447, 76.815453);
                }

                CameraPosition camPos = new CameraPosition(sydney[0], 15, 0,0);
                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));
                mMap.animateCamera (CameraUpdateFactory.zoomTo (14) );
                mMap.addMarker(new MarkerOptions().position(sydney[0]));
                // Showing selected spinner item
                Toast.makeText(adapterView.getContext(), "Selected: " + address[0], Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLastLocation ();
                }
                break;
        }
    }
}
