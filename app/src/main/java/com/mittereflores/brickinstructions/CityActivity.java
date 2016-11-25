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

public class CityActivity extends Activity implements View.OnClickListener {


    PDFTools pdfe = new PDFTools();
	private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
		
		// Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setVisibility(View.GONE);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.CityLayout);

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
        t.setScreenName("City");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);

        final ImageButton lC4437 = (ImageButton) findViewById(R.id.lC4437);
        lC4437.setOnClickListener(this);
        final ImageButton lC30017 = (ImageButton) findViewById(R.id.lC30017);
        lC30017.setOnClickListener(this);
        final ImageButton lC30018 = (ImageButton) findViewById(R.id.lC30018);
        lC30018.setOnClickListener(this);
        final ImageButton lC30220 = (ImageButton) findViewById(R.id.lC30220);
        lC30220.setOnClickListener(this);
        final ImageButton lC30222 = (ImageButton) findViewById(R.id.lC30222);
        lC30222.setOnClickListener(this);
        final ImageButton lC30226 = (ImageButton) findViewById(R.id.lC30226);
        lC30226.setOnClickListener(this);
        final ImageButton lC30227 = (ImageButton) findViewById(R.id.lC30227);
        lC30227.setOnClickListener(this);
        final ImageButton lC30228 = (ImageButton) findViewById(R.id.lC30228);
        lC30228.setOnClickListener(this);
        final ImageButton lC60053 = (ImageButton) findViewById(R.id.lC60053);
        lC60053.setOnClickListener(this);
        final ImageButton lC60055 = (ImageButton) findViewById(R.id.lC60055);
        lC60055.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        GoogleAnalytics.getInstance(CityActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        GoogleAnalytics.getInstance(CityActivity.this).reportActivityStop(this);
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
        getMenuInflater().inflate(R.menu.menu_city, menu);
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
            case R.id.lC4437:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[0]);
                Tracker a = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                a.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci4437")
                        .build());
                break;
            case R.id.lC30017:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[1]);
                Tracker b = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                b.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci30017")
                        .build());
                break;
            case R.id.lC30018:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[2]);
                Tracker c = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                c.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci30018")
                        .build());
                break;
            case R.id.lC30220:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[3]);
                Tracker d = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                d.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci30220")
                        .build());
                break;
            case R.id.lC30222:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[4]);
                Tracker e = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                e.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci30222")
                        .build());
                break;
            case R.id.lC30226:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[5]);
                Tracker f = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                f.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci30226")
                        .build());
                break;
            case R.id.lC30227:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[6]);
                Tracker g = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                g.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci30227")
                        .build());
                break;
            case R.id.lC30228:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[7]);
                Tracker h = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                h.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci30228")
                        .build());
                break;
            case R.id.lC60053:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[8]);
                Tracker i = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                i.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci60053")
                        .build());
                break;
            case R.id.lC60055:
                pdfe.showPDFUrl(this, ArrayUrl.cityUrl[9]);
                Tracker j = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                j.send(new HitBuilders.EventBuilder()
                        .setCategory("City")
                        .setAction("Ci60055")
                        .build());
                break;
            default:
                break;
        }

    }

}

