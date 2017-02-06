package de.breitenbach;

/**
 * Created by yamaneko on 28.01.2017.
 */
public class BGData
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

    public int getBG()
    {
        return BG;
    }

    public void setBG(int BG)
    {
        this.BG = BG;
    }

    public String getDataID()
    {
        return DataID;
    }

    public void setDataID(String dataID)
    {
        DataID = dataID;
    }

    public String getDinnerSituation()
    {
        return DinnerSituation;
    }

    public void setDinnerSituation(String dinnerSituation)
    {
        DinnerSituation = dinnerSituation;
    }

    public String getDrugSituation()
    {
        return DrugSituation;
    }

    public void setDrugSituation(String drugSituation)
    {
        DrugSituation = drugSituation;
    }

    public long getMData()
    {
        return MData;
    }

    public void setMData(long MData)
    {
        this.MData = MData;
    }

    public String getNote()
    {
        return Note;
    }

    public void setNote(String note)
    {
        Note = note;
    }

    public long getLastChangeTime()
    {
        return LastChangeTime;
    }

    public void setLastChangeTime(long lastChangeTime)
    {
        LastChangeTime = lastChangeTime;
    }

    public String getDataSource()
    {
        return DataSource;
    }

    public void setDataSource(String dataSource)
    {
        DataSource = dataSource;
    }

    public String getTimeZone()
    {
        return TimeZone;
    }

    public void setTimeZone(String timeZone)
    {
        TimeZone = timeZone;
    }
}
