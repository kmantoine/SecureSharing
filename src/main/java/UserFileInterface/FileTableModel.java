package UserFileInterface;

import FileShare.DBConnection;
import java.io.File;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kerwan Miguel Antoine
 */

class FileTableModel extends AbstractTableModel {

    private File[] files;
    private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
    private String[] columns = {"Icon", "File", "Path", "Size", "Last Modified"};

    FileTableModel() {
        this(new File[0]);
    }

    FileTableModel(File[] files) {
        this.files = files;
    }

    @Override
    public Object getValueAt(int row, int column) {
        File file = files[row];
        int pathIndex = file.getAbsolutePath ().indexOf (DBConnection.name);
        switch (column) {
            case 0:
                return fileSystemView.getSystemIcon(file);
            case 1:
                return fileSystemView.getSystemDisplayName(file);
            case 2:
                return file.getPath().substring(pathIndex);
            case 3:
                return file.length();
            case 4:
                return file.lastModified();
        }
        return "";
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return ImageIcon.class;
            case 3:
                return Long.class;
            case 4:
                return Date.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
  
    @Override
    public int getRowCount() {
        return files.length;
    }

    public File getFile(int row) { //getter method
        return files[row];
    }

    public void setFiles(File[] files) { //setter method
        this.files = files;
        fireTableDataChanged();
    }
}