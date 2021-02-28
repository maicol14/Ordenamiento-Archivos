package Vista;

import javax.swing.JFileChooser;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import Controlador.MetodoOrdenamiento;

public class Vista extends javax.swing.JFrame {

	
	MetodoOrdenamiento m = new MetodoOrdenamiento();
    /**
     * Crear el formulario
     */
    public Vista() {
        initComponents();
    }
    
    JFileChooser seleccionar = new JFileChooser(); // Se crea el objeto.
    File archivo; 


    /**
     * Este m�todo se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este c�digo. El contenido de este m�todo es siempre
     * Regenerado por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        btnguardar = new javax.swing.JButton();
        btnabrir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnordenar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnguardar.setText("Guardar archivo");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnabrir.setText("Abrir  archivo");
        btnabrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnabrirActionPerformed(evt);
            }
        });

        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);

        jLabel1.setText("ORDENAMIENTO");

        btnordenar.setText("Ordenar");
        btnordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(btnabrir, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar)
                        .addGap(10, 10, 10)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnabrir)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnordenar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {// condicional para  general  si el archivo  fue guardado  
            archivo = seleccionar.getSelectedFile();
            if ((archivo.getName().endsWith("txt")) || (archivo.getName().endsWith("csv"))) {//condicional para que eliga si es archivo txt o csc
                String Documento = txtarea.getText();
                String mensaje = m.GuardarArchivo(archivo, Documento);
                if (mensaje != null) { //si es compatible  lo guarda 
                    JOptionPane.showMessageDialog(null, mensaje);
                } else {//si no es compatible  genera  un mensaje no compatible 
                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Guardar documento de txt o csv");
            }

        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnabrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabrirActionPerformed
        // TODO add your handling code here:
        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {// condicional para  abrir  el  archivo  con JfielChooser
            archivo = seleccionar.getSelectedFile();// Seleccionar archivo
            if (archivo.canRead()) {// abrir el archivo 
                if ((archivo.getName().endsWith("txt")) || (archivo.getName().endsWith("csv"))) {// condicional para   que abra solo archivos txt o csv
                    String documento = m.AbrirArchivo(archivo);
                    txtarea.setText(documento);
                } else {// valida si es archivo  txt  o csv  si no lo es  genera un mensaje  archivo no compatible 
                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }
            }
        }
    }//GEN-LAST:event_btnabrirActionPerformed

    private void btnordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordenarActionPerformed
        // TODO add your handling code here:

        txtarea.setText(" ");// mostrar  el ordenamiento en un tex area 
    	int aux;// variable auxiliar para validar el metodo ordenamiento 
        String vector[] = m.AbrirArchivo(archivo).split(" "); // se guarda  en un arreglo  todo el contenido del archivo en una varaible vector  
        int[] valores = new int[vector.length]; // se genera un arreglo con el nombre vector para mostarlo
        for (int i = 0; i < vector.length; i++) {// for para mostrar el recorrido 
            valores[i] = Integer.parseInt(vector[i]);
        }

        String seleccion = (JOptionPane.showInputDialog(null, "Seleccione el ordenamiento", "Ordenamiento",
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Ascendente", "Descendente"}, "Seleccionar")).toString();//jptionpane para generar
        // una ventana de obciones para elegir si es Ascendente o decendente 

        if (seleccion == "Ascendente") {// condicional para elegir si es Acendente 
            for (int i = 0; i < vector.length - 1; i++) { // metodo de burbuja para ordenar  Ascendentemente 
                for (int j = i + 1; j < vector.length; j++) {
                    if (valores[i] > valores[j]) {
                        aux = valores[j];
                        valores[j] = valores[i];
                        valores[i] = aux;
                    }
                }
            }
            
            // Imprime el array ascendente. 
            StringBuffer documento = new StringBuffer(); 
            for (int i = 0; i < valores.length; i++) {
                vector[i] = Integer.toString(valores[i]);
                documento = documento.append(vector[i]+" ");
            }
           
            String ascendente = documento.toString();
           txtarea.setText(ascendente);
            
        } else {// si eliges la opcion decendente  genera este   metodo  
            for (int i = 0; i < vector.length - 1; i++) { // for anidado  para  leer el vector 
                for (int j = i + 1; j < vector.length; j++) {
                    if (valores[i] < valores[j]) { //condicional para  ordenar los numeros desendentemente 
                        aux = valores[j];
                        valores[j] = valores[i];
                        valores[i] = aux;
                    }
                }
            }

            // Imprimimos el array descendente. 
            StringBuffer documento = new StringBuffer();
            for (int i = 0; i < valores.length; i++) { // for para  imprimir los numeros ingresados ya ordenados
                vector[i] = Integer.toString(valores[i]);
                documento = documento.append(vector[i]+" ");
            }
           
            String ascendente = documento.toString();
            txtarea.setText(ascendente);// muestra los numeros ordenados  decendentemente  en el tex area  
        }
//John 
    }//GEN-LAST:event_btnordenarActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabrir;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnordenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txtarea;
    // End of variables declaration//GEN-END:variables
}
