package com.google.cloud.wallenius.wallenius.gcp.beans;

import java.util.Objects;

/**
 *
 * @author wallenius
 */
public class SillyBean {

    private Integer amount;
    private String name;

    public SillyBean(Integer amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public SillyBean() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SillyBean{" + "amount=" + amount + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SillyBean other = (SillyBean) obj;
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
    
    
    
}
