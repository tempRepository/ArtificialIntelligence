import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Student implements Comparable<Student> {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getElectronics() {
        return electronics;
    }

    public void setElectronics(float electronics) {
        this.electronics = electronics;
    }

    public float getComputerScience() {
        return computerScience;
    }

    public void setComputerScience(float computerScience) {
        this.computerScience = computerScience;
    }

    public float getMathematics() {
        return mathematics;
    }

    public void setMathematics(float mathematics) {
        this.mathematics = mathematics;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public float getGerman() {
        return german;
    }

    public void setGerman(float german) {
        this.german = german;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private float electronics;
    private float computerScience;
    private float mathematics;
    private float english;
    private float german;
    private String name;

    public float membershipFunctionMin() {
        ArrayList<Float> MF_Values = new ArrayList<Float>();
        MF_Values.add(getMF_ComputerScience());
        MF_Values.add(getMF_Electronics());
        MF_Values.add(getMF_English());
        MF_Values.add(getMF_German());
        MF_Values.add(getMF_Mathematics());
        return Collections.min(MF_Values);
    }

    private float membershipFunctionScienceSubject(float value) {
        if (value >= 2 && value <= 4.3) {
            return 0;
        } else if (value >= 4.3 && value <= 4.8) {
            return (float) ((float) (value - 4.3) / 0.5);
        } else {
            return 1;
        }

    }

    private float membershipFunctionLanguage(float value) {
        if (value >= 2 && value <= 4.2) {
            return 0;
        } else if (value >= 4.2 && value <= 4.6) {
            return (float) ((float) (value - 4.2) / 0.4);
        } else {
            return 1;
        }

    }

    public float getMF_Electronics() {
        return membershipFunctionScienceSubject(electronics);
    }

    public float getMF_ComputerScience() {
        return membershipFunctionScienceSubject(computerScience);
    }

    public float getMF_Mathematics() {
        return membershipFunctionScienceSubject(mathematics);
    }

    public float getMF_English() {
        return membershipFunctionLanguage(english);
    }

    public float getMF_German() {
        return membershipFunctionLanguage(german);
    }

    public String toString() {
        return getId() + " " + getComputerScience() + " " + getElectronics()
                + " " + getMathematics() + " " + getEnglish() + " "
                + getGerman() + " " + getName();

    }

    public String toStringMF() {
        return getId() + " " + String.format("%.2f", getMF_ComputerScience())
                + " " + String.format("%.2f", getMF_Electronics()) + " "
                + String.format("%.2f", getMF_Mathematics()) + " "
                + String.format("%.2f", getMF_English()) + " "
                + String.format("%.2f", getMF_German()) + " " + getName();
    }

    @Override
    public int compareTo(Student o) {
        float thisMF = this.membershipFunctionMin();
        float oMF = o.membershipFunctionMin();
        if (thisMF > oMF) {
            return 1;
        } else if (thisMF == oMF) {
            return 0;
        } else {
            return -1;
        }

    }

}
