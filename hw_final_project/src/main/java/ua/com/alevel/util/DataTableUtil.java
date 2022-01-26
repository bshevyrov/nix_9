package ua.com.alevel.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;

public final class DataTableUtil {

    private DataTableUtil() {
    }

    public static PageRequest dataTableRequestToPageRequest(DataTableRequest request) {

        int size = request.getPageSize();
        int page = request.getCurrentPage() - 1;
        String sortParam = request.getSort();
        String orderParam = request.getOrder();

        Sort sort = orderParam.equals("desc")
                ? Sort.by(sortParam).descending()
                : Sort.by(sortParam).ascending();
        return PageRequest.of(page, size, sort);
    }

    public static <T extends BaseEntity> DataTableResponse<T> responsePageToDTResponse(Page<T> responsePage, DataTableRequest request) {
        int page = (request.getCurrentPage() - 1) * request.getPageSize();
        int size = request.getPageSize();
        String order = request.getOrder();
        String sort = request.getOrder();

        DataTableResponse<T> dataTableResponse = new DataTableResponse<>();
        dataTableResponse.setSort(sort);
        dataTableResponse.setOrder(order);
        dataTableResponse.setPageSize(size);
        dataTableResponse.setCurrentPage(page);
        dataTableResponse.setItemsSize(responsePage.getTotalElements());
        dataTableResponse.setTotalPages(responsePage.getTotalPages());
        dataTableResponse.setItems(responsePage.getContent());
        return dataTableResponse;
    }
}
