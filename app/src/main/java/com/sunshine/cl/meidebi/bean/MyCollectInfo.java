package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class MyCollectInfo {

    /**
     * id : 1920
     * strUp : 一号店188-15元优惠券
     * strImgUrl : http://img.meidebi.com/mdb/mdbsitelog/510644daa7baf.gif
     * strDown : 满188减15
     * type : 1
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
        private String strUp;
        private String strImgUrl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStrUp() {
            return strUp;
        }

        public void setStrUp(String strUp) {
            this.strUp = strUp;
        }

        public String getStrImgUrl() {
            return strImgUrl;
        }

        public void setStrImgUrl(String strImgUrl) {
            this.strImgUrl = strImgUrl;
        }
    }
}
