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


    public int getHeightUnit()
    {
        return HeightUnit;
    }

    public void setHeightUnit(int heightUnit)
    {
        HeightUnit = heightUnit;
    }

    public int getWeightUnit()
    {
        return WeightUnit;
    }

    public void setWeightUnit(int weightUnit)
    {
        WeightUnit = weightUnit;
    }

    public long getDateofbirth()
    {
        return dateofbirth;
    }

    public void setDateofbirth(long dateofbirth)
    {
        this.dateofbirth = dateofbirth;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public short getHeight()
    {
        return height;
    }

    public void setHeight(short height)
    {
        this.height = height;
    }

    public String getLogo()
    {
        return logo;
    }

    public void setLogo(String logo)
    {
        this.logo = logo;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public short getWeight()
    {
        return weight;
    }

    public void setWeight(short weight)
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
