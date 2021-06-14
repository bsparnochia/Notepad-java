package com.practica.java.notepad;

import com.practica.java.util.files.FileText;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * El block de notas es una herramienta para la apertura,edición y
 * guardado de archivos de texto con extensión '.txt'
 * @author brian
 */
public class Notepad extends javax.swing.JFrame {
    public Notepad() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaTexto = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        MenuItemNuevo = new javax.swing.JMenuItem();
        MenuItemAbrir = new javax.swing.JMenuItem();
        MenuItemGuardar = new javax.swing.JMenuItem();
        MenuOpciones = new javax.swing.JMenu();
        MenuItemInfo = new javax.swing.JMenuItem();
        MenuItemSalir = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notepad");
        setLocation(new java.awt.Point(800, 400));

        txaTexto.setColumns(20);
        txaTexto.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txaTexto.setRows(5);
        jScrollPane1.setViewportView(txaTexto);

        MenuArchivo.setText("Archivo");

        MenuItemNuevo.setText("Nuevo");
        MenuItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNuevoActionPerformed(evt);
            }
        });
        MenuArchivo.add(MenuItemNuevo);

        MenuItemAbrir.setText("Abrir");
        MenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAbrirActionPerformed(evt);
            }
        });
        MenuArchivo.add(MenuItemAbrir);

        MenuItemGuardar.setText("Guardar");
        MenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemGuardarActionPerformed(evt);
            }
        });
        MenuArchivo.add(MenuItemGuardar);

        jMenuBar1.add(MenuArchivo);

        MenuOpciones.setText("Opciones");

        MenuItemInfo.setText("Acerca de");
        MenuItemInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemInfoActionPerformed(evt);
            }
        });
        MenuOpciones.add(MenuItemInfo);

        MenuItemSalir.setText("Salir");
        MenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSalirActionPerformed(evt);
            }
        });
        MenuOpciones.add(MenuItemSalir);

        jMenuBar1.add(MenuOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Finaliza la ejecución del block de notas
     * @param evt se produce al hacer click en menú Opciones>Salir
     */
    private void MenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuItemSalirActionPerformed

    /**
     * Brinda información sobre la versión del block de notas
     * @param evt se produce al hacer click en menú Opciones>Acerca de
     */
    private void MenuItemInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemInfoActionPerformed
        JOptionPane.showMessageDialog(
                this,
                "Bloc de Notas V1.0 \nCreador: Brian Sparnochia\nJunio 2021",
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_MenuItemInfoActionPerformed

    /**
     * Genera un nuevo documento, si el block contiene texto
     * se le preguntará al usuario para proseguir, luego descarta el documento actual
     * @param evt evento producido al hacer click en Archivo>Nuevo
     */
    private void MenuItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNuevoActionPerformed
        if(txaTexto.getText().isEmpty() || txaTexto.getText()==null)return;
        if(JOptionPane.showConfirmDialog(this,"El documento que no haya sido guardado se perderá\n¿Desea continuar?")!=0)return;
        txaTexto.setText("");
    }//GEN-LAST:event_MenuItemNuevoActionPerformed

    /**
     * Guarda el contenido del block de notas en un archivo existente, sino lo crea
     * @param evt Se produce al hacer click en Archivo>Guardar
     */
    private void MenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemGuardarActionPerformed
        JFileChooser fc=new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Texto","txt"));
        fc.showSaveDialog(this);
        //Implementar Guardar y Guardar Como ( funciona para ambos pero si no existe lo guarda sin extension )
        //hay que agregarle la extension a la ruta del FileChooser
        File file=fc.getSelectedFile();
        if(file==null)return;
        new FileText(file).setText(txaTexto.getText());
    }//GEN-LAST:event_MenuItemGuardarActionPerformed

    /**
     * Abre un archivo de texto almacenado en el disco
     * para su edición en el block de notas
     * @param evt Se produce al hacer click en Archivo>Abrir
     */
    private void MenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAbrirActionPerformed
        JFileChooser fc=new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Texto","txt"));
        fc.showOpenDialog(this);
        File file=fc.getSelectedFile();
        if (file==null)return;
        txaTexto.setText(new FileText(file).getText());
    }//GEN-LAST:event_MenuItemAbrirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notepad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenuItem MenuItemAbrir;
    private javax.swing.JMenuItem MenuItemGuardar;
    private javax.swing.JMenuItem MenuItemInfo;
    private javax.swing.JMenuItem MenuItemNuevo;
    private javax.swing.JMenuItem MenuItemSalir;
    private javax.swing.JMenu MenuOpciones;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaTexto;
    // End of variables declaration//GEN-END:variables
}
