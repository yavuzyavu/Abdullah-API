package pojos;
public class Odev2Pojo {

    private String name;
    private String jop;
    private String createdAt;

    public Odev2Pojo(String name, String jop, String createdAt) {
        this.name = name;
        this.jop = jop;
        this.createdAt = createdAt;
    }

    public Odev2Pojo() {
    }

    public Odev2Pojo(String morpheus, String zion_president) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Odev2Pojo{" +
                "name='" + name + '\'' +
                ", jop='" + jop + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
