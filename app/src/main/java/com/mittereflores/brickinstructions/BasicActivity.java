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


public class BasicActivity extends Activity implements View.OnClickListener {

    PDFTools pdfe = new PDFTools();
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        // Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setVisibility(View.GONE);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.BasicLayout);

        // Добавление в разметку экземпляра adView.
        layout.addView(adView);

        // Инициирование общего запроса.
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
        t.setScreenName("Basic Model");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);

        final ImageButton iBcoop = (ImageButton)findViewById(R.id.iBcoop);
        iBcoop.setOnClickListener(this);
        final ImageButton iBy = (ImageButton)findViewById(R.id.iBy);
        iBy.setOnClickListener(this);
        final ImageButton iBvkg = (ImageButton)findViewById(R.id.iBvkg);
        iBvkg.setOnClickListener(this);
        final ImageButton iBCat = (ImageButton)findViewById(R.id.iBCat);
        iBCat.setOnClickListener(this);
        final ImageButton iBSpeeder = (ImageButton)findViewById(R.id.iBSpeeder);
        iBSpeeder.setOnClickListener(this);
        final ImageButton iBmft = (ImageButton)findViewById(R.id.iBmft);
        iBmft.setOnClickListener(this);
        final ImageButton iBme = (ImageButton)findViewById(R.id.iBme);
        iBme.setOnClickListener(this);
        final ImageButton iBmo = (ImageButton)findViewById(R.id.iBmo);
        iBmo.setOnClickListener(this);
        final ImageButton iBrobo = (ImageButton)findViewById(R.id.iBrobo);
        iBrobo.setOnClickListener(this);
        final ImageButton iBmsc = (ImageButton)findViewById(R.id.iBmsc);
        iBmsc.setOnClickListener(this);
        final ImageButton iB4915 = (ImageButton)findViewById(R.id.iB4915);
        iB4915.setOnClickListener(this);
        final ImageButton iB4838 = (ImageButton)findViewById(R.id.iB4838);
        iB4838.setOnClickListener(this);
        final ImageButton iB5864 = (ImageButton)findViewById(R.id.iB5864);
        iB5864.setOnClickListener(this);
        final ImageButton iB5865 = (ImageButton)findViewById(R.id.iB5865);
        iB5865.setOnClickListener(this);
        final ImageButton iB5762 = (ImageButton)findViewById(R.id.iB5762);
        iB5762.setOnClickListener(this);
        final ImageButton iB6741 = (ImageButton)findViewById(R.id.iB6741);
        iB6741.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        GoogleAnalytics.getInstance(BasicActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        GoogleAnalytics.getInstance(BasicActivity.this).reportActivityStop(this);
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
            switch (v.getId()) {
                case R.id.iBcoop:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[0]);
                    Tracker a = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    a.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM40109")
                            .build());
                    break;
                case R.id.iBy:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[1]);
                    Tracker b = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    b.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM31014")
                            .build());
                    break;
                case R.id.iBvkg:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[2]);
                    Tracker c = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    c.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM31013")
                            .build());
                    break;
                case R.id.iBCat:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[3]);
                    Tracker d = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    d.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM30188")
                            .build());
                    break;
                case R.id.iBSpeeder:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[4]);
                    Tracker e = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    e.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM31000")
                            .build());
                    break;
                case R.id.iBmft:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[5]);
                    Tracker f = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    f.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM6911")
                            .build());
                    break;
                case R.id.iBme:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[6]);
                    Tracker g = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    g.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM5761")
                            .build());
                    break;
                case R.id.iBmo:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[7]);
                    Tracker h = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    h.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM6742")
                            .build());
                    break;
                case R.id.iBrobo:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[8]);
                    Tracker i = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    i.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM4917")
                            .build());
                    break;
                case R.id.iBmsc:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[9]);
                    Tracker j = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    j.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM6910")
                            .build());
                    break;
                case R.id.iB4915:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[10]);
                    Tracker k = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    k.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM4916")
                            .build());
                    break;
                case R.id.iB4838:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[11]);
                    Tracker l = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    l.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM4838")
                            .build());
                    break;
                case R.id.iB5864:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[12]);
                    Tracker m = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    m.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM5864")
                            .build());
                    break;
                case R.id.iB5865:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[13]);
                    Tracker n = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    n.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM5866")
                            .build());
                    break;
                case R.id.iB5762:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[14]);
                    Tracker o = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    o.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM5762")
                            .build());
                    break;
                case R.id.iB6741:
                    pdfe.showPDFUrl(this, ArrayUrl.basicUrl[15]);
                    Tracker p = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                    p.send(new HitBuilders.EventBuilder()
                            .setCategory("Basic Model")
                            .setAction("BM6741")
                            .build());
                    break;
                default:
                    break;

            }

        }



}
