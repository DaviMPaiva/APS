package cin.ufpe.aps.AluCar.controllers;

import java.util.ArrayList;
import java.util.List;

import cin.ufpe.aps.AluCar.models.Car;

public class ControleHistorico {


    public List<Car> obterHistorico() {
        // mock a list of cars
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Uno", "ABC-1234", (float) 100.0, 2010, "Gasolina", "Manual", "https://mundodoautomovelparapcd.com.br/wp-content/uploads/2019/12/Fox-Xtreme-2020-01-1110x629.jpg"));
        cars.add(new Car("Gol", "DEF-5678", (float) 200.0, 2015, "Gasolina", "Manual", "https://scontent.frec3-1.fna.fbcdn.net/v/t39.30808-6/295307720_450544647104857_8188193324368191353_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=I7VR6LCYvDMAX8RhoRG&_nc_ht=scontent.frec3-1.fna&oh=00_AfAx4kJe71pCcfGgqOGXv8eborTGxHhKdyJhmVmhIIP3vw&oe=6582BE86"));
        cars.add(new Car("Palio", "GHI-9012", (float) 300.0, 2020, "Gasolina", "Manual", "https://9f29a5fd9c.cbaul-cdnwnd.com/d8dacc4449515a1d555fffe97ec76136/system_preview_detail_200000009-0c6800d5ec-public/palio-tunado-2[1].jpg"));

        System.out.println("Retrieving historical data...");
        return cars;
    }

}
