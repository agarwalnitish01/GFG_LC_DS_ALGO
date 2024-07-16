package pattern;

public class BuilderDesignPattern {
    private String id;
    private String name;
    private String address;

    private BuilderDesignPattern(EmployeeBuilder builder) {
        this.id=builder.id;
        this.name=builder.name;
        this.address=builder.address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    static class EmployeeBuilder {
        private String id;
        private String name;
        private String address;

        public EmployeeBuilder buildId(String id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder buildName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder buildAddress(String address) {
            this.address = address;
            return this;
        }


        public BuilderDesignPattern build() {
            return new BuilderDesignPattern(this);
        }
    }
}
