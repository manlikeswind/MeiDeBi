package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */
public class HotStoreGridInfo {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 61
         * name : 美国亚马逊
         * host : amazon.com
         * androidicon : http://css.meidebi.com/api/siteicon/android/amazon.com.jpg
         * iosicon : http://css.meidebi.com/api/siteicon/ios/amazon.com.jpg
         */

        private List<HaitaoBean> haitao;
        /**
         * id : 64
         * name : 天猫
         * host : tmall.com
         * androidicon : http://css.meidebi.com/api/siteicon/android/tmall.com.jpg
         * iosicon : http://css.meidebi.com/api/siteicon/ios/tmall.com.jpg
         */

        private List<GuoneiBean> guonei;

        public List<HaitaoBean> getHaitao() {
            return haitao;
        }

        public void setHaitao(List<HaitaoBean> haitao) {
            this.haitao = haitao;
        }

        public List<GuoneiBean> getGuonei() {
            return guonei;
        }

        public void setGuonei(List<GuoneiBean> guonei) {
            this.guonei = guonei;
        }

        public static class HaitaoBean {
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

        public static class GuoneiBean {
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
}
