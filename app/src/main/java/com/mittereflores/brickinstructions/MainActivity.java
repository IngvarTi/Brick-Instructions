package com.mittereflores.brickinstructions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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

import com.mittereflores.brickinstructions.GoogleAnalyticsApp.TrackerName;


public class MainActivity extends Activity implements View.OnClickListener{

    private static final String MY_SETTINGS = "my_settings";
    PDFTools pdfe = new PDFTools();


    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создание экземпляра adView.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setVisibility(View.GONE);

        // Поиск разметки LinearLayout (предполагается, что ей был присвоен
        // атрибут android:id="@+id/mainLayout").
        LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayout);

        // Добавление в разметку экземпляра adView.
        layout.addView(adView);

        // Инициирование общего запроса.
        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice("9F6FEC69B4D6EB41F13C9F0058F06AC7")
//                .addTestDevice("0999F05675AD0BEFAE585E82F3F576CA")
                .build();

        // Загрузка adView с объявлением.
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                adView.setVisibility(View.VISIBLE);
            }
        });

		// Создание запроса объявления.
        //		  "0999F05675AD0BEFAE585E82F3F576CA"               HTC HD 2
        //        "9F6FEC69B4D6EB41F13C9F0058F06AC7"        Asus Fonepad HD 7


        final ImageButton imButBasic = (ImageButton) findViewById(R.id.imButBasic);
        imButBasic.setOnClickListener(this);
        final ImageButton imButBasicSet = (ImageButton) findViewById(R.id.imButBasicSet);
        imButBasicSet.setOnClickListener(this);
        final ImageButton imButCity = (ImageButton) findViewById(R.id.imButCity);
        imButCity.setOnClickListener(this);
        final ImageButton imButCreatTransport = (ImageButton) findViewById(R.id.imButCreatTransport);
        imButCreatTransport.setOnClickListener(this);
        final ImageButton imButCreatCreature = (ImageButton) findViewById(R.id.imButCreatCreature);
        imButCreatCreature.setOnClickListener(this);
        final ImageButton imButStarWars = (ImageButton) findViewById(R.id.imButStarWars);
        imButStarWars.setOnClickListener(this);

        Tracker t = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
        t.setScreenName("Home");
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAdvertisingIdCollection(true);



        SharedPreferences sp = getSharedPreferences(MY_SETTINGS,
                Context.MODE_PRIVATE);
        // проверяем, первый ли раз открывается программа
        boolean hasVisited = sp.getBoolean(getString(R.string.hasvisited), false);

        if (!hasVisited) {
            if (pdfe.isPDFSupported( this )){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.info)
                        .setMessage(getString(R.string.setMessageTrue))
                        .setIcon(R.drawable.ic_file_download_grey600_48dp)
                        .setCancelable(false)
                        .setPositiveButton(R.string.download,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Tracker t = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                                        t.send(new HitBuilders.EventBuilder()
                                                .setCategory("Information")
                                                .setAction("Download all instructions 1")
                                                .build());
                                        String[] basicUrl = ArrayUrl.basicUrl;
                                        for (int u = 0; u < basicUrl.length; u++){
                                            pdfe.downloadPDF(getApplicationContext(),basicUrl[u]);
                                        }
                                        String[] basicSetUrl = ArrayUrl.basicSetUrl;
                                        for (int u = 0; u < basicSetUrl.length; u++){
                                            pdfe.downloadPDF(getApplicationContext(),basicSetUrl[u]);
                                        }
                                        String[] cityUrl = ArrayUrl.cityUrl;
                                        for (int u = 0; u < cityUrl.length; u++){
                                            pdfe.downloadPDF(getApplicationContext(),cityUrl[u]);
                                        }
                                        String[] creatorCreatureUrl = ArrayUrl.creatorCreatureUrl;
                                        for (int u = 0; u < creatorCreatureUrl.length; u++){
                                            pdfe.downloadPDF(getApplicationContext(),creatorCreatureUrl[u]);
                                        }
                                        String[] creatTransportUrl = ArrayUrl.creatTransportUrl;
                                        for (int u = 0; u < creatTransportUrl.length; u++){
                                            pdfe.downloadPDF(getApplicationContext(),creatTransportUrl[u]);
                                        }
                                        String[] starWarsUrl = ArrayUrl.starWarsUrl;
                                        for (int u = 0; u < starWarsUrl.length; u++){
                                            pdfe.downloadPDF(getApplicationContext(),starWarsUrl[u]);
                                        }
//                                        dialog.cancel();
                                    }
                                })
                        .setNegativeButton(R.string.cancel,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Tracker t = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                                        t.send(new HitBuilders.EventBuilder()
                                                .setCategory("Information")
                                                .setAction("Online 1")
                                                .build());
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show(); // выводим нужную активность
                SharedPreferences.Editor e = sp.edit();
                e.putBoolean(getString(R.string.hasvisited), true);
                e.commit(); // не забудьте подтвердить изменения
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.info)
                        .setMessage(getString(R.string.setMessageFalse))
                        .setIcon(R.drawable.ic_info_outline_grey600_48dp)
                        .setCancelable(false)
                        .setNegativeButton(R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Tracker t = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                                        t.send(new HitBuilders.EventBuilder()
                                                .setCategory("Information")
                                                .setAction("Not Pdf 1")
                                                .build());
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show(); // выводим нужную активность
                SharedPreferences.Editor e = sp.edit();
                e.putBoolean(getString(R.string.hasvisited), true);
                e.commit(); // не забудьте подтвердить изменения
            }

        }

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        GoogleAnalytics.getInstance(MainActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        GoogleAnalytics.getInstance(MainActivity.this).reportActivityStop(this);
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.info:
                if (pdfe.isPDFSupported( this )){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.info)
                            .setMessage(getString(R.string.setMessageTrue))
                            .setIcon(R.drawable.ic_file_download_grey600_48dp)
                            .setCancelable(false)
                            .setPositiveButton(R.string.download,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Tracker t = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                                            t.send(new HitBuilders.EventBuilder()
                                                    .setCategory("Information")
                                                    .setAction("Download all instructions")
                                                    .build());
                                            String[] basicUrl = ArrayUrl.basicUrl;
                                            for (int u = 0; u < basicUrl.length; u++){
                                                pdfe.downloadPDF(getApplicationContext(),basicUrl[u]);
                                            }
                                            String[] basicSetUrl = ArrayUrl.basicSetUrl;
                                            for (int u = 0; u < basicSetUrl.length; u++){
                                                pdfe.downloadPDF(getApplicationContext(),basicSetUrl[u]);
                                            }
                                            String[] cityUrl = ArrayUrl.cityUrl;
                                            for (int u = 0; u < cityUrl.length; u++){
                                                pdfe.downloadPDF(getApplicationContext(),cityUrl[u]);
                                            }
                                            String[] creatorCreatureUrl = ArrayUrl.creatorCreatureUrl;
                                            for (int u = 0; u < creatorCreatureUrl.length; u++){
                                                pdfe.downloadPDF(getApplicationContext(),creatorCreatureUrl[u]);
                                            }
                                            String[] creatTransportUrl = ArrayUrl.creatTransportUrl;
                                            for (int u = 0; u < creatTransportUrl.length; u++){
                                                pdfe.downloadPDF(getApplicationContext(),creatTransportUrl[u]);
                                            }
                                            String[] starWarsUrl = ArrayUrl.starWarsUrl;
                                            for (int u = 0; u < starWarsUrl.length; u++){
                                                pdfe.downloadPDF(getApplicationContext(),starWarsUrl[u]);
                                            }
//                                        dialog.cancel();
                                        }
                                    })
                            .setNegativeButton(R.string.cancel,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Tracker t = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                                            t.send(new HitBuilders.EventBuilder()
                                                    .setCategory("Information")
                                                    .setAction("Online")
                                                    .build());
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show(); // выводим нужную активность
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.info)
                            .setMessage(getString(R.string.setMessageFalse))
                            .setIcon(R.drawable.ic_info_outline_grey600_48dp)
                            .setCancelable(false)
                            .setNegativeButton(R.string.ok,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Tracker t = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                                            t.send(new HitBuilders.EventBuilder()
                                                    .setCategory("Information")
                                                    .setAction("Not Pdf")
                                                    .build());
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show(); // выводим нужную активность
                }



                break;
            case R.id.action_settings:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.rateuri)));
                startActivity(intent);
                break;
            case R.id.disclaimer:
                AlertDialog.Builder builderD = new AlertDialog.Builder(MainActivity.this);
                builderD.setTitle(R.string.disclaimer)
                        .setMessage(getString(R.string.disclaimerText))
                        .setCancelable(false)
                        .setNegativeButton(getString(R.string.ok),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertD = builderD.create();
                alertD.show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imButBasic:
                Intent BasicLayout = new Intent(MainActivity.this, BasicActivity.class);
                startActivity(BasicLayout);
                Tracker a = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                a.send(new HitBuilders.EventBuilder()
                .setCategory("Activity")
                .setAction("Basic Model")
                .build());
                break;
            case R.id.imButBasicSet:
                Intent BasicSetLayout = new Intent(MainActivity.this, BasicSetActivity.class);
                startActivity(BasicSetLayout);
                Tracker b = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                b.send(new HitBuilders.EventBuilder()
                        .setCategory("Activity")
                        .setAction("Basic Set")
                        .build());
                break;
            case R.id.imButCity:
                Intent CityLayout = new Intent(MainActivity.this, CityActivity.class);
                startActivity(CityLayout);
                Tracker c = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                c.send(new HitBuilders.EventBuilder()
                        .setCategory("Activity")
                        .setAction("City")
                        .build());
                break;
            case R.id.imButCreatTransport:
                Intent CreateTransportLayout = new Intent(MainActivity.this, CreatTransportActivity.class);
                startActivity(CreateTransportLayout);
                Tracker d = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                d.send(new HitBuilders.EventBuilder()
                        .setCategory("Activity")
                        .setAction("Creat Transport")
                        .build());
                break;
            case R.id.imButCreatCreature:
                Intent CreatorCreatureLayout = new Intent(MainActivity.this, CreatorCreatureActivity.class);
                startActivity(CreatorCreatureLayout);
                Tracker e = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                e.send(new HitBuilders.EventBuilder()
                        .setCategory("Activity")
                        .setAction("Creat Creature")
                        .build());
                break;
            case R.id.imButStarWars:
                Intent StarWarsLayout = new Intent(MainActivity.this, StarWarsActivity.class);
                startActivity(StarWarsLayout);
                Tracker f = ((GoogleAnalyticsApp) getApplication()).getTracker(TrackerName.APP_TRACKER);
                f.send(new HitBuilders.EventBuilder()
                        .setCategory("Activity")
                        .setAction("Star Wars")
                        .build());
                break;
            default:
                break;

        }

    }

    public void onClickBasicModel(View view) {
        Intent BasicLayout = new Intent(MainActivity.this, BasicActivity.class);
        startActivity(BasicLayout);

    }

    public void onClickBasicSet(View view) {
        Intent BasicSetLayout = new Intent(MainActivity.this, BasicSetActivity.class);
        startActivity(BasicSetLayout);
    }

    public void onClickCity(View view) {
        Intent CityLayout = new Intent(MainActivity.this, CityActivity.class);
        startActivity(CityLayout);
    }

    public void onClickCreatTransport(View view) {
        Intent CreateTransportLayout = new Intent(MainActivity.this, CreatTransportActivity.class);
        startActivity(CreateTransportLayout);
    }

    public void onClickCreatorCreature(View view) {
        Intent CreatorCreatureLayout = new Intent(MainActivity.this, CreatorCreatureActivity.class);
        startActivity(CreatorCreatureLayout);
    }

    public void onClickStarWars(View view) {
        Intent StarWarsLayout = new Intent(MainActivity.this, StarWarsActivity.class);
        startActivity(StarWarsLayout);
    }
	

}
