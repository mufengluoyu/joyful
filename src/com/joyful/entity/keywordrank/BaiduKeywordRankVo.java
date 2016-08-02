package com.joyful.entity.keywordrank;

import java.util.Date;

import com.joyful.common.util.excel.annotation.ExcelField;

/**
 * 百度数据导入模板的数据
 * @author hechangzhi	2016年8月1日11:08:31
 *
 */
public class BaiduKeywordRankVo {
	private String keyword;		//关键字
	private String extensionUnit;	//推广单元
	private String extensionPlan;	//推广计划
	private Date sendDate; 	//日期
	private String showQuantity;	//展现量
	private String clickQuantity;	//点击量
	private String consumeQuantity;	//消费
	private String clickRate;	//点击率
	private String clickAveragePrice;	//平均点击价格
	private String webPageConversion;	//网页转化（百度数据专用）
	private String merchantBridgeConversion;	//商桥转化（百度数据专用）
	private String telephoneConversion;	//电话转化（百度数据专用）
	private String averageOrder;	//平均排名（百度数据专用）

	@ExcelField(title="日期", align=2, sort=10)
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
    @ExcelField(title="关键词", align=2, sort=20)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
    @ExcelField(title="推广单元", align=2, sort=30)
    public String getExtensionUnit() {
        return extensionUnit;
    }

    public void setExtensionUnit(String extensionUnit) {
        this.extensionUnit = extensionUnit == null ? null : extensionUnit.trim();
    }
    @ExcelField(title="推广计划", align=2, sort=40)
    public String getExtensionPlan() {
        return extensionPlan;
    }

    public void setExtensionPlan(String extensionPlan) {
        this.extensionPlan = extensionPlan == null ? null : extensionPlan.trim();
    }
    @ExcelField(title="展现", align=2, sort=50)
    public String getShowQuantity() {
        return showQuantity;
    }

    public void setShowQuantity(String showQuantity) {
        this.showQuantity = showQuantity;
    }
    @ExcelField(title="点击", align=2, sort=60)
    public String getClickQuantity() {
        return clickQuantity;
    }

    public void setClickQuantity(String clickQuantity) {
        this.clickQuantity = clickQuantity;
    }
    @ExcelField(title="消费", align=2, sort=70)
    public String getConsumeQuantity() {
        return consumeQuantity;
    }

    public void setConsumeQuantity(String consumeQuantity) {
        this.consumeQuantity = consumeQuantity;
    }
    @ExcelField(title="点击率", align=2, sort=80)
    public String getClickRate() {
        return clickRate;
    }

    public void setClickRate(String clickRate) {
        this.clickRate = clickRate;
    }
    @ExcelField(title="平均点击价格", align=2, sort=90)
    public String getClickAveragePrice() {
        return clickAveragePrice;
    }

    public void setClickAveragePrice(String clickAveragePrice) {
        this.clickAveragePrice = clickAveragePrice;
    }
    @ExcelField(title="网页转化", align=2, sort=100)
    public String getWebPageConversion() {
        return webPageConversion;
    }

    public void setWebPageConversion(String webPageConversion) {
        this.webPageConversion = webPageConversion;
    }
    @ExcelField(title="商桥转化", align=2, sort=110)
    public String getMerchantBridgeConversion() {
        return merchantBridgeConversion;
    }

    public void setMerchantBridgeConversion(String merchantBridgeConversion) {
        this.merchantBridgeConversion = merchantBridgeConversion;
    }
    @ExcelField(title="电话转化", align=2, sort=120)
    public String getTelephoneConversion() {
        return telephoneConversion;
    }

    public void setTelephoneConversion(String telephoneConversion) {
        this.telephoneConversion = telephoneConversion;
    }
    @ExcelField(title="平均排名", align=2, sort=130)
    public String getAverageOrder() {
        return averageOrder;
    }

    public void setAverageOrder(String averageOrder) {
        this.averageOrder = averageOrder;
    }
	
}
