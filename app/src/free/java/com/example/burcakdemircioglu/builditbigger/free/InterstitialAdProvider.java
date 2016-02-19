package com.example.burcakdemircioglu.builditbigger.free;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by burcakdemircioglu on 19/02/16.
 */
public class InterstitialAdProvider {
    public static void loadInterstitialAd(InterstitialAd ad, AdRequest adRequest){
        ad.loadAd(adRequest);
    }
}
