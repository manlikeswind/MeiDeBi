package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
public class MyMessageInfo {

    /**
     * id : 3432072
     * touserid : 13798066
     * relateuserid : 1
     * content : 很抱歉，您的晒单<a href="http://www.meidebi.com/s-20445.html" target="_blank">来自比友[一路向阳]的手机晒单</a>由于"....."被审核未通过，请<a href="http://www.meidebi.com/Showdan/edit/id/20445.html" target="_blank">重新修改</a>再提交吧！<a href="http://www.meidebi.com/s-20445.html" target="_blank">查看</a>
     * sysmsgid : 0
     * ispm : 0
     * createtime : 1476685104
     * isread : 1
     * isdelete : 0
     * relatephoto : http://avatar.mdbimg.com/000/00/00/01_avatar_small.jpg?t=3
     * con : 很抱歉，您的晒单来自比友[一路向阳]的手机晒单由于"....."被审核未通过，请重新修改再提交吧！查看
     * tonickname : 一路向阳
     * relatenickname : admin
     * type : 4
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String createtime;
        private String con;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getCon() {
            return con;
        }

        public void setCon(String con) {
            this.con = con;
        }
    }
}
