package com.example.burcakdemircioglu.builditbigger.free;

import android.graphics.Color;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;

/**
 * Created by burcakdemircioglu on 18/02/16.
 */
public class AdProvider {
    public static void getAd(View v){
        AdView mAdView = (AdView) v.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("141030849A0204221832FE8B3C5419E1")
                .build();
        mAdView.setBackgroundColor(Color.BLACK);
        mAdView.loadAd(adRequest);
    }
}
