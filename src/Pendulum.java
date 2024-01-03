public class Pendulum {
  public double dump;
  public double driveAmp;
  public double driveFreq;
  public double theta;
  public double omega;
  public double t;
  public double dt = 0.001;
  Pendulum(double dump, double driveAmp, double driveFreq, double theta0, double omega0) {
    this.dump = dump;
    this.driveAmp = driveAmp;
    this.driveFreq = driveFreq;
    this.omega = omega0;
    this.theta = theta0;
  }
  public void nextStep() {
    double alpha, alphaMid, thetaMid, omegaMid;
    alpha = this.torque(theta, omega, t);
    thetaMid = this.theta + this.omega*0.5*this.dt;
    omegaMid = this.omega + alpha*0.5*this.dt;
    alphaMid = this.torque(thetaMid, omegaMid, this.t + 0.5*this.dt);
    this.theta += omegaMid*this.dt;
    this.omega += alphaMid*this.dt;
    this.t += this.dt;
  }
  private double torque(double theta, double omega, double t) {
    return -Math.sin(theta) - this.dump*this.omega + this.driveAmp*Math.sin(this.driveFreq*t);
  }

}
