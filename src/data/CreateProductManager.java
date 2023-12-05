package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import data.models.CreateProduct;
import data.models.User;

public class CreateProductManager {
    private String pathFile;
    private ArrayList<CreateProduct> createProducts;
    public CreateProductManager(String pathFile) {
        this.pathFile = pathFile;
        this.createProducts = new ArrayList<>();
    }
    public String getPathDirectory() {
        return pathFile;
    }
    public void setPathDirectory(String pathDirectory) {
        this.pathFile = pathDirectory;
    }
    public ArrayList<CreateProduct> getCreateProducts() {
        this.createProducts = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(this.pathFile))) {
            String line = reader.readLine();
            while(line != null) {
                String[] data = line.split(",");
                CreateProduct createProduct = new CreateProduct(data[0], data[1], data[2], data[3]);
                this.createProducts.add(createProduct);
                line = reader.readLine();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return this.createProducts;
    }
    public void saveInOneShot() {
        String allData = "";
        for (CreateProduct createProduct : this.createProducts) {
            allData += createProduct.toString() + "\n";
        }
        saveFileLines(allData);
    }
    public void saveCreateProduct(CreateProduct createProduct) {
        getCreateProducts();
        this.createProducts.add(createProduct);
        saveInOneShot();
    }
    public void saveFileLines(String allData) {
        try {
            FileWriter writer = new FileWriter(this.pathFile);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(allData);
            buffer.newLine();
            buffer.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
