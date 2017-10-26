package id.sch.mlg.smktelkom.googlemapsudacity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;


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
    double latitude, longitude;

    public PetaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_peta, container, false);
        Button btnMap = view.findViewById(R.id.buttnMaps);
        Button btnSatellite = view.findViewById(R.id.buttnSatelite);
        Button btnHybrid = view.findViewById(R.id.buttnHybrid);
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

        MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void flyTo(CameraPosition target) {
        map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        map = googleMap;
        LatLng Malang = new LatLng(-7.9666, 112.6326);
        CameraPosition target = CameraPosition.builder().target(Malang).zoom(14).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}