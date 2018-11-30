package com.example.vlad.androidapp.Entities;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private Object message;
    @SerializedName("pager")
    @Expose
    private Pager pager;
    @SerializedName("result")
    @Expose
    private List<Product> result = null;
    @SerializedName("suggestion")
    @Expose
    private Object suggestion;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public List<Product> getResult() {
        return result;
    }

    public void setResult(List<Product> result) {
        this.result = result;
    }

    public Object getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Object suggestion) {
        this.suggestion = suggestion;
    }
}

