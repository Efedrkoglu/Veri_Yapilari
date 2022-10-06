import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int StackSecim, menu, size, data;

        do{
            System.out.println("1. Dizi ile Stack");
            System.out.println("2. Bagli Liste ile Stack");
            System.out.println("0. Cikis");
            StackSecim = scan.nextInt();

            if(StackSecim == 1){
                System.out.print("Dizi-Stack yapisinin boyutunu giriniz:");
                size = scan.nextInt();
                DiziStack s1 = new DiziStack(size);

                do{
                    System.out.println("*****************");
                    System.out.println("1. push()");
                    System.out.println("2. pop()");
                    System.out.println("3. search()");
                    System.out.println("4. print()");
                    System.out.println("0. Secime don");
                    System.out.println("*****************");

                    menu = scan.nextInt();

                    switch (menu){
                        case 1->{
                            System.out.print("Eklenecek eleman: ");
                            data = scan.nextInt();
                            s1.push(data);
                        }

                        case 2->{
                            s1.pop();
                        }

                        case 3->{
                            System.out.print("Aranan eleman: ");
                            data = scan.nextInt();
                            s1.search(data);
                        }

                        case 4->{
                            s1.printStack();
                        }

                        case 0->{
                            System.out.println("Secim ekranina donuluyor...");
                        }

                        default ->{
                            System.out.println("Hatali secim!");
                        }
                    }

                }while(menu != 0);
            }
            else if(StackSecim == 2){
                System.out.print("Bagli Liste-Stack yapisinin boyutunu giriniz:");
                size = scan.nextInt();
                BagliListeStack lls1 = new BagliListeStack(size);

                do{
                    System.out.println("*****************");
                    System.out.println("1. push()");
                    System.out.println("2. pop()");
                    System.out.println("3. search()");
                    System.out.println("4. print()");
                    System.out.println("0. Secime don");
                    System.out.println("*****************");

                    menu = scan.nextInt();

                    switch (menu){
                        case 1->{
                            System.out.print("Eklenecek eleman: ");
                            data = scan.nextInt();
                            lls1.push(data);
                        }

                        case 2->{
                            lls1.pop();
                        }

                        case 3->{
                            System.out.print("Aranan eleman: ");
                            data = scan.nextInt();
                            lls1.search(data);
                        }

                        case 4->{
                            lls1.printStack();
                        }

                        case 0->{
                            System.out.println("Secim ekranina donuluyor...");
                        }

                        default ->{
                            System.out.println("Hatali secim!");
                        }
                    }

                }while(menu != 0);
            }
            else if (StackSecim == 0){
                System.out.println("Cikis yapiliyor...");
            }
            else{
                System.out.println("Hatali secim!");
            }
        }while(StackSecim != 0);
    }
}
