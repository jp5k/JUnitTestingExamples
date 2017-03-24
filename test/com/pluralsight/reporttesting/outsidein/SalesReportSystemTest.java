package com.pluralsight.reporttesting.outsidein;


import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class SalesReportSystemTest
{

    @Test
    public void findsExampleSalesInOutput()
    {
        ApplicationRunner runner = new ApplicationRunner();

        String output = runner.run("resources/example-sales.csv");

        assertThat(output, containsString("- London          -    235 -"));
    }

}
