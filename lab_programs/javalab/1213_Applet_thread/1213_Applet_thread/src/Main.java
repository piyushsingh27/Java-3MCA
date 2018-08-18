package com.mca;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.applet.*;
import java.util.*;

public class Main extends JApplet implements Runnable {
	Font bigFont;
	boolean painted = false;
	private Color bgColor = new Color(238, 238, 238);
	private Thread clockThread = null;
	private Thread logoThread = null;
	private Vector objs[] = new Vector[8];
	private ArrayList<Point2D> arr = new ArrayList<Point2D>();
	private String dateStr;
	private String marqueeStr;
	private String timeStr;
	private int index = 0;
	private String fullStr = "Emergency crews in Australia are battling unseasonal bushfires which have erupted across drought-stricken New South Wales (NSW). Almost 80 fires were burning along the state's coast on Thursday, having ripped through more than 1,000 hectares in recent days. No lives or homes were in immediate danger, according to officials. Winter bushfires are uncommon but have flared up this year due to dry conditions, authorities say.";
	private int size = 63;

	public void run() {
		System.out.println("Logo: Running...");
		initCup();
		timeStr = "";
		dateStr = "";
		marqueeStr = "";
	}

	public void init() {
		System.out.println("Logo: Initializing...");
		//setBackground(bgColor); // Not working for JApplet
		StringBuilder sb = new StringBuilder(fullStr.length() + size);
		for (int i = 0; i < size; i++) {
			sb.append(' ');
		}
		sb.append("TODAY NEWS: ");
		sb.append(fullStr);
		fullStr = sb.toString();
		new Thread(this).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
					Thread.sleep(1000);
						dateTextUpdate();
					}
				} catch (InterruptedException e) {
					e.printStackTrace(System.out);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Thread.sleep(1000 / 10);
						marqueeTextUpdate(fullStr, size);
						repaint();
					}
				} catch (InterruptedException e) {
					e.printStackTrace(System.out);
				}
			}
		}).start();
	}

	public void start() {
		System.out.println("Logo: Starting...");
		repaint();
	}

	public void stop() {
		logoThread = null;
	}

	public void destroy() {

	}
 
	public void paint(Graphics g) {
		//System.out.println("Logo: Painting...");

		Graphics2D g2D = (Graphics2D) g;

		if (!painted) {
			for (int i = 0; i < objs.length; i++) {
	    		for (int j = 0; j < objs[i].size(); j++) {
	    			g2D.draw((Shape)objs[i].elementAt(j));
				}
			}

			GeneralPath path = new GeneralPath();
			g2D.setColor(new Color(216, 57, 50));
			CubicCurve2D c = (CubicCurve2D)objs[0].elementAt(0);

			// Smoke
			paintCC(g2D, objs[0]);
			paintCC(g2D, objs[1]);

			g2D.setColor(new Color(62, 136, 194));

			// Cup body
			paintCLC(g2D, objs[2]);
			paintCLC(g2D, objs[3]);
			paintCLC(g2D, objs[4]);
			// Cup ear
			paintCC(g2D, objs[5]);
			// Cup dish
			paintCCQ(g2D, objs[6]);
			paintCC(g2D, objs[7]);
			painted = true;
		}
		g.setColor(bgColor);
		g.fillRect(320, 170, 420, 200);
		g.fillRect(0, 0, 800, 50);

		g.setColor(new Color(236, 111, 46));
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
		g.drawString(dateStr, 330, 220);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 80)); 
		g.drawString(timeStr, 345, 300);

		g.setColor(new Color(55, 126, 34));
		g.setFont(new Font("Courier", Font.PLAIN, 20));
		g.drawString(marqueeStr, 25, 25);
	}

	@SuppressWarnings("unchecked")
	private void initCup() {
		Vector smoke1 = new Vector();
		smoke1.addElement(new CubicCurve2D.Float(110, 200, 30, 115, 160, 135, 150, 70));
		smoke1.addElement(new CubicCurve2D.Float(110, 200, 60, 130, 170, 145, 150, 70));
		objs[0] = smoke1;

		Vector smoke2 = new Vector();
		smoke2.addElement(new CubicCurve2D.Float(130, 220, 160, 190, 70, 165, 175, 120));
		smoke2.addElement(new CubicCurve2D.Float(130, 220, 190, 170, 80, 175, 175, 120));
		objs[1] = smoke2;

		Vector cupTop = new Vector();
		cupTop.addElement(new CubicCurve2D.Float(90, 213, 0, 240, 175, 230, 190, 225));
		cupTop.addElement(new Line2D.Float(190, 225, 180, 233));
		cupTop.addElement(new CubicCurve2D.Float(90, 213, -40, 245, 175, 240, 180, 233));
		objs[2] = cupTop;

		Vector cupMid = new Vector();
		cupMid.addElement(new CubicCurve2D.Float(80, 247, 60, 267, 155, 255, 155, 255));
		cupMid.addElement(new Line2D.Float(155, 255, 165, 262));
		cupMid.addElement(new CubicCurve2D.Float(80, 247, 30, 277, 155, 270, 165, 262));
		objs[3] = cupMid;

		Vector cupBot = new Vector();
		cupBot.addElement(new CubicCurve2D.Float(90, 278, 60, 298, 155, 286, 144, 286));
		cupBot.addElement(new Line2D.Float(144, 286, 162, 293));
		cupBot.addElement(new CubicCurve2D.Float(90, 278, 40, 298, 125, 306, 162, 293));
		objs[4] = cupBot;

		Vector cupEar = new Vector();
		cupEar.addElement(new CubicCurve2D.Float(195, 213, 240, 205, 240, 239, 180, 270));
		cupEar.addElement(new CubicCurve2D.Float(195, 213, 255, 190, 260, 250, 180, 270));
		objs[5] = cupEar;

		Vector cupDish = new Vector();
		cupDish.addElement(new CubicCurve2D.Float(70, 300, -40, 320, 245, 323, 200, 300));
		cupDish.addElement(new QuadCurve2D.Float(160, 320, 230, 310, 200, 300));
		cupDish.addElement(new CubicCurve2D.Float(70, 300, -40, 315, 100, 330, 160, 320));
		objs[6] = cupDish;

		Vector cupDishShadow = new Vector();
		cupDishShadow.addElement(new CubicCurve2D.Float(70, 327, 110, 332, 185, 332, 220, 315));
		cupDishShadow.addElement(new CubicCurve2D.Float(70, 327, 110, 338, 195, 338, 220, 315));
		objs[7] = cupDishShadow;
	}

	private void paintCC(Graphics2D g, Vector v) {
		CubicCurve2D c;
		GeneralPath path;

		path = new GeneralPath();
		c = (CubicCurve2D)v.elementAt(0);
		path.moveTo(c.getX1(), c.getY1());
		path.curveTo(c.getCtrlX1(), c.getCtrlY1(), c.getCtrlX2(), c.getCtrlY2(), c.getX2(), c.getY2());
		c = (CubicCurve2D)v.elementAt(1);
		path.curveTo(c.getCtrlX2(), c.getCtrlY2(), c.getCtrlX1(), c.getCtrlY1(), c.getX1(), c.getY1());
		path.closePath();
		g.fill(path);
	}

	private void paintCLC(Graphics2D g, Vector v) {
		CubicCurve2D c;
		Line2D l;
		GeneralPath path;

		path = new GeneralPath();
		c = (CubicCurve2D)v.elementAt(0);
		path.moveTo(c.getX1(), c.getY1());
		path.curveTo(c.getCtrlX1(), c.getCtrlY1(), c.getCtrlX2(), c.getCtrlY2(), c.getX2(), c.getY2());
		l = (Line2D)v.elementAt(1);
		path.lineTo(l.getX2(), l.getY2());
		c = (CubicCurve2D)v.elementAt(2);
		path.curveTo(c.getCtrlX2(), c.getCtrlY2(), c.getCtrlX1(), c.getCtrlY1(), c.getX1(), c.getY1());
		path.closePath();
		g.fill(path);
	}

	private void paintCCQ(Graphics2D g, Vector v) {
		CubicCurve2D c;
		QuadCurve2D q;
		GeneralPath path;

		path = new GeneralPath();
		c = (CubicCurve2D)v.elementAt(0);
		path.moveTo(c.getX1(), c.getY1());
		path.curveTo(c.getCtrlX1(), c.getCtrlY1(), c.getCtrlX2(), c.getCtrlY2(), c.getX2(), c.getY2());
		q = (QuadCurve2D)v.elementAt(1);
		path.quadTo(q.getCtrlX(), q.getCtrlY(), q.getX1(), q.getY1());
		c = (CubicCurve2D)v.elementAt(2);
		path.curveTo(c.getCtrlX2(), c.getCtrlY2(), c.getCtrlX1(), c.getCtrlY1(), c.getX1(), c.getY1());
		path.closePath();
		g.fill(path);
	}

	private void dateTextUpdate() {
		Calendar greg = Calendar.getInstance();
		greg.setTime(new Date());
		dateStr = String.format("%s / %02d, %s (%s)", greg.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US), greg.get(Calendar.DAY_OF_MONTH), greg.get(Calendar.YEAR), greg.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US));
		timeStr = String.format("%02d : %02d : %02d", greg.get(Calendar.HOUR_OF_DAY), greg.get(Calendar.MINUTE), greg.get(Calendar.SECOND));
	}

	private void marqueeTextUpdate(String s, int n) {
        index++;
        if (index > s.length() - n) {
            index = 0;
        }
        marqueeStr = s.substring(index, index + n);
	}
}