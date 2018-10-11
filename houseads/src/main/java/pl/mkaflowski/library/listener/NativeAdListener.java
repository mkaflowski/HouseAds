/*
 * Created by Darshan Pandya.
 * @itznotabug
 * Copyright (c) 2018.
 */

package pl.mkaflowski.library.listener;

import android.view.View;

@SuppressWarnings("unused")
public interface NativeAdListener {

    void onAdLoaded();

    void onAdLoadFailed();

    interface CallToActionListener {
        void onCallToActionClicked(View view);
    }
}
