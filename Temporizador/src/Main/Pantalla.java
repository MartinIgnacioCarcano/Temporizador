package Main;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Pantalla extends javax.swing.JFrame {

    private Timer t;
    private ActionListener ac;
    private int x;

    public Pantalla() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        IniciarBtn = new javax.swing.JButton();
        ProgresoBar = new javax.swing.JProgressBar();
        TextoLbl = new javax.swing.JLabel();
        Separdor = new javax.swing.JSeparator();
        PausaBtn = new javax.swing.JButton();
        MinutosBox = new javax.swing.JComboBox<>();
        ReiniciarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IniciarBtn.setText("Iniciar");
        IniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(IniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 80, -1));

        ProgresoBar.setMaximum(25);
        jPanel1.add(ProgresoBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 270, 40));

        TextoLbl.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TextoLbl.setText("Temporizador");
        jPanel1.add(TextoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Separdor.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(Separdor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 42, 270, -1));

        PausaBtn.setText("Pausar");
        PausaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PausaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(PausaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 110, -1));

        MinutosBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5 min", "10 min", "25 min", "30 min" }));
        jPanel1.add(MinutosBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        ReiniciarBtn.setText("Reiniciar");
        ReiniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ReiniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarBtnActionPerformed
        int num = 0;
        x=0;
        ProgresoBar.setValue(0);
        switch(MinutosBox.getSelectedIndex()){
            case 0 -> num = 5;
            case 1 -> num = 10;
            case 2 -> num = 25;
            case 3 -> num = 30;
        }
        ProgresoBar.setMaximum(num);
        final int aux = num;            
        /*
            dentro del action listener se tienen 
            que usar variables locales o si son 
            globales deben ser finales
        */
        ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = x + 1;
                ProgresoBar.setValue(x);
                if(aux==x){
                    JOptionPane.showMessageDialog(null, "Tiempo Finalizado");
                    
                }
            }
        };
        t = new Timer(60000, ac);
        t.start();
    }//GEN-LAST:event_IniciarBtnActionPerformed

    private void PausaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PausaBtnActionPerformed
        if(t.isRunning()==true){
            t.stop();
            PausaBtn.setText("Reanudar");
        }else{
            t.start();
            PausaBtn.setText("Pausar");
        }
    }//GEN-LAST:event_PausaBtnActionPerformed

    private void ReiniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarBtnActionPerformed
        t.removeActionListener(ac);
        ProgresoBar.setValue(0);
    }//GEN-LAST:event_ReiniciarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IniciarBtn;
    private javax.swing.JComboBox<String> MinutosBox;
    private javax.swing.JButton PausaBtn;
    private javax.swing.JProgressBar ProgresoBar;
    private javax.swing.JButton ReiniciarBtn;
    private javax.swing.JSeparator Separdor;
    private javax.swing.JLabel TextoLbl;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
}
