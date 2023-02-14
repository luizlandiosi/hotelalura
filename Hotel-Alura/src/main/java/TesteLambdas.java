import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import Controller.HospedeController;
import Controller.ReservaController;



public class TesteLambdas {

	public static void main(String[] args) {
		HospedeController hospedeController = new HospedeController();
		List<Hospede> hospedes = hospedeController.listar();

		ReservaController reservaController = new ReservaController();
		List<Reserva> reservas = reservaController.listar();

		System.out.println("Relatório:");
		System.out.println("Valor arrecadado");
		System.out.println(reservas.stream().mapToDouble(r -> r.getValor()).sum());
		System.out.println("\nHospedes brasileiros");
		filtra(hospedes, h -> h.getNacionalidade().equalsIgnoreCase("brasileiro"), h -> System.out.println(h));
		System.out.println("\nReservas abaixo de 1000 reais");
		filtra(reservas, r -> r.getValor() <= 1000.0, r -> System.out.println(r));
		System.out.println("\nReservas pagas no dinheiro");
		filtra(reservas, r -> r.getFormaDePagamento().equals("Dinheiro"), r -> System.out.println(r));
	}

	private static <T> void filtra(List<T> list, Predicate<T> p, Consumer<T> c) { 
		for (T t : list) {
			if (p.test(t)) {
				c.accept(t);
			}
		}
	}
}