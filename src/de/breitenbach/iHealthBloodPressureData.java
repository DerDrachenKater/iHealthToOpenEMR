package de.breitenbach;

/**
 * Created by yamaneko on 28.01.2017.
 */
public class iHealthBloodPressureData
{
    int BPL;
    String DataID;
    int HP;
    int HR;
    int LP;
    long MDate;
    String Note;
    long LastChangeTime;
    String DataSource;
    String TimeZone;

    @Override
    public String toString()
    {
        return "iHealthBloodPressureData{\n" +
                "BPL=" + BPL +
                ", \nDataID='" + DataID + '\'' +
                ", \nHP=" + HP +
                ", \nHR=" + HR +
                ", \nLP=" + LP +
                ", \nMDate=" + MDate +
                ", \nNote='" + Note + '\'' +
                ", \nLastChangeTime=" + LastChangeTime +
                ", \nDataSource='" + DataSource + '\'' +
                ", \nTimeZone='" + TimeZone + '\'' +
                '}';
    }
}
