package mvc;

import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {

    Boolean unsavedChanges = false;
    String fileName = null;

    // TODO: All methods below
    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    public void changed() {
        setUnsavedChanges(true); //me
        notifySubscribers();
//        firePropertyChange("unsavedChanges", false, true);
    }

//    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
//
//    }
}