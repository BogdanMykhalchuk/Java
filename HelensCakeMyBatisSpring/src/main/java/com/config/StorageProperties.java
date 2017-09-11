package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Dreawalker on 08.09.2017.
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "D:\\Bogdan\\Job\\Java\\Java\\HelensCakeMyBatisSpring\\src\\main\\webapp\\img\\loaded\\";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
