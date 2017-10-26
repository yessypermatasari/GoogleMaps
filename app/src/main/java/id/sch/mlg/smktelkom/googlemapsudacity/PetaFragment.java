package id.sch.mlg.smktelkom.googlemapsudacity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class PetaFragment extends android.support.v4.app.Fragment implements OnMapReadyCallback {

    static final CameraPosition MALANG = CameraPosition.builder().target(new LatLng(-7.9666, 112.6326))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

    static final CameraPosition KANADA = CameraPosition.builder().target(new LatLng(56.130366, -106.346771))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition LONDON = CameraPosition.builder().target(new LatLng(51.507351, 51.507351))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition MELBOURNE = CameraPosition.builder().target(new LatLng(-37.813628, 144.963058))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

    GoogleMap map;
    boolean mapReady = false;
    MarkerOptions HotelTugu, BalaiKota, Stasiun, buckingham, williamstown, rocky, Niagara;
    LatLng llHotel = new LatLng(-7.9773, 112.6329);
    LatLng llBal = new LatLng(-7.978, 112.6338);
    LatLng llSta = new LatLng(-7.9775, 112.637);
    LatLng llBuck = new LatLng(37.551830, -78.554516);
    LatLng llWill = new LatLng(42.712020, 42.712020);
    LatLng llRicky = new LatLng(44.264300, -109.786953);
    LatLng llNia = new LatLng(43.082816, -79.074163);
    public PetaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_peta, container, false);
        HotelTugu = new MarkerOptions().position(new LatLng(-7.9773, 112.6329)).title("Hotel Tugu")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        BalaiKota = new MarkerOptions().position(new LatLng(-7.978, 112.6338)).title("Balai Kota Malang")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        Stasiun = new MarkerOptions().position(new LatLng(-7.9775, 112.637)).title("Stasiun Kereta Malang")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        buckingham = new MarkerOptions().position(new LatLng(37.551830, -78.554516)).title("Buckingham")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        williamstown = new MarkerOptions().position(new LatLng(42.712020, 42.712020)).title("WilliamStown")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        rocky = new MarkerOptions().position(new LatLng(44.264300, -109.786953)).title("Rocky Mountains")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        Niagara = new MarkerOptions().position(new LatLng(43.082816, -79.074163)).title("Niagara Waterfall")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        Button btnMap = view.findViewById(R.id.buttnMaps);
        Button btnSatellite = view.findViewById(R.id.buttSatellite);
        Button btnHybrid = view.findViewById(R.id.buttHybrid);
        Button btnMalang = view.findViewById(R.id.btnMalang);
        Button btnKanada = view.findViewById(R.id.btnKanada);
        Button btnLondon = view.findViewById(R.id.btnLondon);
        Button btnMel = view.findViewById(R.id.btnMelbourne);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        btnSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        btnKanada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(KANADA);
            }
        });
        btnLondon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(LONDON);
            }
        });
        btnMel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(MELBOURNE);
            }
        });
        btnMalang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(MALANG);
            }
        });

        MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }


    private void flyTo(CameraPosition target) {
        map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        map = googleMap;
        map.addMarker(HotelTugu);
        map.addMarker(BalaiKota);
        map.addMarker(Stasiun);
        map.addMarker(buckingham);
        map.addMarker(williamstown);
        map.addMarker(rocky);
        map.addMarker(Niagara);
        map = googleMap;
        LatLng Malang = new LatLng(-7.9666, 112.6326);
        CameraPosition target = CameraPosition.builder().target(Malang).zoom(14).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        map.addPolyline(new PolylineOptions().geodesic(true)
                .add(llHotel)
                .add(llBal)
                .add(llSta)
                .add(llBuck)
                .add(llWill)
                .add(llRicky)
                .add(llNia));
        map.addCircle(new CircleOptions().center(llBal).radius(5000).strokeColor(Color.GREEN)
                .fillColor(Color.argb(64, 0, 255, 0)));
    }
}