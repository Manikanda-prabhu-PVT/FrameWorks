package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {
        String path = ".\\testData\\data.xlsx"; // make sure this path is correct
        ExcelUtility xlutil = new ExcelUtility(path, "Sheet1");

        int rows = xlutil.getRowCount();
        Object[][] data = new Object[rows][2];

        for (int i = 0; i < rows; i++) {
            data[i][0] = xlutil.getCellData(i + 1, 0); // Username
            data[i][1] = xlutil.getCellData(i + 1, 1); // Password
        }

        return data;
    }
}
