package pl.mkaflowski.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import pl.mkaflowski.library.HouseAdsDialog;
import pl.mkaflowski.library.listener.AdListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final HouseAdsDialog houseAds = new HouseAdsDialog(MainActivity.this);
        String url = "http://url.usermd.net/apps.json";
        houseAds.setUrl(url); //URL to Json File
//        houseAds.setCardCorners(100); // Set CardView's corner radius.
//        houseAds.setCtaCorner(100); //Set CTA Button's background radius.
//        houseAds.hideIfAppInstalled(false); //An App's Ad will be shown if it is Installed on the Device.
//        houseAds.setUsePaletteColor(false);
        houseAds.setThemeId(R.style.AppTheme);
//        houseAds.showHeaderIfAvailable(false); //Show Header Image if available, true by default
        houseAds.setForceLoadFresh(false); //Fetch Json everytime loadAds() is called, true by default, if set to false, Json File's Response is kept untill App is closed!
        houseAds.loadAds();

        houseAds.setAdListener(new AdListener() {
            @Override
            public void onAdLoadFailed() {
                Log.e("onAdLoadFailed", "onAdLoadFailed");
            }

            @Override
            public void onAdLoaded() {
                //Show AdDialog as soon as it is loaded.
                houseAds.showAd();
            }

            @Override
            public void onAdClosed() {
            }

            @Override
            public void onAdShown() {
            }

            @Override
            public void onAdClicked() {
            }
        });
    }
}
