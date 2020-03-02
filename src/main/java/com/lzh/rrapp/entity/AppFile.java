package com.lzh.rrapp.entity;

import lombok.Data;

/**
 * @auther LuoZhiHui
 * @date 2020/3/2 15:19
 */
@Data
public class AppFile {
    private String name;
    private String fileName;
    private String url;
    private String diskUrl;
    private String date;
    private String serverUpdate;
    private long fileSize;
    private String fileMd5;
    private String remark;
}
