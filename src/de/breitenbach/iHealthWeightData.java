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

    public float getBMI()
    {
        return BMI;
    }

    public void setBMI(float BMI)
    {
        this.BMI = BMI;
    }

    public String getDataID()
    {
        return DataID;
    }

    public void setDataID(String dataID)
    {
        DataID = dataID;
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

    public float getWeightValue()
    {
        return WeightValue;
    }

    public void setWeightValue(float weightValue)
    {
        WeightValue = weightValue;
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
