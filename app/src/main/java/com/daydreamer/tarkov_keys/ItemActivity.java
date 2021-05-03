package com.daydreamer.tarkov_keys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

import android.graphics.Color;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView price;
    LineChart lineChart;
    private Item item;
    JSONObject itemObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity);

        getPassedItem();
        InitSpawnAdapter();
        InitOpenAdapter();

        ImageView img = findViewById(R.id.itemImg);
        TextView spawnText = findViewById(R.id.spawnText);
        TextView lootText = findViewById(R.id.loot);
        TextView title = findViewById(R.id.key_title);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    getItemPrice(item.id);

                } catch (Exception e) {
                    Log.i("LOL", e.getMessage());
                    runOnUiThread(new Runnable() {
                        public void run() {
                            new SweetAlertDialog(ItemActivity.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Price is not available :(")
                                    .show();
                        }
                    });

                    e.printStackTrace();
                }
            }
        });

        thread.start();


        lootText.setText(item.loot);
        title.setText(item.name);
        price = findViewById(R.id.price);
        img.setImageResource(item.item);
        spawnText.setText(item.spawn);
        recyclerView.setNestedScrollingEnabled(false);

    }


    private ArrayList<Entry> values() {
        ArrayList<Entry> data = new ArrayList<Entry>();

        try {
            JSONArray array = itemObj.getJSONArray("prices");

            int buf = 1;

            for (int i = 0 ; i < array.length(); i++) {
                JSONObject price = array.getJSONObject(i);

                data.add(new Entry(buf, Integer.parseInt(price.getString("price"))));
                buf++;
            }

        } catch (JSONException e) {

            e.printStackTrace();
        }

        return data;
    }

    private void setupLineChart() {

        lineChart = findViewById(R.id.lineChart);
        LineDataSet lineDataSet = new LineDataSet(values(), "Price");


        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getAxisLeft().setTextColor(Color.WHITE);
        lineChart.getXAxis().setTextColor(Color.WHITE);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        // lineDataSet.setDrawFilled(true);
        //lineDataSet.setDrawValues(false);
        lineDataSet.setCircleHoleColor(Color.parseColor("#27cf75"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setFillColor(ContextCompat.getColor(this, R.color.green));
        lineDataSet.setColor(ContextCompat.getColor(this, R.color.green));
        lineDataSet.setFillAlpha(255);
        lineDataSet.setValueTextColor(Color.WHITE);
        lineDataSet.setValueTextSize(12f);


        //lineDataSet.setDrawCircles(false);
        lineDataSet.setCircleColor(Color.parseColor("#27cf75"));
        lineChart.getDescription().setText("");
        lineChart.getLegend().setEnabled(false);
        lineChart.getXAxis().setEnabled(false);
        lineChart.getAxisRight().setEnabled(false);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);

        LineData data = new LineData(dataSets);

        lineChart.setData(data);
        lineChart.invalidate();
    }


    private void getPassedItem() {
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Item item = (Item) bundle.getSerializable("item");
        this.item = item;
    }

    public Drawable scaleImage(Drawable image, float scaleFactor) {

        if ((image == null) || !(image instanceof BitmapDrawable)) {
            return image;
        }

        Bitmap b = ((BitmapDrawable) image).getBitmap();

        int sizeX = Math.round(image.getIntrinsicWidth() * scaleFactor);
        int sizeY = Math.round(image.getIntrinsicHeight() * scaleFactor);

        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, sizeX, sizeY, false);

        image = new BitmapDrawable(getResources(), bitmapResized);

        return image;

    }

    private void InitSpawnAdapter() {
        final ArrayList<ItemSpawn> exampleList = new ArrayList<>();
        for (int i = 0; i < item.spawnImg.length; i++) {
            // exampleList.add(new ItemSpawn(item.getSpawnImg()[i]));
            exampleList.add(new ItemSpawn(scaleImage(getResources().getDrawable(item.getSpawnImg()[i]), 0.2f)));
        }


        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new AdapterSpawn(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void InitOpenAdapter() {
        final ArrayList<ItemOpen> exampleList = new ArrayList<>();

        for (int i = 0; i < item.openImg.length; i++) {
            exampleList.add(new ItemOpen(scaleImage(getResources().getDrawable(item.getOpenImg()[i]), 0.35f)));
            //  exampleList.add(new ItemOpen(item.getOpenImg()[i]));
        }

        recyclerView = findViewById(R.id.recyclerView3);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new AdapterOpen(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void getItemPrice(String id) {
        //   https://tarkov-prices.com/api/item


        String API = "https://ttarkov.herokuapp.com/api/item";
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        RequestBody formBody = new FormBody.Builder()
                .add("bsgId", String.valueOf(id))
                .build();
        final Request request = new Request.Builder().url(API).post(formBody).addHeader("bsgid", String.valueOf(id)).addHeader("price_limit", "7").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.i("LOL", e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                try {
                    itemObj = new JSONObject(response.body().string());
                    Log.i("LOL", itemObj.toString());

                    runOnUiThread(new Runnable() {
                        public void run() {

                            new SweetAlertDialog(ItemActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("Price is available :)")
                                    .show();

                            setupLineChart();
                            try {
                                price.setText("₽" + itemObj.getString("price"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (JSONException e) {
                    runOnUiThread(new Runnable() {
                        public void run() {


                        }
                    });
                    e.printStackTrace();
                }
            }

        });

    }


}
