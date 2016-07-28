package com.salesforce.dev.framework.dto;

/**
 * Created by veronica on 8/21/2015.
 */
public class FilterView {
    private String fieldFilter;
    private String operatorFilter;
    private String valueFilter;
    public FilterView(){}

    public String getFieldFilter() {
        return fieldFilter;
    }

    public String getOperatorFilter() {
        return operatorFilter;
    }

    public String getValueFilter() {
        return valueFilter;
    }

    public void setFieldFilter(String fieldFilter) {
        this.fieldFilter = fieldFilter;
    }

    public void setOperatorFilter(String operatorFilter) {
        this.operatorFilter = operatorFilter;
    }

    public void setValueFilter(String valueFilter){
        this.valueFilter = valueFilter;
    }
}
