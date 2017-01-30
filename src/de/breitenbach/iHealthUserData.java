package de.breitenbach;
/**
 * Created by nerix on 28.01.17.
 */
public class iHealthUserData
{

    int HeightUnit;
    int WeightUnit;
    long dateofbirth;
    String gender;
    short height;
    String logo;
    String nickname;
    String userid;
    short weight;


    @Override
    public String toString()
    {
        return "iHealthUserData{\n" +
                "HeightUnit=" + HeightUnit +
                ", \nWeightUnit=" + WeightUnit +
                ", \ndateofbirth=" + dateofbirth +
                ", \ngender='" + gender + '\'' +
                ", \nheight=" + height +
                ", \nlogo='" + logo + '\'' +
                ", \nnickname='" + nickname + '\'' +
                ", \nuserid='" + userid + '\'' +
                ", \nweight=" + weight +
                '}';
    }
}
