package com.mittereflores.brickinstructions;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.ads.*;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class CreatTransportActivity extends Activity implements View.OnClickListener {

    PDFTools pdfe = new PDFTools();
	private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_transport);
		
		// Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setVisibility(View.GONE);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.CreateTransportLayout);

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
        t.setScreenName("Creat Transport");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);


        final ImageButton iBCT4891 = (ImageButton) findViewById(R.id.iBCT4891);
        iBCT4891.setOnClickListener(this);
        final ImageButton iBCT4939a = (ImageButton) findViewById(R.id.iBCT4939a);
        iBCT4939a.setOnClickListener(this);
        final ImageButton iBCT4939b = (ImageButton) findViewById(R.id.iBCT4939b);
        iBCT4939b.setOnClickListener(this);
        final ImageButton iBCT5763 = (ImageButton) findViewById(R.id.iBCT5763);
        iBCT5763.setOnClickListener(this);
        final ImageButton iBCT6743a = (ImageButton) findViewById(R.id.iBCT6743a);
        iBCT6743a.setOnClickListener(this);
        final ImageButton iBCT6743b = (ImageButton) findViewById(R.id.iBCT6743b);
        iBCT6743b.setOnClickListener(this);
        final ImageButton iBCT6913a = (ImageButton) findViewById(R.id.iBCT6913a);
        iBCT6913a.setOnClickListener(this);
        final ImageButton iBCT6913b = (ImageButton) findViewById(R.id.iBCT6913b);
        iBCT6913b.setOnClickListener(this);
        final ImageButton iBCT31002a = (ImageButton) findViewById(R.id.iBCT31002a);
        iBCT31002a.setOnClickListener(this);
        final ImageButton iBCT31002b = (ImageButton) findViewById(R.id.iBCT31002b);
        iBCT31002b.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        GoogleAnalytics.getInstance(CreatTransportActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        GoogleAnalytics.getInstance(CreatTransportActivity.this).reportActivityStop(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_creat_transport, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iBCT4891:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[0]);
                Tracker a = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                a.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT4891")
                        .build());
                break;
            case R.id.iBCT4939a:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[1]);
                Tracker b = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                b.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT4939a")
                        .build());
                break;
            case R.id.iBCT4939b:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[2]);
                Tracker c = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                c.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT4939b")
                        .build());
                break;
            case R.id.iBCT5763:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[3]);
                Tracker d = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                d.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT5763")
                        .build());
                break;
            case R.id.iBCT6743a:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[4]);
                Tracker e = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                e.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT6743a")
                        .build());
                break;
            case R.id.iBCT6743b:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[5]);
                Tracker f = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                f.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT6743b")
                        .build());
                break;
            case R.id.iBCT6913a:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[6]);
                Tracker g = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                g.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT6913a")
                        .build());
                break;
            case R.id.iBCT6913b:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[7]);
                Tracker h = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                h.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT6913b")
                        .build());
                break;
            case R.id.iBCT31002a:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[8]);
                Tracker i = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                i.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT31002a")
                        .build());
                break;
            case R.id.iBCT31002b:
                pdfe.showPDFUrl(this, ArrayUrl.creatTransportUrl[9]);
                Tracker j = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                j.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Transport")
                        .setAction("CT31002b")
                        .build());
                break;
            default:
                break;
        }
    }

}
