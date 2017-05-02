package fcplay;

import javax.swing.*;
import javax.swing.*;

import java.awt.*;
import java.io.*;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {

	int cityNum = 48;

	public void paintComponent(Graphics g) { // 方法名不能改，覆盖了父类的paintComponent方法，重绘时会自动调用该方法
		super.paintComponent(g);
		
		try {
			GA ga = new GA(50, 48, 3000, 0.8f, 0.9f);
			ga.init("E://data.txt");
			ga.solve();
			int[] bestTour = ga.getBestTour();
			int bestLength=ga.getBestLength();
			g.drawString("最佳长度:"+bestLength, 30, 540);

			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < cityNum; i++) {
				sb.append(bestTour[i]+"-");
	        }
			sb.delete(sb.length()-1, sb.length());
			g.drawString("最佳路径:"+sb.toString(), 30, 570);
			
			g.setColor(Color.RED); // 设置颜色
			// 读取数据
			int[] x;
			int[] y;

			String strbuff;
			BufferedReader data = new BufferedReader(new InputStreamReader(
					new FileInputStream("E://data.txt")));

			x = new int[cityNum];
			y = new int[cityNum];
			for (int i = 0; i < cityNum; i++) {
				// 读取一行数据，数据格式1 6734 1453
				strbuff = data.readLine();
				// 字符分割
				String[] strcol = strbuff.split(" ");
				x[i] = Integer.valueOf(strcol[1]);// x坐标
				y[i] = Integer.valueOf(strcol[2]);// y坐标
				g.fillOval(x[i] / 10, y[i] / 10, 5, 5);
				g.drawString(String.valueOf(i), x[i] / 10, y[i] / 10);
			}
			data.close();
			
			g.setColor(Color.BLUE); // 设置颜色
			for(int j=0;j<cityNum-1;j++)
			{
				g.drawLine(x[bestTour[j]]/ 10, y[bestTour[j]]/ 10, x[bestTour[j+1]]/ 10, y[bestTour[j+1]]/ 10);
			}
			
			g.setColor(Color.GREEN); // 设置颜色
			g.fillOval(x[bestTour[0]]/ 10, y[bestTour[0]]/ 10, 6, 6);
			g.fillOval(x[bestTour[cityNum-1]]/ 10, y[bestTour[cityNum-1]]/ 10, 6, 6);
			
			// g.drawLine(100, 100, 300, 300); // 画线
			// g.drawArc(330, 330, 10, 10, 0, 0);
			// g.fillOval(350, 350, 10, 10);
			// g.fillRect(380, 380, 10, 10);
		} catch (Exception e) {
			e.printStackTrace(); // 异常处理？
		}
	}

	public static void main(String[] args) throws Exception {
		JFrame f = new JFrame();
		f.setTitle("遗传算法求解TSP");
		f.getContentPane().add(new MyPanel());
		f.setSize(1000, 640);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
