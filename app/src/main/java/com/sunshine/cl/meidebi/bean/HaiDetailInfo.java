package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public class HaiDetailInfo {

    /**
     * activeprice : ￥36.11
     * siteid : 61
     * coinsign : $
     * id : 1391401
     * commentcount : 2
     * votesm : 0
     * votesp : 11
     * directmailmoney :
     * createtime : 1476864854
     * transfermoney : 18.00
     * directratiomoney :
     * category : 27
     * title : Calvin Klein End On End Dobby 男童衬衫
     * fcategory : 2
     * sethottime : 1476865536
     * userid : 13461806
     * linktype : 1
     * proprice : ￥36.11
     * lowpricetype : 0
     * orginprice : ￥266.62
     * cpsurl :
     * orginprice_change : 263.46
     * activeprice_change : 35.68
     * hpostage : 0
     * image : http://p.mdbimg.com/share_201610_58072b597884feczxnm.jpg-dpdisplay1
     * setagthottime : 1476865536
     * isabroad : 1
     * nickname : 欧阳
     * photo : http://avatar.mdbimg.com/013/46/18/06_avatar_small.jpg?t=2
     * sitename : 美国亚马逊
     * whorsubsites : null
     * directtariff : 0
     * remoteimage : http://p.mdbimg.com/share_201610_58072b597884feczxnm.jpg-dpdisplay1
     * freight : $0.00
     * price : ￥36.11
     * aprice : $5.35
     * aproprice : $5.35
     * aorginprice : $39.50
     * aactiveprice : $5.35
     * contry : {"id":"1","name":"美国","nameshort":"USA","allnameshort":"a:5:{i:0;s:2:\"us\";i:1;s:3:\"usa\";i:2;s:5:\"urban\";i:3;s:3:\"www\";i:4;s:5:\"en_us\";}","icon":"http://p.meidebi.com/contry_201507_559c935429cbdyzscqv.png"}
     * postage : $-1.00
     * transitcompany : {"id":"1","name":"转运四方【IPS】","host":"transrush.com","firstpin":"Z","ismain":"1","createtime":"1457015524"}
     * payment : [{"id":"3","name":"Amazon Payment","createtime":"1377167207"},{"id":"5","name":"银联人民币信用卡","createtime":"1385106211"},{"id":"6","name":"双币信用卡","createtime":"1385106246"}]
     * totalmoney_dec : 凑单到手 约￥53.68
     * appactivelink : null
     * appactiveimage : null
     * description : /Content-linkdesc-linkid-1391401-isWiFi-1.html
     * otherprice : /Content-otherprice-linkid-1391401.html
     * haitaoarticle : /Content-article-linkid-1391401.html?from=app
     * outurl : http://a.meidebi.com/new.php/Share-tolink.html?id=1391401
     * favnum : 0
     * type : 2
     * userReviewsData : {"commentnum":"2","commentlist":[{"id":"1458567","fromid":"1391401","referto":"0","type":"1","comment":"倒退20年，我也能穿[:default_左哼哼]","content":"倒退20年，我也能穿[:default_左哼哼]","createtime":"1476865597","userid":"13794320","touserid":"0","headphoto":"http://avatar.mdbimg.com/noavatar_middle.jpg","nickname":"LJ123","tonickname":"匿名"},{"id":"1458560","fromid":"1391401","referto":"0","type":"1","comment":"适合初中生吧，也算大童？","content":"适合初中生吧，也算大童？","createtime":"1476865078","userid":"13795290","touserid":"0","headphoto":"http://avatar.mdbimg.com/noavatar_middle.jpg","nickname":"Deep、 深爱","tonickname":"匿名"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String commentcount;
        private String votesm;
        private String votesp;
        private String createtime;
        private String title;
        private String orginprice;
        private String image;
        private int isabroad;
        private String setagthottime;
        private String nickname;
        private String photo;
        private String sitename;
        private String price;
        private String aactiveprice;
        private String postage;
        /**
         * id : 1
         * name : 转运四方【IPS】
         * host : transrush.com
         * firstpin : Z
         * ismain : 1
         * createtime : 1457015524
         */

        private TransitcompanyBean transitcompany;
        private String totalmoney_dec;
        private String description;
        private String otherprice;
        private String haitaoarticle;
        private String outurl;
        /**
         * commentnum : 2
         * commentlist : [{"id":"1458567","fromid":"1391401","referto":"0","type":"1","comment":"倒退20年，我也能穿[:default_左哼哼]","content":"倒退20年，我也能穿[:default_左哼哼]","createtime":"1476865597","userid":"13794320","touserid":"0","headphoto":"http://avatar.mdbimg.com/noavatar_middle.jpg","nickname":"LJ123","tonickname":"匿名"},{"id":"1458560","fromid":"1391401","referto":"0","type":"1","comment":"适合初中生吧，也算大童？","content":"适合初中生吧，也算大童？","createtime":"1476865078","userid":"13795290","touserid":"0","headphoto":"http://avatar.mdbimg.com/noavatar_middle.jpg","nickname":"Deep、 深爱","tonickname":"匿名"}]
         */

        private UserReviewsDataBean userReviewsData;
        private List<String> whorsubsites;

        public List<String> getWhorsubsites() {
            return whorsubsites;
        }

        public void setWhorsubsites(List<String> whorsubsites) {
            this.whorsubsites = whorsubsites;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getIsabroad() {
            return isabroad;
        }

        public void setIsabroad(int isabroad) {
            this.isabroad = isabroad;
        }

        public String getCommentcount() {
            return commentcount;
        }

        public void setCommentcount(String commentcount) {
            this.commentcount = commentcount;
        }

        public String getVotesm() {
            return votesm;
        }

        public void setVotesm(String votesm) {
            this.votesm = votesm;
        }

        public String getVotesp() {
            return votesp;
        }

        public void setVotesp(String votesp) {
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

        public String getOrginprice() {
            return orginprice;
        }

        public void setOrginprice(String orginprice) {
            this.orginprice = orginprice;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getSetagthottime() {
            return setagthottime;
        }

        public void setSetagthottime(String setagthottime) {
            this.setagthottime = setagthottime;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
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

        public String getAactiveprice() {
            return aactiveprice;
        }

        public void setAactiveprice(String aactiveprice) {
            this.aactiveprice = aactiveprice;
        }

        public String getPostage() {
            return postage;
        }

        public void setPostage(String postage) {
            this.postage = postage;
        }

        public TransitcompanyBean getTransitcompany() {
            return transitcompany;
        }

        public void setTransitcompany(TransitcompanyBean transitcompany) {
            this.transitcompany = transitcompany;
        }

        public String getTotalmoney_dec() {
            return totalmoney_dec;
        }

        public void setTotalmoney_dec(String totalmoney_dec) {
            this.totalmoney_dec = totalmoney_dec;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getOtherprice() {
            return otherprice;
        }

        public void setOtherprice(String otherprice) {
            this.otherprice = otherprice;
        }

        public String getHaitaoarticle() {
            return haitaoarticle;
        }

        public void setHaitaoarticle(String haitaoarticle) {
            this.haitaoarticle = haitaoarticle;
        }

        public String getOuturl() {
            return outurl;
        }

        public void setOuturl(String outurl) {
            this.outurl = outurl;
        }

        public UserReviewsDataBean getUserReviewsData() {
            return userReviewsData;
        }

        public void setUserReviewsData(UserReviewsDataBean userReviewsData) {
            this.userReviewsData = userReviewsData;
        }

        public static class TransitcompanyBean {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class UserReviewsDataBean {
            /**
             * id : 1458567
             * fromid : 1391401
             * referto : 0
             * type : 1
             * comment : 倒退20年，我也能穿[:default_左哼哼]
             * content : 倒退20年，我也能穿[:default_左哼哼]
             * createtime : 1476865597
             * userid : 13794320
             * touserid : 0
             * headphoto : http://avatar.mdbimg.com/noavatar_middle.jpg
             * nickname : LJ123
             * tonickname : 匿名
             */

            private List<CommentlistBean> commentlist;

            public List<CommentlistBean> getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(List<CommentlistBean> commentlist) {
                this.commentlist = commentlist;
            }

            public static class CommentlistBean {
                private String comment;
                private String createtime;
                private String headphoto;
                private String nickname;

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

                public String getHeadphoto() {
                    return headphoto;
                }

                public void setHeadphoto(String headphoto) {
                    this.headphoto = headphoto;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }
            }
        }
    }
}
