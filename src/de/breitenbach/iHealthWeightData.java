package de.breitenbach;

/**
 * Created by yamaneko on 28.01.2017.
 */
public class iHealthWeightData
{
    float BMI;
    String DataID;
    long MDate;
    String Note;
    float WeightValue;
    long LastChangeTime;
    String DataSource;
    String TimeZone;

    @Override
    public String toString()
    {
        return "iHealthWeightData{\n" +
                "BMI=" + BMI +
                ", \nDataID='" + DataID + '\'' +
                ", \nMDate=" + MDate +
                ", \nNote='" + Note + '\'' +
                ", \nWeightValue=" + WeightValue +
                ", \nLastChangeTime=" + LastChangeTime +
                ", \nDataSource='" + DataSource + '\'' +
                ", \nTimeZone='" + TimeZone + '\'' +
                '}';
    }
}
