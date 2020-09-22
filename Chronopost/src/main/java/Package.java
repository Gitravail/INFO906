import java.util.List;

public class Package {
    private long id;
    private float weight;
    private float value;
    private String origin;
    private String destination;
    private List<PackageStatus> packageStatusList;

    public Package() {
        
    }

    public Package(float weight, float value, String origin, String destination) {
        this.weight = weight;
        this.value = value;
        this.origin = origin;
        this.destination = destination;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<PackageStatus> getPackageStatusList() {
        return packageStatusList;
    }

    public void setPackageStatusList(List<PackageStatus> packageStatusList) {
        this.packageStatusList = packageStatusList;
    }
}
