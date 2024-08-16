public class Cars {
    private final String car_brand;
    private final String car_model;
    private final int car_year;
    private int car_km;
    public Cars(String car_brand, String car_model, int car_year) {
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.car_year = car_year;
        this.car_km = 0;
    }
    public String get_descriptive_name() {
        String descriptive_name = car_year + " " + car_brand + " " + car_model;
        return TitleCase.Title(descriptive_name);
    }
    public String read_odometer() {
        String template = "This car has %d kilometers on it";
        return String.format(template, car_km);
    }
    public void update_odometer(int new_km) {
        if (new_km > car_km){
            car_km = new_km;
        }
    }
    public void increment_odometer(int add_km) {
        car_km += add_km;
    }
}

