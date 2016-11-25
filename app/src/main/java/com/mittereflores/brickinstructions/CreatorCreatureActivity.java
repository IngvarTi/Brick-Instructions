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

public class CreatorCreatureActivity extends Activity implements View.OnClickListener {

    PDFTools pdfe = new PDFTools();
	private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator_creature);
		
		// Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setVisibility(View.GONE);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.CreatorCreatureLayout);

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
        t.setScreenName("Creat Creature");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);

        final ImageButton iBCC4884 = (ImageButton) findViewById(R.id.iBCC4884);
        iBCC4884.setOnClickListener(this);
        final ImageButton iBCC4994 = (ImageButton) findViewById(R.id.iBCC4994);
        iBCC4994.setOnClickListener(this);
        final ImageButton iBCC6914a = (ImageButton) findViewById(R.id.iBCC6914a);
        iBCC6914a.setOnClickListener(this);
        final ImageButton iBCC6914b = (ImageButton) findViewById(R.id.iBCC6914b);
        iBCC6914b.setOnClickListener(this);
        final ImageButton iBCC31004a = (ImageButton) findViewById(R.id.iBCC31004a);
        iBCC31004a.setOnClickListener(this);
        final ImageButton iBCC31004b = (ImageButton) findViewById(R.id.iBCC31004b);
        iBCC31004b.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        GoogleAnalytics.getInstance(CreatorCreatureActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        GoogleAnalytics.getInstance(CreatorCreatureActivity.this).reportActivityStop(this);
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
        getMenuInflater().inflate(R.menu.menu_creator_creature, menu);
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
            case R.id.iBCC4884:
                pdfe.showPDFUrl(this, ArrayUrl.creatorCreatureUrl[0]);
                Tracker a = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                a.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Creature")
                        .setAction("CC4884")
                        .build());
                break;
            case R.id.iBCC4994:
                pdfe.showPDFUrl(this, ArrayUrl.creatorCreatureUrl[1]);
                Tracker b = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                b.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Creature")
                        .setAction("CC4994")
                        .build());
                break;
            case R.id.iBCC6914a:
                pdfe.showPDFUrl(this, ArrayUrl.creatorCreatureUrl[2]);
                Tracker c = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                c.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Creature")
                        .setAction("CC6914a")
                        .build());
                break;
            case R.id.iBCC6914b:
                pdfe.showPDFUrl(this, ArrayUrl.creatorCreatureUrl[3]);
                Tracker d = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                d.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Creature")
                        .setAction("CC6914b")
                        .build());
                break;
            case R.id.iBCC31004a:
                pdfe.showPDFUrl(this, ArrayUrl.creatorCreatureUrl[4]);
                Tracker e = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                e.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Creature")
                        .setAction("CC31004a")
                        .build());
                break;
            case R.id.iBCC31004b:
                pdfe.showPDFUrl(this, ArrayUrl.creatorCreatureUrl[5]);
                Tracker f = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
                f.send(new HitBuilders.EventBuilder()
                        .setCategory("Creat Creature")
                        .setAction("CC31004b")
                        .build());
                break;
            default:
                break;
        }
    }

}
