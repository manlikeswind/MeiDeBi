package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
public class MyExplodeInfo {

    /**
     * id : 1398994
     * userid : 13798066
     * image : http://p.mdbimg.com/share_201610_580ccf25cd3e0jambir.jpg-dpdisplay1
     * title : 克丽丝汀 DIOR 迪奥 魅惑润唇蜜SPF10 3.5g
     * siteid : 2
     * fcategory : 48
     * category : 49
     * timeout : 1
     * linktype : 1
     * ishot : 0
     * sethottime : 0
     * isagthot : 0
     * setagthottime : 0
     * isoriginal : 0
     * createtime : 1477234469
     * updatetime : 0
     * statustext : 审核已通过
     * sitename : 京东
     * price : 269.00
     * postage : 0.00
     * lowpricetype : 0
     * commentcount : 0
     * votesm : 0
     * votesp : 0
     * nickname : 一路向阳
     * categoryname : 彩妆香水
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
        private String image;
        private String title;
        private String createtime;
        private String statustext;
        private String sitename;
        private String price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getStatustext() {
            return statustext;
        }

        public void setStatustext(String statustext) {
            this.statustext = statustext;
        }

        public String getSitename() {
            return sitename;
        }

        public void setSitename(String sitename) {
            this.sitename = sitename;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
