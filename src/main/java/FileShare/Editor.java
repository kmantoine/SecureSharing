package FileShare;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Editor extends javax.swing.JInternalFrame {
    String FileName = "";
    Clipboard Clipboard = getToolkit().getSystemClipboard();
    
    public Editor() {
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
        DecryptButton = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(80000, 600));

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);
        TextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                try {
                    TextAreaKeyPressed(evt);
                } catch (IOException | UnsupportedFlavorException ex) {
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

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
        
        DecryptButton.setText("Decrypt");
        DecryptButton.addActionListener(this::DecryptButtonActionPerformed);

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
                .addComponent(DecryptButton)
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
                    .addComponent(DecryptButton)
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
    protected void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerforme
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
    protected void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
       dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed
    private void DecryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptButtonActionPerformed
        JFileChooser files = new JFileChooser();
        files.setCurrentDirectory(new java.io.File("Shared/"));
        files.addActionListener((ActionEvent e) -> {
            if (JFileChooser.CANCEL_SELECTION.equals(e.getActionCommand())) {
                files.cancelSelection();
            } 
            else if (JFileChooser.APPROVE_SELECTION.equals(e.getActionCommand())) {
                if(files.getSelectedFile() != null){
                    FileName = files.getSelectedFile().getPath();
                    //Crypto.Decrypt();
                    setTitle(Crypto.decryptedFile.getPath());
                    FileName = Crypto.decryptedFile.getPath();
                }
                try{
                    try (BufferedReader reader = new BufferedReader (new FileReader(FileName))) {
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while((line = reader.readLine()) != null){
                            sb.append(line).append("\n");
                            TextArea.setText(sb.toString());
                        }
                    }
                }
                catch (IOException ex){
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        files.addChoosableFileFilter(new FileNameExtensionFilter("Documents", "docx", "doc", "ppt", "pptx", "xlsx", "xls"));
        files.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        files.addChoosableFileFilter(new FileNameExtensionFilter("Media Files", "mp3", "mp4", "mov", "avi", "aac", "m4a"));
        files.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
        files.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
        files.showOpenDialog(rootPane.getContentPane());
    }//GEN-LAST:event_DecryptButtonActionPerformed
    private void ConvertButtonActionPerformed(java.awt.event.ActionEvent evt){
        JOptionPane.showMessageDialog(rootPane, "This Option is Coming Soon!");
    }
    
    private void TextAreaKeyPressed(java.awt.event.KeyEvent evt) throws IOException, UnsupportedFlavorException {
        if ((evt.getKeyCode() == KeyEvent.VK_C) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            cutCopyPaste("copy");
        }
        else if ((evt.getKeyCode() == KeyEvent.VK_X) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            cutCopyPaste("cut");
        }
        else if ((evt.getKeyCode() == KeyEvent.VK_V) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            cutCopyPaste("paste");
        }
    }    
    private void cutCopyPaste (String what) throws UnsupportedFlavorException, IOException {
        switch (what) {
            case "cut":
                String TextCut = TextArea.getSelectedText();
                StringSelection CutSelection = new StringSelection(TextCut);
                Clipboard.setContents(CutSelection, CutSelection);
                TextArea.replaceRange("",TextArea.getSelectionStart(),TextArea.getSelectionEnd());
                break;
            case "copy":
                String TextCopy = TextArea.getSelectedText();
                StringSelection CopySelection = new StringSelection(TextCopy);
                Clipboard.setContents(CopySelection, CopySelection);
                break;
            case "paste":
                Transferable TextPaste = Clipboard.getContents(this);
                String Sel = (String) TextPaste.getTransferData(DataFlavor.stringFlavor);        
                TextArea.replaceRange(Sel,TextArea.getSelectionStart(),TextArea.getSelectionEnd());
                break;
        }
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
       catch(UnsupportedFlavorException | IOException ex){
           Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_PasteTextActionPerformed
    
    private void saveF () {
        File file = new File(FileName);
        if(file.exists()){
            try (FileWriter fileWriter = new FileWriter(FileName)) {
                fileWriter.write(TextArea.getText());
                setTitle(FileName); 
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JFileChooser files = new JFileChooser();
            files.addActionListener((ActionEvent e) -> {
                if (JFileChooser.CANCEL_SELECTION.equals(e.getActionCommand())) {
                    files.cancelSelection();
                } 
                else if (JFileChooser.APPROVE_SELECTION.equals(e.getActionCommand())) {
                    if(files.getSelectedFile() != null){
                        FileName = files.getSelectedFile().getPath().concat(".txt");
                        setTitle(FileName);
                    }
                    try {
                        try (FileWriter fileWriter = new FileWriter(FileName)) {
                            fileWriter.write(TextArea.getText());
                            setTitle(FileName);
                        }            
                    }        
                    catch(IOException ex){
                        Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            files.addChoosableFileFilter(new FileNameExtensionFilter("Documents", "docx", "doc", "ppt", "pptx", "xlsx", "xls"));
            files.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            files.addChoosableFileFilter(new FileNameExtensionFilter("Media Files", "mp3", "mp4", "mov", "avi", "aac", "m4a"));
            files.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
            files.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
            files.showSaveDialog(rootPane.getContentPane());        
        }
    } 
    private void openF () {
        JFileChooser files = new JFileChooser();
        files.addActionListener((ActionEvent e) -> {
            if (JFileChooser.CANCEL_SELECTION.equals(e.getActionCommand())) {
                files.cancelSelection();
            } 
            else if (JFileChooser.APPROVE_SELECTION.equals(e.getActionCommand())) {
                if(files.getSelectedFile() != null){
                    FileName = files.getSelectedFile().getPath();
                    setTitle(FileName);
                }
                try{
                    try (BufferedReader reader = new BufferedReader (new FileReader(FileName))) {
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while((line = reader.readLine()) != null){
                            sb.append(line).append("\n");
                            TextArea.setText(sb.toString());
                        }
                    }
                }
                catch (IOException ex){
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        files.addChoosableFileFilter(new FileNameExtensionFilter("Documents", "docx", "doc", "ppt", "pptx", "xlsx", "xls"));
        files.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        files.addChoosableFileFilter(new FileNameExtensionFilter("Media Files", "mp3", "mp4", "mov", "avi", "aac", "m4a"));
        files.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
        files.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
        files.showOpenDialog(rootPane.getContentPane());
    }
    private void shareF () {
        Share nextpage = new Share();
        if (nextpage.isShowing()) {
            toFront();
        }
        else {
            SecureShare.addToDesktop(nextpage);
            nextpage.setVisible(true);
        }
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
        catch (IOException ex){
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }

    public void buildInterface() {
        setBounds(30,50,700,500);
        setTitle("File Editor");
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setFrameIcon(new javax.swing.ImageIcon("resources/Grambling_State_Tigers_logo.png"));
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    public javax.swing.JTextArea TextArea;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton DecryptButton;
    // End of variables declaration//GEN-END:variables 
    
}