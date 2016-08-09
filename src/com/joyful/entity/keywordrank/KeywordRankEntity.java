package com.joyful.entity.keywordrank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import com.joyful.entity.base.BaseEntity;

public class KeywordRankEntity extends BaseEntity{
	private String id;			//id
	private String keyword;		//关键字
	private String extensionUnit;	//推广单元
	private String extensionPlan;	//推广计划
	private Date sendDate; 	//日期
	private BigDecimal showQuantity;	//展现量
	private BigDecimal clickQuantity;	//点击量
	private BigDecimal consumeQuantity;	//消费
	private String clickRate;	//点击率
	private BigDecimal clickAveragePrice;	//平均点击价格
	private String type;	//类型（百度，神马）
	private String account;	//账户（神马导入数据专用）
	private BigDecimal webPageConversion;	//网页转化（百度数据专用）
	private BigDecimal merchantBridgeConversion;	//商桥转化（百度数据专用）
	private BigDecimal telephoneConversion;	//电话转化（百度数据专用）
	private BigDecimal averageOrder;	//平均排名（百度数据专用）
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getExtensionUnit() {
        return extensionUnit;
    }

    public void setExtensionUnit(String extensionUnit) {
        this.extensionUnit = extensionUnit == null ? null : extensionUnit.trim();
    }

    public String getExtensionPlan() {
        return extensionPlan;
    }

    public void setExtensionPlan(String extensionPlan) {
        this.extensionPlan = extensionPlan == null ? null : extensionPlan.trim();
    }

    public BigDecimal getShowQuantity() {
    	if(showQuantity != null)
    		return showQuantity.setScale(5, RoundingMode.HALF_UP);
    	else 
    		return showQuantity;
    }

    public void setShowQuantity(BigDecimal showQuantity) {
        this.showQuantity = showQuantity;
    }

    public BigDecimal getClickQuantity() {
    	if(clickQuantity != null)
    		return clickQuantity.setScale(5, RoundingMode.HALF_UP);
    	else
    		return clickQuantity;
    }

    public void setClickQuantity(BigDecimal clickQuantity) {
        this.clickQuantity = clickQuantity;
    }

    public BigDecimal getConsumeQuantity() {
    	if(consumeQuantity != null)
    		return consumeQuantity.setScale(5, RoundingMode.HALF_UP);
    	else 
    		return consumeQuantity;
    }

    public void setConsumeQuantity(BigDecimal consumeQuantity) {
        this.consumeQuantity = consumeQuantity;
    }

    public String getClickRate() {
        return clickRate;
    }

    public void setClickRate(String clickRate) {
        this.clickRate = clickRate;
    }

    public BigDecimal getClickAveragePrice() {
    	if(clickAveragePrice != null)
    		return clickAveragePrice.setScale(5, RoundingMode.HALF_UP);
    	else 
    		return clickAveragePrice;
    }

    public void setClickAveragePrice(BigDecimal clickAveragePrice) {
        this.clickAveragePrice = clickAveragePrice;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public BigDecimal getWebPageConversion() {
        return webPageConversion;
    }

    public void setWebPageConversion(BigDecimal webPageConversion) {
        this.webPageConversion = webPageConversion;
    }

    public BigDecimal getMerchantBridgeConversion() {
        return merchantBridgeConversion;
    }

    public void setMerchantBridgeConversion(BigDecimal merchantBridgeConversion) {
        this.merchantBridgeConversion = merchantBridgeConversion;
    }

    public BigDecimal getTelephoneConversion() {
        return telephoneConversion;
    }

    public void setTelephoneConversion(BigDecimal telephoneConversion) {
        this.telephoneConversion = telephoneConversion;
    }

    public BigDecimal getAverageOrder() {
        return averageOrder;
    }

    public void setAverageOrder(BigDecimal averageOrder) {
        this.averageOrder = averageOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
	
}
