package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class MyShowInfo {

    /**
     * id : 20445
     * userid : 13798066
     * title : 来自比友[一路向阳]的手机晒单
     * pic : http://s.meidebi.com/showdan_201610_580436094ad98vdhulq.png-sdlist3
     * pics : a:1:{i:0;s:67:"http://s.meidebi.com/showdan_201610_580436094ad98vdhulq.png-sdlist3";}
     * createtime : 1476670999
     * setpftime : 0
     * isperfect : 0
     * status : 0
     * unchecked : 0
     * ip : 119.79.228.3
     * impression :
     * album : a:1:{i:0;s:59:"http://s.meidebi.com/showdan_201610_580436094ad98vdhulq.png";}
     * tagstr :
     * isabroad : 0
     * devicetype : 2
     * shortcontent :
     * showdan_id : 20445
     * content : 么么么呃呃呃
     * votesp : 1
     * votesm : 0
     * showcount : 1
     * commentcount : 0
     * orgimages : a:1:{i:0;s:75:"http://s.meidebi.com/showdan_201610_580436094ad98vdhulq.png-detail1nowarter";}
     * remark :
     * checktime : 1476685104
     * checkip : 222.183.232.188
     * star : 0
     * coppernum : 0
     * coinsnum : 0
     * reason : .....
     * cover : http://s.meidebi.com/showdan_201610_580436094ad98vdhulq.png-sdlist3
     * siteid : 1
     * dbquality : 0.0
     * dispatch : 0.0
     * custom : 0.0
     * average : 0.0
     * transitcompany : 0
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
        private String title;
        private String createtime;
        private String status;
        private String orgimages;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOrgimages() {
            return orgimages;
        }

        public void setOrgimages(String orgimages) {
            this.orgimages = orgimages;
        }
    }
}
