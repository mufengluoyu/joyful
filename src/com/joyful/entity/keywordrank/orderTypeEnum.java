package com.joyful.entity.keywordrank;

import com.joyful.common.util.EnumObj;

public enum orderTypeEnum implements EnumObj{

	CONSUME("1","消费"),CLICK("2","点击"),SHOW("3","展现");
	// 成员变量
    private String index;
    private String name;
    
    // 构造方法
    orderTypeEnum(String index, String name) {
        this.name = name;
        this.index = index;
    }
	 // 普通方法  根据id查找对应的名称
    public String getValue(Object key) {
        for (orderTypeEnum c : orderTypeEnum.values()) {
            if (c.getIndex().trim() == key) {
                return c.name;
            }
        }
        return null;
    }
    //根据名称查找对应的key
    public String getKey(Object value){
    	for (orderTypeEnum c : orderTypeEnum.values()) {
            if (c.getName().trim() == value) {
                return c.index;
            }
        }
        return null;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
}
