package com.tofibashers.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by TofixXx on 26.09.2014.
 */
@Entity
@Table(name="amounts")
public class Amount implements Serializable{

    @Id
    private Integer id;

    @Basic
    private Long value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

}
