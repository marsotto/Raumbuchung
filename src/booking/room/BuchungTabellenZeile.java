package booking.room;

import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class BuchungTabellenZeile {

	private final IntegerProperty ID_BuchungProperty;
	private final IntegerProperty ID_KlasseProperty;
	private final IntegerProperty ID_RaumProperty;
	private final ObjectProperty<Date> Datum_vonProperty; 
	private final ObjectProperty<Date> Datum_bisProperty;
	
	public BuchungTabellenZeile () {
		
		this.ID_BuchungProperty = new SimpleIntegerProperty(this, "ID_Buchung");
		this.ID_KlasseProperty = new SimpleIntegerProperty(this, "ID_Klasse");
		this.ID_RaumProperty = new SimpleIntegerProperty(this, "ID_Raum");
		this.Datum_vonProperty = new SimpleObjectProperty<>(this, "Datum_von");
		this.Datum_bisProperty = new SimpleObjectProperty<>(this, "Datum_bis");
	}

    /**
     * Returns the ID_Buchung property for use within a view
     * @return the ID_Buchung property
     */
    public IntegerProperty ID_BuchungProperty () {
		return this.ID_BuchungProperty;
    }
    
    public IntegerProperty ID_KlasseProperty () {
		return this.ID_KlasseProperty;
    }
    
    public IntegerProperty ID_RaumProperty () {
		return this.ID_RaumProperty;
    }
	
    public final ObjectProperty<Date> Datum_bisProperty() {
        return this.Datum_vonProperty;
    }
    
    public final ObjectProperty<Date> Datum_vonProperty() {
        return this.Datum_bisProperty;
    }
 
    public final int getID_Buchung () {
    	return this.ID_BuchungProperty.get();
    }
    
    public final void setID_Buchung (final int value) {
    	this.ID_BuchungProperty.set(value);
    }
    
    public final int getID_Raum () {
    	return this.ID_RaumProperty.get();
    }
    
    public final void setID_Raum (final int value) {
    	this.ID_RaumProperty.set(value);
    }
    
    public final int getID_Klasse () {
    	return this.ID_KlasseProperty.get();
    }
    
    public final void setID_Klasse (final int value) {
    	this.ID_KlasseProperty.set(value);
    }
    
    public final Date getDatum_von() {
    	return Datum_vonProperty.get();
    }
    
    public final void setDatum_von(Date date) {
        this.Datum_vonProperty.set(date);
    }

    public final Date getDatum_bis() {
    	return this.Datum_bisProperty.get();
    }
    
    public final void setDatum_bis(Date bisDateProperty) {
        this.Datum_bisProperty.set(bisDateProperty);
    }

}
