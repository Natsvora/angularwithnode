
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder;
import net.sf.dynamicreports.report.builder.column.PercentageColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.BorderBuilder;
import net.sf.dynamicreports.report.builder.style.ConditionalStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.datasource.DRDataSource;

public class Report {

    private Connection connection;

    public void Build() {
        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle
                = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
        StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);

        TextColumnBuilder<String> name = col.column("Student", "name", type.stringType());
        TextColumnBuilder<String> sub = col.column("Subject", "Sub", type.stringType());
        TextColumnBuilder<Integer> mark = col.column("Marks", "marks", type.integerType());
        TextColumnBuilder<BigDecimal> average = mark.divide(0, 5);
        ConditionalStyleBuilder condition3 = stl.conditionalStyle(cnd.smaller(mark, 34))
                .setBackgroundColor(new Color(204, 0, 0))
                .bold();
        mark.setStyle(stl.style().setHorizontalTextAlignment(HorizontalTextAlignment.CENTER).setBorder(stl.penDotted()).conditionalStyles(condition3));
        Bar3DChartBuilder itemChart = cht.bar3DChart()
                .setTitle("Avg For Every Student")
                .setCategory(name)
                .addSerie(cht.serie(average));

        try {
            report()
                    .setColumnTitleStyle(columnTitleStyle)
                    .setColumnStyle(stl.style().setHorizontalTextAlignment(HorizontalTextAlignment.CENTER).setBorder(stl.penDotted()))
                    .highlightDetailEvenRows()
                    // .setTemplate()
                    .columns(
                            sub,
                            mark
                    )
                    .subtotalsAtFirstGroupFooter(sbt.avg(mark).setLabel("Avg Marks").setLabelPosition(Position.LEFT))
                    .groupBy(name)
                    .summary(itemChart)
                    .title(cmp.text("First Dynamic Report"))
                    .pageFooter(cmp.pageXofY())
                    .setDataSource("select * from uni join marks on uni.id= marks.stdid", connection)
                    .show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Report();
    }

    private DRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("Name", "studentcol");
        dataSource.add("Naimish", "DDU");
        dataSource.add("Ks", "Gtu");
        dataSource.add("Vp", "DDU");
        return dataSource;
    }

    public Report() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?zeroDateTimeBehavior=convertToNull", "root", "root");
            Build();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
