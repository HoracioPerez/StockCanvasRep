package generic;

import java.util.Objects;

/**
 *
 * @author Horacio Perez
 */
public abstract class IdObject {

    protected String id;

    public IdObject(String id) {
        this.id = id;
    }

    public IdObject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IdObject other = (IdObject) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+'{' + "id=" + id + '}';
    }
    
    
}
