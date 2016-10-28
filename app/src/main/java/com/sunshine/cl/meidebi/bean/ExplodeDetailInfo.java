package com.sunshine.cl.meidebi.bean;

/**
 * Created by Administrator on 2016/10/25.
 */
public class ExplodeDetailInfo {

    /**
     * type : 2
     * linkinfo : {"linkurl":"http://item.m.jd.com/product/10623992360.html","linkimge":"http://img10.360buyimg.com/n0/jfs/t3286/317/1156718473/179263/4a369d8b/57c68c3dN84a34546.jpg","orginprice":"398.00","proprice":"138.00","title":"战地吉普（AFS JEEP）针织衫 男 拼接保暖开衫毛衣外套 2016秋冬新款加厚纯色 262花灰 L 130斤"}
     * site : {"id":"2","name":"京东","coinsign":"￥","exchange":"0.0000","coinname":"人民币","whs":{"2":{"id":"2","whname":"华东地区"},"3":{"id":"3","whname":"西南地区"},"4":{"id":"4","whname":"华南地区"},"9":{"id":"9","whname":"华中地区"},"16":{"id":"16","whname":"华北地区"},"54":{"id":"54","whname":"东北地区"},"55":{"id":"55","whname":"西北地区"}}}
     * usertype : 1
     * resubmit : 0
     * token : {"key":"__mdbhash__","value":"c7fed2ae7a9b51f9e1f65d7977905b47_5c26fa62c53fde1de37b65045a28011c"}
     * session : 33nus60cgciedf5r53vab6hf12
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * linkurl : http://item.m.jd.com/product/10623992360.html
         * linkimge : http://img10.360buyimg.com/n0/jfs/t3286/317/1156718473/179263/4a369d8b/57c68c3dN84a34546.jpg
         * orginprice : 398.00
         * proprice : 138.00
         * title : 战地吉普（AFS JEEP）针织衫 男 拼接保暖开衫毛衣外套 2016秋冬新款加厚纯色 262花灰 L 130斤
         */

        private LinkinfoBean linkinfo;

        public LinkinfoBean getLinkinfo() {
            return linkinfo;
        }

        public void setLinkinfo(LinkinfoBean linkinfo) {
            this.linkinfo = linkinfo;
        }

        public static class LinkinfoBean {
            private String linkurl;
            private String linkimge;
            private String proprice;
            private String title;

            public String getLinkurl() {
                return linkurl;
            }

            public void setLinkurl(String linkurl) {
                this.linkurl = linkurl;
            }

            public String getLinkimge() {
                return linkimge;
            }

            public void setLinkimge(String linkimge) {
                this.linkimge = linkimge;
            }

            public String getProprice() {
                return proprice;
            }

            public void setProprice(String proprice) {
                this.proprice = proprice;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
