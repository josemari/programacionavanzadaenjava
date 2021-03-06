package org.jomaveger.examples.chapter1;

import java.util.Objects;

import org.jomaveger.lang.DeepCloneable;

public class Manager extends Employee implements DeepCloneable {

    private Double incentivo;

    public Manager(final String nombre, final Double salario, final Integer anno, final Integer mes, final Integer dia) {
        super(nombre, salario, anno, mes, dia);
        this.incentivo = 0.0;
    }

    public Manager(Manager manager) {
        super(manager);
        this.incentivo = manager.incentivo;
    }

    public static Manager newInstance(Manager manager) {
        return new Manager(manager);
    }

    public Double getIncentivo() {
        return this.incentivo;
    }

    public void setIncentivo(Double incentivo) {
        this.incentivo = incentivo;
    }

    @Override
    public Double getSueldo() {
        Double sueldoBase = super.getSueldo();
        return sueldoBase + this.incentivo;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;

        Manager other = (Manager) otherObject;

        return Objects.equals(this.incentivo, other.incentivo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), this.incentivo);
    }

    @Override
    public String toString() {
        return super.toString() + "[incentivo=" + this.incentivo + ']';
    }

    public Manager deepCopy() throws Exception {
        return DeepCloneable.deepCopy(this);
    }
}
