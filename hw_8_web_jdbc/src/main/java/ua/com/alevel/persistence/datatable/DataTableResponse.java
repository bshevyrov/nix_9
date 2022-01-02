package ua.com.alevel.persistence.datatable;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DataTableResponse<ENTITY extends BaseEntity> {

    private List<ENTITY> items;
    private long itemSize;
    private Map<Object,Object> otherParamMap;

    public DataTableResponse() {
        items= Collections.emptyList();
        otherParamMap = Collections.emptyMap();
        itemSize = 0;
    }

    public List<ENTITY> getItems() {
        return items;
    }

    public void setItems(List<ENTITY> items) {
        this.items = items;
    }

    public long getItemSize() {
        return itemSize;
    }

    public void setItemSize(long itemSize) {
        this.itemSize = itemSize;
    }

    public Map<Object, Object> getOtherParamMap() {
        return otherParamMap;
    }

    public void setOtherParamMap(Map<Object, Object> otherParamMap) {
        this.otherParamMap = otherParamMap;
    }
}
