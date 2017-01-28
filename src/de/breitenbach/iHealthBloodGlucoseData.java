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
        return "iHealthBloodGlucoseData{\n" +
                "BG=" + BG +
                ", \nDataID='" + DataID + '\'' +
                ", \nDinnerSituation='" + DinnerSituation + '\'' +
                ", \nDrugSituation='" + DrugSituation + '\'' +
                ", \nMData=" + MData +
                ", \nNote='" + Note + '\'' +
                ", \nLastChangeTime=" + LastChangeTime +
                ", \nDataSource='" + DataSource + '\'' +
                ", \nTimeZone='" + TimeZone + '\'' +
                '}';
    }
}
