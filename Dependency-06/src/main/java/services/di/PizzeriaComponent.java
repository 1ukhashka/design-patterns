package services.di;
import dagger.Component;
import services.pizzeria.PizzeriaService;

@Component
public interface PizzeriaComponent {
    PizzeriaService getPizzeriaService();
}