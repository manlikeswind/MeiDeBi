package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
public class AppRecommendInfo {

    /**
     * data : [{"id":"10","appname":"招财锁","appdesc":"一款会赚钱的手锁屏app，每日轻松解锁获取收益。","applogo":"http://img.meidebi.com/mdb/mdbad/apprecommend_20161014174346.png","appurl":"http://119.cc/lockscreen/LockScreen_s1025.apk","listorder":"0"},{"id":"11","appname":"夺宝大师","appdesc":"下载立得18元，1元可得iPhone7！","applogo":"http://img.meidebi.com/mdb/mdbad/apprecommend_20161017175447.png","appurl":"http://mdb.mdbimg.com/mdbad/cn.qimai.shopping__tuiguang22__1.3.0__130.apk","listorder":"0"},{"id":"9","appname":"存吧","appdesc":"存吧手机应用银行，只存应用不存钱。","applogo":"http://img.meidebi.com/mdb/mdbad/apprecommend_20161013115731.png","appurl":"http://mdb.mdbimg.com/mdbad/AppBank.com.adot.pbank_3.0.2_09281056_410_0.apk","listorder":"1"},{"id":"4","appname":"疯狂造人","appdesc":"备孕怀孕期妈妈必备助手","applogo":"http://img.meidebi.com/mdb/mdbad/apprecommend_20160906101632.png","appurl":"http://d.bzstatic.com/V4.4.0/BzCrazy_5.6.1_huanliang2.apk","listorder":"3"},{"id":"7","appname":"伊健康","appdesc":"最暖心的女性健康管理平台","applogo":"http://img.meidebi.com/mdb/mdbad/apprecommend_20160914160029.png","appurl":"http://www.hmsgtech.com/adapter/system/downloadApp?channel=meidebi","listorder":"6"}]
     * info : GET_DATA_SUCCESS
     * status : 1
     */

    private String info;
    private int status;
    /**
     * id : 10
     * appname : 招财锁
     * appdesc : 一款会赚钱的手锁屏app，每日轻松解锁获取收益。
     * applogo : http://img.meidebi.com/mdb/mdbad/apprecommend_20161014174346.png
     * appurl : http://119.cc/lockscreen/LockScreen_s1025.apk
     * listorder : 0
     */

    private List<DataBean> data;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String appname;
        private String appdesc;
        private String applogo;
        private String appurl;
        private String listorder;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAppname() {
            return appname;
        }

        public void setAppname(String appname) {
            this.appname = appname;
        }

        public String getAppdesc() {
            return appdesc;
        }

        public void setAppdesc(String appdesc) {
            this.appdesc = appdesc;
        }

        public String getApplogo() {
            return applogo;
        }

        public void setApplogo(String applogo) {
            this.applogo = applogo;
        }

        public String getAppurl() {
            return appurl;
        }

        public void setAppurl(String appurl) {
            this.appurl = appurl;
        }

        public String getListorder() {
            return listorder;
        }

        public void setListorder(String listorder) {
            this.listorder = listorder;
        }
    }
}
