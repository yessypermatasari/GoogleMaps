package id.sch.mlg.smktelkom.googlemapsudacity;


import android.os.Bundle;
import android.view.LayoutInflater;
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

    GoogleMap maps;
    boolean mapsReady = false;

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

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapsReady)
                    maps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        btnSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapsReady)
                    maps.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapsReady)
                    maps.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapsReady = true;
        maps = googleMap;
        LatLng Malang = new LatLng(-7.966620, 112.632632);
        CameraPosition target = CameraPosition.builder().target(Malang).zoom(14).build();
        maps.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
