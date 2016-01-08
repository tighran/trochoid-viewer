import java.awt.*;
import java.applet.*;

public class spiroApp extends Applet
{
  public void paint(Graphics g)
  {
    double radius1 = 1.0;
    double radius2 = 2.0/11.0;

    //interest: 1.0, 0.4
    double r1bias = 1.0;
    double r2bias = 1.0;

    double increment = 0.1;
    double theta = 0;

    double x1;
    double y1;
    double x2 = r1bias * (radius1 - radius2) * Math.cos(theta) + r2bias * radius2 * Math.cos(-(radius1/radius2 - 1) * theta + Math.PI);
    double y2 = r1bias * (radius1 - radius2) * Math.sin(theta) + r2bias * radius2 * Math.sin(-(radius1/radius2 - 1) * theta + Math.PI);

    int x1coord;
    int y1coord;
    int x2coord;
    int y2coord;

    for (int i = 0; i < 260; i++)
    {
      x1 = x2;
      y1 = y2;
      theta = theta + increment;
      x2 = r1bias * (radius1 - radius2) * Math.cos(theta) + r2bias * radius2 * Math.cos(-(radius1/radius2 - 1) * theta + Math.PI);
      y2 = r1bias * (radius1 - radius2) * Math.sin(theta) + r2bias * radius2 * Math.sin(-(radius1/radius2 - 1) * theta + Math.PI);
      x1coord = (int) (250+200*x1);
      y1coord = (int) (250+200*y1);
      x2coord = (int) (250+200*x2);
      y2coord = (int) (250+200*y2);
      g.drawLine(x1coord, y1coord, x2coord, y2coord);
    }

    theta = Math.PI;
    r1bias = 0.8;
    r2bias = 1.0;
    x2 = r1bias * (radius1 - radius2) * Math.cos(theta) + r2bias * radius2 * Math.cos(-(radius1/radius2 - 1) * theta);
    y2 = r1bias * (radius1 - radius2) * Math.sin(theta) + r2bias * radius2 * Math.sin(-(radius1/radius2 - 1) * theta);

    //circle!
    theta = 0;
    x2 = Math.cos(theta);
    y2 = Math.sin(theta);
    for(int i=0;i<70;i++)
    {
      x1 = x2;
      y1 = y2;
      theta = theta + increment;
      x2 = Math.cos(theta);
      y2 = Math.sin(theta);
      x1coord = (int) (250+200*x1);
      y1coord = (int) (250+200*y1);
      x2coord = (int) (250+200*x2);
      y2coord = (int) (250+200*y2);
      g.drawLine(x1coord, y1coord, x2coord, y2coord);
    }

    g.setColor(Color.red);
    g.drawLine(240,250,260,250);
    g.drawLine(250,240,250,260);
  }
}
