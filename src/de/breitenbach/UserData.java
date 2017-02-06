package de.breitenbach;

/**
 * Created by nerix on 28.01.17.
 */
public class UserData
{

    private int HeightUnit;
    private int WeightUnit;
    private long dateofbirth;
    private String gender;
    private short height;
    private String logo;
    private String nickname;
    private String userid;
    private short weight;


    int getHeightUnit()
    {
        return HeightUnit;
    }

    void setHeightUnit(int heightUnit)
    {
        HeightUnit = heightUnit;
    }

    int getWeightUnit()
    {
        return WeightUnit;
    }

    void setWeightUnit(int weightUnit)
    {
        WeightUnit = weightUnit;
    }

    long getDateofbirth()
    {
        return dateofbirth;
    }

    void setDateofbirth(long dateofbirth)
    {
        this.dateofbirth = dateofbirth;
    }

    String getGender()
    {
        return gender;
    }
    void setGender(String gender)
    {
        this.gender = gender;
    }

    short getHeight()
    {
        return height;
    }

    void setHeight(short height)
    {
        this.height = height;
    }

    String getLogo()
    {
        return logo;
    }

    void setLogo(String logo)
    {
        this.logo = logo;
    }

    String getNickname()
    {
        return nickname;
    }

    void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    String getUserid()
    {
        return userid;
    }

    void setUserid(String userid)
    {
        this.userid = userid;
    }

    short getWeight()
    {
        return weight;
    }

    void setWeight(short weight)
    {
        this.weight = weight;
    }

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
