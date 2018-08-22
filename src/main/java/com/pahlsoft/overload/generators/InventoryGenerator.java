package com.pahlsoft.overload.generators;

import com.github.javafaker.Faker;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class InventoryGenerator {

    public static JsonObject buildInventoryItem() {
        Faker faker = new Faker();
        Random rand = new Random();
            JsonObject jsonPayLoad = Json.createObjectBuilder()
                    .add("id", String.valueOf(UUID.randomUUID()))
                    .add("loc", rand.nextInt(600) + 1)
                    .add("line_abbrev","")
                    .add("part_number", rand.nextInt(750000) + 1)
                    .add("expanded_part_number", rand.nextInt(25) + 1)
                    .add("description", faker.commerce().productName())
                    .add("store_group_id", rand.nextInt(600) + 1)
                    .add("department_id",rand.nextInt(25) + 1)
                    .add("sub_department_id",rand.nextInt(4) + 1)
                    .add("current_year_ref_class_cd","")
                    .add("last_year_ref_class_cd","")
                    .add("group_code","")
                    .add("ref_unit_designator_cd","")
                    .add("hazardous_materials_id", "")
                    .add("per_car_qty", "")
                    .add("supplier_id", rand.nextInt(75) + 1)
                    .add("standard_pkg", "")
                    .add("factory_std_pkg", "")
                    .add("sort_number", "")
                    .add("case_qty","")
                    .add("ref_seasonal_flag_cd", randomSeasonalCode())
                    .add("last_price_change_date",getRandomPastDate())
                    .add("lock_resale_prices", "")
                    .add("lock_cost_core_cost","")
                    .add("reportable",randomYesNo())
                    .add("tax_status_primary_ref_option_cd","")
                    .add("tax_status_secondary_ref_option_cd","")
                    .add("core_sales_tax_status_primary_ref_option_cd", "")
                    .add("core_sales_tax_status_secondary_ref_option_cd","")
                    .add("core_returns_tax_status_primary_ref_option_cd","")
                    .add("core_returns_tax_status_secondary_ref_option_cd", "")
                    .add("list", "")
                    .add("red", "")
                    .add("yellow", "")
                    .add("green", "")
                    .add("pink","")
                    .add("master_installer","")
                    .add("blue", "")
                    .add("core_price",randomDollarAmount(1,5000))
                    .add("cost",randomDollarAmount(1,5000))
                    .add("dvd_cost",randomDollarAmount(1,5000))
                    .add("jobber_stocked_cost",randomDollarAmount(1,5000))
                    .add("jobber_non_stocked_cost",randomDollarAmount(1,5000))
                    .add("core_cost",randomDollarAmount(1,5000))
                    .add("jobber_core_cost",randomDollarAmount(1,5000))
                    .add("store_retail_price1",randomDollarAmount(1,5000))
                    .add("store_retail_price2",randomDollarAmount(1,5000))
                    .add("store_retail_price3",randomDollarAmount(1,5000))
                    .add("average_cost",randomDollarAmount(1,5000))
                    .add("economic_order_qty","")
                    .add("economic_order_qty_discount_percent","")
                    .add("last_yr_cost",randomDollarAmount(1,5000))
                    .add("last_yr_core_cost",randomDollarAmount(1,5000))
                    .add("invoice_qty_min_for_discount","")
                    .add("discount_for_large_invoices","")
                    .add("weight_in_kilos",rand.nextInt(1000) + 1)
                    .add("country_of_origin",faker.address().countryCode())
                    .add("special_product_id_code","")
                    .add("last_updated_dvd_rev_num","")
                    .add("last_modified_date",getRandomPastDate())
                    .add("modified_by_employee_id",rand.nextInt(200) + 1)
                    .add("last_bin_label_print_date",getRandomPastDate())
                    .add("last_bin_label_print_price",randomDollarAmount(1,5000))
                    .add("post_date",getRandomPastDate())
                    .add("extract_date",getRandomFutureDate() )
                    .add("df_sequence", "")
                    .build();
        return jsonPayLoad;

    }

    private static String randomYesNo() {
        Random rand = new Random();
        int value = rand.nextInt(100) + 1;
        if (value % 2 == 0) {
            return "Y";
        } else {
            return "N";
        }
    }

    private static String randomSeasonalCode() {
        Random rand = new Random();
        int value = rand.nextInt(5) + 1;
        if (value == 1) {
            return "WINTER";
        } else if (value ==2) {
            return "SPRING";
        } else if (value ==3) {
            return "SUMMER";
        } else if (value ==4) {
            return "FALL";
        } else {
            return "ALL";
        }
    }

    private static String randomDollarAmount(int min, int max) {
        Random rand = new Random();
        float result = rand.nextFloat() * (max - min) + min;
        return String.format("%.2f", result);
    }

    private static long getRandomFutureDate() {
        return new Date(new Faker().date().future(20,TimeUnit.DAYS).getTime()).getTime();
    }

    private static long getRandomPastDate() {
        return new Date(new Faker().date().past(10,TimeUnit.DAYS).getTime()).getTime();
    }
}

