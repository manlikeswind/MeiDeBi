package com.sunshine.cl.meidebi.constants;

/**
 * Created by Administrator on 2016/10/17.
 */
public class Constants {

    public static final String AD_AUTO = "http://a.meidebi.com/new.php/Share-getslide?version=3.2.3&devicetoken=352284040670808&devicetype=2";
    public static final String SEARCH_CLASS_GRID = "http://a.meidebi.com/new.php/Share-getcatgorys?version=3.2.3&ismain=1&devicetoken=352284040670808&devicetype=2";
    public static final String SEARCH_HOT_GRID = "http://a.meidebi.com/new.php/Share-getmall?version=3.2.3&devicetoken=864394101000273&devicetype=2";
    public static final String BASE_PATH = "http://a.meidebi.com/new.php";

    //B.国内特惠
    public static class DOMESTIC{
        // 1.列表
        //  精华
        public static final  String DOMESTIC_HOT = "http://a.meidebi.com/new.php/Share-allhotlist?version=3.2.3&devicetoken=352284040670808&limit=20&p=0&type=guo&devicetype=2" ;
        //最新
        public static final  String DOMESTIC_NEWEST = "http://a.meidebi.com/new.php/Share-alllist?version=3.2.3&devicetoken=352284040670808&limit=20&p=0&type=guo&devicetype=2";
        //列表详情：同3.1
    }


    //C.海淘精品
    public static class OVERSEA{
        //  1.列表
        // 精华
        public static final  String OVERSEA_HOT = "http://a.meidebi.com/new.php/Share-allhotlist?version=3.2.3&devicetoken=352284040670808&limit=20&p=0&type=hai&devicetype=2";
        //最新
        public  static final  String OVERSEA_NEWEST = "http://a.meidebi.com/new.php/Share-alllist?version=3.2.3&devicetoken=352284040670808&limit=20&p=0&type=hai&devicetype=2";
        // 列表详情：同3.1
    }


    //D.天猫折扣
    public static class TMALL{
        //1.列表
        //精华
        public static final  String TMALL_HOT = "http://a.meidebi.com/new.php/Share-allhotlist?version=3.2.3&devicetoken=352284040670808&limit=20&p=0&type=tian&devicetype=2";
        //最新：
        public static final  String TMALL_NEWEST = "http://a.meidebi.com/new.php/Share-alllist?version=3.2.3&devicetoken=352284040670808&limit=20&p=0&type=tian&devicetype=2";
        //列表详情：同3.1
    }

    public static class CONVERSION{
        //兑换接口
        public static final String CONVERSION_LIST = "http://a.meidebi.com/new.php/Share-quanlist?version=3.2.3&devicetoken=352284040670808&devicetype=2";

        //详情接口:
        public static final String CONVERSION_DETAIL = "http://a.meidebi.com/new.php/Share-onecoupon?version=3.2.3&devicetoken=352284040670808&id=1919&devicetype=2";
        //id=兑换接口中的id

    }

    public static class SHOW{
        //精华
        public static final String SHOW_HOT = "http://a.meidebi.com/new.php/Share-showdanlist?version=3.2.3&devicetoken=352284040670808&p=0&devicetype=2&hot=1";
        //最新
        public static final String SHOW_NEW = "http://a.meidebi.com/new.php/Share-showdanlist?version=3.2.3&devicetoken=352284040670808&p=0&devicetype=2&hot=0";

        public static final String SHOW_DETAIL = "http://a.meidebi.com/new.php/Share-onelink?type=1&id=20401&devicetype=2&version=3.2.3";
    }

    public static class MIME{

        public static final String APP_RECOMMEND = "http://a.meidebi.com/new.php/Resources-apprecommend?version=3.2.3&devicetoken=352284040670808&devicetype=2";

        public static final String MY_EXPLODE = "http://a.meidebi.com/new.php/Customer-mylink.html?pagecount=20&page=1&devicetoken=357107070610953&version=3.2.3&devicetype=2&userkey=d92887238ffa32dbe4c69c4678e3df239b33783e4cc6e9effeb215f4774a13a4959d04bf5d";

        public static final String MY_MESSAGE = "http://a.meidebi.com/new.php/Customer-mymessage?p=1&devicetoken=357107070610953&version=3.2.3&devicetype=2&userkey=d177913ed2d2d47120e46b7581d20c8c1243df1b293777d8ec58b7fa3ae8f6c7f021cb9704";

        public static final String MY_CONVERSION_USEABLE = "http://a.meidebi.com/new.php/Customer-mycoupon.html?istimeout=0&limit=20&page=1&devicetoken=357107070610953&version=3.2.3&devicetype=2&userkey=d177913ed2d2d47120e46b7581d20c8c1243df1b293777d8ec58b7fa3ae8f6c7f021cb9704";

        public static final String MY_COMMENT = "http://a.meidebi.com/new.php/Customer-comment.html?p=1&limit=15&type=1&devicetoken=357107070610953&version=3.2.3&devicetype=2&userkey=d177913ed2d2d47120e46b7581d20c8c1243df1b293777d8ec58b7fa3ae8f6c7f021cb9704";

        public static final String MY_COLLECT_FAVO = "http://a.meidebi.com/new.php/Customer-usercenter?ftype=1&limit=15&page=1&type=4&devicetoken=357107070610953&version=3.2.3&devicetype=2&userkey=d177913ed2d2d47120e46b7581d20c8c1243df1b293777d8ec58b7fa3ae8f6c7f021cb9704";

        public static final String MY_COLLECT_SHOW = "http://a.meidebi.com/new.php/Customer-usercenter?ftype=4&limit=15&page=1&type=4&devicetoken=357107070610953&version=3.2.3&devicetype=2&userkey=d177913ed2d2d47120e46b7581d20c8c1243df1b293777d8ec58b7fa3ae8f6c7f021cb9704";

        public static final String MY_COLLECT_CONVERSION = "http://a.meidebi.com/new.php/Customer-usercenter?ftype=5&limit=15&page=1&type=4&devicetoken=357107070610953&version=3.2.3&devicetype=2&userkey=d177913ed2d2d47120e46b7581d20c8c1243df1b293777d8ec58b7fa3ae8f6c7f021cb9704";

        public static final String MY_SHOW_DONE = "http://a.meidebi.com/new.php/Customer-myshoppingexp.html?pagecount=20&page=1&devicetoken=357107070610953&version=3.2.3&devicetype=2&userkey=d177913ed2d2d47120e46b7581d20c8c1243df1b293777d8ec58b7fa3ae8f6c7f021cb9704";
    }

    public static class EXPLODE{
        //爆料详情页面
        public static final String EXPLODE_DETAIL = "http://a.meidebi.com/new.php/Share-getshareinfo?devicetype=2&version=3.2.3&url=http%3A%2F%2Fitem.m.jd.com%2Fproduct%2F10623992360.html%3Fsid%3D136e1480e44416179fa1214f9deb1f49&userkey=d177913ed2d2d47120e46b7581d20c8c1243df1b293777d8ec58b7fa3ae8f6c7f021cb9704";

        //爆料详情页面的商品分类地址
        public static final String EXPLODE_DETAIL_GOOD_CLASS = "http://a.meidebi.com/new.php/Share-getcatetree?devicetype=2&version=3.2.3";

    }

}
