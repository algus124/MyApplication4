package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.naver.maps.map.NaverMap;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;


public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

// create map view
        NMapView mapView = findViewById(R.id.map);
        mapView.setNcpClientId("YOUR_CLIENT_ID_HERE");

// set Client ID for Open MapViewer Library
        mMapView.setNcpClientId(clientId);

// set the activity content to the map view
        setContentView(mMapView);

// initialize map view
        mMapView.setClickable(true);

        mMapView.setBuiltInZoomControls(true, null);

// register listener for map state changes
        mMapView.setOnMapStateChangeListener(onMapViewStateChangeListener);
        mMapView.setOnMapViewTouchEventListener(onMapViewTouchEventListener);

// use map controller to zoom in/out, pan and set map center, zoom level etc.
        mMapController = mMapView.getMapController();
    }

    public void onMapInitHandler(NMapView mapView, NMapError errorInfo) {
        if (errorInfo == null) { // success
            mMapController.setMapCenter(new NGeoPoint(35.945239, 126.682153), 11);
        } else { // fail
            Log.e(Log_TAG, "onMapInitHandler: error=" + errorInfo.toString());
        }
    }

}
