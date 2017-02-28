package com.kobe.ubersplash.utils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jack on 2017/2/8.
 */

public class TeanBeen {

    @SerializedName("美女")
    public List<PeopleBeen> girls;

    public List<PeopleBeen> getGirls() {
        return girls;
    }

    public void setGirls(List<PeopleBeen> girls) {
        this.girls = girls;
    }

    public static class PeopleBeen {
        private String img;
        private String imgsrc;
        private String pixel;
        private int upTimes;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public int getUpTimes() {
            return upTimes;
        }

        public void setUpTimes(int upTimes) {
            this.upTimes = upTimes;
        }
    }

}
