package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */
public class TradeClassGridInfo {

    /**
     * id : 1
     * name : 3C数码
     * parentid : 0
     * androidicon : http://css.meidebi.com/api/cateicon/android/shuma.png
     * iosicon : http://css.meidebi.com/api/cateicon/ios/shuma.png
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String name;
        private String androidicon;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAndroidicon() {
            return androidicon;
        }

        public void setAndroidicon(String androidicon) {
            this.androidicon = androidicon;
        }
    }
}
