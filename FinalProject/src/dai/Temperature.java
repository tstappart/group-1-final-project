package dai;
 
import java.io.Serializable;
import numberlist.objectlist.Copiable;
 
/**
 *
 * @author crocker
 */
public class Temperature implements Copiable, Comparable<Temperature>, Serializable {
 
    private double value;
    private char unit;
 
    public Temperature() {
        value = 0;
        unit = 'F';
    }
 
    public Temperature(double value, char unit) {
        this.value = value;
        this.unit = unit;
    }
 
    public double getValue() {
        return value;
    }
 
    public char getUnit() {
        return unit;
    }
 
    public Temperature add(Temperature other) {
        Temperature temp = new Temperature(this.value, this.unit);
        if (temp.getUnit() != other.getUnit()) {
            other = other.convertTo(temp.getUnit());
        }
        double newValue = temp.getValue() + other.getValue();
        Temperature added = new Temperature(newValue, this.unit);
        return added;
    }
 
    public Temperature subtract(Temperature other) {
        Temperature temp = new Temperature(this.value, this.unit);
        if (temp.getUnit() != other.getUnit()) {
            other = other.convertTo(temp.getUnit());
        }
        double newValue = temp.getValue() - other.getValue();
        Temperature added = new Temperature(newValue, this.unit);
        return added;
    }
 
    public Temperature convertTo(char unit) {
        Temperature temp = new Temperature(this.value, this.unit);
        if (unit == 'F' && temp.getUnit() != 'F') {
            if (temp.getUnit() == 'C') {
                return convertCelsiusAndFahrenheit(temp);
            } else {
                return convertKelvinAndFahrenheit(temp);
            }
        } else if (unit == 'C' && temp.getUnit() != 'C') {
            if (temp.getUnit() == 'F') {
                return convertCelsiusAndFahrenheit(temp);
            } else {
                return convertKelvinAndCelsius(temp);
            }
        } else if (unit == 'K' && temp.getUnit() != 'K') {
            if (temp.getUnit() == 'F') {
                return convertKelvinAndFahrenheit(temp);
            } else {
                return convertKelvinAndCelsius(temp);
            }
        } else {
            return temp;
        }
    }
 
    public Temperature convertCelsiusAndFahrenheit(Temperature temp) {
        Temperature newTemp;
        if (temp.getUnit() == 'F') {
            double newValue = (5.0 / 9.0) * (temp.getValue() - 32);
            newTemp = new Temperature(newValue, 'C');
            return newTemp;
        } else {
            double newValue = (9.0 / 5.0) * (temp.getValue() + 32);
            newTemp = new Temperature(newValue, 'F');
            return newTemp;
        }
    }
 
    public Temperature convertKelvinAndFahrenheit(Temperature temp) {
        Temperature newTemp;
        if (temp.getUnit() == 'F') {
            double newValue = ((5.0 / 9.0) * (temp.getValue() - 32)) + 273;
            newTemp = new Temperature(newValue, 'K');
            return newTemp;
        } else {
            double newValue = ((9.0 / 5.0) * (temp.getValue() - 273)) + 32;
            newTemp = new Temperature(newValue, 'F');
            return newTemp;
        }
    }
 
    public Temperature convertKelvinAndCelsius(Temperature temp) {
        Temperature newTemp;
        if (temp.getUnit() == 'C') {
            double newValue = temp.getValue() + 273;
            newTemp = new Temperature(newValue, 'K');
            return newTemp;
        } else {
            double newValue = temp.getValue() - 273;
            newTemp = new Temperature(newValue, 'C');
            return newTemp;
        }
    }
 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.value)
                ^ (Double.doubleToLongBits(this.value) >>> 32));
        hash = 83 * hash + this.unit;
        return hash;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Temperature other = (Temperature) obj;
        if (this.value != other.value) {
            return false;
        }
        if (this.unit != other.unit) {
            return false;
        }
        return true;
    }
 
    @Override
    public String toString() {
        if (this.unit != 'K') {
            return this.value + "\u00B0" + " " + this.unit;
        } else {
            return this.value + " " + this.unit;
        }
    }
 
    @Override
    public Temperature copy() {
        Temperature t = new Temperature(this.value, this.unit);
        return t;
    }
 
    @Override
    public int compareTo(Temperature other) {
        Temperature temp = new Temperature(this.value, this.unit);
        if (temp.getUnit() != other.getUnit()) {
            other = other.convertTo(temp.getUnit());
        }
        return Double.compare(temp.getValue(), other.getValue());
    }
 
}