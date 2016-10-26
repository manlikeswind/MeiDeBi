package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class MyConversionUseableInfo {

    /**
     * id : 1919
     * mallid : 1033
     * card : gtwdvzittw
     * pass :
     * couponid : 1919
     * saled : 1
     * saleuserid : 1
     * buyuserid : 13798066
     * salejiluid : 91626
     * saletime : 1477276920
     * createtime : 1476430544
     * ctype : 1
     * userid : 1
     * title : 考拉海购新用户满499减50优惠券
     * man : 499
     * jian : 50
     * copper : 2
     * getstart : 0
     * getend : 1477929540
     * usestart : 1476430544
     * useend : 1477929540
     * isbindaccount : 0
     * limitnewuser : 0
     * allgoods : 0
     * zhuanchang :
     * daixiadan : 0
     * couponcount : 402
     * saledcount : 57
     * tags :
     * description :
     <p style="margin-bottom:0px;">
     1、登陆考拉海购官网成功后，点击<strong><span style="color:#FF0000;">个人中心—&gt;我的优惠券—&gt;兑换优惠码—&gt;输入券码</span></strong>兑换红包；
     </p>
     <p style="margin-bottom:0px;">
     2、兑换成功后<strong><span style="color:#FF0000;">3天</span></strong>内有效；每个账户仅限使用1张；
     </p>
     <p style="margin-bottom:0px;">
     3、优惠券仅限购买实物类的商品使用，<strong><span style="color:#F54E54;">仅限新用户使用</span></strong>，<strong>部分母婴类特殊商品无法使用</strong>，请以商品页为准；
     </p>
     <p style="margin-bottom:0px;">
     4、每笔订单仅限使用一张优惠券，优惠券不可合并；
     </p>
     <p style="margin-bottom:0px;">
     5、若使用优惠券的订单发生退货行为，如果是直接抵扣类现金券，则根据商品金额比例退还相应的现金券，如果是满额扣减类优惠券，则优惠券不予返还。
     </p>





     * hit : 0
     * commentcount : 0
     * timeout : 0
     * status : 1
     * ishot : 0
     * jubao : 0
     * buylevel : 0
     * dayaccountlimit : 1
     * dayiplimit : 1
     * type : 1
     * imgUrl : http://p.mdbimg.com/site_201602_56c2ee759617fnemyki.jpg
     * host : kaola.com
     * siteurl : http://cps.kaola.com/cps/login?unionId=3479711075&uid=&trackingCode=&targetUrl=http://www.kaola.com
     * salenickname : admin
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String card;
        private String title;
        private String usestart;
        private String useend;
        private String imgUrl;

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUsestart() {
            return usestart;
        }

        public void setUsestart(String usestart) {
            this.usestart = usestart;
        }

        public String getUseend() {
            return useend;
        }

        public void setUseend(String useend) {
            this.useend = useend;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
