package ua.com.alevel.persistence.datatable;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DataTableResponse<E extends BaseEntity> {

    private List<E> eList;
    private long eListSize;
    private Map<Object, Object> otherParamMap;
    private long totalPage;


    public DataTableResponse() {
        this.eList = Collections.emptyList();
        this.eListSize = 0L;
        this.otherParamMap = Collections.emptyMap();
    }


    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> geteList() {
        return eList;
    }

    public void seteList(List<E> eList) {
        this.eList = eList;
    }

    public long geteListSize() {
        return eListSize;
    }

    public void seteListSize(long eListSize) {
        this.eListSize = eListSize;
    }

    public Map<Object, Object> getOtherParamMap() {
        return otherParamMap;
    }

    public void setOtherParamMap(Map<Object, Object> otherParamMap) {
        this.otherParamMap = otherParamMap;
    }
}
