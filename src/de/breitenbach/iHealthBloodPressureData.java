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

    public int getBPL()
    {
        return BPL;
    }

    public void setBPL(int BPL)
    {
        this.BPL = BPL;
    }

    public String getDataID()
    {
        return DataID;
    }

    public void setDataID(String dataID)
    {
        DataID = dataID;
    }

    public int getHP()
    {
        return HP;
    }

    public void setHP(int HP)
    {
        this.HP = HP;
    }

    public int getHR()
    {
        return HR;
    }

    public void setHR(int HR)
    {
        this.HR = HR;
    }

    public int getLP()
    {
        return LP;
    }

    public void setLP(int LP)
    {
        this.LP = LP;
    }

    public long getMDate()
    {
        return MDate;
    }

    public void setMDate(long MDate)
    {
        this.MDate = MDate;
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
