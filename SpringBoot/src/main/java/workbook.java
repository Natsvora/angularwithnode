
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class workbook {

    private static Connection connect;
    private static Statement statement;

    public static ResultSet dataSet() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?zeroDateTimeBehavior=convertToNull", "root", "root");
            statement = connect.createStatement();
            return statement.executeQuery("SELECT * FROM products");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(workbook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(workbook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ResultSet) new RuntimeException("result set error");
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {

        ResultSet resultSet = dataSet();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Student");

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style1 = workbook.createCellStyle();
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setVerticalAlignment(VerticalAlignment.CENTER);
        style1.setFont(font);
        XSSFColor c1 = new XSSFColor(new Color(28, 127, 105));
        style1.setFillForegroundColor(c1);
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style1.setBorderBottom(BorderStyle.THICK);
        style1.setBorderRight(BorderStyle.THICK);

        XSSFColor c2 = new XSSFColor(new Color(102, 255, 255));
        XSSFColor c3 = new XSSFColor(new Color(255, 255, 255));

        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setAlignment(HorizontalAlignment.CENTER);
        style2.setVerticalAlignment(VerticalAlignment.CENTER);
        style2.setFillForegroundColor(c3);
        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style2.setBorderBottom(BorderStyle.THICK);
        style2.setBorderRight(BorderStyle.THICK);

        XSSFFont font1 = workbook.createFont();
        font1.setBold(true);
        font1.setFontHeight(8);

        XSSFCellStyle style3 = workbook.createCellStyle();
        style3.setAlignment(HorizontalAlignment.CENTER);
        style3.setVerticalAlignment(VerticalAlignment.CENTER);
        style3.setFont(font1);
        style3.setFillForegroundColor(c2);
        style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style3.setBorderBottom(BorderStyle.THICK);
        style3.setBorderRight(BorderStyle.THICK);
//        style3.setFillBackgroundColor(c3);
//        style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font3 = workbook.createFont();
        font3.setBold(true);
        font3.setFontHeight(20);
        XSSFCellStyle style4 = workbook.createCellStyle();
        style4.setFont(font3);
        style4.setAlignment(HorizontalAlignment.CENTER);
        style4.setVerticalAlignment(VerticalAlignment.CENTER);
//        style4.setFillForegroundColor(c1);
//        style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFRow header = spreadsheet.createRow(0);
        header.setHeight((short) 1200);
        spreadsheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 5));

        XSSFCell cell;
        cell = header.createCell(0);
        //  cell.setCellValue("Image");

        InputStream inputStream = new FileInputStream("/home/naimish/stark.png");

        byte[] imageBytes = IOUtils.toByteArray(inputStream);

        int pictureureIdx = workbook.addPicture(imageBytes, workbook.PICTURE_TYPE_PNG);

        inputStream.close();

        CreationHelper helper = workbook.getCreationHelper();

        Drawing drawing = spreadsheet.createDrawingPatriarch();

        ClientAnchor anchor = helper.createClientAnchor();

        anchor.setCol1(0);
        anchor.setRow1(0);

        Picture pict = drawing.createPicture(anchor, pictureureIdx);
        pict.getPreferredSize();

        cell.setCellStyle(style4);
        cell = header.createCell(1);
        cell.setCellValue("Atlanta Bread Company - CC Usage January 2017\n"
                + "( 01-01-2017 through 01-31-2017 )");
        cell.setCellStyle(style4);

        XSSFRow row = spreadsheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("RESTAURANT");
        cell.setCellStyle(style1);
        cell = row.createCell(1);
        cell.setCellValue("DISTRIBUTOR");
        cell.setCellStyle(style1);
        cell = row.createCell(2);
        cell.setCellValue("Product Name");
        cell.setCellStyle(style1);
        cell = row.createCell(3);
        cell.setCellStyle(style1);
        cell.setCellValue("QTY Shipped");
        cell = row.createCell(4);
        cell.setCellStyle(style1);
        cell.setCellValue("Avg Price");
        cell = row.createCell(5);
        cell.setCellValue("Total Sales");
        cell.setCellStyle(style1);
        int i = 2;
        spreadsheet.setAutoFilter(new CellRangeAddress(spreadsheet.getFirstRowNum() + 1, spreadsheet.getLastRowNum(), 0, 5));
        XSSFCellStyle rowstyle;
        while (resultSet.next()) {
            if (i % 2 == 0) {
                rowstyle = style3;
            } else {
                rowstyle = style2;
            }
            style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            row = spreadsheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(resultSet.getString("name"));
            cell.setCellStyle(rowstyle);
            cell = row.createCell(1);
            cell.setCellValue(resultSet.getString("dist_name"));
            cell.setCellStyle(rowstyle);
            cell = row.createCell(2);
            cell.setCellValue(resultSet.getString("description"));
            cell.setCellStyle(rowstyle);
            cell = row.createCell(3);
            cell.setCellValue(resultSet.getDouble("total_usage"));
            cell.setCellStyle(rowstyle);
            cell = row.createCell(4);
            cell.setCellValue(resultSet.getDouble("price"));
            cell.setCellStyle(rowstyle);
            cell = row.createCell(5);
            cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
            cell.setCellFormula("PRODUCT(D" + (i + 1) + ":E" + (i + 1) + ")");
            cell.setCellStyle(rowstyle);
            i++;
        }

        rowstyle = workbook.createCellStyle();
        rowstyle.setAlignment(HorizontalAlignment.CENTER);
        rowstyle.setVerticalAlignment(VerticalAlignment.CENTER);
        rowstyle.setFont(font1);
        rowstyle.setBorderBottom(BorderStyle.DOUBLE);
        rowstyle.setBorderLeft(BorderStyle.DOUBLE);
        rowstyle.setBorderRight(BorderStyle.DOUBLE);
        rowstyle.setBorderTop(BorderStyle.DOUBLE);

        XSSFRow footer = spreadsheet.createRow(i);
        cell = footer.createCell(0);
        cell.setCellValue("Total");
        cell.setCellStyle(rowstyle);
        cell = footer.createCell(1);
        cell.setCellStyle(rowstyle);
        cell = footer.createCell(2);
        cell.setCellStyle(rowstyle);
        cell = footer.createCell(3);
        cell.setCellStyle(rowstyle);
        cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SUM(D3:D" + (i) + ")");
        cell = footer.createCell(4);
        cell.setCellStyle(rowstyle);
        cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SUM(E3:E" + (i) + ")");
        cell = footer.createCell(5);
        cell.setCellStyle(rowstyle);
        cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
        cell.setCellFormula("SUM(F3:F" + (i) + ")");

        spreadsheet.autoSizeColumn(0);
        spreadsheet.autoSizeColumn(1);
        spreadsheet.autoSizeColumn(2);
        spreadsheet.autoSizeColumn(3);
        spreadsheet.autoSizeColumn(4);
        spreadsheet.autoSizeColumn(5);
        workbook.write(new FileOutputStream("/home/naimish/Student.xlsx"));
    }
}
