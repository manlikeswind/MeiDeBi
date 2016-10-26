package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class MyCommentInfo {

    /**
     * id : 1458711
     * comment : 还可以。。。。
     * createtime : 2016-10-19 20:52:43
     * fromtitle : 《MOVADO 摩凡陀 kara系列 女士时尚腕表》
     * fromtype : 1
     * fromid : 1387388
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
        private String comment;
        private String createtime;
        private String fromtitle;
        private String fromtype;
        private String fromid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getFromtitle() {
            return fromtitle;
        }

        public void setFromtitle(String fromtitle) {
            this.fromtitle = fromtitle;
        }

        public String getFromtype() {
            return fromtype;
        }

        public void setFromtype(String fromtype) {
            this.fromtype = fromtype;
        }

        public String getFromid() {
            return fromid;
        }

        public void setFromid(String fromid) {
            this.fromid = fromid;
        }
    }
}
