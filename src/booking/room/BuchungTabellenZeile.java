package booking.room;

import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class BuchungTabellenZeile {

	private final IntegerProperty idBuchungProperty;
	private final IntegerProperty idKlasseProperty;
	private final IntegerProperty idRaumProperty;
	private final ObjectProperty<Date> vonDateProperty; 
	private final ObjectProperty<Date> bisDateProperty;
	
	public BuchungTabellenZeile () {
		
		this.idBuchungProperty = new SimpleIntegerProperty(this, "ID_Buchung");
		this.idKlasseProperty = new SimpleIntegerProperty(this, "ID_Klasse");
		this.idRaumProperty = new SimpleIntegerProperty(this, "ID_Raum");
		this.vonDateProperty = new SimpleObjectProperty<>(this, "vonDate");
		this.bisDateProperty = new SimpleObjectProperty<>(this, "bisDate");
	}

    /**
     * Returns the ID_Buchung property for use within a view
     * @return the ID_Buchung property
     */
    public IntegerProperty idBuchungProperty () {
		return this.idBuchungProperty;
    }
    
    public IntegerProperty idKlasseProperty () {
		return this.idKlasseProperty;
    }
    
    public IntegerProperty idRaumProperty () {
		return this.idRaumProperty;
    }
	
    public final ObjectProperty<Date> bisDateProperty() {
        return bisDateProperty;
    }
    
    public final ObjectProperty<Date> vonDateProperty() {
        return vonDateProperty;
    }
    
    public final void setvonDateProperty(Date date) {
        this.vonDateProperty.set(date);
    }

    public final Date getClientDate() {
        return vonDateProperty.get();
    }

    public final void setbisDateProperty(Date bisDateProperty) {
        this.bisDateProperty.set(bisDateProperty);
    }

    public final Date getbisDateProperty() {
        return bisDateProperty.get();
    }

    public IntegerProperty getIdBuchungProperty () {
		return idBuchungProperty;
	}

	public IntegerProperty getIdKlasseProperty () {
		return idKlasseProperty;
	}

	public IntegerProperty getIdRaumProperty () {
		return idRaumProperty;
	}
	
	public void setIdBuchungProperty (final int value) {
		this.idBuchungProperty.set(value);
	}

	public void setIdKlasseProperty (final int value) {
		this.idKlasseProperty.set(value);
	}

	public void setIdRaumProperty (final int value) {
		this.idRaumProperty.set(value);
	}
	
	
	
	
}
