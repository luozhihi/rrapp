package com.lzh.rrapp.enumType;

/**
 * @auther LuoZhiHui
 * @date 2020/3/2 15:28
 */
public enum ServerTypeEnum {

    FILE_SUGARM("SUGARM", ""),
    FILE_HUOBI("HUOBI",""),
    FILE_ARW("ARW",""),
    FILE_COTC("COTC","");

    private String name;
    private String value;

    ServerTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
