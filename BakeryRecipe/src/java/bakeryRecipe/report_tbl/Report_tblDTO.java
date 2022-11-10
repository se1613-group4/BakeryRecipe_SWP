/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakeryRecipe.report_tbl;

import java.sql.Date;

/**
 *
 * @author ThongNT
 */
public class Report_tblDTO {

    private int reportId;
    private int user_id;
    private int recipe_id;
    private String comment_detail;
    private Date created_date;

    //Constructors

    public Report_tblDTO() {
    }
    
    public Report_tblDTO(int reportId, int user_id, int recipe_id, String comment_detail, Date created_date) {
        this.reportId = reportId;
        this.user_id = user_id;
        this.recipe_id = recipe_id;
        this.comment_detail = comment_detail;
        this.created_date = created_date;
    }

    Report_tblDTO(int reportId, int user_id,int recipe_id, String comment_detail) {
        this.reportId = reportId;
        this.user_id = user_id;
        this.recipe_id = recipe_id;
        this.comment_detail = comment_detail;
    }

    
    //Getters, Setters

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getComment_detail() {
        return comment_detail;
    }

    public void setComment_detail(String comment_detail) {
        this.comment_detail = comment_detail;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
    
    
    
}
