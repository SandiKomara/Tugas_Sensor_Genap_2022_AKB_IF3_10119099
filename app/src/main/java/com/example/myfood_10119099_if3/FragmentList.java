package com.example.myfood_10119099_if3;

// NIM   : 10119099
// Nama  : Sandi Komara
// Kelas : IF3

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class FragmentList extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        SupportMapFragment mapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);


        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mapFragment.getMapAsync(googleMap -> {

                LatLng lok1 = new LatLng(-6.888863, 107.618448);
                MarkerOptions markerOptions1 = new MarkerOptions().position(lok1).title("Warkop ADD");

                LatLng lok2 = new LatLng(-6.887456033230609, 107.61537229913695);
                MarkerOptions markerOptions2 = new MarkerOptions().position(lok2).title("Warung Nasi Babeh");

                LatLng lok3 = new LatLng(-6.890686050251905, 107.61713164231581);
                MarkerOptions markerOptions3 = new MarkerOptions().position(lok3).title("Susu Murni DU");

                LatLng lok4 = new LatLng(-6.886519334986712, 107.61509026970444);
                MarkerOptions markerOptions4 = new MarkerOptions().position(lok4).title("Warung Nasi SPG");

                LatLng lok5 = new LatLng(-6.895689019284014, 107.61623251018055);
                MarkerOptions markerOptions5 = new MarkerOptions().position(lok5).title("de.u Coffee");

                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lok3,15));
                googleMap.addMarker(markerOptions1);
                googleMap.addMarker(markerOptions2);
                googleMap.addMarker(markerOptions3);
                googleMap.addMarker(markerOptions4);
                googleMap.addMarker(markerOptions5);


            });
        }
        else {
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 100);
        }
        return view;
    }
}