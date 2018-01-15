package com.cmcc.lib_network.model;

import java.util.List;

/**
 * <p>DESCRIBE</p><br>
 *
 * @author lwc
 * @date 2017/12/15 1:20
 * @note -
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class JfShiTiModel extends ResultModel {
    
    /**
     * info : {"id":1,"title":"贾汪区纪检监察巡察家访问卷配偶\n","dannums":12,"duonums":0,"wendannums":1,"create_time":1513247848,"pic":null,"typeid":96,"danxuan":[{"id":9,"typeid":96,"title":"您对纪委家访的态度\n","daan":"A、欢迎 |B、不欢迎 |C、无所谓|D、其他\n","sort":0,"catid":98,"danan":["A、欢迎 ","B、不欢迎 ","C、无所谓","D、其他\n"]},{"id":10,"typeid":96,"title":"您希望区纪委何时开展家访\n","daan":"A、中秋、过年期间|B、常规节日期间|C、无所谓 |D、其他\n","sort":0,"catid":98,"danan":["A、中秋、过年期间","B、常规节日期间","C、无所谓 ","D、其他\n"]},{"id":11,"typeid":96,"title":"您希望区纪委开展家访的周期是多久\n","daan":"A、一季度 |B、半年 |C、一年|D、其他\n","sort":0,"catid":98,"danan":["A、一季度 ","B、半年 ","C、一年","D、其他\n"]},{"id":12,"typeid":96,"title":"您希望的家访方式是\n","daan":"A、入户家访 |B、电话家访| C、网上家访 |D、其他\n","sort":0,"catid":98,"danan":["A、入户家访 ","B、电话家访"," C、网上家访 ","D、其他\n"]},{"id":13,"typeid":96,"title":"工作日您配偶晚上一般到家时间是几点？\n","daan":"A、6点之前 |B、6点\u2014\u20147点|C、7点\u2014\u20148点 |D、8点之后\n","sort":0,"catid":98,"danan":["A、6点之前 ","B、6点\u2014\u20147点","C、7点\u2014\u20148点 ","D、8点之后\n"]},{"id":14,"typeid":96,"title":"您配偶每月参加几次聚餐（家庭聚餐除外）\n","daan":"A、0\u2014\u20142次 |B、3\u2014\u20144次 |C、5\u2014\u20146次 |D、7次及以上\n","sort":0,"catid":98,"danan":["A、0\u2014\u20142次 ","B、3\u2014\u20144次 ","C、5\u2014\u20146次 ","D、7次及以上\n"]},{"id":15,"typeid":96,"title":"您配偶到家后会继续工作多长时间","daan":"A、半小时以内|B、半小时\u2014\u20141小时 |C、1小时到2小时|D、2小时以上\n","sort":0,"catid":98,"danan":["A、半小时以内","B、半小时\u2014\u20141小时 ","C、1小时到2小时","D、2小时以上\n"]},{"id":16,"typeid":96,"title":"您的家庭目前存在的问题（没有可以不填）\n","daan":"A、家庭经济困难 |B、工作较忙难以顾及家庭  |C、夫妻沟通不畅 |D、其他\n","sort":0,"catid":98,"danan":["A、家庭经济困难 ","B、工作较忙难以顾及家庭  ","C、夫妻沟通不畅 ","D、其他\n"]},{"id":17,"typeid":96,"title":"家庭成员之间的相处关系","daan":"A、非常融洽|B、一般和睦 |C、不太融洽\n","sort":0,"catid":98,"danan":["A、非常融洽","B、一般和睦 ","C、不太融洽\n"]},{"id":18,"typeid":96,"title":"您了解您爱人在单位的情况吗","daan":"A、十分了解 |B、基本了解 |C、了解一些|D基本不了解\n","sort":0,"catid":98,"danan":["A、十分了解 ","B、基本了解 ","C、了解一些","D基本不了解\n"]},{"id":19,"typeid":96,"title":"您了解您爱人在单位情况的主要途径是","daan":"A、从爱人本人处了解 |B、与其领导沟通 |C、从其同事处了解 |D、其他\n","sort":0,"catid":98,"danan":["A、从爱人本人处了解 ","B、与其领导沟通 ","C、从其同事处了解 ","D、其他\n"]},{"id":20,"typeid":96,"title":"您希望您爱人以后从事工作","daan":"A、继续从事纪检工作 |B、从事其他单位工作| C、其他\n","sort":0,"catid":98,"danan":["A、继续从事纪检工作 ","B、从事其他单位工作"," C、其他\n"]}],"wenda":[{"id":21,"typeid":96,"title":"其他意见建议","daan":null,"sort":0,"catid":100}]}
     */
    
    public ShiTiInfoBean info;
    
    public static class ShiTiInfoBean {
        /**
         * id : 1
         * title : 贾汪区纪检监察巡察家访问卷配偶
         * <p>
         * dannums : 12
         * duonums : 0
         * wendannums : 1
         * create_time : 1513247848
         * pic : null
         * typeid : 96
         * danxuan : [{"id":9,"typeid":96,"title":"您对纪委家访的态度\n","daan":"A、欢迎 |B、不欢迎 |C、无所谓|D、其他\n","sort":0,"catid":98,"danan":["A、欢迎 ","B、不欢迎 ","C、无所谓","D、其他\n"]},{"id":10,"typeid":96,"title":"您希望区纪委何时开展家访\n","daan":"A、中秋、过年期间|B、常规节日期间|C、无所谓 |D、其他\n","sort":0,"catid":98,"danan":["A、中秋、过年期间","B、常规节日期间","C、无所谓 ","D、其他\n"]},{"id":11,"typeid":96,"title":"您希望区纪委开展家访的周期是多久\n","daan":"A、一季度 |B、半年 |C、一年|D、其他\n","sort":0,"catid":98,"danan":["A、一季度 ","B、半年 ","C、一年","D、其他\n"]},{"id":12,"typeid":96,"title":"您希望的家访方式是\n","daan":"A、入户家访 |B、电话家访| C、网上家访 |D、其他\n","sort":0,"catid":98,"danan":["A、入户家访 ","B、电话家访"," C、网上家访 ","D、其他\n"]},{"id":13,"typeid":96,"title":"工作日您配偶晚上一般到家时间是几点？\n","daan":"A、6点之前 |B、6点\u2014\u20147点|C、7点\u2014\u20148点 |D、8点之后\n","sort":0,"catid":98,"danan":["A、6点之前 ","B、6点\u2014\u20147点","C、7点\u2014\u20148点 ","D、8点之后\n"]},{"id":14,"typeid":96,"title":"您配偶每月参加几次聚餐（家庭聚餐除外）\n","daan":"A、0\u2014\u20142次 |B、3\u2014\u20144次 |C、5\u2014\u20146次 |D、7次及以上\n","sort":0,"catid":98,"danan":["A、0\u2014\u20142次 ","B、3\u2014\u20144次 ","C、5\u2014\u20146次 ","D、7次及以上\n"]},{"id":15,"typeid":96,"title":"您配偶到家后会继续工作多长时间","daan":"A、半小时以内|B、半小时\u2014\u20141小时 |C、1小时到2小时|D、2小时以上\n","sort":0,"catid":98,"danan":["A、半小时以内","B、半小时\u2014\u20141小时 ","C、1小时到2小时","D、2小时以上\n"]},{"id":16,"typeid":96,"title":"您的家庭目前存在的问题（没有可以不填）\n","daan":"A、家庭经济困难 |B、工作较忙难以顾及家庭  |C、夫妻沟通不畅 |D、其他\n","sort":0,"catid":98,"danan":["A、家庭经济困难 ","B、工作较忙难以顾及家庭  ","C、夫妻沟通不畅 ","D、其他\n"]},{"id":17,"typeid":96,"title":"家庭成员之间的相处关系","daan":"A、非常融洽|B、一般和睦 |C、不太融洽\n","sort":0,"catid":98,"danan":["A、非常融洽","B、一般和睦 ","C、不太融洽\n"]},{"id":18,"typeid":96,"title":"您了解您爱人在单位的情况吗","daan":"A、十分了解 |B、基本了解 |C、了解一些|D基本不了解\n","sort":0,"catid":98,"danan":["A、十分了解 ","B、基本了解 ","C、了解一些","D基本不了解\n"]},{"id":19,"typeid":96,"title":"您了解您爱人在单位情况的主要途径是","daan":"A、从爱人本人处了解 |B、与其领导沟通 |C、从其同事处了解 |D、其他\n","sort":0,"catid":98,"danan":["A、从爱人本人处了解 ","B、与其领导沟通 ","C、从其同事处了解 ","D、其他\n"]},{"id":20,"typeid":96,"title":"您希望您爱人以后从事工作","daan":"A、继续从事纪检工作 |B、从事其他单位工作| C、其他\n","sort":0,"catid":98,"danan":["A、继续从事纪检工作 ","B、从事其他单位工作"," C、其他\n"]}]
         * wenda : [{"id":21,"typeid":96,"title":"其他意见建议","daan":null,"sort":0,"catid":100}]
         */
        
        public String id;
        public String title;
        public String dannums;
        public String duonums;
        public String wendannums;
        public String panduannums;
        public String create_time;
        public String pic;
        public String typeid;
        public String nums;
        public List<DanxuanBean> danxuan;
        public List<DuoxuanBean> duoxuan;
        public List<WendaBean> wenda;
        public List<PanduanBean> panduan;
        public String danxuanfenshu;
        public String duoxuanfenshu;
        public String panduanfenshu;
        public String times;
        
        public static class DanxuanBean {
            /**
             * id : 9
             * typeid : 96
             * title : 您对纪委家访的态度
             * <p>
             * daan : A、欢迎 |B、不欢迎 |C、无所谓|D、其他
             * <p>
             * sort : 0
             * catid : 98
             * danan : ["A、欢迎 ","B、不欢迎 ","C、无所谓","D、其他\n"]
             */
            
            public String id;
            public String typeid;
            public String title;
            public String daan;
            public String sort;
            public String catid;
            public List<String> danan;
            public String daanjiexi;
            public String okdaan;
        }
        
        public static class DuoxuanBean {
            /**
             * id : 9
             * typeid : 96
             * title : 您对纪委家访的态度
             * <p>
             * daan : A、欢迎 |B、不欢迎 |C、无所谓|D、其他
             * <p>
             * sort : 0
             * catid : 98
             * danan : ["A、欢迎 ","B、不欢迎 ","C、无所谓","D、其他\n"]
             */
            
            public String id;
            public String typeid;
            public String title;
            public String daan;
            public String sort;
            public String catid;
            public List<String> danan;
            public String okdaan;
        }
        
        public static class WendaBean {
            /**
             * id : 21
             * typeid : 96
             * title : 其他意见建议
             * daan : null
             * sort : 0
             * catid : 100
             */
            
            public String id;
            public String typeid;
            public String title;
            public String daan;
            public String sort;
            public String catid;
            public String okdaan;
        }
        
        public static class PanduanBean {
            /**
             * id : 87
             * typeid : 104
             * title : 2012年12月5日，中共中央政治局召开会议，审议通过了中央政治局关于改进工作作风、密切联系群众的“八项规定”。
             * daan : √|×
             * sort : null
             * catid : 101
             * daanjiexi : null
             * okdaan : ×
             * create_time : 1513680326
             * danan : ["√","×"]
             */
            
            public String id;
            public String typeid;
            public String title;
            public String daan;
            public String sort;
            public String catid;
            public String daanjiexi;
            public String okdaan;
            public String create_time;
            public List<String> danan;
        }
    }
}
