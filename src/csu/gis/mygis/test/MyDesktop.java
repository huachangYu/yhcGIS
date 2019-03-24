package csu.gis.mygis.test;

import csu.gis.mygis.map.GLayer;
import csu.gis.mygis.ui.MapControl;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyDesktop extends javax.swing.JFrame {

    public MyDesktop() {
        super("yhcGIS");
        initComponents();
        setBounds(100, 50, 600, 480);
        mapControl.setBuddy(mapMousePosition);
        contentControl.setBuddy(mapControl);
        mapControl.setBuddy(jMenuPaint);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        contentControl1 = new csu.gis.mygis.ui.ContentControl();
        contentControl2 = new csu.gis.mygis.ui.ContentControl();
        contentControl3 = new csu.gis.mygis.ui.ContentControl();
        contentControl4 = new csu.gis.mygis.ui.ContentControl();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentControl = new csu.gis.mygis.ui.ContentControl();
        mapControl = new csu.gis.mygis.ui.MapControl();
        jToolBar1 = new javax.swing.JToolBar();
        btnZoomIn = new javax.swing.JButton();
        btnZoomOut = new javax.swing.JButton();
        btnRepaint = new javax.swing.JButton();
        btnDragged = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        mapMousePosition = new csu.gis.mygis.ui.MapMousePosition();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuItemOpen = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemExit = new javax.swing.JMenuItem();
        jMenuPaint = new javax.swing.JMenu();
        menuDrawPoint = new javax.swing.JRadioButtonMenuItem();
        menuDrawLine = new javax.swing.JRadioButtonMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane2.setToolTipText("");

        contentControl.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(contentControl);

        jSplitPane2.setLeftComponent(jScrollPane1);

        mapControl.setBackground(new java.awt.Color(255, 255, 255));
        mapControl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout mapControlLayout = new javax.swing.GroupLayout(mapControl);
        mapControl.setLayout(mapControlLayout);
        mapControlLayout.setHorizontalGroup(
            mapControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        mapControlLayout.setVerticalGroup(
            mapControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(mapControl);

        jToolBar1.setRollover(true);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnZoomIn.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        btnZoomIn.setText("放大");
        btnZoomIn.setFocusable(false);
        btnZoomIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomInActionPerformed(evt);
            }
        });
        jToolBar1.add(btnZoomIn);

        btnZoomOut.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        btnZoomOut.setText("缩小");
        btnZoomOut.setFocusable(false);
        btnZoomOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomOutActionPerformed(evt);
            }
        });
        jToolBar1.add(btnZoomOut);

        btnRepaint.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        btnRepaint.setText("重绘");
        btnRepaint.setFocusable(false);
        btnRepaint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRepaint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRepaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepaintActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRepaint);

        btnDragged.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        btnDragged.setSelected(true);
        btnDragged.setText("拖动");
        btnDragged.setFocusable(false);
        btnDragged.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDragged.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDragged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDraggedActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDragged);

        mapMousePosition.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mapMousePosition.setText("纬度：0.0000000 经度：0.0000000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapMousePosition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapMousePosition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N

        jMenu1.setText("文件");
        jMenu1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jMenuItem1.setText("新建");
        jMenu1.add(jMenuItem1);

        menuItemOpen.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        menuItemOpen.setText("打开");
        menuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemOpen);

        jMenuItem4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jMenuItem4.setText("保存");
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator1);

        menuItemExit.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        menuItemExit.setText("退出");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemExit);

        jMenuBar1.add(jMenu1);

        jMenuPaint.setText("绘制");
        jMenuPaint.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N

        menuDrawPoint.setText("点");
        menuDrawPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDrawPointActionPerformed(evt);
            }
        });
        jMenuPaint.add(menuDrawPoint);

        menuDrawLine.setText("线");
        menuDrawLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDrawLineActionPerformed(evt);
            }
        });
        jMenuPaint.add(menuDrawLine);

        jMenuBar1.add(jMenuPaint);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane2)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSplitPane2)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenActionPerformed
        JFileChooser chooser = new JFileChooser("D:\\biancheng\\java\\MyGIS");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("mygis file", "mygis");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            GLayer Layer = mapControl.loadLayer(chooser.getSelectedFile().getAbsolutePath());
            contentControl.addLayer(Layer);
            mapControl.repaint();
        }
    }//GEN-LAST:event_menuItemOpenActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void btnZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomInActionPerformed
        mapControl.zoomIn(0.5);
    }//GEN-LAST:event_btnZoomInActionPerformed

    private void btnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOutActionPerformed
        mapControl.zoomOut(2);
    }//GEN-LAST:event_btnZoomOutActionPerformed

    private void btnRepaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepaintActionPerformed

    }//GEN-LAST:event_btnRepaintActionPerformed

    private void menuDrawPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDrawPointActionPerformed
        if (menuDrawPoint.isSelected()) {
            mapControl.setCurrentDrawOperation(MapControl.DRAW_POINT);
            menuDrawLine.setSelected(false);
        }
    }//GEN-LAST:event_menuDrawPointActionPerformed

    private void menuDrawLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDrawLineActionPerformed
        if (menuDrawLine.isSelected()) {
            mapControl.setCurrentDrawOperation(MapControl.DRAW_LINESTRING);
            menuDrawPoint.setSelected(false);
        }
    }//GEN-LAST:event_menuDrawLineActionPerformed

    private void btnDraggedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDraggedActionPerformed
        mapControl.setMapDragging(btnDragged.isSelected());
    }//GEN-LAST:event_btnDraggedActionPerformed

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
            java.util.logging.Logger.getLogger(MyDesktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyDesktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyDesktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyDesktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        MyDesktop desktop = new MyDesktop();
        desktop.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDragged;
    private javax.swing.JButton btnRepaint;
    private javax.swing.JButton btnZoomIn;
    private javax.swing.JButton btnZoomOut;
    private csu.gis.mygis.ui.ContentControl contentControl;
    private csu.gis.mygis.ui.ContentControl contentControl1;
    private csu.gis.mygis.ui.ContentControl contentControl2;
    private csu.gis.mygis.ui.ContentControl contentControl3;
    private csu.gis.mygis.ui.ContentControl contentControl4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu jMenuPaint;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToolBar jToolBar1;
    private csu.gis.mygis.ui.MapControl mapControl;
    private csu.gis.mygis.ui.MapMousePosition mapMousePosition;
    private javax.swing.JRadioButtonMenuItem menuDrawLine;
    private javax.swing.JRadioButtonMenuItem menuDrawPoint;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemOpen;
    // End of variables declaration//GEN-END:variables
}
