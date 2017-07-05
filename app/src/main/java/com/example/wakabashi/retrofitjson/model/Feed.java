package com.example.wakabashi.retrofitjson.model;

import com.example.wakabashi.retrofitjson.model.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by wakabashi on 2017/07/04.
 */

public class Feed {
    @SerializedName("kind")
    @Expose
    private String king;

    @SerializedName("data")
    @Expose
    private Data data;


    public String getKing() {
        return king;
    }

    public void setKing(String king) {
        this.king = king;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "king='" + king + '\'' +
                ", data=" + data +
                '}';
    }
}
