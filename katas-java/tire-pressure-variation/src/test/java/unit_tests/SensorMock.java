package unit_tests;

import tirepressuremonitoringsystem.iSensor;

public class SensorMock implements iSensor {

  double currentPressure  ;

  public SensorMock(double currentPressure) {
    this.currentPressure = currentPressure;
  }

  @Override
  public double popNextPressurePsiValue() {
    return currentPressure;
  }
  
  public void setPressure( double newPressure) {
    currentPressure = newPressure ;
  }
}
