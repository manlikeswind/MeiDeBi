package com.sunshine.cl.meidebi.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class DialogInfo {

    /**
     * data : [{"id":"1","name":"3C数码","value":[{"id":"95","name":"电脑整机"},{"id":"7","name":"电脑硬件"},{"id":"21","name":"外设网络"},{"id":"8","name":"手机"},{"id":"9","name":"平板电脑"},{"id":"23","name":"数码配件"},{"id":"10","name":"数码摄像"},{"id":"96","name":"智能穿戴"}]},{"id":"3","name":"家用电器","value":[{"id":"31","name":"厨卫电器"},{"id":"33","name":"大家电"},{"id":"34","name":"生活电器"},{"id":"77","name":"影音设备"},{"id":"97","name":"个护健康"}]},{"id":"2","name":"服饰箱包","value":[{"id":"24","name":"女装"},{"id":"25","name":"男装"},{"id":"27","name":"童装"},{"id":"26","name":"内衣家居服"},{"id":"98","name":"男鞋"},{"id":"28","name":"女鞋"},{"id":"130","name":"童鞋"},{"id":"30","name":"服装配饰"},{"id":"99","name":"珠宝配饰"},{"id":"100","name":"潮流女包"},{"id":"101","name":"精品男包"},{"id":"29","name":"功能箱包"}]},{"id":"53","name":"运动户外","value":[{"id":"92","name":"户外服饰"},{"id":"102","name":"户外鞋袜"},{"id":"103","name":"运动服饰"},{"id":"62","name":"户外装备"},{"id":"104","name":"运动鞋袜"},{"id":"105","name":"体育项目"}]},{"id":"4","name":"日用百货","value":[{"id":"106","name":"生活日用品"},{"id":"38","name":"厨房用具"},{"id":"107","name":"清洁用品"},{"id":"89","name":"宠物用品"},{"id":"36","name":"成人用品"}]},{"id":"5","name":"家居家装","value":[{"id":"43","name":"住宅家具"},{"id":"108","name":"家装软饰"},{"id":"85","name":"五金建材"},{"id":"39","name":"实用工具"},{"id":"109","name":"灯具"},{"id":"37","name":"家纺布艺"},{"id":"110","name":"园艺"}]},{"id":"52","name":"食品保健","value":[{"id":"60","name":"零食特产"},{"id":"58","name":"酒水饮料"},{"id":"111","name":"茗茶冲调"},{"id":"59","name":"保健品"},{"id":"61","name":"粮油调味"},{"id":"112","name":"生鲜食品"}]},{"id":"48","name":"个护化妆","value":[{"id":"49","name":"彩妆香水"},{"id":"51","name":"面部护肤"},{"id":"50","name":"美发护发"},{"id":"35","name":"身体护肤"},{"id":"79","name":"口腔护理"},{"id":"78","name":"生理卫生"},{"id":"113","name":"眼睛护理"}]},{"id":"6","name":"母婴玩具","value":[{"id":"44","name":"奶粉"},{"id":"46","name":"营养辅食"},{"id":"115","name":"尿裤湿巾"},{"id":"116","name":"婴儿洗护"},{"id":"117","name":"喂养用品"},{"id":"118","name":"童车童床"},{"id":"119","name":"安全座椅"},{"id":"94","name":"孕妇用品"},{"id":"86","name":"孕妇服装"},{"id":"47","name":"玩具模型"}]},{"id":"55","name":"钟表镜饰","value":[{"id":"69","name":"珠宝首饰"},{"id":"70","name":"挂钟手表"},{"id":"84","name":"精品眼镜"},{"id":"120","name":"其他奢侈品"}]},{"id":"121","name":"办公文具","value":[{"id":"87","name":"办公设备"},{"id":"88","name":"办公耗材"},{"id":"122","name":"文具用品"}]},{"id":"56","name":"汽车用品","value":[{"id":"123","name":"汽车整车"},{"id":"72","name":"养护耗材"},{"id":"124","name":"汽车装饰"},{"id":"125","name":"美容清洗"},{"id":"126","name":"车载设备"},{"id":"71","name":"配件工具"},{"id":"127","name":"保养服务"}]},{"id":"54","name":"文化产物","value":[{"id":"65","name":"图书"},{"id":"68","name":"音像制品"},{"id":"67","name":"电子书刊"},{"id":"82","name":"游戏软件"},{"id":"66","name":"报纸杂志"},{"id":"83","name":"APP"}]},{"id":"57","name":"其它","value":[{"id":"73","name":"信用卡"},{"id":"128","name":"旅游产品"},{"id":"90","name":"机票酒店"},{"id":"93","name":"鲜花礼品"},{"id":"129","name":"充值票务"},{"id":"74","name":"本地生活"},{"id":"91","name":"其它"}]}]
     * info : GET_DATA_SUCCESS
     * status : 1
     */

    private String info;
    private int status;
    /**
     * id : 1
     * name : 3C数码
     * value : [{"id":"95","name":"电脑整机"},{"id":"7","name":"电脑硬件"},{"id":"21","name":"外设网络"},{"id":"8","name":"手机"},{"id":"9","name":"平板电脑"},{"id":"23","name":"数码配件"},{"id":"10","name":"数码摄像"},{"id":"96","name":"智能穿戴"}]
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
        private String name;
        /**
         * id : 95
         * name : 电脑整机
         */

        private List<ValueBean> value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ValueBean> getValue() {
            return value;
        }

        public void setValue(List<ValueBean> value) {
            this.value = value;
        }

        public static class ValueBean {
            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
