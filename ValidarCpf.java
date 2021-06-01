import java.util.InputMismatchException;

public class ValidarCpf {
	public static boolean autenticaCPF(String CPF) {
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || CPF.equals("00000000000") || (CPF.length() != 11)) 
			return (false);

			char numVer1, numVer2;
			int i, peso, numero, soma, valor;

			try {
				soma = 0;
				peso = 10;
				for (i = 0; i < 9; i++) {
					numero = (int) (CPF.charAt(i)-48);
					soma = soma + (numero * peso);
					peso--;
				}
				soma = soma * 10;

				if (soma % 11 == 10) {
					numVer1 = '0';

				} else {
					valor = soma % 11;
					numVer1 = (char) (valor + 48);
					

				}
				soma = 0;
				peso = 11;
				for(i=0;i<10;i++){
					numero = (int) (CPF.charAt(i)-48);
					soma = soma + (numero * peso);
					peso--;
				}
				valor = 11-(soma%11);
				if(valor == 10||valor ==11) {
					numVer2= '0';
				}
				else {
					numVer2 = (char) (valor + 48);
				}
				
				if(numVer1 == CPF.charAt(9) && numVer2 == CPF.charAt(10)) {
					return true;
				}else {
					return false;
				}
				

			} catch (InputMismatchException erro) {
				return (false);
			}
		}

	}