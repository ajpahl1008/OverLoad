package com.pahlsoft.overload.generators;

import com.github.javafaker.Faker;

import javax.json.Json;
import javax.json.JsonObject;


public class InventoryStockGenerator {
    public static void main(String[] args) {
        Faker faker = new Faker();
        for (int x = 0; x<7; x++) {
            System.out.println(faker.commerce().productName());
            System.out.println(faker.commerce().price());
            JsonObject jsonPayLoad = Json.createObjectBuilder()
                    .add("df_store_status", "")
                    .add("loc","")
                    .add("store_department_id", "")
                    .add("ref_min_Max_status_cd","")
                    .add("use_economic_order_qty","")
                    .add("initial_stocking_date","")
                    .add("ref_initial_stocking_reason_cd","")
                    .add("last_sale_date","")
                    .add("last_lost_sale_date","")
                    .add("previous_lost_sale_date","")
                    .add("last_return_date","")
                    .add("last_receipt_date","")
                    .add("minimum_stock_qty","")
                    .add("maximum_stock_qty","")
                    .add("on_hand","")
                    .add("returned_cores_on_hand","")
                    .add("returned_defectives_on_hand","")
                    .add("work_in_progress","")
                    .add("days_allocated_to_wip","")
                    .add("on_order","")
                    .add("days_on_order","")
                    .add("days_on_backorder","")
                    .add("on_factory_order","")
                    .add("days_on_factory_order","")
                    .add("factory_order_flag","")
                    .add("ref_order_suspense_cd","")
                    .add("physical_inventory_date","")
                    .add("faim_code","")
                    .add("last_modified_date","")
                    .add("modified_by_employee_id","")
                    .add("last_sold_rads_date","")
                    .add("post_date", "")
                    .add("extract_date","")
                    .add("df_sequence", "")
                    .build();
            System.out.println(jsonPayLoad.toString());
        }

    }
}


