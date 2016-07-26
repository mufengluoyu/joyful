package com.joyful.entity.user;

import com.joyful.common.util.EnumObj;

public enum SexEnum implements EnumObj{

	All("1","全部");
	// 成员变量
    private String index;
    private String name;
    
    // 构造方法
    SexEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }
	 // 普通方法  根据id查找对应的名称
    public String getValue(Object key) {
        for (SexEnum c : SexEnum.values()) {
            if (c.getIndex().trim() == key) {
                return c.name;
            }
        }
        return null;
    }
    //根据名称查找对应的key
    public String getKey(Object value){
    	for (SexEnum c : SexEnum.values()) {
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
