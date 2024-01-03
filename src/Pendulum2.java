import java.awt.*;

public class Pendulum2 {
    public static void main(String[] args) {
      Pendulum pendulum1 = new Pendulum(0.5, 1.2, 0.5, 0, 0);
      Pendulum pendulum2 = new Pendulum(0.5, 1.2, 0.5, 0.001, 0);
      double tMax = 100;
      double dt = 0.001;
      Plot plot = new Plot("Theta of DDP in time",0,100,5, -50,50,1);
      plot.setPointSize(1);
      for (double t = 0; t < tMax; t += 10*dt) {
        for (int i = 0; i < 10; i++) {
          pendulum1.nextStep();
          pendulum2.nextStep();
        }
        plot.setColor(Color.red);
        plot.addPoint(t, pendulum1.theta);
        plot.setColor(Color.blue);
        plot.addPoint(t, pendulum2.theta);
      }
    }
}
