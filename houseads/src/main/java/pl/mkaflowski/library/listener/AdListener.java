/*
 * Created by Darshan Pandya.
 * @itznotabug
 * Copyright (c) 2018.
 */

package pl.mkaflowski.library.listener;

public interface AdListener {

    void onAdLoadFailed();

    void onAdLoaded();

    void onAdClosed();

    void onAdShown();

    void onAdClicked();
}
