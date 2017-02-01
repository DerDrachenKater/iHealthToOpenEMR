package de.breitenbach;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nerix on 01.02.17.
 */
public class iHealthWeighttoGraph
{
    static XYChart paintWeightToGraph()
    {
        XYChart graph = new XYChartBuilder().width(800).height(600).title("Gewicht").theme(Styler.ChartTheme.GGPlot2)
                .build();
        graph.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        graph.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        String[][] table = iHealthWeightDB.selectWeight();
        List<Date> dates = new ArrayList<Date>();
        List<Double> values = new ArrayList<Double>();

        DateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.S");
        Date date = null;

        for ( int  i = 0; i < table.length; i++)
        {
            try
            {
                date = sdf.parse(table[i][2]);
            }catch (ParseException pe)
            {
                pe.printStackTrace();
            }
            values.add(Double.parseDouble(table[i][3]));
            dates.add(date);
        }
        XYSeries chart = graph.addSeries("Gewichtsdaten",dates,values);

        chart.setLineColor(XChartSeriesColors.BLUE);
        chart.setMarkerColor(Color.ORANGE);
        chart.setMarker(SeriesMarkers.CIRCLE);
        chart.setLineStyle(SeriesLines.SOLID);

        return graph;
    }
}
