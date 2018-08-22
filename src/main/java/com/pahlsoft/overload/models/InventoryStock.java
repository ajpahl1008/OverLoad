package com.pahlsoft.overload.models;

public class InventoryStock {
    int df_store_status;
    int loc;
    int store_department_id;
    String ref_min_Max_status_cd;
    int use_economic_order_qty;
    String initial_stocking_date;
    String ref_initial_stocking_reason_cd;
    String last_sale_date;
    String last_lost_sale_date;
    String previous_lost_sale_date;
    String last_return_date;
    String last_receipt_date;
    int minimum_stock_qty;
    int maximum_stock_qty;
    float on_hand;
    float returned_cores_on_hand;
    float returned_defectives_on_hand;
    float work_in_progress;
    int days_allocated_to_wip;
    int on_order;
    int days_on_order;
    int days_on_backorder;
    int on_factory_order;
    int days_on_factory_order;
    String factory_order_flag;
    String ref_order_suspense_cd;
    String physical_inventory_date;
    String faim_code;
    String last_modified_date;
    int modified_by_employee_id;
    String last_sold_rads_date;
    String post_date;
    String extract_date;
    int df_sequence;

    public int getDf_store_status() {
        return df_store_status;
    }

    public void setDf_store_status(int df_store_status) {
        this.df_store_status = df_store_status;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public int getStore_department_id() {
        return store_department_id;
    }

    public void setStore_department_id(int store_department_id) {
        this.store_department_id = store_department_id;
    }

    public String getRef_min_Max_status_cd() {
        return ref_min_Max_status_cd;
    }

    public void setRef_min_Max_status_cd(String ref_min_Max_status_cd) {
        this.ref_min_Max_status_cd = ref_min_Max_status_cd;
    }

    public int getUse_economic_order_qty() {
        return use_economic_order_qty;
    }

    public void setUse_economic_order_qty(int use_economic_order_qty) {
        this.use_economic_order_qty = use_economic_order_qty;
    }

    public String getInitial_stocking_date() {
        return initial_stocking_date;
    }

    public void setInitial_stocking_date(String initial_stocking_date) {
        this.initial_stocking_date = initial_stocking_date;
    }

    public String getRef_initial_stocking_reason_cd() {
        return ref_initial_stocking_reason_cd;
    }

    public void setRef_initial_stocking_reason_cd(String ref_initial_stocking_reason_cd) {
        this.ref_initial_stocking_reason_cd = ref_initial_stocking_reason_cd;
    }

    public String getLast_sale_date() {
        return last_sale_date;
    }

    public void setLast_sale_date(String last_sale_date) {
        this.last_sale_date = last_sale_date;
    }

    public String getLast_lost_sale_date() {
        return last_lost_sale_date;
    }

    public void setLast_lost_sale_date(String last_lost_sale_date) {
        this.last_lost_sale_date = last_lost_sale_date;
    }

    public String getPrevious_lost_sale_date() {
        return previous_lost_sale_date;
    }

    public void setPrevious_lost_sale_date(String previous_lost_sale_date) {
        this.previous_lost_sale_date = previous_lost_sale_date;
    }

    public String getLast_return_date() {
        return last_return_date;
    }

    public void setLast_return_date(String last_return_date) {
        this.last_return_date = last_return_date;
    }

    public String getLast_receipt_date() {
        return last_receipt_date;
    }

    public void setLast_receipt_date(String last_receipt_date) {
        this.last_receipt_date = last_receipt_date;
    }

    public int getMinimum_stock_qty() {
        return minimum_stock_qty;
    }

    public void setMinimum_stock_qty(int minimum_stock_qty) {
        this.minimum_stock_qty = minimum_stock_qty;
    }

    public int getMaximum_stock_qty() {
        return maximum_stock_qty;
    }

    public void setMaximum_stock_qty(int maximum_stock_qty) {
        this.maximum_stock_qty = maximum_stock_qty;
    }

    public float getOn_hand() {
        return on_hand;
    }

    public void setOn_hand(float on_hand) {
        this.on_hand = on_hand;
    }

    public float getReturned_cores_on_hand() {
        return returned_cores_on_hand;
    }

    public void setReturned_cores_on_hand(float returned_cores_on_hand) {
        this.returned_cores_on_hand = returned_cores_on_hand;
    }

    public float getReturned_defectives_on_hand() {
        return returned_defectives_on_hand;
    }

    public void setReturned_defectives_on_hand(float returned_defectives_on_hand) {
        this.returned_defectives_on_hand = returned_defectives_on_hand;
    }

    public float getWork_in_progress() {
        return work_in_progress;
    }

    public void setWork_in_progress(float work_in_progress) {
        this.work_in_progress = work_in_progress;
    }

    public int getDays_allocated_to_wip() {
        return days_allocated_to_wip;
    }

    public void setDays_allocated_to_wip(int days_allocated_to_wip) {
        this.days_allocated_to_wip = days_allocated_to_wip;
    }

    public int getOn_order() {
        return on_order;
    }

    public void setOn_order(int on_order) {
        this.on_order = on_order;
    }

    public int getDays_on_order() {
        return days_on_order;
    }

    public void setDays_on_order(int days_on_order) {
        this.days_on_order = days_on_order;
    }

    public int getDays_on_backorder() {
        return days_on_backorder;
    }

    public void setDays_on_backorder(int days_on_backorder) {
        this.days_on_backorder = days_on_backorder;
    }

    public int getOn_factory_order() {
        return on_factory_order;
    }

    public void setOn_factory_order(int on_factory_order) {
        this.on_factory_order = on_factory_order;
    }

    public int getDays_on_factory_order() {
        return days_on_factory_order;
    }

    public void setDays_on_factory_order(int days_on_factory_order) {
        this.days_on_factory_order = days_on_factory_order;
    }

    public String getFactory_order_flag() {
        return factory_order_flag;
    }

    public void setFactory_order_flag(String factory_order_flag) {
        this.factory_order_flag = factory_order_flag;
    }

    public String getRef_order_suspense_cd() {
        return ref_order_suspense_cd;
    }

    public void setRef_order_suspense_cd(String ref_order_suspense_cd) {
        this.ref_order_suspense_cd = ref_order_suspense_cd;
    }

    public String getPhysical_inventory_date() {
        return physical_inventory_date;
    }

    public void setPhysical_inventory_date(String physical_inventory_date) {
        this.physical_inventory_date = physical_inventory_date;
    }

    public String getFaim_code() {
        return faim_code;
    }

    public void setFaim_code(String faim_code) {
        this.faim_code = faim_code;
    }

    public String getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(String last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public int getModified_by_employee_id() {
        return modified_by_employee_id;
    }

    public void setModified_by_employee_id(int modified_by_employee_id) {
        this.modified_by_employee_id = modified_by_employee_id;
    }

    public String getLast_sold_rads_date() {
        return last_sold_rads_date;
    }

    public void setLast_sold_rads_date(String last_sold_rads_date) {
        this.last_sold_rads_date = last_sold_rads_date;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getExtract_date() {
        return extract_date;
    }

    public void setExtract_date(String extract_date) {
        this.extract_date = extract_date;
    }

    public int getDf_sequence() {
        return df_sequence;
    }

    public void setDf_sequence(int df_sequence) {
        this.df_sequence = df_sequence;
    }
}
