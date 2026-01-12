import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos funcionarios seram cadastrados: ");
        int n = scanner.nextInt();
        List<Funcionarios> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Funciovario #" + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            Funcionarios funcionarios = new Funcionarios(id, name, salary);
            list.add(funcionarios);
        }

        System.out.println();
        System.out.print("Entre com o id do funcionario que receberar o aumento salarial: ");
        int idSalary = scanner.nextInt();
        Integer pos = position(list, idSalary);
        if (pos == null) {
            System.out.println("Esse id nao existe");
        } else {
            System.out.print("Qual a porcentagem do aumento: ");
            double porcent = scanner.nextDouble();
            list.get(pos).aumento(porcent);
        }

        System.out.println();
        System.out.println("Lista de funcionarios:");
        for (Funcionarios f : list) {
            System.out.println(f);
        }
    }


    public static Integer position(List<Funcionarios> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}