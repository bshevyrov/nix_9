package ua.com.alevel.veiw.dto.request;

import java.util.Date;

public abstract class RequestDto {

    private long id;
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RequestDto() {
    }
}
