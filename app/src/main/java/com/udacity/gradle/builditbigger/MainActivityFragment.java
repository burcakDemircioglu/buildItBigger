package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.burcakdemircioglu.builditbigger.free.AdProvider;
import com.example.burcakdemircioglu.builditbigger.free.InterstitialAdProvider;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    Button button;
    InterstitialAd mInterstitialAd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        button=(Button)root.findViewById(R.id.button);


        AdProvider.getAd(root);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                new EndpointsAsyncTask(getActivity()).execute(getContext());
            }
        });
        requestNewInterstitial();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    EndpointsAsyncTask endpointsAsyncTask=new EndpointsAsyncTask(getActivity());
                    endpointsAsyncTask.execute(getContext());
                }
            }
        });


        return root;
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("141030849A0204221832FE8B3C5419E1")
                .build();

        InterstitialAdProvider.loadInterstitialAd(mInterstitialAd, adRequest);
    }
}
