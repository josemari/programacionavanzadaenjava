package org.jomaveger.lang.dbc;

import java.io.Serializable;

import org.jomaveger.lang.DeepCloneable;
import org.jomaveger.lang.dbc.exceptions.ContractViolationException;

public final class Contract {
	
	public static final String PRECONDITION_ERROR = "Precondicion Fallida.";
	public static final String POSTCONDITION_ERROR = "Postcondicion Fallida.";
	public static final String CLASS_INVARIANT_ERROR = "Invariante de Clase Fallido.";
	public static final String CHECK_ERROR = "Asercion Fallida.";
	public static final String OLD_ERROR = "Imposible Calcular el Valor a la Entrada del Metodo.";

	public static void require(boolean condition) {
		if (!condition) {
			throw new ContractViolationException(PRECONDITION_ERROR);
		}
	}
	
	public static void require(boolean condition, String description) {
		if (!condition) {
			throw new ContractViolationException(PRECONDITION_ERROR + description);
		}
	}
	
	public static void ensure(boolean condition) {
		if (!condition) {
			throw new ContractViolationException(POSTCONDITION_ERROR);
		}
	}
	
	public static void ensure(boolean condition, String description) {
		if (!condition) {
			throw new ContractViolationException(POSTCONDITION_ERROR + description);
		}
	}
	
	public static void invariant(boolean condition) {
		if (!condition) {
			throw new ContractViolationException(CLASS_INVARIANT_ERROR);
		}
	}
	
	public static void invariant(boolean condition, String description) {
		if (!condition) {
			throw new ContractViolationException(CLASS_INVARIANT_ERROR + description);
		}
	}
	
	public static void check(boolean condition) {
		if (!condition) {
			throw new ContractViolationException(CHECK_ERROR);
		}
	}
	
	public static void check(boolean condition, String description) {
		if (!condition) {
			throw new ContractViolationException(CHECK_ERROR + description);
		}
	}
	
	public static <T extends Serializable> T old(T t) {
		T old;
		try {
			old = DeepCloneable.deepCopy(t);	
		} catch (Exception ex) {
			throw new ContractViolationException(OLD_ERROR);
		}
		return old;
	}
}
