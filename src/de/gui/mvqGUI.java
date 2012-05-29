/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * mvqGUI.java
 *
 * Created on 29.05.2012, 21:59:13
 */
package de.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Doro
 */
public class mvqGUI extends javax.swing.JApplet {

    /** Initializes the applet mvqGUI */
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(mvqGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mvqGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mvqGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mvqGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates an ImageIcon if the path is valid.
     * @param String - resource path
     * @param String - description of the file
     */
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
     
    /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
    
    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        playerPanel = new javax.swing.JPanel();
        pnameLB = new javax.swing.JLabel();
        pwinsLB = new javax.swing.JLabel();
        plossLB = new javax.swing.JLabel();
        pscoreLB = new javax.swing.JLabel();
        pwinsTF = new javax.swing.JTextField();
        plossTF = new javax.swing.JTextField();
        pscoreTF = new javax.swing.JTextField();
        pnameTF = new javax.swing.JTextField();
        quizPanel = new javax.swing.JPanel();
        qNrLB = new javax.swing.JLabel();
        qNrTF = new javax.swing.JTextField();
        qThemaLB = new javax.swing.JLabel();
        qThemaTF = new javax.swing.JTextField();
        qBild = new javax.swing.JLabel();
        qwinsLB = new javax.swing.JLabel();
        qlossLB = new javax.swing.JLabel();
        qscoreLB = new javax.swing.JLabel();
        qwinsTF = new javax.swing.JTextField();
        qlossTF = new javax.swing.JTextField();
        qscoreTF = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        nextBtn = new javax.swing.JButton();
        timer = new javax.swing.JTextField();
        startBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();

        playerPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));

        pnameLB.setText("Name:");

        pwinsLB.setText("Gewonnen:");

        plossLB.setText("Verloren:");

        pscoreLB.setText("Score:");

        pwinsTF.setEditable(false);
        pwinsTF.setText("jTextField1");

        plossTF.setEditable(false);
        plossTF.setText("jTextField2");

        pscoreTF.setEditable(false);
        pscoreTF.setText("jTextField3");

        pnameTF.setEditable(false);
        pnameTF.setText("jTextField4");

        javax.swing.GroupLayout playerPanelLayout = new javax.swing.GroupLayout(playerPanel);
        playerPanel.setLayout(playerPanelLayout);
        playerPanelLayout.setHorizontalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(pwinsLB)
                        .addGap(18, 18, 18)
                        .addComponent(pwinsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(plossLB)
                        .addGap(18, 18, 18)
                        .addComponent(plossTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(pscoreLB)
                        .addGap(18, 18, 18)
                        .addComponent(pscoreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(pnameLB)
                        .addGap(18, 18, 18)
                        .addComponent(pnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        playerPanelLayout.setVerticalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnameLB)
                    .addComponent(pnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwinsLB)
                    .addComponent(plossLB)
                    .addComponent(pscoreLB)
                    .addComponent(pwinsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plossTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pscoreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        quizPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));

        qNrLB.setText("Quiz-Nr.:");

        qNrTF.setEditable(false);
        qNrTF.setText("jTextField5");

        qThemaLB.setText("jLabel6");

        qThemaTF.setEditable(false);
        qThemaTF.setText("jTextField6");

        qBild.setIcon(new javax.swing.ImageIcon(getScaledImage(createImageIcon("pics/image004.jpg").getImage(), 310, 170)));
        qBild.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));

        qwinsLB.setText("Gewonnen:");

        qlossLB.setText("Verloren:");

        qscoreLB.setText("Score:");

        qwinsTF.setEditable(false);
        qwinsTF.setText("jTextField7");

        qlossTF.setEditable(false);
        qlossTF.setText("jTextField8");

        qscoreTF.setEditable(false);
        qscoreTF.setText("jTextField9");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");

        nextBtn.setText("Weiter");
        nextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nextBtnMouseReleased(evt);
            }
        });

        timer.setEditable(false);
        timer.setText("jTextField10");

        startBtn.setText("Start");
        startBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                startBtnMouseReleased(evt);
            }
        });

        stopBtn.setText("Ende");
        stopBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stopBtnMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout quizPanelLayout = new javax.swing.GroupLayout(quizPanel);
        quizPanel.setLayout(quizPanelLayout);
        quizPanelLayout.setHorizontalGroup(
            quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quizPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quizPanelLayout.createSequentialGroup()
                        .addComponent(qBild, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(quizPanelLayout.createSequentialGroup()
                                .addComponent(startBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(stopBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quizPanelLayout.createSequentialGroup()
                                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))))
                    .addGroup(quizPanelLayout.createSequentialGroup()
                        .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(quizPanelLayout.createSequentialGroup()
                                .addComponent(qNrLB)
                                .addGap(18, 18, 18)
                                .addComponent(qNrTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(quizPanelLayout.createSequentialGroup()
                                .addComponent(qwinsLB)
                                .addGap(18, 18, 18)
                                .addComponent(qwinsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66)
                        .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(quizPanelLayout.createSequentialGroup()
                                .addComponent(qThemaLB)
                                .addGap(18, 18, 18)
                                .addComponent(qThemaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(quizPanelLayout.createSequentialGroup()
                                .addComponent(qlossLB)
                                .addGap(18, 18, 18)
                                .addComponent(qlossTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(qscoreLB)
                                .addGap(24, 24, 24)
                                .addComponent(qscoreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(quizPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addGroup(quizPanelLayout.createSequentialGroup()
                        .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3))
                        .addContainerGap(407, Short.MAX_VALUE))))
            .addGroup(quizPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(nextBtn)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        quizPanelLayout.setVerticalGroup(
            quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quizPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qNrLB)
                    .addComponent(qNrTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qThemaLB)
                    .addComponent(qThemaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qwinsLB)
                    .addComponent(qlossLB)
                    .addComponent(qscoreLB)
                    .addComponent(qwinsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qlossTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qscoreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quizPanelLayout.createSequentialGroup()
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(quizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startBtn)
                            .addComponent(stopBtn)))
                    .addComponent(qBild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(quizPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(quizPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nextBtnMouseReleased

    private void startBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_startBtnMouseReleased

    private void stopBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopBtnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_stopBtnMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton nextBtn;
    private javax.swing.JPanel playerPanel;
    private javax.swing.JLabel plossLB;
    private javax.swing.JTextField plossTF;
    private javax.swing.JLabel pnameLB;
    private javax.swing.JTextField pnameTF;
    private javax.swing.JLabel pscoreLB;
    private javax.swing.JTextField pscoreTF;
    private javax.swing.JLabel pwinsLB;
    private javax.swing.JTextField pwinsTF;
    private javax.swing.JLabel qBild;
    private javax.swing.JLabel qNrLB;
    private javax.swing.JTextField qNrTF;
    private javax.swing.JLabel qThemaLB;
    private javax.swing.JTextField qThemaTF;
    private javax.swing.JLabel qlossLB;
    private javax.swing.JTextField qlossTF;
    private javax.swing.JLabel qscoreLB;
    private javax.swing.JTextField qscoreTF;
    private javax.swing.JPanel quizPanel;
    private javax.swing.JLabel qwinsLB;
    private javax.swing.JTextField qwinsTF;
    private javax.swing.JButton startBtn;
    private javax.swing.JButton stopBtn;
    private javax.swing.JTextField timer;
    // End of variables declaration//GEN-END:variables
}