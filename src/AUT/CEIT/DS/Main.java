package AUT.CEIT.DS;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please write down your objective :");
        AgenceyList agenceyList = new AgenceyList();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("close program")) {
            if (input.contains("add service")) {
                System.out.println("please write the service name :");
                String result = scanner.nextLine();
                agenceyList.getServiceList().addService(result);
            }

            if (input.contains("add subservice")) {
                String result1 = "";
                String result2 = "";
                System.out.println("please write the name of the subservice and the name of the service respectivley :");
                result1 = scanner.nextLine();
                result2 = scanner.nextLine();
                agenceyList.getServiceList().addSubService(result1, result2);
            }

            if (input.contains("add offer")) {
                String result1 = "";
                String result2 = "";
                System.out.println("please write the name of the service and the name of the agency respectivley :");
                result1 = scanner.nextLine();
                result2 = scanner.nextLine();
                agenceyList.addOffer(result2, result1);
            }
            if (input.contains("delete")) {
                String result1 = "";
                String result2 = "";
                System.out.println("please write the name of the service and the name of the agency respectivley :");
                result1 = scanner.nextLine();
                result2 = scanner.nextLine();
                agenceyList.delete(result1, result2);
            }
            if (input.contains("add agency")) {
                String result = "";
                System.out.println("please write down the agency name :");
                result = scanner.nextLine();
                agenceyList.addAgencey(result);
            }
            if (input.contains("list agencies")) {
                System.out.println("**********");
                agenceyList.listAgencies();
                System.out.println("**********");
            }
            if (input.equals("list services")) {
                System.out.println("**********");
                agenceyList.listServices();
                System.out.println("**********");
                System.out.println("\n");
            }
            if (input.contains("list services from")) {
                String result = "";
                System.out.println("please write down the service name :");
                result = scanner.nextLine();
                agenceyList.listServicesFrom(result);
                System.out.println("\n");
            }
            if (input.equals("order")) {
                System.out.println("please enter the agency name :");
                String res1 = scanner.nextLine();
                System.out.println("please enter the service name :");
                String res2 = scanner.nextLine();
                System.out.println("please enter the customer name :");
                String res3 = scanner.nextLine();
                System.out.println("please enter the immediacey level (normal, urgent, extraUrgent) :");
                String res4 = scanner.nextLine();
                agenceyList.order(res1, res2, res3, res4);
            }
            if (input.contains("list orders")) {
                String result = "";
                System.out.println("please enter the agency name :");
                result = scanner.nextLine();
                System.out.println("**********");
                agenceyList.listOrders(result);
                System.out.println("**********");
            }

            System.out.println("what is your next command?");
            input = scanner.nextLine();
        }


    }
}
