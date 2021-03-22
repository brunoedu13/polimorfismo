package aplication;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();


        for(int i=1; i <= n ; i++){

            System.out.print("Common, used or imported (c/u/i)? ");
            char c = sc.next().charAt(0);
            System.out.println("Product #" + i +  " data:");
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if(c == 'c'){
                list.add(new Product(name,price));
            }
            else if (c == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = sc.next();
                list.add(new UsedProduct(name,price,sdf.parse(date)));

            }
            else if(c == 'i')
            {
                System.out.print("Customs fee: ");
                Double customsfee = sc.nextDouble();
                new UsedProduct(name,price,customsfee);
                list.add(new ImportedProduct(name,price,customsfee));
            }


        }

        for(Product li: list){
            System.out.println(li.priceTag());
        }










        sc.close();



    }



}
