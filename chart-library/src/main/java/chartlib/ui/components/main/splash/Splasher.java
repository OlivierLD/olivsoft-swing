package chartlib.ui.components.main.splash;

public class Splasher
{
  public static void main(String[] args)
  {
    SplashWindow.splash(Splasher.class.getResource("LogiSail.png"));
    SplashWindow.invokeMain("chartlib.ui.components.main.ChartLib", args);
    SplashWindow.disposeSplash();
  }
}
