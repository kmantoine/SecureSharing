package UserFileInterface;

import FileShare.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Icon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.*;
import javax.swing.filechooser.FileSystemView;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.apache.commons.io.FilenameUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.nio.channels.FileChannel;

/**
 *
 * @author Kerwan Miguel Antoine
 */
public class FileManager extends javax.swing.JInternalFrame {
    
    public static File currentFile;
    private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
    private Desktop desktop = Desktop.getDesktop();
    private FileTableModel fileTableModel;
    private ListSelectionListener listSelectionListener;
    private boolean cellSizesSet = false;
    private int rowIconPadding = 6;
    DefaultTreeModel treeModel;
    TreeSelectionListener treeSelectionListener;

    private ActionListener ActionListener;
    private static long time;
    static long eventMask = AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK;
    
    public FileManager() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButton10 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jPanel10 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jPanel11 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultMutableTreeNode mainFolder = new DefaultMutableTreeNode();
        treeModel = new DefaultTreeModel(mainFolder);

        treeSelectionListener = (TreeSelectionEvent tse) -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)tse.getPath().getLastPathComponent();
            showChildren(node);
            getFileDetails((File)node.getUserObject());
            jTree1.expandRow (tse.getPath().getLastPathComponent().hashCode ());
        };

        File UsrFiles = new File ("User Files/" + DBConnection.name + "/Welcome Folder"); //User folders
        if (!UsrFiles.exists ()) {
            UsrFiles.mkdirs ();
            File welcomeFile = new File (UsrFiles + "/Welcome File.txt");
            try {
                welcomeFile.createNewFile ();
                PrintWriter writer = new PrintWriter(welcomeFile, "UTF-8");
                writer.println("Welcome to SecureShare");
                writer.println("\nWe hope you enjoy our program");
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Error creating new sample folder", ex);
            }
        }

        File[] roots = UsrFiles.getParentFile ().listFiles (new FileFilter() {
            @Override
            public boolean accept(File file) {
                return !file.isHidden();
            }
        });
        for (File subRoots : roots) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(subRoots);
            mainFolder.add( node );
            File[] files = subRoots.listFiles ();

            for (File file : files) {
                if (file.isDirectory()) {
                    node.add(new DefaultMutableTreeNode(file));
                }
            }
        }
        jTree1 = new javax.swing.JTree(treeModel);
        jPanel7 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("File Manager");
        setBounds(new java.awt.Rectangle(150, 50, 150, 0));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Grambling_State_Tigers_logo.png"))); // NOI18N
        setVisible(true);

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel8.setLayout(new java.awt.BorderLayout(5, 5));

        jPanel5.setLayout(new java.awt.BorderLayout(3, 3));

        jToolBar1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 204)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setAutoscrolls(true);
        jToolBar1.setBounds(new java.awt.Rectangle(0, 0, 1155, 33));
        jToolBar1.setMinimumSize(new java.awt.Dimension(1155, 33));
        jToolBar1.setPreferredSize(new java.awt.Dimension(1155, 33));

        jButton1.setText("New");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("Open");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        this.getRootPane().setDefaultButton(jButton2);
        jToolBar1.add(jSeparator1);

        jButton9.setText("Share");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton5.setText("Decrypt");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator2);

        jButton7.setText("Delete");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton8.setText("Copy");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton6.setText("Rename");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton3.setText("Print");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator3);

        jButton4.setText("Convert");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator4);
        jToolBar1.add(jSeparator7);

        jButton10.setText("Exit");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);
        jToolBar1.add(jSeparator5);

        jPanel10.setPreferredSize(new java.awt.Dimension(360, 10));
        jPanel10.setLayout(new java.awt.BorderLayout(3, 3));
        jToolBar1.add(jPanel10);
        jToolBar1.add(jSeparator6);

        jPanel11.setEnabled(false);
        jPanel11.setMinimumSize(new java.awt.Dimension(250, 25));
        jPanel11.setPreferredSize(new java.awt.Dimension(300, 25));
        jPanel11.setLayout(new java.awt.BorderLayout(3, 3));

        jTextField2.setColumns(35);
        jTextField2.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("SEARCH");
        jTextField2.setToolTipText("Search Current Folder");
        jTextField2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, new java.awt.Color(204, 204, 204)));
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.setOpaque(true);
        jTextField2.setRequestFocusEnabled(false);
        jTextField2.setSelectionEnd(0);
        jTextField2.setSelectionStart(0);
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel11.add(jTextField2, java.awt.BorderLayout.CENTER);

        jToolBar1.add(jPanel11);

        jPanel5.add(jToolBar1, java.awt.BorderLayout.NORTH);
        jButton2.setEnabled(desktop.isSupported(Desktop.Action.OPEN));
        jButton3.setEnabled(desktop.isSupported(Desktop.Action.PRINT));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
        jPanel1.setLayout(new java.awt.BorderLayout(4, 2));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 2, 2));

        jLabel1.setText("File");
        jLabel1.setEnabled(false);
        jPanel2.add(jLabel1);

        jLabel2.setText("Path");
        jLabel2.setEnabled(false);
        jPanel2.add(jLabel2);

        jLabel3.setText("Modified");
        jLabel3.setEnabled(false);
        jPanel2.add(jLabel3);

        jLabel4.setText("Size");
        jLabel4.setEnabled(false);
        jPanel2.add(jLabel4);

        jLabel5.setText("Type");
        jLabel5.setEnabled(false);
        jPanel2.add(jLabel5);

        jPanel1.add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel3.setLayout(new java.awt.GridLayout(0, 1, 2, 2));
        jPanel3.add(jLabel6);

        jTextField1.setEditable(false);
        jTextField1.setColumns(5);
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.setRequestFocusEnabled(false);
        jTextField1.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jTextField1);
        jPanel3.add(jLabel7);
        jPanel3.add(jLabel8);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jRadioButton2.setText("File");
        jRadioButton2.setEnabled(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jRadioButton2, java.awt.BorderLayout.LINE_START);

        jRadioButton1.setText("Directory");
        jRadioButton1.setEnabled(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jRadioButton1, java.awt.BorderLayout.CENTER);

        jProgressBar1.setVisible (false);
        jProgressBar1.setString("LOADING");
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setBackground (Color.blue);
        jProgressBar1.setForeground(Color.orange);
        UIManager.put("ProgressBar.background", Color.ORANGE);
        UIManager.put("ProgressBar.foreground", Color.BLUE);
        jPanel4.add(jProgressBar1, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel4);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel5, java.awt.BorderLayout.NORTH);

        jSplitPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 1, true), "Select a file", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(102, 153, 255))); // NOI18N
        jSplitPane1.setDividerLocation(230);
        jSplitPane1.setDividerSize(7);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(454, 202));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setDragEnabled(true);
        jTable1.setShowGrid(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int row = jTable1.getSelectionModel().getLeadSelectionIndex();
                RowSorter sorter = jTable1.getRowSorter();
                try {
                    if ( sorter != null){
                        row = sorter.convertRowIndexToModel(row);
                    }
                    getFileDetails( ((UserFileInterface.FileTableModel)jTable1.getModel()).getFile(row) );
                }
                catch (IndexOutOfBoundsException ex) {  }
            }
        };

        jTable1.getSelectionModel ().addListSelectionListener (listSelectionListener);

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel6);

        jPanel9.setLayout(new java.awt.BorderLayout(3, 3));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 289));

        jTree1.setAutoscrolls(true);
        jTree1.setFocusCycleRoot(true);
        jTree1.setRootVisible(false);
        jTree1.addTreeSelectionListener(treeSelectionListener);
        jTree1.setCellRenderer(new FileTreeCellRenderer());
        jTree1.expandRow(0);
        jTree1.setExpandsSelectedPaths (true);
        jTree1.setRowHeight(25);
        jTree1.setScrollsOnExpand(true);
        jTree1.setSelectionRows(new int[] {0});
        jTree1.setShowsRootHandles(true);
        jScrollPane1.setViewportView(jTree1);
        Toolkit.getDefaultToolkit().addAWTEventListener((AWTEvent e) -> {
            time = System.currentTimeMillis();
        }, eventMask);

        time = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            while (true) {
                if (System.currentTimeMillis() - time > 10000) {
                    this.repaint ();
                }
            }
        });
        thread.start();

        jTree1.requestFocusInWindow ();

        jPanel9.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jPanel9);

        jPanel8.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.BorderLayout(3, 3));
        jPanel8.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        System.exit (0);
    }//GEN-LAST:event_jButton10ActionPerformed
//CONVERT A FILE
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "This option is not yet available!", "Coming Soon!", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
    }//GEN-LAST:event_jButton4ActionPerformed
//PRINT A FILE
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (currentFile==null) {
            JOptionPane.showMessageDialog(rootPane, "Please select a File or Directory", "Nothing Selected", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
            return;
        }
        try {
            desktop.print(currentFile);
        } catch(IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Error Printing", ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
//OPEN A FILE
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        openFile ();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jRadioButton1.setSelected (false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jRadioButton2.setSelected (false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed
//SHARE A FILE
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (currentFile==null) {
            JOptionPane.showMessageDialog(rootPane, "Please select a File or Directory", "Nothing Selected", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
            return;
        }
        SecureShare.addToDesktop (SecureShare.share = new Share());
    }//GEN-LAST:event_jButton9ActionPerformed
//CREATE A NEW FILE
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (currentFile==null) {
            JOptionPane.showMessageDialog(rootPane, "Please select a Directory", "Nothing Selected", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
            return;
        }
        JPanel panel = new JPanel(new BorderLayout(3,3));
        JPanel panel1 = new JPanel(new GridLayout(1,0,2,2));
        JRadioButton newFile = new JRadioButton("File");
        JRadioButton newDirectory = new JRadioButton("Directory", true);
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(newFile);
        buttons.add(newDirectory);
        panel1.add( newFile );
        panel1.add( newDirectory );
        JTextField newFilename = new JTextField(15);
        panel.add( new JLabel("New Filename: "), BorderLayout.WEST );
        panel.add( newFilename );
        panel.add( panel1, BorderLayout.SOUTH );

        int result = JOptionPane.showConfirmDialog(rootPane, panel,"Create a New File", JOptionPane.OK_CANCEL_OPTION, HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
        if (result==JOptionPane.OK_OPTION) {
            try {
                boolean created;
                File parentFile = currentFile;
                if (!parentFile.isDirectory()) {
                    parentFile = parentFile.getParentFile();
                }
                File file = new File( parentFile, newFilename.getText() );
                if (newFile.isSelected()) {
                    created = file.createNewFile();
                } else {
                    created = file.mkdir();
                }
                if (created) {
                    TreePath parentPath = findTreePath(parentFile);
                    DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)parentPath.getLastPathComponent();
                    if (file.isDirectory()) {
                        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(file);
                        TreePath currentPath = findTreePath(currentFile);
                        treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
                    }
                    showChildren(parentNode);
                    jPanel8.repaint();
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "The new file could not be created", "Error Creating File", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
                }
            } catch(IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Error creating new file", ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
//DELETE A FILE
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (currentFile==null) {
            JOptionPane.showMessageDialog(rootPane, "Please select a File or Directory", "Nothing Selected", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
            return;
        }
        String name;
        if (currentFile.isFile ()) {
            String removeExt = currentFile.getName ().substring (currentFile.getName ().lastIndexOf ("."));
            name = currentFile.getName ().replace (removeExt, "");
        }
        else {
            name = currentFile.getName ();
        }
        int options = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete \"" + name + "\"?", "Delete File", JOptionPane.OK_CANCEL_OPTION, HEIGHT,  new ImageIcon(getClass().getResource("/secureShare_logo.png")));
        if (options==JOptionPane.OK_OPTION) {
                boolean directory = currentFile.isDirectory();
                if (currentFile.delete()) {
                    TreePath parentPath = findTreePath(currentFile.getParentFile());
                    DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)parentPath.getLastPathComponent();
                    if (directory) {
                        TreePath currentPath = findTreePath(currentFile);
                        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)currentPath.getLastPathComponent();
                        treeModel.removeNodeFromParent(currentNode);
                    }
                    showChildren(parentNode);
                    jPanel8.repaint();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "The file could not be deleted", "Error Deleting File", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));

                }
        }
    }//GEN-LAST:event_jButton7ActionPerformed
//RENAME A FILE
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (currentFile==null) {
            JOptionPane.showMessageDialog(rootPane, "Please select a File or Directory", "Nothing Selected", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
            return;
        }
        String name = currentFile.getName ();
        String renameTo = (String)JOptionPane.showInputDialog(rootPane, "Enter a New Name", "Rename File", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/secureShare_logo.png")), null, name);
        if (renameTo!=null) {
            boolean directory = currentFile.isDirectory();
            TreePath parentPath = findTreePath(currentFile.getParentFile());
            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)parentPath.getLastPathComponent();
            boolean renamed = currentFile.renameTo(new File(currentFile.getParentFile(), renameTo));
            if (renamed) {
                if (directory) {
                    TreePath currentPath = findTreePath(currentFile);
                    DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)currentPath.getLastPathComponent();
                    treeModel.removeNodeFromParent(currentNode);
                }
                showChildren(parentNode);
                jPanel8.repaint ();
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "The file could not be renamed", "Error Renaming File", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
            }
        }        
    }//GEN-LAST:event_jButton6ActionPerformed
//COPY A FILE
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (currentFile==null) {
            JOptionPane.showMessageDialog(rootPane, "Please select a File or Directory", "Nothing Selected", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
            return;
        }
        JFileChooser select = new JFileChooser();
        select.setCurrentDirectory(new java.io.File("User Files/" + DBConnection.name));
        select.addActionListener((ActionEvent e) -> {
            if (JFileChooser.CANCEL_SELECTION.equals(e.getActionCommand())) {
                select.setVisible (false);
            }
            else if (JFileChooser.APPROVE_SELECTION.equals(e.getActionCommand())) {
                if(select.getSelectedFile() != null){
                    File dest = new File(select.getSelectedFile ().getAbsolutePath ());
                    try {
                        if (dest.createNewFile()) {
                            FileChannel fromChannel = new FileInputStream(currentFile.getParentFile ()).getChannel();
                            FileChannel toChannel = new FileOutputStream(dest).getChannel();
                            toChannel.transferFrom(fromChannel, 0, fromChannel.size());
                            TreePath parentPath = findTreePath(dest.getParentFile());
                            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)parentPath.getLastPathComponent();
                            if (dest.isDirectory ()) {
                                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(dest);
                                TreePath currentPath = findTreePath(currentFile);
                                treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
                            }
                            showChildren(parentNode);
                            jPanel8.repaint();
                        }
                        else {
                            JOptionPane.showMessageDialog(rootPane, "The file could not be copied", "Error Copying File", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
                        }
                    }
                    catch (HeadlessException | IOException | NullPointerException ex) {
                        Logger.getLogger (Share.class.getName()).log (Level.SEVERE, "Error copying file", ex);
                    }
                }
            }
        });
        select.showSaveDialog(rootPane);
    }//GEN-LAST:event_jButton8ActionPerformed
//DECRYPT A FILE
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (FilenameUtils.isExtension (currentFile.getAbsolutePath (), "encrypted")) {     
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
            JLabel label = new JLabel("Password: ");
            JPasswordField pword = new JPasswordField(16);
            panel.add(label);
            panel.add(pword);
            String[] options = new String[]{"Decrypt", "Cancel"};
            int option = JOptionPane.showOptionDialog(rootPane, panel, "This File is Encrypted", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("/secureShare_logo.png")), options, options[1]);
            if (option == 0){
                char[] password = pword.getPassword();
                String key = String.copyValueOf(password);
                if (DBConnection.pullKey(currentFile.getName (), key)) {
                    Crypto.Decrypt (currentFile, key);
                    JOptionPane.showMessageDialog(rootPane, "File has been decrypted successfully", "Decyption Succesful", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "You've entered the wrong password. Try again.", "Wrong Password!", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
                }     
            }
            else if (option==1) {
                panel.setVisible(false);
            }
        }
        File parentFile = currentFile.getParentFile ();
        TreePath parentPath = findTreePath(parentFile);
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)parentPath.getLastPathComponent();
        showChildren (parentNode);
        jPanel8.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        jTextField2.setText ("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        jTextField2.setText ("SEARCH");
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        JTextField searchResults = new JTextField("");
        AutoCompleteDecorator decorator;

        JComboBox combobox = new JComboBox(new Object[]{treeModel});
        AutoCompleteDecorator.decorate(combobox);
        searchResults.setEditable (false);
        searchResults.setBounds (100, 100, 100, 100);
        searchResults.setLayout(new FlowLayout());
        searchResults.add(combobox);
        searchResults.setVisible(true);
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            openFile ();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public void openFile () {
        if (currentFile==null) {
            JOptionPane.showMessageDialog(rootPane, "Please select a File or Directory", "Nothing Selected", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
        }
        File parentFile = currentFile;
        File file = new File( parentFile, currentFile.getName ());
        if (FilenameUtils.isExtension (currentFile.getAbsolutePath (), "encrypted")) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
            JLabel label = new JLabel("Password: ");
            JPasswordField pword = new JPasswordField(16);
            panel.add(label);
            panel.add(pword);
            String[] options = new String[]{"Decrypt", "Cancel"};
            int option = JOptionPane.showOptionDialog(rootPane, panel, "This File is Encrypted", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("/secureShare_logo.png")), options, options[1]);
            if (option == 0){
                char[] password = pword.getPassword();
                String key = String.copyValueOf(password);
                if (DBConnection.pullKey(currentFile.getName (), key)) {
                    Crypto.Decrypt (currentFile, key);
                    JOptionPane.showMessageDialog(rootPane, "File has been decrypted successfully", "Decyption Succesful", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
                    try {
                        desktop.open(currentFile);
                    } catch(IOException ex) {
                        Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Error Opening File", ex);
                    }
                    //Refresh Viewer
                    if (!parentFile.isDirectory()) {
                        parentFile = parentFile.getParentFile();
                    }
                    if (currentFile.exists ()) {
                        TreePath parentPath = findTreePath(parentFile);
                        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)parentPath.getLastPathComponent();
                        if (file.isDirectory()) {
                            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(file);
                            TreePath currentPath = findTreePath(currentFile);
                            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)currentPath.getLastPathComponent();
                            treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
                        }
                        showChildren(parentNode);
                        jPanel8.repaint();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "You've entered the wrong password. Try again.", "Wrong Password!", HEIGHT, new ImageIcon(getClass().getResource("/secureShare_logo.png")));
                }
            }
            else if (option==1) {
                panel.setVisible(false);
            }
        }
        else {
            try {
                desktop.open (currentFile);
            }
            catch (IOException ex) {
                Logger.getLogger (FileManager.class.getName()).log (Level.SEVERE, null, ex);
            }
        }
    }



    private void showChildren(final DefaultMutableTreeNode node) {
        jTree1.setEnabled(false);
        jProgressBar1.setVisible(true);
        jProgressBar1.setIndeterminate(true);

        SwingWorker<Void, File> worker = new SwingWorker<Void, File>() {
            @Override
            public Void doInBackground() {
                File file = (File) node.getUserObject();
                if (file.isDirectory()) {
                    File[] files = fileSystemView.getFiles(file, true);
                    if (node.isLeaf()) {
                        for (File child : files) {
                            if (child.isDirectory()) {
                                publish(child);
                            }
                        }
                    }
                    setTableData(files);
                }
                return null;
            }

            @Override
            protected void process(List<File> chunks) {
                for (File child : chunks) {
                    node.add(new DefaultMutableTreeNode(child));
                }
            }

            @Override
            protected void done() {
                jProgressBar1.setIndeterminate(false);
                jProgressBar1.setVisible(false);
                jTree1.setEnabled(true);
            }
        };
        worker.execute();
    }

    private void getFileDetails (File file) {
        currentFile = file;
        Icon icon = fileSystemView.getSystemIcon(file);
        jLabel6.setIcon(icon);
        jLabel6.setText(fileSystemView.getSystemDisplayName(file));
        jTextField1.setText(file.getPath().substring (file.getPath().lastIndexOf (DBConnection.name)));
        jLabel7.setText(new Date(file.lastModified()).toString());
        jLabel8.setText(file.length() + " bytes");
        jRadioButton1.setSelected(file.isDirectory());
        jRadioButton2.setSelected(file.isFile());
        this.setTitle(DBConnection.name + " - " + fileSystemView.getSystemDisplayName(file));
        this.repaint();
    }

    private TreePath findTreePath(File file) {
        TreePath treePath = null;
        for (int i=0; i<jTree1.getRowCount(); i++) {
            treePath = jTree1.getPathForRow(i);
            Object object = treePath.getLastPathComponent();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)object;
            File nodeFile = (File)node.getUserObject();

            if (nodeFile==file) {
                return treePath;
            }   
        }
        return treePath;
    }

    // Update table
    private void setTableData(final File[] files) {
        SwingUtilities.invokeLater(() -> {
            if (fileTableModel==null) {
                fileTableModel = new FileTableModel();
                jTable1.setModel(fileTableModel);
            }
            jTable1.getSelectionModel().removeListSelectionListener(listSelectionListener);
            fileTableModel.setFiles(files);
            jTable1.getSelectionModel().addListSelectionListener(listSelectionListener);
            if (!cellSizesSet) {
                Icon icon = fileSystemView.getSystemIcon(files[0]);
                jTable1.setRowHeight( icon.getIconHeight()+rowIconPadding );
                
                setColumnWidth(0,-1);
                setColumnWidth(3,-60);
                jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
                setColumnWidth(4,100);
                cellSizesSet = true;
            }
        });
    }

    private void setColumnWidth(int column, int width) {
        TableColumn tableColumn = jTable1.getColumnModel().getColumn(column);
        if (width<0) {
            JLabel label = new JLabel( (String)tableColumn.getHeaderValue() );
            Dimension preferred = label.getPreferredSize();
            width = (int)preferred.getWidth()+14;
        }
        tableColumn.setPreferredWidth(width);
        tableColumn.setMaxWidth(width);
        tableColumn.setMinWidth(width);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
