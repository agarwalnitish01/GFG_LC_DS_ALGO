package pattern;

public class DesignPatternRunner {

    public static void main(String[] args) {

        builderPattern();
        singletonBuilderPattern();
        factoryDesignPattern();
    }

    private static void factoryDesignPattern() {
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        Client twoWheelerClient = new Client(twoWheelerFactory);
        Vehicle twoWheeler = twoWheelerClient.getVehicle();
        twoWheeler.printVehicle();

        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        Client fourWheelerClient = new Client(fourWheelerFactory);
        Vehicle fourWheeler = fourWheelerClient.getVehicle();
        fourWheeler.printVehicle();
    }

    private static void singletonBuilderPattern() {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }

    private static void builderPattern() {
        BuilderDesignPattern builderDesignPattern = new BuilderDesignPattern.EmployeeBuilder()
                .buildId("1")
                .buildAddress("kolkata")
                .buildName("nitish")
                .build();

        System.out.println(builderDesignPattern.getId());
        System.out.println(builderDesignPattern.getName());
        System.out.println(builderDesignPattern.getAddress());
    }


}

