package com.mittereflores.brickinstructions;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.ads.*;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class BasicSetActivity extends Activity implements View.OnClickListener {

    PDFTools pdfe = new PDFTools();
	private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_set);
		
		// Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setVisibility(View.GONE);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.BasicSetLayout);

        // Добавление в разметку экземпляра adView.
        layout.addView(adView);

        // �?нициирование общего запроса.
        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice("9F6FEC69B4D6EB41F13C9F0058F06AC7")
//                .addTestDevice("0999F05675AD0BEFAE585E82F3F576CA")
                .build();

        // Загрузка adView с объявлением.
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener()
        { @Override public void onAdLoaded() {
                adView.setVisibility(View.VISIBLE); } });

        Tracker t = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
        t.setScreenName("Basic Set");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);


        final ImageButton iB6167 = (ImageButton)findViewById(R.id.iB6167);
        iB6167.setOnClickListener(this);
        final ImageButton iB10681 = (ImageButton)findViewById(R.id.iB10681);
        iB10681.setOnClickListener(this);
        final ImageButton iB6192 = (ImageButton)findViewById(R.id.iB6192);
        iB6192.setOnClickListener(this);
        final ImageButton iB6187 = (ImageButton)findViewById(R.id.iB6187);
        iB6187.setOnClickListener(this);
        final ImageButton iB7870 = (ImageButton)findViewById(R.id.iB7870);
        iB7870.setOnClickListener(this);
        final ImageButton iB5482 = (ImageButton)findViewById(R.id.iB5482);
        iB5482.setOnClickListener(this);
        final ImageButton iB3600 = (ImageButton)findViewById(R.id.iB3600);
        iB3600.setOnClickListener(this);
        final ImageButton iB5584 = (ImageButton)findViewById(R.id.iB5584);
        iB5584.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        GoogleAnalytics.getInstance(BasicSetActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        GoogleAnalytics.getInstance(BasicSetActivity.this).reportActivityStop(this);
    }
	
	    @Override
    public void onPause() {
        adView.pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        adView.resume();
    }

    @Override
    public void onDestroy() {
        adView.destroy();
        super.onDestroy();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iB6167:
                pdfe.showPDFUrl(this, ArrayUrl.basicSetUrl[0]);
                Tracker a = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                a.send(new HitBuilders.EventBuilder()
                        .setCategory("Basic Set")
                        .setAction("BS6167")
                        .build());
                break;
            case R.id.iB10681:
                pdfe.showPDFUrl(this, ArrayUrl.basicSetUrl[1]);
                Tracker b = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                b.send(new HitBuilders.EventBuilder()
                        .setCategory("Basic Set")
                        .setAction("BS10681")
                        .build());
                break;
            case R.id.iB6192:
                pdfe.showPDFUrl(this, ArrayUrl.basicSetUrl[2]);
                Tracker c = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                c.send(new HitBuilders.EventBuilder()
                        .setCategory("Basic Set")
                        .setAction("BS6192")
                        .build());
                break;
            case R.id.iB6187:
                pdfe.showPDFUrl(this, ArrayUrl.basicSetUrl[3]);
                Tracker d = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                d.send(new HitBuilders.EventBuilder()
                        .setCategory("Basic Set")
                        .setAction("BS6187")
                        .build());
                break;
            case R.id.iB7870:
                pdfe.showPDFUrl(this, ArrayUrl.basicSetUrl[4]);
                Tracker e = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                e.send(new HitBuilders.EventBuilder()
                        .setCategory("Basic Set")
                        .setAction("BS7870")
                        .build());
                break;
            case R.id.iB5482:
                pdfe.showPDFUrl(this, ArrayUrl.basicSetUrl[5]);
                Tracker f = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                f.send(new HitBuilders.EventBuilder()
                        .setCategory("Basic Set")
                        .setAction("BS5482")
                        .build());
                break;
            case R.id.iB3600:
                pdfe.showPDFUrl(this, ArrayUrl.basicSetUrl[6]);
                Tracker g = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                g.send(new HitBuilders.EventBuilder()
                        .setCategory("Basic Set")
                        .setAction("BS3600")
                        .build());
                break;
            case R.id.iB5584:
                pdfe.showPDFUrl(this, ArrayUrl.basicSetUrl[7]);
                Tracker h = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                h.send(new HitBuilders.EventBuilder()
                        .setCategory("Basic Set")
                        .setAction("BS5584")
                        .build());
                break;
            default:
                break;

        }
    }

}
