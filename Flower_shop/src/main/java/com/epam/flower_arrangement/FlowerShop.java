package main.java.com.epam.flower_arrangement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlowerShop {
    private FlowerArrangement flowerArrangement;
    private List<Flower> flowers = new ArrayList<>();
    private List<Packaging> packaging = new ArrayList<>();

    public FlowerShop() {
        createFlowersList();
        createPackagingList();
    }

    public void createFlowerArrangement() throws IOException, InterruptedException {
        List<Flower> flowers;
        Packaging packaging;
        System.out.println("Hello! We have the following flowers:");
        Thread.sleep(1000);
        showFlowers();
        flowers = chooseFlowers();
        System.out.println("What packaging should I use for your flower arrangement? We have following:");
        showPackaging();
        packaging = choosePackaging();
        if(flowers.size() > 0)
            flowerArrangement = new FlowerArrangement(flowers, packaging);
        System.out.println("Your flower arrangement:");
        System.out.println(flowerArrangement);
    }

    private List<Flower> chooseFlowers() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Flower> flowersList = new ArrayList<>();
        String flowerName;
        System.out.println("Please enter the names of the flowers that will make up the flower arrangement:");
        while (!((flowerName = reader.readLine()).equals(""))) {
            if(validateData(flowerName) && searchInFlowerList(flowerName)) {
                flowersList.add(new Flower(flowerName.toLowerCase()));
            } else {
                System.out.println("It's not a flower.");
            }
        }
        return flowersList;
    }

    private Packaging choosePackaging() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String packagingType;
        System.out.println("Please enter the type of packaging:");
        packagingType = reader.readLine();
        reader.close();
        if(validateData(packagingType) && searchInPackagingList(packagingType)) {
            return new Packaging(packagingType.toLowerCase());
        } else {
            System.out.println("It's not a packaging.");
        }
        return new Packaging("Paper");
    }

    private boolean validateData(String string) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private boolean searchInFlowerList(String flowerName) {
        boolean flag = false;
        for (Flower flower : flowers) {
            if (flower.getName().equalsIgnoreCase(flowerName)) {
                flag = true;
                break;
            }
        }
        if (!flag) System.out.println("Sorry, but we don't have this flower.");
        return flag;
    }

    private boolean searchInPackagingList(String packagingType) {
        boolean flag = false;
        for (Packaging type : packaging) {
            if (type.getType().equalsIgnoreCase(packagingType)) {
                flag = true;
                break;
            }
        }
        if (!flag) System.out.println("Sorry, but we don't have this packaging.");
        return flag;
    }

    private void createFlowersList() {
        BufferedReader reader;
        String flowerName;
        InputStream path = getClass().getResourceAsStream("/main/resources/flowers.txt");
        try {
            reader = new BufferedReader(new InputStreamReader(path));
            while (reader.ready()) {
                flowerName = reader.readLine();
                flowers.add(new Flower(flowerName));
            }
        } catch (IOException e) {
            System.out.println("Resource wasn't found.");
            e.printStackTrace();
        }
    }

    private void createPackagingList() {
        BufferedReader reader;
        String packagingType;
        InputStream path = getClass().getResourceAsStream("/main/resources/types_of_packaging.txt");
        try {
            reader = new BufferedReader(new InputStreamReader(path));
            while (reader.ready()) {
                packagingType = reader.readLine();
                packaging.add(new Packaging(packagingType));
            }
        } catch (IOException e) {
            System.out.println("Resource wasn't found.");
            e.printStackTrace();
        }
    }

    private void showFlowers() throws InterruptedException {
        for (Flower flower : flowers) {
            Thread.sleep(500);
            System.out.println(flower);
        }
    }

    private void showPackaging() throws InterruptedException {
        for (Packaging type : packaging) {
            Thread.sleep(500);
            System.out.println(type);
        }
    }

    public List<Flower> getFlowers() {
        createFlowersList();
        return flowers;
    }

    public List<Packaging> getPackaging() {
        createPackagingList();
        return packaging;
    }
}
