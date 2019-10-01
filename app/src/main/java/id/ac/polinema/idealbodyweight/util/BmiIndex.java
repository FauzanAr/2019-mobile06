package id.ac.polinema.idealbodyweight.util;

public class BmiIndex {
    private float height;
    private int mass;
    private String result;

    public BmiIndex(int mass, int height){
        this.mass = mass;
        this.height = Float.parseFloat(String.valueOf(height/100));
        this.result = calculate();
    }

    private String calculate() {
        float tmpResult;
        tmpResult = mass  / (height*height);

        if(tmpResult < 18.50){
            return "Underweight";
        }else if(tmpResult < 24.99){
            return "Normal (Healthy Weight)";
        }else if(tmpResult < 29.99){
            return "Pre-Obese";
        }else if (tmpResult < 34.99){
            return "Obese Class 1";
        }else if (tmpResult < 39.99){
            return "Obese Class 2";
        }else if (tmpResult > 40.00){
            return "Obese Class 3";
        }else
            return "Wrong Input!!";
    }

    public String getResult(){
        return result;
    }
}
