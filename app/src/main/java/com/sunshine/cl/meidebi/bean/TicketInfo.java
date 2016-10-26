package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/22.
 */
public class TicketInfo {

    /**
     * data : {"linklist":[{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/510644daa7baf.gif","mallid":"5","favnum":1,"sitename":"1号店","votesp":null,"id":"1920","man":"188","title":"一号店188-15元优惠券","userid":"1","jian":"15"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":11,"sitename":"考拉海购","votesp":null,"id":"1919","man":"499","title":"考拉海购新用户满499减50优惠券","userid":"1","jian":"50"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":0,"sitename":"考拉海购","votesp":null,"id":"1918","man":"399","title":"考拉海购新用户满399减40优惠券","userid":"1","jian":"40"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":2,"sitename":"考拉海购","votesp":null,"id":"1917","man":"299","title":"考拉海购新用户满299减30优惠券","userid":"1","jian":"30"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":0,"sitename":"考拉海购","votesp":null,"id":"1916","man":"199","title":"考拉海购满199减20优惠券","userid":"1","jian":"20"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":0,"sitename":"考拉海购","votesp":null,"id":"1915","man":"99","title":"考拉海购满99减10优惠券","userid":"1","jian":"10"},{"imgUrl":"http://p.mdbimg.com/site_201603_56ea6206dd54fxkaszv.png","mallid":"176","favnum":0,"sitename":"可得眼镜","votesp":null,"id":"1912","man":"100","title":"可得网100-20框架眼镜券","userid":"1","jian":"20"},{"imgUrl":"http://p.mdbimg.com/site_201603_56ea6206dd54fxkaszv.png","mallid":"176","favnum":0,"sitename":"可得眼镜","votesp":null,"id":"1911","man":"500","title":"可得网500-50优惠券","userid":"1","jian":"50"},{"imgUrl":"http://p.mdbimg.com/site_201603_56ea6206dd54fxkaszv.png","mallid":"176","favnum":0,"sitename":"可得眼镜","votesp":null,"id":"1910","man":"200","title":"可得网200-20优惠券","userid":"1","jian":"20"},{"imgUrl":"http://p.mdbimg.com/site_201603_56ea6206dd54fxkaszv.png","mallid":"176","favnum":1,"sitename":"可得眼镜","votesp":null,"id":"1909","man":"100","title":"可得网100-8优惠券","userid":"1","jian":"8"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/5107d2d192ffe.gif","mallid":"17","favnum":0,"sitename":"新蛋中国","votesp":null,"id":"1908","man":"30","title":"新蛋网30元新客券","userid":"1","jian":"30"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/5107d2d192ffe.gif","mallid":"17","favnum":0,"sitename":"新蛋中国","votesp":null,"id":"1907","man":"150","title":"新蛋网150-15优惠券","userid":"1","jian":"15"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/541926eca70be.jpg","mallid":"846","favnum":0,"sitename":"网易","votesp":null,"id":"1906","man":"399","title":"网易严选399-60优惠券","userid":"1","jian":"60"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/541926eca70be.jpg","mallid":"846","favnum":0,"sitename":"网易","votesp":null,"id":"1905","man":"299","title":"网易严选299-50优惠券","userid":"1","jian":"50"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/541926eca70be.jpg","mallid":"846","favnum":0,"sitename":"网易","votesp":null,"id":"1904","man":"199","title":"网易严选199-30优惠券","userid":"1","jian":"30"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/541926eca70be.jpg","mallid":"846","favnum":2,"sitename":"网易","votesp":null,"id":"1903","man":"15","title":"网易严选15元新客券","userid":"1","jian":"15"},{"imgUrl":"http://p.mdbimg.com/site_201601_569da82ed9b1awsifbc.png","mallid":"214","favnum":1,"sitename":"乐视商城","votesp":null,"id":"1902","man":"2000","title":"乐视商城2000-100优惠券","userid":"1","jian":"100"},{"imgUrl":"http://p.mdbimg.com/site_201601_569da82ed9b1awsifbc.png","mallid":"214","favnum":0,"sitename":"乐视商城","votesp":null,"id":"1901","man":"1000","title":"乐视商城1000-50电视券","userid":"1","jian":"50"},{"imgUrl":"http://p.mdbimg.com/site_201601_569da82ed9b1awsifbc.png","mallid":"214","favnum":0,"sitename":"乐视商城","votesp":null,"id":"1900","man":"1000","title":"乐视商城1000-50手机券","userid":"1","jian":"50"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/5108c2f2024b0.gif","mallid":"19","favnum":0,"sitename":"聚美优品","votesp":null,"id":"1899","man":"200","title":"聚美优品200-30优惠券","userid":"1","jian":"30"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/5108c2f2024b0.gif","mallid":"19","favnum":0,"sitename":"聚美优品","votesp":null,"id":"1898","man":"150","title":"聚美优品150-20优惠券","userid":"1","jian":"20"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/51ee02dbef581.png","mallid":"181","favnum":0,"sitename":"网酒网","votesp":null,"id":"1896","man":"100","title":"网酒网100-15优惠券","userid":"1","jian":"15"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/512443930415f.gif","mallid":"52","favnum":2,"sitename":"知我药妆","votesp":null,"id":"1895","man":"300","title":"知我药妆300-45优惠券","userid":"1","jian":"45"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/512443930415f.gif","mallid":"52","favnum":1,"sitename":"知我药妆","votesp":null,"id":"1894","man":"200","title":"知我药妆200-25优惠券","userid":"1","jian":"25"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/512443930415f.gif","mallid":"52","favnum":0,"sitename":"知我药妆","votesp":null,"id":"1893","man":"100","title":"知我药妆100-10优惠券","userid":"1","jian":"10"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/511fa3e997b00.gif","mallid":"67","favnum":0,"sitename":"速普母婴商城","votesp":null,"id":"1892","man":"6","title":"速普网6元优惠券","userid":"1","jian":"6"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":3,"sitename":"考拉海购","votesp":null,"id":"1886","man":"10","title":"考拉海淘新人10元优惠券","userid":"1","jian":"10"}],"count":27}
     */
    private DataEntity data;


    public void setData(DataEntity data) {
        this.data = data;
    }

    public DataEntity getData() {
        return data;
    }


    public class DataEntity {
        /**
         * linklist : [{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/510644daa7baf.gif","mallid":"5","favnum":1,"sitename":"1号店","votesp":null,"id":"1920","man":"188","title":"一号店188-15元优惠券","userid":"1","jian":"15"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":11,"sitename":"考拉海购","votesp":null,"id":"1919","man":"499","title":"考拉海购新用户满499减50优惠券","userid":"1","jian":"50"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":0,"sitename":"考拉海购","votesp":null,"id":"1918","man":"399","title":"考拉海购新用户满399减40优惠券","userid":"1","jian":"40"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":2,"sitename":"考拉海购","votesp":null,"id":"1917","man":"299","title":"考拉海购新用户满299减30优惠券","userid":"1","jian":"30"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":0,"sitename":"考拉海购","votesp":null,"id":"1916","man":"199","title":"考拉海购满199减20优惠券","userid":"1","jian":"20"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":0,"sitename":"考拉海购","votesp":null,"id":"1915","man":"99","title":"考拉海购满99减10优惠券","userid":"1","jian":"10"},{"imgUrl":"http://p.mdbimg.com/site_201603_56ea6206dd54fxkaszv.png","mallid":"176","favnum":0,"sitename":"可得眼镜","votesp":null,"id":"1912","man":"100","title":"可得网100-20框架眼镜券","userid":"1","jian":"20"},{"imgUrl":"http://p.mdbimg.com/site_201603_56ea6206dd54fxkaszv.png","mallid":"176","favnum":0,"sitename":"可得眼镜","votesp":null,"id":"1911","man":"500","title":"可得网500-50优惠券","userid":"1","jian":"50"},{"imgUrl":"http://p.mdbimg.com/site_201603_56ea6206dd54fxkaszv.png","mallid":"176","favnum":0,"sitename":"可得眼镜","votesp":null,"id":"1910","man":"200","title":"可得网200-20优惠券","userid":"1","jian":"20"},{"imgUrl":"http://p.mdbimg.com/site_201603_56ea6206dd54fxkaszv.png","mallid":"176","favnum":1,"sitename":"可得眼镜","votesp":null,"id":"1909","man":"100","title":"可得网100-8优惠券","userid":"1","jian":"8"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/5107d2d192ffe.gif","mallid":"17","favnum":0,"sitename":"新蛋中国","votesp":null,"id":"1908","man":"30","title":"新蛋网30元新客券","userid":"1","jian":"30"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/5107d2d192ffe.gif","mallid":"17","favnum":0,"sitename":"新蛋中国","votesp":null,"id":"1907","man":"150","title":"新蛋网150-15优惠券","userid":"1","jian":"15"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/541926eca70be.jpg","mallid":"846","favnum":0,"sitename":"网易","votesp":null,"id":"1906","man":"399","title":"网易严选399-60优惠券","userid":"1","jian":"60"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/541926eca70be.jpg","mallid":"846","favnum":0,"sitename":"网易","votesp":null,"id":"1905","man":"299","title":"网易严选299-50优惠券","userid":"1","jian":"50"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/541926eca70be.jpg","mallid":"846","favnum":0,"sitename":"网易","votesp":null,"id":"1904","man":"199","title":"网易严选199-30优惠券","userid":"1","jian":"30"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/541926eca70be.jpg","mallid":"846","favnum":2,"sitename":"网易","votesp":null,"id":"1903","man":"15","title":"网易严选15元新客券","userid":"1","jian":"15"},{"imgUrl":"http://p.mdbimg.com/site_201601_569da82ed9b1awsifbc.png","mallid":"214","favnum":1,"sitename":"乐视商城","votesp":null,"id":"1902","man":"2000","title":"乐视商城2000-100优惠券","userid":"1","jian":"100"},{"imgUrl":"http://p.mdbimg.com/site_201601_569da82ed9b1awsifbc.png","mallid":"214","favnum":0,"sitename":"乐视商城","votesp":null,"id":"1901","man":"1000","title":"乐视商城1000-50电视券","userid":"1","jian":"50"},{"imgUrl":"http://p.mdbimg.com/site_201601_569da82ed9b1awsifbc.png","mallid":"214","favnum":0,"sitename":"乐视商城","votesp":null,"id":"1900","man":"1000","title":"乐视商城1000-50手机券","userid":"1","jian":"50"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/5108c2f2024b0.gif","mallid":"19","favnum":0,"sitename":"聚美优品","votesp":null,"id":"1899","man":"200","title":"聚美优品200-30优惠券","userid":"1","jian":"30"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/5108c2f2024b0.gif","mallid":"19","favnum":0,"sitename":"聚美优品","votesp":null,"id":"1898","man":"150","title":"聚美优品150-20优惠券","userid":"1","jian":"20"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/51ee02dbef581.png","mallid":"181","favnum":0,"sitename":"网酒网","votesp":null,"id":"1896","man":"100","title":"网酒网100-15优惠券","userid":"1","jian":"15"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/512443930415f.gif","mallid":"52","favnum":2,"sitename":"知我药妆","votesp":null,"id":"1895","man":"300","title":"知我药妆300-45优惠券","userid":"1","jian":"45"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/512443930415f.gif","mallid":"52","favnum":1,"sitename":"知我药妆","votesp":null,"id":"1894","man":"200","title":"知我药妆200-25优惠券","userid":"1","jian":"25"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/512443930415f.gif","mallid":"52","favnum":0,"sitename":"知我药妆","votesp":null,"id":"1893","man":"100","title":"知我药妆100-10优惠券","userid":"1","jian":"10"},{"imgUrl":"http://img.meidebi.com/mdb/mdbsitelog/511fa3e997b00.gif","mallid":"67","favnum":0,"sitename":"速普母婴商城","votesp":null,"id":"1892","man":"6","title":"速普网6元优惠券","userid":"1","jian":"6"},{"imgUrl":"http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg","mallid":"1033","favnum":3,"sitename":"考拉海购","votesp":null,"id":"1886","man":"10","title":"考拉海淘新人10元优惠券","userid":"1","jian":"10"}]
         * count : 27
         */
        private List<LinklistEntity> linklist;
        private int count;

        public void setLinklist(List<LinklistEntity> linklist) {
            this.linklist = linklist;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<LinklistEntity> getLinklist() {
            return linklist;
        }

        public int getCount() {
            return count;
        }

        public class LinklistEntity {
            /**
             * imgUrl : http://img.meidebi.com/mdb/mdbsitelog/510644daa7baf.gif
             * id : 1920
             * man : 188
             * jian : 15
             */
            private String imgUrl;
            private String id;
            private String man;
            private String jian;

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setMan(String man) {
                this.man = man;
            }


            public void setJian(String jian) {
                this.jian = jian;
            }

            public String getImgUrl() {
                return imgUrl;
            }


            public String getId() {
                return id;
            }

            public String getMan() {
                return man;
            }

            public String getJian() {
                return jian;
            }
        }
    }
}
