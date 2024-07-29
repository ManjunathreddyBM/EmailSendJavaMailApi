package com.bbmp.AdLicence.model;

import lombok.Data;

@Data
public class EmailTemplate {
    private String subject;
    private String content;
    private String toEmail;

}
