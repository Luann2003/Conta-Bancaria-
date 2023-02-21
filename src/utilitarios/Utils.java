package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
	
	static NumberFormat formatandoNumeros = new DecimalFormat("R$ #,##0.00");
	
	public static String doubleTostring(Double valor) {
		return formatandoNumeros.format(valor);
	}
	

}
