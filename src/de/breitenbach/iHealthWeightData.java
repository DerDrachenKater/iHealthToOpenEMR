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
        return "iHealthBloodGlucoseData{" +
                "BMI=" + BMI +
                ", DataID='" + DataID + '\'' +
                ", MDate=" + MDate +
                ", Note='" + Note + '\'' +
                ", WeightValue=" + WeightValue +
                ", LastChangeTime=" + LastChangeTime +
                ", DataSource='" + DataSource + '\'' +
                ", TimeZone='" + TimeZone + '\'' +
                '}';
    }
}
