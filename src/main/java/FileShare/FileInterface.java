package FileShare;

import java.awt.FileDialog;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileInterface extends javax.swing.JFrame {
    String FileName = "";
    Clipboard Clipboard = getToolkit().getSystemClipboard();
    
    public FileInterface() {
        initComponents();  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        NewButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        OpenButton = new javax.swing.JButton();
        ShareButton = new javax.swing.JButton();
        ConvertButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NewFile = new javax.swing.JMenuItem();
        OpenFile = new javax.swing.JMenuItem();
        ShareFile = new javax.swing.JMenuItem();
        SaveFile = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        CutText = new javax.swing.JMenuItem();
        CopyText = new javax.swing.JMenuItem();
        PasteText = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(80000, 600));

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        NewButton.setText("New");
        NewButton.addActionListener(this::NewButtonActionPerformed);

        SaveButton.setText("Save");
        SaveButton.addActionListener(this::SaveButtonActionPerformed);

        OpenButton.setText("Open");
        OpenButton.addActionListener(this::OpenButtonActionPerformed);

        ShareButton.setText("Share");
        ShareButton.addActionListener(this::ShareButtonActionPerformed);

        ConvertButton.setText("Convert");
        ConvertButton.addActionListener(this::ConvertButtonActionPerformed);

        ExitButton.setText("Exit");
        ExitButton.addActionListener(this::ExitButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(NewButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShareButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConvertButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewButton)
                    .addComponent(SaveButton)
                    .addComponent(OpenButton)
                    .addComponent(ShareButton)
                    .addComponent(ConvertButton)
                    .addComponent(ExitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        FileMenu.setText("File");

        NewFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        NewFile.setText("New");
        NewFile.addActionListener(this::NewFileActionPerformed);
        FileMenu.add(NewFile);

        OpenFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenFile.setText("Open");
        OpenFile.addActionListener(this::OpenFileActionPerformed);
        FileMenu.add(OpenFile);

        ShareFile.setText("Share");
        ShareFile.addActionListener(this::ShareFileActionPerformed);
        FileMenu.add(ShareFile);

        SaveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveFile.setText("Save");
        SaveFile.addActionListener(this::SaveFileActionPerformed);
        FileMenu.add(SaveFile);

        Exit.setText("Exit");
        Exit.addActionListener(this::ExitActionPerformed);
        FileMenu.add(Exit);

        jMenuBar1.add(FileMenu);

        EditMenu.setText("Edit");
        jMenuBar1.add(EditMenu);
        setJMenuBar(jMenuBar1);

        CutText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        CutText.setText("Cut");
        CutText.addActionListener(this::CutTextActionPerformed);
        EditMenu.add(CutText);

        CopyText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CopyText.setText("Copy");
        CopyText.addActionListener(this::CopyTextActionPerformed);
        EditMenu.add(CopyText);

        PasteText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        PasteText.setText("Paste");
        PasteText.addActionListener(this::PasteTextActionPerformed);
        EditMenu.add(PasteText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFileActionPerformed
        newF();
    }//GEN-LAST:event_NewFileActionPerformed

    private void OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileActionPerformed
        openF();     
    }//GEN-LAST:event_OpenFileActionPerformed

    private void SaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileActionPerformed
        saveF();
    }//GEN-LAST:event_SaveFileActionPerformed
    
    private void ShareFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShareFileActionPerformed
      shareF();
    }//GEN-LAST:event_ShareFileActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerforme
        dispose();
    }//GEN-LAST:event_ExitActionPerformed
     
    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        newF();
    }//GEN-LAST:event_NewButtonActionPerformed

    private void OpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenButtonActionPerformed  
        openF();
    }//GEN-LAST:event_OpenButtonActionPerformed
    
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        saveF();
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ShareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShareButtonActionPerformed
        shareF();
    }//GEN-LAST:event_ShareButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
       dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed
    
    private void ConvertButtonActionPerformed(java.awt.event.ActionEvent evt){
        JOptionPane.showMessageDialog(rootPane, "This Option is Coming Soon!");
    }

    private void CutTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutTextActionPerformed
        String TextCut = TextArea.getSelectedText();
        StringSelection CutSelection = new StringSelection(TextCut);
        Clipboard.setContents(CutSelection, CutSelection);
        TextArea.replaceRange("",TextArea.getSelectionStart(),TextArea.getSelectionEnd());
    }//GEN-LAST:event_CutTextActionPerformed

    private void CopyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyTextActionPerformed
        String TextCopy = TextArea.getSelectedText();
        StringSelection CopySelection = new StringSelection(TextCopy);
        Clipboard.setContents(CopySelection, CopySelection);
    }//GEN-LAST:event_CopyTextActionPerformed

    private void PasteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteTextActionPerformed
       try{
           Transferable TextPaste = Clipboard.getContents(this);
           String Sel = (String) TextPaste.getTransferData(DataFlavor.stringFlavor);
           TextArea.replaceRange(Sel,TextArea.getSelectionStart(),TextArea.getSelectionEnd());
       }
       catch(UnsupportedFlavorException | IOException e){
           System.out.println("Did not work");
       }
    }//GEN-LAST:event_PasteTextActionPerformed
    
    private void saveF () {
        FileDialog fileDialog = new FileDialog(this, "Save File ", FileDialog.SAVE);
        File file = new File(FileName);
        if(file.exists()){
            try (FileWriter fileWriter = new FileWriter(FileName)) {
                fileWriter.write(TextArea.getText());
                setTitle(FileName); 
            } catch (IOException ex) {
                Logger.getLogger(FileInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            fileDialog.setVisible(true);
            if(fileDialog.getFile() != null){
            FileName = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(FileName);
            }
            
            try{
                try (FileWriter fileWriter = new FileWriter(FileName)) {
                    fileWriter.write(TextArea.getText());
                    setTitle(FileName);
                }            
            }        
            catch(IOException e){
                System.out.println("File not found");
            }           
        }
    } 
    private void openF () {
        FileDialog fileDialog = new FileDialog(this, "Open File ", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if(fileDialog.getFile() != null){
            if (FileName.endsWith(".encrypted")){
                Crypto.Decrypt();
            }
            FileName = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(FileName);
        }
        try{
            try (BufferedReader reader = new BufferedReader (new FileReader(FileName))) {
                StringBuilder sb = new StringBuilder();
                String line;
                //    String key = null;
                //     Crypto.fileProcessor(Cipher.DECRYPT_MODE,key,encryptedFile,decryptedFile);
                while((line = reader.readLine()) != null){
                    sb.append(line).append("\n");
                    TextArea.setText(sb.toString());
                }
            }
        }
        catch (IOException e){
            System.out.println(e);   
        }    
    }
    private void shareF () {
        Selection nextpage = new Selection();
        nextpage.setVisible(true);
        dispose();
    }
    private void newF() {
        TextArea.setText("DEMO TEXT TO BE REPLACED");
        setTitle("Untitled");
        FileName = "";    
    }

    void OpenFileToEdit(File file, String filename) {
        setTitle(filename);      
        try{
            try (BufferedReader reader = new BufferedReader (new FileReader(file))) {
                StringBuilder builder = new StringBuilder();
                String line;
                while((line = reader.readLine()) != null){
                    builder.append(line).append("\n");
                    TextArea.setText(builder.toString());
                }
            }
        }
        catch (IOException e){
            System.out.println("File Not Found ");
        }          
    }

    public void buildInterface() {
        this.setBounds(0,0,700,500);
        this.setTitle("SecureShare");    
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConvertButton;
    private javax.swing.JMenuItem CopyText;
    private javax.swing.JMenuItem CutText;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JButton ExitButton;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JButton NewButton;
    private javax.swing.JMenuItem NewFile;
    private javax.swing.JButton OpenButton;
    private javax.swing.JMenuItem OpenFile;
    private javax.swing.JMenuItem PasteText;
    private javax.swing.JButton SaveButton;
    private javax.swing.JMenuItem SaveFile;
    private javax.swing.JButton ShareButton;
    private javax.swing.JMenuItem ShareFile;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables 
    
}