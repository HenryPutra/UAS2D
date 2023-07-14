import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;



public class No3UAS {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL("https://dummyjson.com/product/search?q=Laptop");
        String response = koneksisaya.getResponse();
        System.out.println(response);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponModel> responseModel = new ArrayList<>();
        for (int i = 0; i < responseJSON.length(); i++) {
            ResponModel resModel = new ResponModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resModel.setTitle(myJSONObject.getString("title"));
            resModel.setDescribe(myJSONObject.getString("describtion"));
            resModel.setPrice(myJSONObject.getString("price"));
            responseModel.add(resModel);
        }

        System.out.println("Response sebelum diurutkan:");
        for (int index = 0; index < responseModel.size(); index++) {
            System.out.println("Title: " + responseModel.get(index).getTitle());
            System.out.println("Description: " + responseModel.get(index).getDescribe());
            System.out.println("Price: " + responseModel.get(index).getPrice());
            System.out.println();
        }

        // Panggil metode selectionSort untuk mengurutkan responseModel berdasarkan harga (price)
        selectionSort(responseModel);

        System.out.println("Response setelah diurutkan:");
        for (int index = 0; index < responseModel.size(); index++) {
            System.out.println("Title: " + responseModel.get(index).getTitle());
            System.out.println("Description: " + responseModel.get(index).getDescribe());
            System.out.println("Price: " + responseModel.get(index).getPrice());
            System.out.println();
        }

        // Input user untuk pencarian entity 'rating'
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan rating yang dicari: ");
        int targetRating = scanner.nextInt();

        System.out.println("Hasil pencarian dengan rating " + targetRating + ":");
        boolean found = false;
        for (int index = 0; index < responseModel.size(); index++) {
            ResponModel currentModel = responseModel.get(index);
            // Ganti 'rating' dengan entity yang sesuai dalam data JSON
            // Ubah tipe data sesuai dengan data JSON yang diharapkan (misalnya: getInt, getDouble)
            int currentRating = currentModel.getRating();
            if (currentRating == targetRating) {
                System.out.println("Title: " + currentModel.getTitle());
                System.out.println("Description: " + currentModel.getDescribe());
                System.out.println("Price: " + currentModel.getPrice());
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Data dengan rating " + targetRating + " tidak ditemukan.");
        }
    }

    private static void selectionSort(ArrayList<ResponModel> responseModel) {
        int n = responseModel.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                double price1 = Double.parseDouble(responseModel.get(j).getPrice());
                double price2 = Double.parseDouble(responseModel.get(minIndex).getPrice());
                if (price1 < price2) {
                    minIndex = j;
                }
            }
            ResponModel temp = responseModel.get(minIndex);
            responseModel.set(minIndex, responseModel.get(i));
            responseModel.set(i, temp);
        }
    }
}
