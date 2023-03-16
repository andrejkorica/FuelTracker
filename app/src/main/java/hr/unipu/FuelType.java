package hr.unipu;

import java.util.List;

public class FuelType {
    private String Fuel;
    private List<FuelStation> data;

    public String getFuel() {
        return Fuel;
    }

    public void setFuel(String fuel) { this.Fuel = fuel; }

    public List<FuelStation> getData() {
        return data;
    }

    public void setData(List<FuelStation> data) {
        this.data = data;
    }
}
