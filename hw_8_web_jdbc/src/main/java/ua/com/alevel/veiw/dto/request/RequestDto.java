package ua.com.alevel.veiw.dto.request;

public abstract class RequestDto {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RequestDto() {
    }
}
