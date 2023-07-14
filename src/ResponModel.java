import java.util.ArrayList;

public class ResponModel {

    private String title;
    private String describe;
    private String price;

    public ResponModel(String title, String describe, String price){
        this.title =title;
        this.describe =describe;
        this.price =price;
    }

    public ResponModel() {

    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title =title;
    }
    public String getDescribe(){
        return describe;
    }
    public void setDescribe(String describe){
        this.describe = describe;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }

    public int getRating() {
        return 0;
    }
    private static void selectionSort(ArrayList<ResponModel> responseModel) {
        int n = responseModel.size();
        for (int i = 0; i < n - 1; i++) {
            int currentIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (responseModel.get(j).getPrice().compareTo(responseModel.get(currentIndex).getPrice()) < 0) {
                    currentIndex = j;
                }
            }
            ResponModel temp = responseModel.get(currentIndex);
            responseModel.set(currentIndex, responseModel.get(i));
            responseModel.set(i, temp);
        }
    }
}
