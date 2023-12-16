package cin.ufpe.aps.AluCar.models;
import java.io.Serializable;

public record Locadora(
        String name,
        String description,
        String local
) {}