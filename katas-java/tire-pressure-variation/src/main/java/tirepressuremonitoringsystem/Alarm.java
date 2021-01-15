package tirepressuremonitoringsystem;

public class Alarm {

  private final double LowPressureThreshold = 17;
  private final double HighPressureThreshold = 21;

  private iSensor sensor = new Sensor();
  private iNotificator notificator;
  public static String ALARM_ACTIVATED = "Alarm activated!";
  public static String ALARM_DEACTIVATED = "Alarm deactivated!";

  private boolean alarmOn = false;

  public Alarm() {
    notificator = new SystemOutNotificator();
  }


  public Alarm(iNotificator notificator) {
    this.notificator = notificator;
  }


  public void check() {
    double psiPressureValue = sensor.popNextPressurePsiValue();

    if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
      if (!isAlarmOn()) {
        alarmOn = true;
        notificator.notify(ALARM_ACTIVATED);
      }
    } else {
      if (isAlarmOn()) {
        alarmOn = false;
        notificator.notify(ALARM_DEACTIVATED);
      }
    }
  }


  public void setSensor(iSensor newSensor) {
    sensor = newSensor;
  }

  private boolean isAlarmOn() {
    return alarmOn;
  }
}
