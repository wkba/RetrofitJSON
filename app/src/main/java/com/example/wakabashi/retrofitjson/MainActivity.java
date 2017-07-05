package com.example.wakabashi.retrofitjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.wakabashi.retrofitjson.model.Feed;
import com.example.wakabashi.retrofitjson.model.children.Children;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final String  BASE_USL = "https://www.reddit.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGetData = (Button) findViewById(R.id.btnGetData);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_USL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RedditAPI redditAPI = retrofit.create(RedditAPI.class);
        Call<Feed> call = redditAPI.getData();

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());

                ArrayList<Children> childrenList = response.body().getData().getChildren();
                for(int i = 0; i<childrenList.size(); i++){
                    Log.d(TAG, "onResponse: \n" +
                            "kind: " + childrenList.get(i).getKind() + "\n" +
                            "contest_mode: " + childrenList.get(i).getData().getContest_mode() + "\n" +
                            "subreddit: " + childrenList.get(i).getData().getSubreddit() + "\n" +
                            "author:" + childrenList.get(i).getData().getAuthor() + "\n" +
                            "\n-----------------------------------\n\n" );
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong" + t.getMessage());
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
