package com.example.HikalMuhamadAlfaridzhi_10120023;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.HikalMuhamadAlfaridzhi_10120023.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

// NIM : 10120023
// NAMA : Hikal Muhamad Alfaridzhi
// KELAS : IF 1
public class RestaurantFragment extends Fragment {

    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restauran, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.my_map);

        getLocation();
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(location -> {
            if(location != null){
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        LatLng lokasi1 = new LatLng(-6.964503991429331, 107.8013676062618);
                        MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Bakso Solo Balapan");
                        googleMap.addMarker(options1);
                        LatLng lokasi2 = new LatLng(-6.9654950481841915, 107.80501247866444);
                        MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Korbeq");
                        googleMap.addMarker(options2);
                        LatLng lokasi3 = new LatLng(-6.944626828831848, 107.77252432552214);
                        MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Waroeng Spesial Sambal SS Jatinangor");
                        googleMap.addMarker(options3);
                        LatLng lokasi4 = new LatLng(-6.954248728571968, 107.76978229863937);
                        MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Mie Ayam Kazozo");
                        googleMap.addMarker(options4);
                        LatLng lokasi5 = new LatLng(-6.966498223138207, 107.82945819803568);
                        MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Asep Stroberi");
                        googleMap.addMarker(options5);
                        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi2,16));
                    }
                });
            }
        });
    }
}