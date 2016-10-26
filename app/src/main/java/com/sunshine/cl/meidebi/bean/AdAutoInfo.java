package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/17.
 */
public class AdAutoInfo {

    /**
     * id : 2727
     * imgurl : http://p.mdbimg.com/slide_201610_580466ec8e007zjvqux.jpg
     * link : http://www.meidebi.com/g-1387369.html
     * title : 5万自营童书/原版书 满199减100元
     * styles :
     * description :
     * starttime : 1476683460
     * endtime : 1477843140
     * sort : 255
     * status : 1
     * type : 1
     * updatetime : 1476683507
     * imgUrl : http://p.mdbimg.com/slide_201610_580466ec8e007zjvqux.jpg
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
        private String imgurl;
        private String link;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
