package crawler.product;

public class Product {
    private String id;
    private String name;
    private String url;
    private String cost;
    private String clearanceCost;
    private String pictureUrl;
    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClearanceCost() {
        return clearanceCost;
    }

    public void setClearanceCost(String clearanceCost) {
        this.clearanceCost = clearanceCost;
    }
}
