package tirepressuremonitoringsystem;

public class TestingNotificator implements iNotificator {

  String lastMessage = Alarm.ALARM_DEACTIVATED ;
  @Override
  public void notify(String message) {
    lastMessage = message ;
  }

  public String getLastMessage(){
    return lastMessage ;
  }
}
