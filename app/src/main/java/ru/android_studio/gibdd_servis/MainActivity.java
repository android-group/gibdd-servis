package ru.android_studio.gibdd_servis;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.crash.FirebaseCrash;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.android_studio.gibdd_servis.auto.activity.RequestAutoActivity;
import ru.android_studio.gibdd_servis.auto.gibdd.CheckAutoType;
import ru.android_studio.gibdd_servis.driver.activity.RequestDriverActivity;

public class MainActivity extends ActivityWithToolbar {

    private static final String APP_ID = "ca-app-pub-7157276789419592~2989801067";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        toolbar.setLogo(R.mipmap.ic_main);

        addMobBanner();
        FirebaseCrash.log("MainActivity created");
        FirebaseCrash.report(new Exception("My first Android non-fatal error"));
    }

    // Проверка водителя
    @OnClick(R.id.menu_driver_btn)
    void menuDriverBtnOnClick() {
        Intent intentDriverActivity = new Intent(getApplicationContext(), RequestDriverActivity.class);
        startActivity(intentDriverActivity);
    }

    // Проверка истории регистрации в ГИБДД
    @OnClick(R.id.menu_car_history_btn)
    void menuCarHistoryBtnOnClick() {
        Intent intentCarHistoryActivity = new Intent(getApplicationContext(), RequestAutoActivity.class);
        intentCarHistoryActivity.putExtra(RequestAutoActivity.CHECK_AUTO_TYPE, CheckAutoType.HISTORY);
        startActivity(intentCarHistoryActivity);
    }

    // Проверка на участие в дорожно-транспортных происшествиях
    @OnClick(R.id.menu_car_dtp_btn)
    void menuCarDtpBtnOnClick() {
        Intent intentCarDtpActivity = new Intent(getApplicationContext(), RequestAutoActivity.class);
        intentCarDtpActivity.putExtra(RequestAutoActivity.CHECK_AUTO_TYPE, CheckAutoType.DTP);
        startActivity(intentCarDtpActivity);
    }

    // Проверка наличия ограничений
    @OnClick(R.id.menu_car_restrict_btn)
    void menuCarRestrictBtnOnClick() {
        Intent intentCarRestrictActivity = new Intent(getApplicationContext(), RequestAutoActivity.class);
        intentCarRestrictActivity.putExtra(RequestAutoActivity.CHECK_AUTO_TYPE, CheckAutoType.RESTRICT);
        startActivity(intentCarRestrictActivity);
    }

    // Проверка нахождения в розыске
    @OnClick(R.id.menu_car_wanted_btn)
    void menuCarWantedBtnOnClick() {
        Intent intentCarWantedActivity = new Intent(getApplicationContext(), RequestAutoActivity.class);
        intentCarWantedActivity.putExtra(RequestAutoActivity.CHECK_AUTO_TYPE, CheckAutoType.WANTED);
        startActivity(intentCarWantedActivity);
    }

    private void addMobBanner() {
        MobileAds.initialize(getApplicationContext(), APP_ID);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        /*AdRequest adRequest = new AdRequest.Builder().addTestDevice("63EC398B918CC0428A2236B4BCC113C3").build();*/
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}