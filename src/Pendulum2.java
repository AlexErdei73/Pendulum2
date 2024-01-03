public class Pendulum2 {
    public static void main(String[] args) {
      Pendulum pendulum1 = new Pendulum(0.5, 0.5, 0.5, 0, 0);
      double tMax = 100;
      double dt = 0.001;
      Plot plot = new Plot("Theta of DDP in time",0,100,5, -1,1,0.1);
      plot.setPointSize(1);
      for (double t = 0; t < tMax; t += 10*dt) {
        for (int i = 0; i < 10; i++) {
          pendulum1.nextStep();
        }
        plot.addPoint(t, pendulum1.theta);
      }
    }
}
