package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author MartinLodahl
 */
@Entity
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String imagepath;
    @ManyToOne(cascade=CascadeType.MERGE)
    Kayak kayak;

    public Image() {
    }

    public Image(String imagepath, Kayak kayak) {
        this.imagepath = imagepath;
        this.kayak = kayak;
    }

    public Image(Integer id, String imagepath, Kayak kayak) {
        this.id = id;
        this.imagepath = imagepath;
        this.kayak = kayak;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Kayak getKayak() {
        return kayak;
    }

    public void setKayak(Kayak kayak) {
        this.kayak = kayak;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.image[ id=" + id + " ]";
    }
    
}
