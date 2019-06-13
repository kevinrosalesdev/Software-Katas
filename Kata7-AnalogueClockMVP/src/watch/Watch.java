package watch;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Watch {
    
    /**
     * Versión 1.1: La mejora consiste en representar la hora del sistema en
     * lugar de las 00:00:00 de la Versión 1.0.
     * 
     * Para ello, se modifican los valores de los atributos 'seconds', 'minutes' y
     * 'hours', que pasan a representar el angulo necesario para mostrar la hora
     * actual del sistema mediante una conversión de Grado Sexagesimal a Radián.
     * 
     * La metodología para hacerlo consiste en restarle a los 90º (Las 00:00:00) el
     * valor del ángulo en radianes correspondiente usando para ello como referencia
     * 'secondStep' para mejorar la eficiencia. Para calcular 'hours', es necesario
     * además multiplicarlo por 5 dado a que en un reloj se representan 12 horas en
     * lugar de los 60 minutos o segundos (60/12 = 5).
     */
    
    private static final double secondStep = Math.PI * 2 /60;
    private static final double minuteStep = secondStep /60;
    private static final double hourStep = minuteStep /12;
    private final List<Observer> observers = new ArrayList<>();
    private double seconds = (Math.PI / 2) - (LocalTime.now().getSecond() * secondStep);
    private double minutes = (Math.PI / 2) - (LocalTime.now().getMinute() * secondStep);
    private double hours = (Math.PI / 2) - (LocalTime.now().getHour() * secondStep * 5);

    public Watch() {
        Timer timer = new Timer();
        timer.schedule(timerTask(), 0, 1000);
    }
    
    public void add(Observer observer){
        observers.add(observer);
    }

    public double getSeconds() {
        return seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }
    
    private TimerTask timerTask() {
        return new TimerTask(){
            @Override
            public void run() {
                step();
                updateObservers();
            }
        };
    }
    
    private void updateObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    private void step() {
        seconds = normalize(seconds - secondStep);
        minutes = normalize(minutes - minuteStep);
        hours = normalize(hours - hourStep);
    }

    private double normalize(double angle) {
        return (angle + 2 * Math.PI) % (2 * Math.PI);
    }
    
    public interface Observer {
        public void update();
    }
}
