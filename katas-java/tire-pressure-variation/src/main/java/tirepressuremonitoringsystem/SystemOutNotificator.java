package tirepressuremonitoringsystem;

public class SystemOutNotificator implements iNotificator {

  @Override
  public void notify(String message) {
    System.out.println(message);
  }
}
