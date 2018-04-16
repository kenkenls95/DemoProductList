package application.model;

/**
 * Created by ManhNguyen on 3/1/18.
 */
public class FileUploadResult extends BaseApiResult {
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
