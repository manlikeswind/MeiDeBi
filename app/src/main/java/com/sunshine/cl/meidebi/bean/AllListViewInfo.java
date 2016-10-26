package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class AllListViewInfo {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * activeprice : 29.99
         * timeout : 1
         * siteid : 206
         * coinsign : $
         * id : 1389158
         * commentcount : 1
         * votesm : 0
         * votesp : 6
         * directmailmoney :
         * createtime : 1476769688
         * transfermoney : 65.00
         * directratiomoney :
         * category : 98
         * title : PUMA 彪马Suede Classic Debossed Q3男士麂皮时尚板鞋
         * fcategory : 2
         * sethottime : 1476771941
         * userid : 13461806
         * linktype : 1
         * proprice : 200.03
         * lowpricetype : 0
         * orginprice : 70.00
         * cpsurl :
         * orginprice_change : 466.90
         * activeprice_change : 200.03
         * hpostage : 0
         * image : http://p.mdbimg.com/share_201610_5805ba005f76eklwjdr.png-dpdisplay1
         * setagthottime : 1476771941
         * ishot : 1
         * isagthot : 1
         * isoriginal : 0
         * updatetime : 1476770443
         * remoteimage : http://p.mdbimg.com/share_201610_5805ba005f76eklwjdr.png-dpdisplay1
         * isabroad : 1
         * sitename : 6pm
         * price : 200.03
         * postage_change : 0.00
         * directmailmoney_dchange : 0.00
         * postage : -1.00
         * nickname : 欧阳
         * categoryname : 男鞋
         */

        private List<LinklistBean> linklist;

        public List<LinklistBean> getLinklist() {
            return linklist;
        }

        public void setLinklist(List<LinklistBean> linklist) {
            this.linklist = linklist;
        }

        public static class LinklistBean {
            private String id;
            private int commentcount;
            private int votesp;
            private String createtime;
            private String title;
            private String setagthottime;
            private String image;
            private int isabroad;
            private String sitename;
            private String price;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getCommentcount() {
                return commentcount;
            }

            public void setCommentcount(int commentcount) {
                this.commentcount = commentcount;
            }

            public int getVotesp() {
                return votesp;
            }

            public void setVotesp(int votesp) {
                this.votesp = votesp;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSetagthottime() {
                return setagthottime;
            }

            public void setSetagthottime(String setagthottime) {
                this.setagthottime = setagthottime;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getIsabroad() {
                return isabroad;
            }

            public void setIsabroad(int isabroad) {
                this.isabroad = isabroad;
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
}
