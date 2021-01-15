package unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import tirepressuremonitoringsystem.Alarm;
import tirepressuremonitoringsystem.TestingNotificator;

public class AlarmTest {

  // @Test
  public void noValeTest() {
    Alarm alarm = new Alarm();
    SensorMock sensorMock = new SensorMock(1000);
    alarm.setSensor(sensorMock);
    alarm.check();
    System.out.println("---------");

    sensorMock.setPressure(18);
    alarm.setSensor(sensorMock);
    alarm.check();
    System.out.println("---------");

    sensorMock.setPressure(10);
    alarm.setSensor(sensorMock);
    alarm.check();
    System.out.println("---------");
  }

  @Test
  public void firstAlarmStatusDeactivated() {
    TestingNotificator testingNotificator = new TestingNotificator();

    Alarm alarm = new Alarm(testingNotificator);
    // Then
    assertEquals(Alarm.ALARM_DEACTIVATED, testingNotificator.getLastMessage());

  }

    @Test
  public void checkHighPressureActivatesAlarm() {
    // Given
    TestingNotificator testingNotificator = new TestingNotificator();

    Alarm alarm = new Alarm(testingNotificator);
    SensorMock sensorMock = new SensorMock(1000);
    alarm.setSensor(sensorMock);

    // When
    alarm.check();

    // Then
    assertEquals(Alarm.ALARM_ACTIVATED, testingNotificator.getLastMessage());

  }


  @Test
  public void checkLowPressureActivatesAlarm() {
    // Given
    TestingNotificator testingNotificator = new TestingNotificator();

    Alarm alarm = new Alarm(testingNotificator);
    SensorMock sensorMock = new SensorMock(16);
    alarm.setSensor(sensorMock);

    // When
    alarm.check();

    // Then
    assertEquals(Alarm.ALARM_ACTIVATED, testingNotificator.getLastMessage());
  }


  @Test
  public void checkPressureBackToNormal() {
    // Given
    TestingNotificator testingNotificator = new TestingNotificator() ;

    Alarm alarm = new Alarm(testingNotificator);
    SensorMock sensorMock = new SensorMock(16);
    alarm.setSensor(sensorMock);

    // When
    alarm.check();
    // Then
    assertEquals(Alarm.ALARM_ACTIVATED, testingNotificator.getLastMessage());

    // When
    sensorMock.setPressure(17);
    alarm.check();
    // Then
    assertEquals(Alarm.ALARM_DEACTIVATED, testingNotificator.getLastMessage());

  }

}

