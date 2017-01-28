package de.breitenbach;

/**
 * Created by yamaneko on 28.01.2017.
 */
public class iHealthBloodGlucoseData
{
    int BG;
    String DataID;
    String DinnerSituation;
    String DrugSituation;
    long MData;
    String Note;
    long LastChangeTime;
    String DataSource;
    String TimeZone;

    @Override
    public String toString()
    {
        return "iHealthBloodGlucoseData{" +
                "BG=" + BG +
                ", DataID='" + DataID + '\'' +
                ", DinnerSituation='" + DinnerSituation + '\'' +
                ", DrugSituation='" + DrugSituation + '\'' +
                ", MData=" + MData +
                ", Note='" + Note + '\'' +
                ", LastChangeTime=" + LastChangeTime +
                ", DataSource='" + DataSource + '\'' +
                ", TimeZone='" + TimeZone + '\'' +
                '}';
    }
}
