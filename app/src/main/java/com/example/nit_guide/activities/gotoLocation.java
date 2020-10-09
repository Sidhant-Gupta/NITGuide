package com.example.nit_guide.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nit_guide.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class gotoLocation extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    Spinner location_spin;
    Location location;
    String place;
    Location currentLocation;
    FusedLocationProviderClient flpc;
    private static final int REQUEST_CODE = 101;

    private static final String TAG = "gotoLocation";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_goto_location);
        Log.d (TAG, "onCreate: Created");

        place = getIntent ().getStringExtra ("obj");
//         Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        mapFragment = (SupportMapFragment) getSupportFragmentManager ( )
//                .findFragmentById (R.id.map);
//
        flpc = LocationServices.getFusedLocationProviderClient (this);
        fetchLastLocation();



    }


    public void fetchLastLocation() {
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
                    mapFragment.getMapAsync (gotoLocation.this);

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
        if(place.equalsIgnoreCase ("The Vintage Cafe")){
                    // do nothing
             sydney[0] = new LatLng(29.947557, 76.815517);

        }

        else if(place.equalsIgnoreCase ("C Seven Hotel")){
            // do nothing
            sydney[0] = new LatLng(29.947557, 76.815517);

        }
        else if(place.equalsIgnoreCase ("Pizza Hut")){
            // do nothing
            sydney[0] = new LatLng(29.947557, 76.815517);

        }
        else if(place.equalsIgnoreCase ("Barcelo's Grill")){
            // do nothing
            sydney[0] = new LatLng(29.947557, 76.815517);

        }
        else if(place.equalsIgnoreCase ("The Meridien")){
            // do nothing
            sydney[0] = new LatLng(29.947557, 76.815517);

        }

        mo = new MarkerOptions().position(sydney[0]).title (place);
        camPos = new CameraPosition(sydney[0], 15, 0,0);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));
        mMap.animateCamera (CameraUpdateFactory.zoomTo (14) );
        mMap.addMarker(new MarkerOptions().position(sydney[0]));

//        public void onNothingSelected(AdapterView<> av){}

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
