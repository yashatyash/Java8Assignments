package com.yash.java8assignments.Ques16;

//User will enter item name, price, date of manufacturing, date of expiring, category name. Now user will enter the name of the category, and you need to print the item detail on the basis of the category name. User can enter starting letter of the item, and you need to print the detail of items. User can also enter either date of manufacturing and date of expiring you need to find the item details on the basis of the date entered. User may ask to print the item on the basis of the price range.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Item
{
    private String itemName;
    private double itemPrice;
    private String dateOfMft,dateOfEx,categoryName;

    public Item(String itemName, double itemPrice, String dateOfMft, String dateOfEx, String categoryName) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.dateOfMft = dateOfMft;
        this.dateOfEx = dateOfEx;
        this.categoryName = categoryName;
    }

    public Item() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getDateOfMft() {
        return dateOfMft;
    }

    public void setDateOfMft(String dateOfMft) {
        this.dateOfMft = dateOfMft;
    }

    public String getDateOfEx() {
        return dateOfEx;
    }

    public void setDateOfEx(String dateOfEx) {
        this.dateOfEx = dateOfEx;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

public class Ques16 {
    String itemName;
    double itemPrice;
    String dateOfMft,dateOfEx,category;
    static List<Item> itemList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int option1,option2;
        while (true) {
            System.out.println("""
                    Enter 1 to add new item.
                    Enter 2 to check item category-wise.
                    Enter 3 to check the item by name.
                    Enter 4 to check item Date of Manufacturing or Date of Expiry
                    Enter 5 to Exit.""");
            option1 = scanner.nextInt();
            scanner.nextLine();
            switch (option1) {
                case 1->
                {
                    new Ques16().addItem();
                }
                case 2->
                {
                    new Ques16().checkItemByCategory();
                }
                case 3->
                {
                    new Ques16().checkItemByName();
                }
                case 4->
                {
                    new Ques16().checkItemByDate();
                }
                case 5->
                {
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }
    private void addItem() throws Exception {
        System.out.println("Enter item name: ");
        itemName = scanner.nextLine();
        System.out.println("Enter item price: ");
        itemPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter item Date of Manufacture: ");
        dateOfMft = scanner.nextLine();
        dateOfMft = new DateOperations().dateConversion(dateOfMft);
        System.out.println("Enter item Date of Expiry: ");
        dateOfEx = scanner.nextLine();
        dateOfEx = new DateOperations().dateConversion(dateOfEx);
        System.out.println("Enter category name: ");
        category = scanner.nextLine();

        itemList.add(new Item(itemName,itemPrice,dateOfMft,dateOfEx,category));
        System.out.println("Item added successfully");
        //System.out.println(itemList.size());
    }
    private void checkItemByCategory()
    {
        //checking list first
        //System.out.println("Size of list"+itemList.size());
        if (itemList.size()!=0)
        {
            System.out.println("Enter the category name you want to search: ");
            String categoryName = scanner.nextLine();
            List<String> list = itemList.stream().filter(category->category.getCategoryName().equalsIgnoreCase(categoryName)).map(Item::getItemName).collect(Collectors.toList());
            System.out.println("Items having the category name - "+categoryName.toUpperCase()+" are: ");
            for (String s:list)
                System.out.println(s);
        }
        else
            System.out.println("List is empty, please add some items first");
    }
    private void checkItemByName()
    {
        //checking list first
        if (itemList.size()!=0)
        {
            System.out.println("Enter the item name starting letter you want to search: ");
            String item = scanner.nextLine();
            List<String> listName = itemList.stream().filter(items->items.getItemName().startsWith(item)).map(Item::getItemName).collect(Collectors.toList());
            System.out.println("Items having the item name starting letter - "+item.toUpperCase()+" are: ");
            for (String s:listName)
                System.out.println(s);
        }
        else
            System.out.println("List is empty, please add some items first");
    }
    private void checkItemByDate()
    {
        //checking list first
        if (itemList.size()!=0)
        {
            System.out.println("Enter the item's Manufacture date or Expiry Date you want to search: ");
            String dates = scanner.nextLine();
            List<String> listName = itemList.stream().filter(items->items.getDateOfMft().equals(dates)||items.getDateOfEx().equals(dates)).map(Item::getItemName).collect(Collectors.toList());
            System.out.println("Items having the Manufacture date or Expiry Date with - "+dates+" are: ");
            for (String s:listName)
                System.out.println(s);
        }
        else
            System.out.println("List is empty, please add some items first");
    }
}
