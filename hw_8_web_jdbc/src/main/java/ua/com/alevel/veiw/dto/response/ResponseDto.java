package ua.com.alevel.veiw.dto.response;

import java.sql.Date;

public abstract class ResponseDto {

    private long id;
    private Date createDate;

    public ResponseDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
