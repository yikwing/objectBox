package com.rongyi.objectbox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Demo class
 *
 * @author yikwing
 * @date 26/03/2018
 */
@Entity
public class Bean {
    @Id
    private long id;

    public Bean(){}

    public Bean(String uuid, String token) {
        this.uuid = uuid;
        this.token = token;
    }

    private String uuid;

    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
