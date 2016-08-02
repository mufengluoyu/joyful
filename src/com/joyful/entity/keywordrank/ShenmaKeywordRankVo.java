package com.joyful.entity.keywordrank;

import java.util.Date;

import com.joyful.common.util.excel.annotation.ExcelField;
/**
 * 神马的数据导入
 * @author hechangzhi 2016年8月1日11:03:54
 *
 */
public class ShenmaKeywordRankVo {
	
	private String keyword;		//关键字
	private String extensionUnit;	//推广单元
	private String extensionPlan;	//推广计划
	private Date sendDate; 	//日期
	private String showQuantity;	//展现量
	private String clickQuantity;	//点击量
	private String consumeQuantity;	//消费
	private String clickRate;	//点击率
	private String clickAveragePrice;	//平均点击价格
	private String account;	//账户（神马导入数据专用）

	@ExcelField(title="时间", align=2, sort=20)
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
    @ExcelField(title="账户", align=2, sort=30)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
    @ExcelField(title="推广计划", align=2, sort=40)
    public String getExtensionPlan() {
        return extensionPlan;
    }

    public void setExtensionPlan(String extensionPlan) {
        this.extensionPlan = extensionPlan == null ? null : extensionPlan.trim();
    }
    @ExcelField(title="推广单元", align=2, sort=50)
    public String getExtensionUnit() {
        return extensionUnit;
    }

    public void setExtensionUnit(String extensionUnit) {
        this.extensionUnit = extensionUnit == null ? null : extensionUnit.trim();
    }
    @ExcelField(title="关键词", align=2, sort=60)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
    @ExcelField(title="展现量", align=2, sort=70)
    public String getShowQuantity() {
        return showQuantity;
    }

    public void setShowQuantity(String showQuantity) {
        this.showQuantity = showQuantity;
    }
    @ExcelField(title="点击量", align=2, sort=80)
    public String getClickQuantity() {
        return clickQuantity;
    }

    public void setClickQuantity(String clickQuantity) {
        this.clickQuantity = clickQuantity;
    }
    @ExcelField(title="消费", align=2, sort=90)
    public String getConsumeQuantity() {
        return consumeQuantity;
    }

    public void setConsumeQuantity(String consumeQuantity) {
        this.consumeQuantity = consumeQuantity;
    }
    @ExcelField(title="点击率", align=2, sort=100)
    public String getClickRate() {
        return clickRate;
    }

    public void setClickRate(String clickRate) {
        this.clickRate = clickRate;
    }
    @ExcelField(title="平均点击价格", align=2, sort=110)
    public String getClickAveragePrice() {
        return clickAveragePrice;
    }

    public void setClickAveragePrice(String clickAveragePrice) {
        this.clickAveragePrice = clickAveragePrice;
    }
  
}
