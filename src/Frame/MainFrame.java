/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Algorithm.Chromosome;
import Algorithm.City;
import Algorithm.GeneticAlgorithm;
import Algorithm.Parameter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import static Algorithm.Parameter.*;
import static Algorithm.Parameter.distance;

/**
 *
 * @author SAKURA
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        setTitle("遗传算法解决旅行社问题");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new DrawPanel();
        jPanel2 = new JPanel();
        jButtonRandomGenerate = new JButton();
        jButtonCalculate = new JButton();
        jButtonReset = new JButton();
        jLabelTheShortestLength = new JLabel();
        jLabelTheLength = new JLabel();
        jLabelCitys = new JLabel();
        jComboBoxCities = new JComboBox<>();
        jLabelGeneration = new JLabel();
        jComboBoxGeneration = new JComboBox<>();
        jLabelPopulation = new JLabel();
        jComboBoxPopulation = new JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 210));
        jPanel1.setBackground(Color.white);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jButtonRandomGenerate.setText("随机生成");
        jButtonRandomGenerate.setMaximumSize(new java.awt.Dimension(120, 25));
        jButtonRandomGenerate.setMinimumSize(new java.awt.Dimension(120, 25));
        jButtonRandomGenerate.setPreferredSize(new java.awt.Dimension(120, 25));
        jButtonRandomGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRandomGenerateActionPerformed(evt);
            }
        });

        jButtonCalculate.setText("计算最佳路径");
        jButtonCalculate.setMaximumSize(new java.awt.Dimension(120, 25));
        jButtonCalculate.setMinimumSize(new java.awt.Dimension(120, 25));
        jButtonCalculate.setPreferredSize(new java.awt.Dimension(120, 25));
        jButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateActionPerformed(evt);
            }
        });

        jButtonReset.setText("重置");
        jButtonReset.setMaximumSize(new java.awt.Dimension(120, 25));
        jButtonReset.setMinimumSize(new java.awt.Dimension(120, 25));
        jButtonReset.setPreferredSize(new java.awt.Dimension(120, 25));
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jLabelTheShortestLength.setText("最佳长度:");
        jLabelTheLength.setMaximumSize(new java.awt.Dimension(400, 15));
        jLabelTheLength.setMinimumSize(new java.awt.Dimension(400, 15));
        jLabelTheLength.setPreferredSize(new java.awt.Dimension(400, 15));

        jLabelCitys.setText("城市数量:");
        jComboBoxCities.setEditable(true);
        jComboBoxCities.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "40", "30","50" }));
        jComboBoxCities.setMinimumSize(new java.awt.Dimension(70, 25));
        jComboBoxCities.setPreferredSize(new java.awt.Dimension(70, 25));

        jLabelGeneration.setText("选择代数:");
        jComboBoxGeneration.setEditable(true);
        jComboBoxGeneration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500", "100", "1000", "3000","5000"}));
        jComboBoxGeneration.setMinimumSize(new java.awt.Dimension(70, 25));
        jComboBoxGeneration.setPreferredSize(new java.awt.Dimension(70, 25));

        jLabelPopulation.setText("种群规模:");
        jComboBoxPopulation.setEditable(true);
        jComboBoxPopulation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "40", "50", "60", "80" }));
        jComboBoxPopulation.setMinimumSize(new java.awt.Dimension(70, 25));
        jComboBoxPopulation.setPreferredSize(new java.awt.Dimension(70, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonRandomGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelTheShortestLength)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTheLength, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPopulation)
                    .addComponent(jLabelGeneration)
                    .addComponent(jLabelCitys))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCities, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGeneration, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRandomGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCities, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCitys))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxGeneration, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelGeneration))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelTheShortestLength))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelPopulation)
                                    .addComponent(jComboBoxPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabelTheLength, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        /*鼠标点击添加 点*/
        Cities.add(new City(Cities.size(),evt.getX(),evt.getY()));
        System.out.println(Cities.get(Cities.size() -1));
        point2DS.add(new Point2D.Double(evt.getX(), evt.getY()));
        jPanel1.repaint();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        setCursor(Cursor.CROSSHAIR_CURSOR); // 进入画板，改变鼠标样式为十字交叉
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        setCursor(Cursor.DEFAULT_CURSOR);  //  退出画板，改变鼠标样式为默认
    }//GEN-LAST:event_jPanel1MouseExited

    private void jButtonRandomGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRandomGenerateActionPerformed
        isNum();
        RandomGenerate();
    }//GEN-LAST:event_jButtonRandomGenerateActionPerformed

    private void jButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateActionPerformed
        isNum();
        new Thread(new Runnable() {
            @Override
            public void run() {
                paintLine();
            }
        }).start();
    }//GEN-LAST:event_jButtonCalculateActionPerformed

    //重置
    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        Cities.clear();
        point2DS.clear();
        line2DS.clear();
        jPanel1.repaint();
        chartData.clear();
        chartData2.clear();
        chartDataAverage.clear();
        distance = null;
    }//GEN-LAST:event_jButtonResetActionPerformed

    /*
    从算法类那里获取最终结果染色体
     */
    private Chromosome getBestRoute() {
        return GeneticAlgorithm.Route();
    }

    /*
    从获取来的染色体中 确定最后路径 和 最佳距离
     */
    private void paintLine() {
        line2DS.clear();
        Chromosome route = getBestRoute();
        int i = 0;
        for (; i < Cities.size() - 1; i++) {
            line2DS.add(new Line2D.Double(point2DS.get(route.get(i)), point2DS.get(route.get(i + 1))));
        }
        line2DS.add(new Line2D.Double(point2DS.get(route.get(i)), point2DS.get(route.get(0))));
        jPanel1.repaint();
        jLabelTheLength.setText((MaxDistance - route.getFitness()) + "");
    }

    /*
    自动生成点
     */
    private void RandomGenerate() {
        Cities.clear();
        point2DS.clear();
        line2DS.clear();
        double MaxWidth = jPanel1.getWidth();
        double MaxHeight = jPanel1.getHeight();
        for (int i = 0; i < cityNum; i++) {
            px = Math.random()*(MaxWidth - 1);
            py = Math.random()*(MaxHeight - 1);
            Cities.add(new City(Cities.size(),px,py));
            point2DS.add(new Point2D.Double(px, py));
        }
        jPanel1.repaint();
    }

    /*
    判断框内是否是数字
     */
    private void isNum() {
        String num;
        String size;
        String gener;
        if (!((num = jComboBoxCities.getSelectedItem().toString()).matches("^[0-9]*[1-9][0-9]*$"))) {
            JOptionPane.showMessageDialog(null, "请输入正整数", "警告", JOptionPane.ERROR_MESSAGE);
            jComboBoxCities.requestFocusInWindow();//输入不通过时焦点落回错误文本框
        } else if(!((size = jComboBoxPopulation.getSelectedItem().toString()).matches("^[0-9]*[1-9][0-9]*$"))) {
            JOptionPane.showMessageDialog(null, "请输入正整数", "警告", JOptionPane.ERROR_MESSAGE);
            jComboBoxPopulation.requestFocusInWindow();//输入不通过时焦点落回错误文本框
        } else if(!((gener = jComboBoxGeneration.getSelectedItem().toString()).matches("^[0-9]*[1-9][0-9]*$"))) {
            JOptionPane.showMessageDialog(null, "请输入正整数", "警告", JOptionPane.ERROR_MESSAGE);
            jComboBoxGeneration.requestFocusInWindow();//输入不通过时焦点落回错误文本框
        } else {
            cityNum = Integer.parseInt(num);
            populationSize = Integer.parseInt(size);
            generation = Integer.parseInt(gener);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButtonCalculate;
    private JButton jButtonRandomGenerate;
    private JButton jButtonReset;
    private javax.swing.JComboBox<String> jComboBoxCities;
    private javax.swing.JComboBox<String> jComboBoxGeneration;
    private javax.swing.JComboBox<String> jComboBoxPopulation;
    private JLabel jLabelCitys;
    private JLabel jLabelGeneration;
    private JLabel jLabelPopulation;
    private JLabel jLabelTheLength;
    private JLabel jLabelTheShortestLength;
    private JPanel jPanel1;
    private JPanel jPanel2;

    //城市数目
    private int cityNum = 0;
    //坐标
    private double px = 0;
    private double py = 0;
    //点的半径
    private double radius = 5;
    //点集
    private ArrayList<Point2D> point2DS = new ArrayList<Point2D>();
    //线集
    private ArrayList<Line2D> line2DS = new ArrayList<Line2D>();

    private class DrawPanel extends JPanel {
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D graphics2D = (Graphics2D)graphics;
            //设置起点为绿色，其他为红色
            graphics2D.setColor(Color.GREEN);
            for (Point2D point2D: point2DS
                    ) {
                graphics2D.fill(new Ellipse2D.Double(point2D.getX() - radius,point2D.getY() - radius,radius , radius));
                graphics2D.setColor(Color.RED);
            }
            //设置线条为橙色
            graphics2D.setColor(Color.orange);
            graphics2D.setStroke(new BasicStroke(2.0f));//设置线条粗细
            for (Line2D line2D: line2DS
                    ) {
                graphics2D.draw(line2D);
            }
        }
    }
    // End of variables declaration//GEN-END:variables
}
