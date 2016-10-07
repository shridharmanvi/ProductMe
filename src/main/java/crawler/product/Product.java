package crawler.product;

public class Product {
    private String id;
    private String name;
    private String url;
    private double cost;
    private String pictureUrl;
    private String description;

    private void setName(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private double getCost() {
        return cost;
    }

    private String getDescription() {
        return description;
    }

    private String getId() {
        return id;
    }

    private String getPictureUrl() {
        return pictureUrl;
    }

    private String getUrl() {
        return url;
    }

    private void setCost(double cost) {
        this.cost = cost;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    private void setUrl(String url) {
        this.url = url;
    }

}
